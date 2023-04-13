import React, {useState, useEffect} from 'react'
import Button from '@mui/material/Button';
import InputTools from '../Tools/InputTools'
import CheckBoxTool1 from '../Tools/CheckBoxTool1';

const Index = () => {
  return (
    <div style={{width: "100%", display: "flex", justifyContent: "center", paddingTop: "1rem"}}>
        <div className='main_user' style={{display: "flex", width: "720px"}}>
            <div className='left_user'>
                <h3>Giriş Yap</h3>
                <div style={{}}>
                    <InputTools title={"Kullanıcı Adı"} type={"text"} width={285}/>
                </div>
                <div style={{paddingTop: "1rem"}}>
                    <InputTools title={"Şifre"} type={"password"} width={285}/>
                </div>
                <div style={{paddingTop: "1rem"}}>
                    <CheckBoxTool1 text={"Beni Hatırla"}/>
                </div>
                <div style={{paddingTop: "1rem"}}>
                    <Button variant="contained" style={{backgroundColor: "#f49b21"}}>Giriş Yap</Button>
                </div>
            </div>
            <div className='right_user'>
                <h3>Üye Ol</h3>
                <div style={{}}>
                    <InputTools title={"Kullanıcı Adı"} type={"text"} width={285}/>
                </div>
                <div style={{paddingTop: "1rem"}}>
                    <InputTools title={"E-mail"} type={"email"} width={285}/>
                </div>
                <div style={{paddingTop: "1rem"}}>
                    <InputTools title={"Şifre"} type={"password"} width={285}/>
                </div>
                <p style={{width: 290, margin: 0, marginTop: "1rem"}}>Kişisel verileriniz, <b style={{color: "blue"}}>Aydınlatma Metni</b>  kapsamında işlenmektedir. “Üye ol” butonuna basarak Üyelik Sözleşmesi’ni <b style={{color: "blue"}}> Rıza Metni'ni-Çerez Politikası'nı</b> okuduğunuzu ve kabul ettiğinizi onaylıyorsunuz</p>
                <div style={{paddingTop: "1rem"}}>
                    <Button variant="contained" style={{backgroundColor: "#f49b21"}}>Üye Ol </Button>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Index