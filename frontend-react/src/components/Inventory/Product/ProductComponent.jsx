import React, { useEffect, useState } from 'react'
import { getProductById, getCart, addCart } from '../../../utils/ApiCommand';
import { useParams } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useDispatch, useSelector} from "react-redux";
import { setCartId, incrementBasketCount} from '../../../store/mainstore';
import { useNavigate } from 'react-router-dom';
import { addBasket } from '../../../utils/ApiCommand';
import Notification from '../../../utils/Notification';

const ProductComponent = () => {
  const [number , setNumber] = useState(1);
  const { cartId, basketCount } = useSelector(state => state.mainStore);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [product, setProduct] = useState();
  const [loading, setLoading] = useState(true);
  const { productId } = useParams();
  const imageUrl = "/image.jpeg";
  useEffect(() => {
    getProductById(productId).then((response) => {
      setProduct(response.data);
      setLoading(false);
    });
  }, [productId]);

  const changeHandler = () => {
    if(localStorage.getItem("token") === null && sessionStorage.getItem("token") === null){
      Notification(2, "Lütfen giriş yapınız.");
    }
    else{
      addBasket(productId, number).then((res) => {
        console.log(res);
        if(res.successful === false){
          Notification(0, "Ürün sepete eklenemedi. Lütfen daha sonra tekrar deneyiniz.");
          return;
        }
        dispatch(incrementBasketCount(basketCount + number));
        Notification(1, "Ürün sepete eklendi.");
      }).catch((err) => {
        console.log(err.response.data.message);
      });
    }
  }

  const numberChange = (e) => {
    if(e.target.value < 1){
      Notification(2, "Daha fazla eksilemez");
      return;
    }
    setNumber(parseInt(e.target.value));
  }

  const decrimentNumber = () => {
    if(number === 1){
      Notification(2, "Daha fazla eksilemez");
      return;
    }
    setNumber(number - 1);
  }

  const incrimentNumber = () => {
    setNumber(number + 1);
  }

  return (
    <div className="product" style={{display: "flex", justifyContent: "center", alignItems: "center", height: "100%"}}>
      {loading ? <div>Loading...</div> : 
      <>
      <Card sx={{ maxWidth: 800 }} style={{display:"flex", justifyContent: "center", alignItems: "center"}}>
      <CardMedia
        component="img"
        alt="green iguana"
        height="500"
        image={imageUrl}
        style={{width: 450}}
      />
      <div>
      <CardContent style={{minWidth: 250, paddingBottom: 0}}>
        <Typography gutterBottom variant="h5" component="div">
          <b>{product.productName}</b> 
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {product.salesPrice} ₺
        </Typography>
      </CardContent>
      <CardActions style={{ paddingLeft: "1rem" }}>
          <button className='btn_decriment' style={{margin:0, borderTopLeftRadius: 5, borderBottomLeftRadius: 5, width: 35, height: 35}} onClick={decrimentNumber}> <b>-</b></button>
            <input type="number" value={number} onChange={numberChange} style={{margin: 0, height: 35, width: 35, textAlign: "center"}}/>
          <button className='btn_incriment' style={{margin:0, borderTopRightRadius: 5, borderBottomRightRadius: 5, width: 35, height: 35}} onClick={incrimentNumber}> <b>+</b></button>
        <Button variant="contained" onClick={changeHandler}>Sepete Ekle</Button>
      </CardActions>
      </div>
    </Card>
      </>}
    </div>
  )
}

export default ProductComponent;