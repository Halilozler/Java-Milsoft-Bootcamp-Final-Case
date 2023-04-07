import React, { useEffect } from "react";
import { Outlet } from "react-router-dom";

function App() {
  let year = new Date().getFullYear();
  return (
  <div className='appScreen'>
        <header>
            <h1>MilSOFTBurada</h1>
        </header>
        <body>
          <Outlet/>
        </body>
        <footer>
            <p>© {year} MilSOFTBurada Tüm Haklar Saklıdır</p>
        </footer>
    </div>
  );
}

export default App;
