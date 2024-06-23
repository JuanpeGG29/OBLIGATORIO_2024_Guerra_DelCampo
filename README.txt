Proyecto por Federica del Campo y Juan Pedro Guerra.

La primer decision que tomamos fue la eleccion de la libreria que ultilizariamos para la carga de los datos, elegimos la libreria openCSV.
La clase LecturaCSV se encarga de leer el archivo, crear instancias de la clase Cancion y almacenarlas en una estructura de datos adecuada (MusicStorage).

Decidimos almacenar las canciones de 3 formas para ayudarnos con las consultas que luego se deben hacer. Se opto por:
 - Un Hash para almacenar las canciones por su ID, permitiendo una búsqueda rápida en tiempo O(1) en promedio.
 - Un BinaryTree para almacenar las canciones por fecha, proporcionando búsquedas y operaciones en tiempo O(log n).
 - Un Hash para almacenar las canciones por combinación de país y fecha, permitiendo una búsqueda eficiente y agrupación de canciones por país y fecha.

Los Artistas los almacenamos en un Hash donde asumimos que el nombre del artista es unico y esa sera la key.

CONSUMO DE MEMORIA Y TIEMPO DE CADA CONSULTA:
- Carga de datos:
  * Tiempo: 7297ms
  * Memoria: 496016312 bytes

- Consulta 1:
  * Tiempo: 63ms
  * Memoria: 0 bytes

- Consulta 2:
  * Tiempo: 69ms
  * Memoria: 526336 bytes

- Consulta 3:
  * Tiempo: 165ms
  * Memoria: 0 bytes

- Consulta 4:
  * Tiempo: 4ms
  * Memoria: 0 bytes

- Consulta 5:
  * Tiempo: 168ms
  * Memoria: 0 bytes

- Total:
  * Tiempo: 7297ms
  * Memoria: 498113464 bytes


