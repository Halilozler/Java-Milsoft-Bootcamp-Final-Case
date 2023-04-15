import {NotificationManager} from 'react-notifications';

export default Notification = (type, text) => {
    if(type === 0){
        NotificationManager.error(text,"Hata!" , 2000);
    }else if(type === 1){
        NotificationManager.success(text,"Başarılı!" , 2000);
    }else if(type === 2){
        NotificationManager.warning(text,"Uyarı!" , 2000);
    }else{
        NotificationManager.info(text,"Bilgilendirme!" , 2000);
    }
}