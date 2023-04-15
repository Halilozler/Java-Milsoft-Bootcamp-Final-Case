import React, { useEffect, useState } from 'react'
import CartList from './CartList'
import { Button } from 'primereact/button';
import { getCart, deleteCart, decrimentCart, addBasket, deleteCartProduct } from '../../utils/ApiCommand';
import { useDispatch, useSelector } from 'react-redux';
import { incrementBasketCount, setTotalPriceGlobal } from "../../store/mainstore"
import Notification from '../../utils/Notification';
import { useNavigate } from 'react-router-dom';


const CartDetail = () => {
  const [cart, setCart] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  const {basketCount} = useSelector(state => state.mainStore);
  const navigate = useNavigate();
  const imageUrl = "/image.jpeg";
  const dispatch = useDispatch();
  useEffect(() => {
    getCart().then((res) => {
      console.log(res.data);
      setCart(res.data);
    })
  }, [])
  useEffect(() => {
    setTotalPrice(cart.reduce((a, b) => a + (b.salesQuantity * b.product.salesPrice), 0).toFixed(2));
  }, [cart])
  const getCartCheckout = () => {
    dispatch(setTotalPriceGlobal(totalPrice));
    navigate("/cartcheckout");
  }
  const deleteCartfunc = () => {
    deleteCart().then((res) => {
      if(res.data == true){
        Notification(1, "Sepetiniz boşaltıldı");
        dispatch(incrementBasketCount(0));
        setCart([]);
      }else{
        Notification(0, "Sepetiniz boşaltılamadı");
      }
    })
  };

  const decrimentCount = (cart) => {
    if(cart.salesQuantity === 1){
      Notification(2, "Daha fazla eksilemez");
      return;
    }
    decrimentCart(cart.product.productId).then((res) => {
      if(res.successful == true){
        setCart((prevCart) => {
          return prevCart.map((item) => {
            if(item.cartProductId === cart.cartProductId){
              return {...item, salesQuantity: item.salesQuantity - 1}
              }
              return item;
              })
              })
              dispatch(incrementBasketCount(basketCount - 1));
      }else{
        Notification(0, "Bir hata oluştu");
      }
    })
  }
  const incrementCount = (cart) => {
    addBasket(cart.product.productId).then((res) => {
      if(res.successful == true){
        setCart((prevCart) => {
          return prevCart.map((item) => {
            if(item.cartProductId === cart.cartProductId){
              return {...item, salesQuantity: item.salesQuantity + 1}
              }
              return item;
              })
              })
              dispatch(incrementBasketCount(undefined));
      }else{
        Notification(0, "Bir hata oluştu");
      }
    })
  }
  const deleteCartProductfunc = (cart) => {
    deleteCartProduct(cart.product.productId).then((res) => {
      if(res.successful == true){
        setCart((prevCart) => {
          return prevCart.filter((item) => {
            if(item.cartProductId === cart.cartProductId){
              return false;
              }
              return true;
              })
              })
              dispatch(incrementBasketCount(basketCount - cart.salesQuantity));
      }else{
        Notification(0, "Bir hata oluştu");
      }
    })
  }

  return (
    <div className='cart_detail'>
      <div className="cart_detail_left">
        <CartList cart={cart} imageUrl={imageUrl} deleteCart={deleteCartfunc} decrimentCount={decrimentCount} incrementCount={incrementCount} deleteCartProduct={deleteCartProductfunc}/>
      </div>
      <div className="cart_detail_right">
        <div>
          <div className="cart_detail_right_title">
            <h3 style={{margin: 0, fontSize: 17, paddingBottom: 4}}>Sipariş Özeti</h3>
          </div>
          <div className="cart_detail_right_total">
            <span>Toplam Tutar: </span>
            <b>{totalPrice} ₺</b>
          </div>
          <div className="cart_detail_right_total">
            <span>Kargo Ücreti: </span>
            {totalPrice > 100 ? <b>Ücretsiz</b> : <b>100 ₺</b>}
          </div>  
          <div className="cart_detail_right_total">
            <span>Toplam Tutar: </span>
            {totalPrice > 100 ? <b>{totalPrice} ₺</b> : <b>{(parseFloat(totalPrice) + 100).toFixed(2)} ₺</b>}
          </div> 
          <Button label="Ödeme Sayfasına Git" style={{marginTop: "1rem"}} className="p-button-raised p-button-rounded p-button-success" onClick={getCartCheckout}/>
        </div>
      </div>
    </div>
  )
}

export default CartDetail