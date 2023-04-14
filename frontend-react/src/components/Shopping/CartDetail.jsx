import React from 'react'
import CartList from './CartList'
import { Button } from 'primereact/button';



const CartDetail = () => {
  return (
    <div className='cart_detail'>
      <div className="cart_detail_left">
        <CartList />
      </div>
      <div className="cart_detail_right">
        <div>
          <div className="cart_detail_right_title">
            <h3 style={{margin: 0, fontSize: 17, paddingBottom: 4}}>Sipariş Özeti</h3>
          </div>
          <div className="cart_detail_right_total">
            <span>Toplam Tutar: </span>
            <b>0 ₺</b>
          </div>
          <div className="cart_detail_right_total">
            <span>Kargo Ücreti: </span>
            <b>0 ₺</b>
          </div>  
          <div className="cart_detail_right_total">
            <span>Toplam Tutar: </span>
            <b>0 ₺</b>
          </div> 
          <Button label="Ödeme Sayfasına Git" style={{marginTop: "1rem"}} className="p-button-raised p-button-rounded p-button-success" />
        </div>
      </div>
    </div>
  )
}

export default CartDetail