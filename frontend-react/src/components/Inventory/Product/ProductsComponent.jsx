import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getProductsByCategoryId } from '../../../utils/ApiCommand';
import ProductCard from './ProductCard';
import HeaderHelper from '../../Helper/HeaderHelper';

const ProductsComponent = () => {
    const [products, setProducts] = useState([]);
    const { categoryId } = useParams();
    useEffect(() => {
        getProductsByCategoryId(categoryId === undefined ? 1 : categoryId).then((response) => {
            console.log(response.data);
            setProducts(response.data);
        });
    }, [categoryId]);
  return (
    <>
        <div className="product-list">
        {products.length === 0 ? <div style={{color: "white"}}>No products found</div>
        :
          products.map((product, index) => (
            <ProductCard key={product.categoryId} imageUrl={"/image.jpeg"} productName={product.productName} salesPrice={product.salesPrice} productId={product.productId}/>
          ))
        }
      </div>
    </>
  )
}

export default ProductsComponent;