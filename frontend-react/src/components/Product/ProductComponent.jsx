import React, { useEffect, useState } from 'react'
import { getProductById } from '../../utils/ApiCommand';
import { useParams } from 'react-router-dom';

const ProductComponent = () => {
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
  return (
    <div className="product">
      {loading ? <div>Loading...</div> : 
      <>
      <img className="product__image" src={imageUrl} alt={product.productName} />
      <div className="product__info">
        <h2 className="product__info-name">{product.productName}</h2>
        <div>
          <button className="product__info-button">Satın Al</button>
          <span className="product__info-price">{product.salesPrice} ₺</span>
        </div>
      </div>
      </>}
    </div>
  )
}

export default ProductComponent;