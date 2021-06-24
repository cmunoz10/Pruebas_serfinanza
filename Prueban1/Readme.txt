Descripción del negocio:
Crear un sistema que se encarga del préstamo de libros en una Biblioteca. El bibliotecario identifica un libro como único por medio del IDLIB
1.   Cuando se desea prestar un libro, al bibliotecario se le debe entregar el IDLIB
2.   Un IDLIB (Libro) no se puede prestar más de una vez
3. Si el IDLIB del libro que se va prestar es palíndromo (Un palíndromo es un número, palabra, o frase que se lee igual al derecho que al revés ejemplo: 1221), debe retornar un mensaje que contenga el siguiente mensaje “los libros palíndromos solo se pueden utilizar en la biblioteca” y no se deberá ejecutar el préstamo.
4. Partiendo de la regla de negocio 1, a la hora de realizar el préstamo se solicite tanto el IDLIB como los datos personales (Nombre, Apellido, Identificación, Fecha Nacimiento, Numero celular) de la persona que realiza el préstamo
5. Si los dígitos numéricos que componen el IDLIB suman más de 40, la fecha de entrega del libro prestado deberá ser máximo 5 días, contando a partir de la fecha actual (incluyendo el día en que se realiza el préstamo) sin contar los domingos. Si la fecha de entrega cae un domingo           deberá ser el siguiente día hábil.  
Esta fecha  usted  la  deberá  calcular  de  acuerdo  a  los  requerimientos  descritos anteriormente, asegúrese de que esta fecha quede almacenada en la base de datos en la entidad del préstamo.

Requerimientos/anotaciones:

-Se utilizo Eclipse. 
-Se requiere la instalacion de Gradle dentro de sus dependencias.
-Se Adjunta imagen con modelo de base de datos.
-Se crear la logica funcional y testeo de funciones.

-Para manipular los préstamos y los libros (CRUD), se deberá hacer uso de los componentes RepositorioLibro y RepositorioPrestamo
Se recomienda seguir los siguientes pasos :
-Tener configurado Java 1.8 como variable de entorno, JAVA_HOME.
-Descargar eclipse Neon.
https://www.eclipse.org/downloads/download.php?file=/oomph/epp/neon/R3/eclipse-inst-win64.exe.
-Abrir eclipse y crear un workspace.
-Instalar el plugin de Gradle.



