import React from 'react'
import { useNavigate } from 'react-router-dom';

const CategoryCard = ({imageUrl, categoryName, categoryId}) => {
  let navigate  = useNavigate();
  const handleClick = () => {
    navigate(`/products/${categoryId}`);
  }
  return (
    <button className="category-product-card" onClick={handleClick}>
        <img className="category-product-card__image" src={imageUrl} alt={categoryName} />
        <div className="category-product-card__name"><p style={{textDecoration: "none"}}>{categoryName}</p></div>
      </button>
  )
}

export default CategoryCard