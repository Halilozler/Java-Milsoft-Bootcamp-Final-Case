import React, { Component, useState } from 'react'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from './App';
//page imports
import MainScreen from './components/MainScreen';
import NotFound from './components/NotFound/Index';

const Router = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<App/>} >
                    <Route index element={<MainScreen/>} />
                </Route>
                <Route path="*" element={<NotFound/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router;