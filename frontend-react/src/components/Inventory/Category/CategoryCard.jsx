import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from "react-redux"
import { setCatId } from '../../../store/mainstore';

const CategoryCard = ({imageUrl, categoryName, categoryId}) => {
  const [hover, setHover] = useState(false);
  const { catId } = useSelector(state => state.mainStore)
  const dispatch = useDispatch()
  let navigate  = useNavigate();
  const handleClick = () => {
    dispatch(setCatId(categoryId))
    navigate(`/products/${categoryId}`);
  }
  const handleMouseEnter = () => {
    setHover(true);
  };

  const handleMouseLeave = () => {
    setHover(false);
  };
  return (
    <div className='category_card'>
      <button className={`category_card_btn ${catId === categoryId ? 'selected' : ''} ${
        hover ? 'hover' : ''
      }`} onClick={handleClick} onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}>
        {categoryName}
      </button>
    </div>
  )
}

export default CategoryCard;