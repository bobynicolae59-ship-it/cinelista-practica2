# CineLista - Proyecto base (DAM2D - Desarrollo de Interfaces)

Plantilla inicial de Spring Boot para las practicas de la asignatura
Desarrollo de Interfaces (2º DAM).

**CineLista** es un catalogo personal de peliculas y series con cuatro
secciones: Mi lista, Anadir titulo, Estrenos y Estadisticas.

## Requisitos
* Java 17+
* Maven (o usar el wrapper `./mvnw` / `mvnw.cmd` incluido)

## Como arrancar
```
./mvnw spring-boot:run
```
Y abrir http://localhost:8080/ (redirige a `/mi-lista`).

## Que trae ya resuelto esta plantilla

Para que podais centraros en el **diseño e implementacion del interfaz**
(el objeto de esta asignatura), ya vienen resueltos la capa de datos y el
cableado minimo de controladores:

* `model/Pelicula.java` y `repository/PeliculaRepository.java`: almacen en
  memoria de peliculas. El modelo por ahora solo tiene `id` y `titulo`, a
  juego con el formulario minimo; el resto de campos (genero, plataforma,
  estado, valoracion) se anaden como TODO segun avancen las practicas. En
  el repositorio, `findById` y `deleteById` estan como stub (sin
  implementar) a proposito.
* `controller/PeliculaController.java`: `/mi-lista` (listar) y
  `/anadir-titulo` (mostrar formulario) ya funcionan. Los metodos
  `guardar` y `eliminar` estan a medias a proposito (las rutas existen,
  pero no llaman todavia al repositorio): completarlos es parte de la
  practica.
* `model/Estreno.java`: al igual que `Pelicula`, por ahora solo tiene `id`
  y `titulo`; el resto de campos (`fechaEstreno`, `genero`, `plataforma`)
  se anaden como TODO en la practica de componentes React.
* `controller/EstrenosController.java`: expone `GET /api/estrenos` con
  datos estaticos de ejemplo (por ahora solo el titulo de cada estreno),
  lista para completarse y consumirse despues desde React.
* `model/Estadistica.java`: por ahora solo tiene `id` y `titulo`; el resto de
  campos (`genero`, `taquilla`, `nota`) se anaden como TODO en la practica
  de informes.
* `controller/EstadisticasController.java`: ya tiene una lista estatica de
  ejemplo con `Estadistica` (por ahora solo el titulo de cada fila) y
  resuelve la ruta de la pagina `/estadisticas`. El endpoint
  `GET /api/estadisticas` **NO** esta hecho a proposito: esta comentado en
  el codigo como TODO.
* `templates/fragments/nav.html`: una navegacion minima y sin estilar,
  incluida ya en las 4 paginas, solo para poder pasar de una pantalla a
  otra desde el primer dia. **No** es la barra de navegacion final: hay
  que disenarla y construirla de verdad.
* `templates/fragments/cabecera.html`: un unico fragmento con varios
  bloques (`th:block`) reutilizables entre paginas:
  * `comunes`: lo que usan las 4 paginas (charset, Bootstrap CSS + JS,
    `static/css/estilo.css`).
  * `datatables`: jQuery + DataTables (core), referenciado solo desde
    `estadisticas.html`.
  * `datatables-buttons`: la extension Buttons de DataTables (para el
    export a CSV), referenciada solo desde `estadisticas.html`.
  * `react`: React, ReactDOM y Babel Standalone (CDN), referenciado solo
    desde `estrenos.html`.

  Cada pagina solo incluye los bloques que necesita; no hay que duplicar
  ninguna de estas etiquetas a mano.
* `static/css/estilo.css`: fichero con la paleta de colores y la
  tipografia de ejemplo (variables CSS) pendiente de definir, ya enlazado
  desde `fragments/cabecera.html`.
* `static/data/estrenos.json` y `static/data/estadisticas.json`: json de
  prueba con el mismo formato que devolveran las APIs, accesibles
  directamente en `http://localhost:8080/data/estrenos.json` y
  `http://localhost:8080/data/estadisticas.json`. Utiles como referencia
  rapida del formato de datos, o para apuntar ahi DataTables/fetch
  mientras probais el frontend antes de tener el controlador real.
* `static/js/componentes/TarjetaEstreno.js`: fichero ya creado y listo
  para cargarse desde `estrenos.html`, pero de momento solo trae el
  esqueleto del comentario de documentacion (props, evento, ejemplo de
  uso) sin rellenar y sin la funcion de React implementada.
* `static/js/componentes/test.html`: plantilla de test manual para
  `TarjetaEstreno`, con los `<script>` de React/Babel ya cargados y tres
  bloques marcados con TODO (montar el componente, comprobar el estado
  inicial, simular el click y comprobar el cambio de estado).
* `static/js/estrenos.js`: fichero vacio salvo el comentario de cabecera,
  listo para recibir la logica de `fetch` + montaje de tarjetas.

## Que teneis que hacer vosotros (una practica por seccion)

| Practica                    | Seccion | Ficheros a completar |
|:----------------------------| :---- | :---- |
| **1 - Diseño**              | Todas | Wireframes/mockups (fuera del proyecto, en la memoria) |
| **2 - Editor + Bootstrap**  | Mi lista / Anadir titulo | `model/Pelicula.java` (resto de campos), `templates/mi-lista.html`, `templates/anadir-titulo.html`, `templates/fragments/nav.html`, `static/css/estilo.css`, `PeliculaController.java` (`guardar`, `eliminar`), `PeliculaRepository.java` (`findById`, `deleteById`) |
| **3 - Componentes React**   | Estrenos | `model/Estreno.java`, `controller/EstrenosController.java`, `static/js/componentes/TarjetaEstreno.js`, `static/js/componentes/test.html`, `static/js/estrenos.js`, `templates/estrenos.html` |
| **4 - Informes/DataTables** | Estadisticas | `model/Estadistica.java`, `controller/EstadisticasController.java` (anadir `GET /api/estadisticas`), `templates/estadisticas.html` |

Cada fichero incluye comentarios `TODO` indicando exactamente que hay
que anadir o completar.

## Estructura del proyecto
```
src/main/java/com/example/cinelista/
├── CinelistaApplication.java
├── config/ServletInitializer.java
├── model/        (Pelicula, Estreno, Estadistica)
├── repository/   (PeliculaRepository)
└── controller/   (PeliculaController, EstrenosController, EstadisticasController)

src/main/resources/
├── templates/
│   ├── fragments/
│   │   ├── nav.html       (navegacion minima, compartida por las 4 paginas)
│   │   └── cabecera.html  (bloques comunes, datatables, datatables-buttons, react)
│   └── mi-lista.html, anadir-titulo.html, estrenos.html, estadisticas.html
└── static/
    ├── css/estilo.css
    ├── data/estrenos.json, estadisticas.json   (json de prueba)
    └── js/
        ├── estrenos.js
        └── componentes/    (TarjetaEstreno.js y su test.html)
```

## Build y test
```
./mvnw clean package
./mvnw verify
```