import React, {useEffect, useState} from 'react'
import { Accordion, AccordionTab } from "primereact/accordion";
import { getCartSummary } from '../../utils/ApiCommand';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

//geçmiş siparişlerim:
const CartSummary = () => {
  const [carts, setCarts] = useState([]);
  const imageUrl = "/image.jpeg";
  useEffect(() => {
    getCartSummary().then((res) => {
      console.log(res.data);
      setCarts(res.data);
    })
  }, [])

  const datetimeFormat = (dateFormat) => {
    const date = new Date(dateFormat);
    const day = String(date.getDate()).padStart(2, "0");
    const month = String(date.getMonth() + 1).padStart(2, "0"); // Aylar 0-11 arasında olduğu için 1 ekleyin
    const year = date.getFullYear();
    const hours = String(date.getHours()).padStart(2, "0");
    const minutes = String(date.getMinutes()).padStart(2, "0");
    return `${day}/${month}/${year} - ${hours}:${minutes} Tarihli Siparişiniz`;
  }

  //const totalPrice = carts.reduce((a, b) => a + (b.cartProductGetDtoList.reduce((a, b) => a + (b.salesQuantity * b.product.salesPrice), 0)), 0).toFixed(2);

  const totalPrice = (cart) => {
    return cart.cartProductGetDtoList.reduce((a, b) => a + (b.salesQuantity * b.product.salesPrice), 0).toFixed(2);
  }

  return (
    <div style={{width: "100%", display: "flex", alignItems: "center", flexDirection: "column"}}>
      <div style={{width: "80%"}}>
      <h3>
        <strong>Geçmiş Siparişlerim</strong>
      </h3>
        <Accordion multiple activeIndex={[0]} >
          {carts.reverse().map((cart) => (
            <AccordionTab header={datetimeFormat(cart.createdDate)}>
            <TableContainer component={Paper} style={{ boxShadow: "none", marginTop: 0 }}>
                <Table sx={{}} aria-label="simple table" style={{ borderCollapse: "collapse" }}>
                    <TableBody>
                        {cart.cartProductGetDtoList.map((row, index) => (
                            <TableRow
                                key={index}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row" style={{display:"flex"}}>
                                <img src={imageUrl} alt={imageUrl} style={{width: 50}} />
                                <p style={{margin: 0, marginLeft: "0.5rem"}}>{row.product.productName}</p> 
                                    {/* {row.product.productName} */}
                                </TableCell>
                                <TableCell align="right">{row.salesQuantity}</TableCell>
                                <TableCell align="right"><b>{row.salesQuantity * row.product.salesPrice} ₺</b></TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
            <b>Kullanılan Kredi Kartı No: </b>{cart.cardNumber}
            <br />
            <b>Toplam Tutar: </b>{totalPrice(cart)} ₺
        </AccordionTab>
          ))}
        </Accordion>
      </div>
    </div>
  )
}

export default CartSummary