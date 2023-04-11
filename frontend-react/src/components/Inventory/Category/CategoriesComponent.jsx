import React,{useState, useEffect} from 'react'
import CategoryCard from './CategoryCard';
import { getCategorias } from '../../../utils/ApiCommand';
import HeaderHelper from '../../Helper/HeaderHelper';

const CategoriesComponent = () => {
  const[categories, setCategories] = useState([]);
  useEffect(() => {
    getCategorias().then((response) => {
      setCategories(response.data);
    });
  },[])
  return (
    <>
    <div className="category-product-list">
      {categories.length === 0 ? <div style={{color: "white"}}>No categories found</div>
      :
        categories.map((category, index) => (
          <CategoryCard key={category.categoryId} imageUrl={"/image.jpeg"} categoryName={category.categoryName} categoryId={category.categoryId}/>
        ))
      }
    </div>
    </>
  )
}

export default CategoriesComponent;