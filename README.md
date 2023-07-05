# GameStore
Tarea 3 Pruebas de Software

Se desarrolló un simulador simple de gestión de una tienda de videojuegos, que funciona a partir de la línea de comandos. El simulador debe administrar algunos aspectos del negocio
y otorgar las funcionalidades que se dan como requerimientos en el enunciado, que son el manejo de usuarios, la visualización del catálogo para clientes y administradores, la compra
y venta de juegos dependiendo del status del usuario, la gestión de inventario y la generación de un reporte simple.

Los archivos con los que funciona el simulador son Game.java, donde se estructura todos los datos y métodos en torno a los juegos, Store,java, donde se definen todas las funcionalidades
que debe poder realizar la tienda, GameStoreSimulator.java, que es donde se modela el comportamiento de la línea de comandos en cuanto a las diferentes entradas y opciones que hay, implementando
las funcionalidades que hay en Store.java para que funcione correctamente, y Main que es donde se corre todo el programa.

Se tiene StoreTest.java, que es el archivo que corresponde a las pruebas unitarias realizadas con JUnit con el fin de probar todas las funcionalidades del sistema definidas en Store.java

Para compilar el programa, primero hay que colocarse en la carpeta src, y en la línea de comandos colocar el siguiente comando:

    javac com/gamestore/models/Game.java com/gamestore/Store.java com/gamestore/GameStoreSimulator.java com/gamestore/Main.java

Para correr el programa, hay que colocarse en la carpeta raíz del proyecto y colocar el siguiente comando:

    java -cp src com.gamestore.Main

Para compilar el archivo de pruebas hay que colocarse en la carpeta raíz del proyecto y colocar el siguiente comando:

    javac -cp lib/junit.jar:lib/hamcrest.jar -d bin src/com/gamestore/*.java test/com/gamestore/StoreTest.java

Para correr el archivo de pruebas se debe ejecutar el siguiente comando:

    java -cp lib/junit.jar:lib/hamcrest.jar:bin org.junit.runner.JUnitCore com.gamestore.StoreTest

  

