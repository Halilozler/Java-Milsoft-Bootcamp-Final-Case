import React, { Component, useState } from 'react'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from './App';
//page imports
import NotFound from './components/NotFound/Index';
import CategoriesComponent from './components/Category/CategoriesComponent';
import ProductsComponent from './components/Product/ProductsComponent';
import ProductComponent from './components/Product/ProductComponent';

const Router = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<App/>} >
                    <Route index element={<CategoriesComponent/>} />
                    <Route path="/products/:categoryId" element={<ProductsComponent/>} />
                    <Route path="/product/:productId" element={<ProductComponent/>} />
                </Route>
                <Route path="*" element={<NotFound/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router;