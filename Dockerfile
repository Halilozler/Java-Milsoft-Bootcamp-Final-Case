# Temel imaj olarak OpenJDK 17 kullanılıyor
FROM openjdk:17

# İmaj içinde çalışacak uygulamanın dizini
ARG APP_DIR=/app

# Uygulama dizinini oluşturun ve çalışma dizini olarak ayarlayın
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}

# Uygulama JAR dosyasını ve gerekli dosyaları imaja kopyalayın
COPY target/*.jar app.jar

# Uygulamanın çalışacağı port
EXPOSE 8080

# Uygulamayı başlatma komutu
CMD ["java", "-jar", "app.jar"]
