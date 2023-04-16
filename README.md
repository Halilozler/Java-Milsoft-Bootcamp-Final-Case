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
 
## Resimler












