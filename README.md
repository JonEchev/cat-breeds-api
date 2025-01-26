# com.proof.breed

Microservicio para el intercambio de datos a traves de REST para consulta a servicio externo de razas de gatos para la empresa Xpert Group.

> <p>#rest #java #spring-boot </p>

---

## Tabla de Contenido

- [Descripción](#descripción)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Endpoints](#endpoints)
- [Autor y contacto](#autor-y-contacto)

---

## Descripción

API que permite la consulta a servicio externo de razas de gatos.

- En el documento: [1 Prueba Técnica - Backend Java.pdf](https://github.com/JonEchev/shopping-cart/blob/main/requirement_document/Evaluaci%C3%B3n%20T%C3%A9cnica%20Backend%20-%20OUM.pdf) se encuentra el requerimiento completo que se desarrollo para está API.

---

## Construido con

El código se encuentra implementado con Java y Gradle usando las siguientes librerías:

- Lombok - Para simplificar la creación de los medios de acceso a datos de un objeto
- Log4j - Para escribir mensajes de registro
- Swagger - Para la documentación técnica del código

---

## Desarrollo
1. Instale Java 17 y un IDE de desarrollo como IntelliJ.
2. Clone este repositorio desde GitHub: https://github.com/JonEchev/cat-breeds-api rama: main.
3. Permita la construcción del proyecto con gradle.
4. Inicialice el proyecto, ejecutando la clase: CatApplication.java
5. La documentación Swagger del backend se encuentra en la siguiente ruta: http://localhost:80/breeds/swagger-ui/index.html

Para ejecutar las pruebas unitarias:
1. Ejecute el proyecto desde test en gradle.

## Endpoints

- **LOCAL**
    - API (GET): http://localhost:80/breeds/cats/consultAll
    - API (GET): http://localhost:80/breeds/cats/consult/:catBreedId
    - API (GET): http://localhost:80/breeds/cats/search?catQuery=abyssinian

---

## Autor y contacto

- **Nombre**: Jonatan Echeverry
- **Correo electrónico**: jonechev1@gmail.com
- **GitHub**: [@JonEchev](https://github.com/JonEchev)
- **LinkedIn**: [jonatan-echeverry](https://www.linkedin.com/in/jonatan-echeverry-7130251a0/)
- **Blog:** [Crazy Genius!](https://crazycuestionct.blogspot.com/search/label/Programaci%C3%B3n)