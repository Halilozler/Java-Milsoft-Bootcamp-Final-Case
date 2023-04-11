import React from 'react'
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';

const ProductCard = ({imageUrl, productName, productId, salesPrice}) => {
    let navigate  = useNavigate();
    const handleClick = () => {
        navigate(`/product/${productId}`);
    }
  return (
    <Card sx={{ maxWidth: 345 }} onClick={handleClick}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="200"
          image={imageUrl}
          alt={productName}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div" style={{textAlign: "center"}}>
            {productName}
          </Typography>
          <Typography variant="body2" color="text.secondary" style={{textAlign: "center", color: "pink", fontSize: 25, fontWeight: 600}}>
            {salesPrice}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  )
}

export default ProductCard