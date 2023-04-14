import React, { useEffect, useState } from 'react'
import CartList from './CartList'
import { Button } from 'primereact/button';
import { getCart } from '../../utils/ApiCommand';



const CartDetail = () => {
  const [cart, setCart] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  const imageUrl = "/image.jpeg";
  useEffect(() => {
    getCart().then((res) => {
      console.log(res.data);
      setCart(res.data);
    })
  }, [])
  useEffect(() => {
    setTotalPrice(cart.reduce((a, b) => a + (b.salesQuantity * b.product.salesPrice), 0).toFixed(2));
  }, [cart])
  return (
    <div className='cart_detail'>
      <div className="cart_detail_left">
        <CartList cart={cart} imageUrl={imageUrl}/>
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
          <Button label="Ödeme Sayfasına Git" style={{marginTop: "1rem"}} className="p-button-raised p-button-rounded p-button-success" />
        </div>
      </div>
    </div>
  )
}

export default CartDetail