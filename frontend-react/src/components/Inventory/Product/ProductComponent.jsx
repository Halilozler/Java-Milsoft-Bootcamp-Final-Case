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

const ProductComponent = () => {
  const { cartId } = useSelector(state => state.mainStore);
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
      />
      <div>
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {product.productName}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {product.salesPrice}
        </Typography>
      </CardContent>
      <CardActions>
      <Button variant="contained" onClick={changeHandler}>Sepete Ekle</Button>
      </CardActions>
      </div>
    </Card>
      </>}
    </div>
  )
}

export default ProductComponent;