import React, {useState, useEffect} from 'react'
import Button from '@mui/material/Button';
import InputTools from '../Tools/InputTools'
import CheckBoxTool1 from '../Tools/CheckBoxTool1';
import { login, signup } from '../../utils/ApiCommand';
import { setLogin } from '../../store/mainstore';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import Notification from '../../utils/Notification';
const Index = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);
  const navigator = useNavigate();
  const dispatch = useDispatch();

  const handleSubmitLogin = (e) => {
    e.preventDefault();
    // Giriş işlemleri
    login(username, password).then((res) => {
      console.log(res);
      if(res.successful === false){
        Notification(0, "Kullanıcı adı veya şifre hatalı.")
        return;
      }
      if(rememberMe) {
        localStorage.setItem("token", res.data.accessToken);
      } else {
        sessionStorage.setItem("token", res.data.accessToken);
      }
      Notification(1, "Giriş işlemi başarılı.");
      dispatch(setLogin());
      navigator("/");
    }).catch((err) => {
      console.log(err.response.data);
    });
  };

  const handleSubmitRegister = (e) => {
    e.preventDefault();
    // Kayıt işlemleri
    signup(username, email, password).then((res) => {
      //tekrar giriş yapılması istenir.
      Notification(1, "Kayıt işlemi başarılı. Giriş yapılıyor.");
      login(username, password).then((res) => {
        if(rememberMe) {
          localStorage.setItem("token", res.data.accessToken);
        } else {
          sessionStorage.setItem("token", res.data.accessToken);
        }
        Notification(1, "Giriş Yapıldı.");
        dispatch(setLogin());
        navigator("/");
      });
    }).catch((err) => {
      console.log(err.response.data.message);
    });
  };

  return (
    <div
      style={{
        width: "100%",
        display: "flex",
        justifyContent: "center",
        paddingTop: "1rem",
      }}
    >
      <div className="main_user" style={{ display: "flex", width: "720px" }}>
        <div className="left_user">
          <h3>Giriş Yap</h3>
          <form onSubmit={handleSubmitLogin}>
            <InputTools
              title={"Kullanıcı Adı"}
              type={"text"}
              width={285}
              state={username}
              setState={setUsername}
              minLength={3}
            />
            <InputTools
              title={"Şifre"}
              type={"password"}
              width={285}
              state={password}
              setState={setPassword}
              minLength={3}
            />
            <CheckBoxTool1 text={"Beni Hatırla"} setState={setRememberMe}/>
            <Button
              variant="contained"
              style={{ backgroundColor: "#f49b21", marginTop: "0.5rem" }}
              type="submit"
            >
              Giriş Yap
            </Button>
          </form>
        </div>
        <div className="right_user">
          <h3>Üye Ol</h3>
          <form onSubmit={handleSubmitRegister}>
            <InputTools
              title={"Kullanıcı Adı"}
              type={"text"}
              width={285}
              state={username}
              setState={setUsername}
              minLength={3}
            />
            <InputTools
              title={"E-mail"}
              type={"email"}
              width={285}
              state={email}
              setState={setEmail}
            />
            <InputTools
              title={"Şifre"}
              type={"password"}
              width={285}
              state={password}
              setState={setPassword}
              minLength={3}
            />
            <p
              style={{
                width: 290,
                margin: 0,
                marginTop: "1rem",
              }}
            >
              Kişisel verileriniz,{" "}
              <b style={{ color: "blue", cursor: "pointer" }}>
                Aydınlatma Metni
              </b>{" "}
              kapsamında işlenmektedir. “Üye ol” butonuna basarak Üyelik
              Sözleşmesi’ni{" "}
              <b style={{ color: "blue", cursor: "pointer" }}>
                {" "}
                Rıza Metni'ni-Çerez Politikası'nı
              </b>{" "}
              okuduğunuzu ve kabul ettiğinizi onaylıyorsunuz
            </p>
            <Button
              variant="contained"
              style={{ backgroundColor: "#f49b21", marginTop: "0.5rem"  }}
              type="submit"
              >
                Üye Ol
              </Button>
            </form>
          </div>
        </div>
      </div>
    );
  };
  
  export default Index;