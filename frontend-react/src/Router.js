import React, { Component, useState } from 'react'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from './App';
//page imports
import NotFound from './components/NotFound/Index';
import CategoriesComponent from './components/Inventory/Category/CategoriesComponent';
import ProductsComponent from './components/Inventory/Product/ProductsComponent';
import ProductComponent from './components/Inventory/Product/ProductComponent';
import IndexMainScreen from './components/MainScreen/Index';
import CartCheckout from './components/Shopping/CartCheckout';
import CartDetail from './components/Shopping/CartDetail';
import CartSummary from './components/Shopping/CartSummary';
import UserOperations from "./components/UserOperations/Index";

const Router = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<App/>} >
                    <Route index element={<IndexMainScreen/>} />
                    <Route path="/category" element={<CategoriesComponent/>} />
                    <Route path="/products/:categoryId" element={<ProductsComponent/>} />
                    <Route path="/product/:productId" element={<ProductComponent/>} />
                    <Route path="/cartcheckout" element={<CartCheckout/>} />
                    <Route path="/cartdetail" element={<CartDetail/>} />
                    <Route path="/cartsummary" element={<CartSummary/>} />
                    <Route path="/user" element={<UserOperations/>} />
                </Route>
                <Route path="*" element={<NotFound/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router;