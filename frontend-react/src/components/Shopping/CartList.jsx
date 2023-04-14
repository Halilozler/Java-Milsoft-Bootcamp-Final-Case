import React, { useState, useEffect } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Button } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

function createData(name, calories, fat, carbs, protein) {
    return { name, calories, fat, carbs, protein };
  }
  
  const rows = [
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0),
    createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
    createData('Eclair', 262, 16.0, 24, 6.0),
    createData('Cupcake', 305, 3.7, 67, 4.3),
    createData('Gingerbread', 356, 16.0, 49, 3.9),
  ];

//sepetimiza eklediğimiz ürünleri göstermek için kullanılan component
export default function CartList() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        //ProductService.getProductsSmall().then((data) => setProducts(data.slice(0, 5)));
    }, []);

    return (
        <>
        <TableContainer component={Paper} style={{backgroundColor: "#f5f5f5", boxShadow: "none"}}>
        <Table sx={{ minWidth: 150 }} aria-label="simple table" style={{borderCollapse: "collapse"}}>
            <TableHead>
                <TableRow> 
                    <TableCell style={{borderBottomWidth: 3, paddingBottom: 0, fontWeight:"bold"}}>ÜRÜN</TableCell>
                    <TableCell align="right" style={{borderBottomWidth: 3, paddingBottom: 0, fontWeight:"bold"}}>FİYAT</TableCell>
                    <TableCell align="right" style={{borderBottomWidth: 3, paddingBottom: 0, fontWeight:"bold"}}>MİKTAR</TableCell>
                    <TableCell align="right" style={{borderBottomWidth: 3, paddingBottom: 0, fontWeight:"bold"}}>TOPLAM</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
            {rows.map((row) => (
                <TableRow
                key={row.name}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                >
                <TableCell component="th" scope="row">
                    {row.name}
                </TableCell>
                <TableCell align="right">{row.calories}</TableCell>
                <TableCell align="right">{row.fat}</TableCell>
                <TableCell align="right"><b>{row.carbs} ₺</b></TableCell>
                </TableRow>
            ))}
            </TableBody>
        </Table>
    </TableContainer>
    <Button variant="outlined" style={{color: "red", borderColor: "red"}} startIcon={<DeleteIcon />}>
        Sepeti Boşalt
    </Button>
    </>
    )
}
        