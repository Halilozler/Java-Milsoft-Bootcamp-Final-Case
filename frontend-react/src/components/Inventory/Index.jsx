import React, { useState, useEffect } from 'react'
import { Outlet } from 'react-router-dom'
import Navbar from '../../Navbar'
import CategoriesComponent from './Category/CategoriesComponent'

const Index = () => {
  const [currentYear, setCurrentYear] = useState(null);

  useEffect(() => {
    const year = new Date().getFullYear();
    setCurrentYear(year);
  }, []);
  return (
      <div className="bottomScreen hide_scrollbar"> 
        <div className="leftBar hide_scrollbar">
          <CategoriesComponent/>
        </div>
        <div className="rightScreen">
          {/* <ProductsComponent/> */}
          <Outlet/>
        </div>
        <div className='copyScreen'>
          <p style={{margin: 0, fontWeight: "bold"}}>
            &copy; {currentYear} - MilSOFTBurada Tüm hakları saklıdır.
          </p>
        </div>
    </div>
  )
}

export default Index