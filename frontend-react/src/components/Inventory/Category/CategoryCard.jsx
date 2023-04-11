import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from "react-redux"
import { setCatId } from '../../../store/mainstore';

const CategoryCard = ({imageUrl, categoryName, categoryId}) => {
  const { catId } = useSelector(state => state.mainStore)
  const dispatch = useDispatch()
  let navigate  = useNavigate();
  const handleClick = () => {
    dispatch(setCatId(categoryId))
    navigate(`/products/${categoryId}`);
  }
  return (
    <div className='category_card'>
      <button className='category_card_btn' onClick={handleClick} style={catId == categoryId ? {backgroundColor: "rgb(144, 202, 249)"} : {backgroundColor: "rgba(54, 148, 240, 255)"}}>
        {categoryName}
      </button>
    </div>
  )
}

export default CategoryCard;