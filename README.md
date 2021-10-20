# Ejercicio técnico para Temperies

### Documentación
Los pasos para poder inicializar la aplicación son los siguientes:

* En primer lugar se debe generar una instancia de MySQL Server en el puerto 3306. 
El nombre del esquema definido en el script DDL es "MovieSystem" y la aplicación usará el usuario y contraseña root/root. 
(En caso de querer cambiar cualquiera de estas opciones, modificar el application.properties)

* Compilar el proyecto (mvn clean package)

* Ejecutar el archivo run.sh

### URL's y endpoints
A continuación se listan algunas de las url's más importantes para revisar el proyecto.

* El basepath es: http://127.0.0.1:8080/api/v1
* La aplicación contiene documentación Swagger. Se puede acceder desde: http://127.0.0.1:8080/api/v1/swagger-ui.html

