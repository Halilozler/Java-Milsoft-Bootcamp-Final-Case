import React from 'react'
import { Outlet } from 'react-router-dom'
import Navbar from '../../Navbar'
import CategoriesComponent from './Category/CategoriesComponent'

const Index = () => {
  return (
      <div className="bottomScreen"> 
        <div className="leftBar">
          <CategoriesComponent/>
        </div>
        <div className="rightScreen">
          {/* <ProductsComponent/> */}
          <Outlet/>
        </div>
    </div>
  )
}

export default Index