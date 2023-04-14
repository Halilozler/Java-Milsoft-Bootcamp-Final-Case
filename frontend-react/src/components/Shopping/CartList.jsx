import React, { useState, useEffect } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Button } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';


//sepetimiza eklediğimiz ürünleri göstermek için kullanılan component
export default function CartList({ cart, imageUrl }) {
    const [products, setProducts] = useState([]);

    useEffect(() => {

    }, []);

    return (
        <>
            {cart.length > 0 ? (
                <>
                    <TableContainer component={Paper} style={{ backgroundColor: "#f5f5f5", boxShadow: "none" }}>
                        <Table sx={{ minWidth: 150 }} aria-label="simple table" style={{ borderCollapse: "collapse" }}>
                            <TableHead>
                                <TableRow>
                                    <TableCell style={{ borderBottomWidth: 3, paddingBottom: 0, fontWeight: "bold" }}>ÜRÜN</TableCell>
                                    <TableCell align="right" style={{ borderBottomWidth: 3, paddingBottom: 0, fontWeight: "bold" }}>FİYAT</TableCell>
                                    <TableCell align="right" style={{ borderBottomWidth: 3, paddingBottom: 0, fontWeight: "bold" }}>MİKTAR</TableCell>
                                    <TableCell align="right" style={{ borderBottomWidth: 3, paddingBottom: 0, fontWeight: "bold" }}>TOPLAM</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {cart.map((row) => (
                                    <TableRow
                                        key={row.cartProductId}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell component="th" scope="row" style={{ display: "flex" }}>
                                            <IconButton aria-label="delete" style={{ color: "red", height: "100%" }}>
                                                <DeleteIcon style={{ width: 20 }} />
                                            </IconButton>
                                            <img src={imageUrl} alt={imageUrl} style={{ width: 50 }} />
                                            <p style={{ margin: 0, marginLeft: "0.5rem" }}>{row.product.productName}</p>
                                        </TableCell>
                                        <TableCell align="right">{row.product.salesPrice}</TableCell>
                                        <TableCell align="right">{row.salesQuantity}</TableCell>
                                        <TableCell align="right"><b>{row.salesQuantity * row.product.salesPrice} ₺</b></TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                    <Button variant="outlined" style={{ color: "red", borderColor: "red" }} startIcon={<DeleteIcon />}>
                        Sepeti Boşalt
                    </Button>
                </>
            ) : ("Sepetinizde ürün bulunmamaktadır.")}
        </>
    )
}