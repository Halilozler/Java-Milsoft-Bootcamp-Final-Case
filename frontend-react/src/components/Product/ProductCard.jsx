import React from 'react'
import { useNavigate } from 'react-router-dom';

const ProductCard = ({imageUrl, productName, productId, salesPrice}) => {
    let navigate  = useNavigate();
    const handleClick = () => {
        navigate(`/product/${productId}`);
    }
  return (
    <button className="category-product-card" onClick={handleClick}>
        <img className="category-product-card__image" src={imageUrl} alt={productName} />
        <div className="category-product-card__name"><p>{productName}</p></div>
        <div className="category-product-card__name"><p><b style={{margin: 0}}>{salesPrice}</b></p></div>
      </button>
  )
}

export default ProductCard