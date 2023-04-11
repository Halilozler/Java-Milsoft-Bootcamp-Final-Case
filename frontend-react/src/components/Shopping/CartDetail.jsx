import React from 'react'
import CartList from './CartList'
import { Button } from 'primereact/button';

const CartDetail = () => {
  return (
    <div className='cart_detail'>
        <>
            <CartList/>
        </>
        <div style={{display: "flex", flexDirection: "column", gap: "1rem"}}>
            <Button label="Sepeti Onayla" severity="success" raised />
            <Button label="Sepeti Sil" severity="danger" raised />
        </div>
    </div>
  )
}

export default CartDetail