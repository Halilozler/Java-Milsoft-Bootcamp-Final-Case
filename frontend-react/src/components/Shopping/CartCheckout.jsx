import React, { useEffect, useState } from 'react'
import InputTools from '../Tools/InputTools';
import { Button } from '@mui/material';
import { completeCart, getCartInformation } from '../../utils/ApiCommand';
import { useDispatch, useSelector } from 'react-redux';
import Notification from '../../utils/Notification';
import { useNavigate } from 'react-router-dom';
import { incrementBasketCount } from "../../store/mainstore"
import CircularProgress from "@mui/material/CircularProgress";

//card bilgileri girdiği sayfa yani ürünüleri aldı sepete ekledi card bilgilerini giricek.
const CartCheckout = () => {
  const [cartNumber, setCartNumber] = useState();
  const [loading, setLoading] = useState(false);
  const {totalPrice} = useSelector(state => state.mainStore);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  useEffect(() => {
    if(totalPrice == 0){
      Notification(2, "Sepetiniz boş, önce sepete ürün ekleyin")
      navigate("/cartdetail");
    }
    getCartInformation().then((res) => {
      setCartNumber(res.data.cardNumber);
    })
  }, [])
  const handleSubmitCart = () => {
    setLoading(true);
    setTimeout(() => {
      completeCart(cartNumber).then((res) => {
        if(res.successful == true){
          //az beklet Yükleme ekranı çıkart
          setLoading(false);
          dispatch(incrementBasketCount(0));
          Notification(1, "Ödeme başarılı");
          navigate("/");
        }else{
          setLoading(false);
          Notification(0, res.errors[0]);
        }
      })
    }, 2500);
    
  }
  return (
    <div className='cart_checkout'>
      <>
      {loading && (
        <div className="loader-container">
          <div style={{display: "flex", alignItems: "center", flexDirection: "column"}}>
            <CircularProgress size={80} style={{ color: "white" }} />
            <p className="loader-text">İşlem yapılıyor, az bekleyin...</p>
          </div>
        </div>
      )}
        <h3>Kredi Kartı Bilgilerinizi Giriniz</h3>
        <form>
          <div style={{display: "flex"}}>
          <InputTools
              title={"İsim"}
              type={"text"}
              width={200}
              //state={username}
              //setState={setUsername}
              minLength={3}
            />
            <InputTools
              title={"Soyisim"}
              type={"text"}
              width={200}
              //state={username}
              //setState={setUsername}
              minLength={3}
              style={{marginLeft: "1rem"}}
            />
          </div>
          <InputTools
              title={"Kredi Kartı Bilgileri"}
              type={"number"}
              width={415}
              //state={username}
              //setState={setUsername}
              minLength={16}
              state={cartNumber}
              setState={setCartNumber}
            />
            <div style={{}}>
            <p>Toplam Tutar: <b>{totalPrice} ₺</b> </p>
            <Button variant="contained" style={{backgroundColor: "#f49b21"}} onClick={handleSubmitCart}>Ödeme Yap</Button>
          </div>
        </form>
      </>
    </div>
  )
}

export default CartCheckout;