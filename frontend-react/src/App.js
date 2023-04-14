import React, { useEffect } from "react";
import Navbar from "./Navbar";
import { useSelector, useDispatch } from 'react-redux';
import Index from "./components/Inventory/Index";
import { setLogin, fetchUser } from "./store/mainstore";

function App() {
  const dispatch = useDispatch();
  const { isAuthenticated } = useSelector(state => state.mainStore)
  useEffect(() => {
    if(localStorage.getItem('token') !== null || sessionStorage.getItem('token') !== null){
      if(!isAuthenticated){
        dispatch(setLogin());
        dispatch(fetchUser());
      }
    }
  }, []);
  return (
    <div className='appScreen'>
      <Navbar/>
      <Index/>
    </div>
  );
}

export default App;
