import React from 'react'
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea } from '@mui/material';
import { addBasket } from '../../../utils/ApiCommand';
import { useDispatch } from 'react-redux';
import { incrementBasketCount } from '../../../store/mainstore';



const ProductCard = ({imageUrl, productName, productId, salesPrice}) => {
    const dispatch = useDispatch();
    let navigate  = useNavigate();
    const handleClick = () => {
        navigate(`/product/${productId}`);
    }
    const basketAddButton = (e) => {
      e.stopPropagation();
      if(localStorage.getItem("token") === null && sessionStorage.getItem("token") === null){
        alert("Lütfen giriş yapınız.");
      }
      else{
        addBasket(productId).then((res) => {
          console.log(res);
          if(res.successful === false){
            alert("Ürün sepete eklenemedi. Lütfen daha sonra tekrar deneyiniz.");
            return;
          }
          dispatch(incrementBasketCount());
          alert("Ürün sepete eklendi.");
        }).catch((err) => {
          console.log(err.response.data.message);
        });
      }
    }
  return (
    <Card sx={{ maxWidth: 240 }} onClick={handleClick}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="200"
          image={imageUrl}
          alt={productName}
        />
        <CardContent style={{paddingTop: 5}}>
          <Typography gutterBottom variant="h5" component="div" style={{marginBottom: 0}}>
            <p style={{margin: 0, fontSize: 17, color: "#898989"}}>{productName}</p>
          </Typography>
          <Typography variant="body2" color="text.secondary" style={{color: "#484848", fontSize: 17, fontWeight: 900, padding: 0}}>
            {salesPrice} ₺
          </Typography>
          <Typography variant="body2" color="text.secondary" style={{color: "#484848", fontSize: 17, fontWeight: 900, padding: 0, display: "flex", justifyContent: "center", marginTop: "0.3rem"}}>
            <Button variant="outlined" onClick={basketAddButton}>Sepete Ekle</Button>
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  )
}

export default ProductCard