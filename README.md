# MilSOFTBurada (Java Milsoft Bootcamp Final Case)

## Kurulum
Proje docker üzerinden çalıştığından dolayı ilk başta bilgisayarımızda docker olmalıdır. <br/>
Docker indirme linki: https://www.docker.com/ adresinden kullandığınız işletim sistemini seçerek indirebilirsiniz. <br/>
Docker kurulumu yaptıktan sonra. Terminal(CMD) üzerinden indirdiğiniz dosyaya gidiniz. <br/>
Sonra ise aşağıda bulunan komutu çalıştırınız. <br/>
1- docker-compose up    <br/>

kurulum bittikten sonra http://localhost:3000 web sitesine giderek uygulamayı kullanabilirsiniz. <br/>

## Veritabanı Şemamız
<img width="600" alt="Screenshot 2023-04-16 at 10 39 41" src="https://user-images.githubusercontent.com/45699509/232283395-78edc5f6-48cc-40a6-ad45-18c91c566751.png"> <br/>
**Cart:** Sepet tiplerimizin tutulduğu ve hangi kullanıcı(users) hangi sepete ait tutulur. <br/>
**Users:** Kullanıcı bilgilerimiz tutulur.  <br/>
**Role:** İlerde olabilecek program genişlemesin ek konulmuştur. Kullanıcı rolerini tutmaktadır.  <br/>
**Users_roles:** Role ve User tablolarının çoka-çok(many to many) ilişkisi kapsamında oluşturuluş tablodur. <br/>
**Category:** Kategori bilgilerimizi tutan tablomuz.  <br/>
**Product:** Ürün bilgilerimizi tutan tablomuz. <br/>
**Cart_product:** Ürünlermiz hangi sepete(cart) ait ne kadar alınmış gibi bilgileri tutmaktadır. Product ve Cart tablolarımıza ilişkisi vardır.   <br/>

## Endpointler
Öncelikli olarak projemin genel hatlarını anlatırsam. Her kullanıcımızın kendine ait 1 tane NEW cartStatu, sepeti(cart) bulunmaktadır. O yüzden backend tarafında işlemlerimizi token içinde saklanan userId alınarak user üzerinden NEW sepete(cart) erişim sağlanmaktadır. Bunun yanında tammalanan sepetlerimizede aynı şekilde userId üzerinden erişim sağlanmaktadır. Bir sepet tamamlandığında yani sipariş verildiğinde sepet NEW durumundan COMPLETE çekilir. Kullanıcı yeni bir ürün eklemeye çalıştığında NEW statülü sepeti var mı diye bakılır yoksa oluşturulur ve sepeti olmuş olur. Tekrar COMPLETE çekilesiye kadar oluşturulmuş sepet üstünden işlem yapılır. <br/>
(+) -> Token gerekli olan endpointler. <br/>

### Auth
***(post) api/auth/signup*** -> Üye olmamızı sağlayan endpoint. Body: {"username":... , "email":... , "password":...} <br/>
***(post) api/auth/signin*** -> Sisteme giriş yapmamızı sağlayan endpoint. Body: {"username":... , "password":...} <br/>
***(get)(+) api/auth/profile*** -> Token içinden userId alarak bunun karşılığı kullanıcı bilgileri döndüren endpoint. <br/>

### Category
***(get) api/category/categories*** -> Kategorilerimizi getiren endpoint <br/>

### Product
***(get) api/product/products/{categoryId}*** -> Kategory id alarak o kategorinin altındaki ürünleri(product) getiren endpoint. <br/>
***(get) api/product/product/{productId}*** -> Product id alarak ürünü ggetiren endpoint. <br/>

### Cart(Cart işlemleri için token gerekmektedir)
***(get)(+) api/cart/get*** -> Cart statüsü NEW olan cart bilgilerini getirir. Eğer yok ise oluşturur. <br/>
***(get)(+) api/cart/get/new*** -> Cart statüsü NEW olan carta ait kayıtlı olan cart_product tablosunu getirir. <br/>
***(get)(+) api/cart/get/completed*** -> Cart statüsü COMPLETE olan cartlara ait cart_product tablosunu getirir. <br/>
***(del)(+) api/cart/remove/all*** -> Kullanıcıya ait olan NEW statülü Cartı bulur ve cart_product tablosundaki bütün ilişkili productlarını siler. <br/>
***(del)(+) api/cart/remove/{productId}*** -> cart_product içinden NEW statülü carta bağlı productı bulur ve satırı tamamen siler. <br/>
***(del)(+) api/cart/remove/quantity/{productId}*** -> cart_product içinden NEW statülü carta bağlı product bulur ve cart_product içinde bulunan salesQuantity tablosundaki değeri eğer 1 değilse 1 düşürür. <br/>
***(post)(+) api/cart/add/{productId}/{salesQuantity}*** -> cart_product içinden Kullanıcın NEW sepetini bulur ve cart - product satır varmı bakar. eğer yoksa salesQuantity doldurarak oluşturur. Eğer var ise salesQuantity satırını gelen sayıya göre artırır. <br/>
***(put)(+) api/cart/checkout*** -> Bizim uygulamamızda cart oluşurken otomatik Kard numarası(CardNumber) atanmaktadır. Kullanıcı bu Kart numarasını değiştirmek isterse bu endpoint ile gerçekleştirir. Bu sepete onaylama aşaması yani kredi kartı ile ödeme sayfası olduğundan dolayı NEW olan sepetimizi(cart) COMPLETE çeker ve ürün sipariş verilmiş gibi gösterilir. Body: {"cartId":..., "cardNumber":...} Burada cartId önemsizdir zaten token içinden userId aracılığı ile kullanıcı sepetine erişiyoruz. <br/>

## Backend-Rest Spring Boot
Kendi içinde loglama yapısı bulunmaktadır. <br/>
Bizim yazdığımız BaseResponse sınıfı ile geriye veri döndürmektedir. <br/>
Global Exception ile hatalar tek bir yerden yakalanmaktadır. <br/>
Token işlemleri yapılmaktadır. <br/>
 
## Resimler(Frontend-React Tarafı)
Ana Sayfamız <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 44 14" src="https://user-images.githubusercontent.com/45699509/232287857-94810cb7-659c-4d2d-b9dd-83e5a7e2edd6.png"> <br/>
Eğer olmayan bir url gitiğimizde 404 sayfamız <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 45 25" src="https://user-images.githubusercontent.com/45699509/232287887-e80a9c23-29c8-4397-892a-943d65968359.png"> <br/>
Giriş ve Üye olma sayfamız <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 45 01" src="https://user-images.githubusercontent.com/45699509/232287964-a66f2587-3537-4cc0-9e63-b7c9ccaad97b.png"> <br/>
Giriş yaptıktan sonra Navbar değişir ve Profil sayfamız <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 47 09" src="https://user-images.githubusercontent.com/45699509/232288010-375651d5-3e93-4ade-9ba9-24b057c8950c.png"> <br/>
Kategori altında ürünler sayfamız <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 46 20" src="https://user-images.githubusercontent.com/45699509/232288048-cd5ef35f-9005-4d16-b4fa-93785a00f6e6.png"> <br/>
Ürüne özel sayfamız <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 46 37" src="https://user-images.githubusercontent.com/45699509/232288072-c808cf7f-02a7-4cea-8773-18399dea9df8.png"> <br/>
Ürün sepete eklendiğinde çıkan bildirim. Bütün işlemler için bildirim çıkmaktadır. <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 50 37" src="https://user-images.githubusercontent.com/45699509/232288102-5934c985-9601-49ab-a061-03c13433fde7.png"> <br/>
Sepetimiz <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 48 06" src="https://user-images.githubusercontent.com/45699509/232288120-5e86bdc1-c310-4ec8-af1b-97b5db70771b.png"> <br/>
Ödeme sayfamız: <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 48 36" src="https://user-images.githubusercontent.com/45699509/232288141-3e3df292-70bd-4cb4-b034-3554507109a8.png"> <br/>
Ödeme yap butonuna bastıktan sonra temsili çıkan bekleme ekranı(2 saniye bekletir) <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 49 33" src="https://user-images.githubusercontent.com/45699509/232288187-168fa5cb-6780-48c2-a972-9fd63cd36f60.png"> <br/>
Profil sayfasında eriştiğimiz Geçmiş Siparişler sayfası <br/>
<img width="600" alt="Screenshot 2023-04-16 at 11 50 25" src="https://user-images.githubusercontent.com/45699509/232288216-2442d9ae-1a7d-4477-9aec-b641d71db475.png">



















