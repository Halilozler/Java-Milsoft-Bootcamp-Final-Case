import axios from 'axios';

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

export const addBasket = async (productId) => {
  let token = localStorage.getItem("token");
  if(token === null){
    token = sessionStorage.getItem("token");
  }
  if(token === null){
    //burada hata döndürülebilir
    alert("Lütfen giriş yapınız");
    return null;
  }

  const response = await axios.post(cartApi + `add/${productId}`, null, {
    headers: {
      Authorization: "Bearer " + token
    }
  });
  return response.data;
}



