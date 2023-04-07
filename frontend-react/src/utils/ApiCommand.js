import axios from 'axios';

const baseUrl = "http://localhost:8080/api/";
const categoryApi = baseUrl + "category/";
const productApi = baseUrl + "product/";
const cartApi = baseUrl + "cart/";

export const getCategorias = async () => {
  const response = await axios.get(categoryApi + "categories");
  return response.data;
}

export const getProductsByCategoryId = async (id) => {
  const response = await axios.get(productApi + "products/" + id);
  return response.data;
}

export const getProductById = async (id) => {
  const response = await axios.get(productApi + "product/" + id);
  return response.data;
}

export const getCart = async (CartId) => {
    const response = await axios.get(cartApi + "get/" + CartId);
    return response.data;
}

export const addCart = async (cartId, productId) => {
    const response = await axios.post(cartApi + "add/" + cartId + "/" + productId);
    return response.data;
}

export const deleteCart = async (cartId, productId) => {
    const response = await axios.delete(baseUrl + "remove/" + cartId + "/" + productId);
    return response.data;
}

export const updateCart = async(cart) => {
    const response = await axios.put(baseUrl + "checkout/", cart);
    return response.data;
}