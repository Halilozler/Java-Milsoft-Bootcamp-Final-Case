import React, { useEffect } from "react";
import Navbar from "./Navbar";
import CategoriesComponent from "./components/Inventory/Category/CategoriesComponent";
import ProductsComponent from "./components/Inventory/Product/ProductsComponent";
import { Outlet } from "react-router-dom";
import Index from "./components/Inventory/Index";

function App() {
  return (
    <div className='appScreen'>
      <Navbar/>
      <Index/>
    </div>
  );
}

export default App;
