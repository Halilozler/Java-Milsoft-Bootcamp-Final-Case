import React, {useEffect, useState} from 'react'
import { Button } from '@mui/material'
import { useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from "react-redux"
import { fetchUser, setLogout } from '../../store/mainstore';


const Profile = () => {
    const { username, email } = useSelector(state => state.mainStore)
    const dispatch = useDispatch()
    let navigate  = useNavigate();

    useEffect(() => {
        if(localStorage.getItem("token") === null && sessionStorage.getItem("token") === null){
            navigate(`/user`);
        }
        if(username === "" || email === ""){
            dispatch(fetchUser());
        }
    }, [username, email]);


    const clickHandler = () => {
        navigate(`/CartSummary`);
    }
    const exit = () => {
        localStorage.removeItem("token");
        sessionStorage.removeItem("token");
        dispatch(setLogout());
        navigate(`/`);
    }
  return (
    <div style={{display: "flex", marginTop: "2rem", marginLeft: "2rem"}}>
        <div style={{display:"flex", flexDirection:"column"}}>
            <img src="/profile.svg" alt="" style={{width: 300}}/>
            <Button variant="contained" color="error" style={{marginTop: "1rem"}} onClick={exit}>
                Çıkış Yap
            </Button>
        </div>
        <div style={{marginLeft: "2rem"}}>
            <h1 style={{margin: 0}}>Profil Bilgileri</h1>
            <p style={{margin: 0, marginTop: "1rem"}}>Kullanıcı Adı: <span style={{fontWeight: "bold"}}>{username}</span></p>
            <p style={{margin: 0, marginTop: "1rem"}}>E-mail: <span style={{fontWeight: "bold"}}>{email}</span></p>
            <Button variant="outlined" style={{marginTop: "1rem"}} onClick={clickHandler}>Geçmiş Siparişlerine Git</Button>
        </div>
        
    </div>
  )
}

export default Profile