import axios from 'axios';
import Notification from './Notification';

const baseUrl = "http://localhost:8080/api/";
const categoryApi = baseUrl + "category/";
const productApi = baseUrl + "product/";
const cartApi = baseUrl + "cart/";
const userApi = baseUrl + "auth/";


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

export const signup = async (username, email, password) => {
  const response = await axios.post(userApi + "signup", {
    username,
    email,
    password
  });
  return response.data;
}

export const login = async (username, password) => {
  const response = await axios.post(userApi + "signin", {
    username,
    password
  });
  return response.data;
}

//username ve emial getirmek için.
export const getProfileInformation = async () => {
  //token varmı baksın 
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.get(userApi + "profile", {
      headers: {
        Authorization: "Bearer " + token
      }
    });
    return response.data;
}

//sepete ekleme
export const addBasket = async (productId, salesQuantity) => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    Notification(0, "Lütfen giriş yapınız");
    return null;
  }

  const response = await axios.post(cartApi + `add/${productId}/${salesQuantity == undefined ? 1 : salesQuantity}`, null, {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}

export const getCartInformation = async () => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.get(cartApi + "get", {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}

//Sepet Getirme
export const getCart = async () => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.get(cartApi + "get/new", {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}

//Geçmiş Sepetler Getirme
export const getCartSummary = async () => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.get(cartApi + "get/completed", {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}

export const deleteCart = async () => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.delete(cartApi + "remove/all", {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}

export const decrimentCart = async (productId) => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.delete(cartApi + `remove/quantity/${productId}`, {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}
export const deleteCartProduct = async (productId) => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.delete(cartApi + `remove/${productId}`, {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}

export const completeCart = async (cardNumber) => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    return null;
  }

  const response = await axios.put(cartApi + `checkout`, {cardNumber},{
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}



