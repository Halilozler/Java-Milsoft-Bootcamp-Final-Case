import React from 'react'
import CartList from './CartList';
import InputTools from '../Tools/InputTools';
import { Button } from '@mui/material';

//card bilgileri girdiği sayfa yani ürünüleri aldı sepete ekledi card bilgilerini giricek.
const CartCheckout = () => {
  const handleSubmitCart = (e) => {

  }
  return (
    <div className='cart_checkout'>
      <>
        <h3>Kredi Kartı Bilgilerinizi Giriniz</h3>
        <form onSubmit={handleSubmitCart}>
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
            />
            <div style={{}}>
            <p>Toplam Tutar: <b>0 ₺</b> </p>
            <Button variant="contained" style={{backgroundColor: "#f49b21"}}>Ödeme Yap</Button>
          </div>
        </form>
      </>
    </div>
  )
}

export default CartCheckout;