import React, {useState} from 'react'
import { Accordion, AccordionTab } from "primereact/accordion";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

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
//geçmiş siparişlerim:
const CartSummary = () => {

  return (
    <div style={{width: "100%", display: "flex", alignItems: "center", flexDirection: "column"}}>
      <div style={{width: "80%"}}>
      <h3>
        <strong>Geçmiş Siparişlerim</strong>
      </h3>
      <Accordion multiple activeIndex={[0]} >
        <AccordionTab header="Header I">
          <TableContainer component={Paper} style={{boxShadow: "none", marginTop: 0}}>
          <Table sx={{ }} aria-label="simple table" style={{borderCollapse: "collapse"}}>
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
                  <TableCell align="right"><b>{row.carbs} ₺</b></TableCell>
                  </TableRow>
              ))}
              </TableBody>
          </Table>
          </TableContainer>
        </AccordionTab>
        <AccordionTab header="Header II">
          <p className="m-0">
            Sed ut perspiciatis unde omnis iste natus error sit voluptatem
            accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
            quae ab illo inventore veritatis et quasi architecto beatae vitae
            dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
            aspernatur aut odit aut fugit, sed quia consequuntur magni dolores
            eos qui ratione voluptatem sequi nesciunt. Consectetur, adipisci
            velit, sed quia non numquam eius modi.
          </p>
        </AccordionTab>
        <AccordionTab header="Header III">
          <p className="m-0">
            At vero eos et accusamus et iusto odio dignissimos ducimus qui
            blanditiis praesentium voluptatum deleniti atque corrupti quos
            dolores et quas molestias excepturi sint occaecati cupiditate non
            provident, similique sunt in culpa qui officia deserunt mollitia
            animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis
            est et expedita distinctio. Nam libero tempore, cum soluta nobis est
            eligendi optio cumque nihil impedit quo minus.
          </p>
        </AccordionTab>
      </Accordion>
      </div>
    </div>
  )
}

export default CartSummary