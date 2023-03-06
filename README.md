# Prueba_Nivel1_LuisMiguelUrbez_TecProgramacion

## Repositorio: https://github.com/LuisMi01/Prueba_Nivel1_LuisMiguelUrbez_TecProgramacion/tree/main

## Ejercicio a realizar: 
el DLE (Diccionario de la Real Academia EspaÑola (https://www.rae.es/obras-academicas/diccionarios/diccionario-de-la-lengua-espanola))tiene 93 000 palabras, si utilizaremos una lista enlazada para almacenar todas las palabras y luego si tenemos que buscar una palabra en dicha estructura el costo es del orden de O(n), es decir 93 000, pero si en su lugar utilizamos una tabla hash encadenada de 28 posiciones (una para cada letra del abecedario) y supongamos que la cantidad de palabras que empieza con cada letra es aproximadamente similar (más allá que no lo sea) el costo de buscar una palabra en este caso es del orden de O(1+a), esto es igual a (1 + 93 000/28) aproximadamente 3 322, lo cual implica una diferencia significativa respecto a la eficiencia de ambas estructuras.

Ahora que ya tenemos un panorama general respecto de las tablas hash es momento de adentrar- nos en la implementación. El TDA tabla hash estará compuesto básicamente de un vector de n elementos al que denominaremos “tabla”. Y además contará con un conjunto de funciones que describen su comportamiento, las cuales se enumeran a continuación:



crear_tabla(tamaño). Crea y devuelve una tabla hash vacía con la cantidad de elementos, deter- minado por el tamaño ingresado

agregar(tabla, dato). Agrega el elemento a la tabla en la posición determinada por la función hash, si se produce una colisión se deberá reubicar el elemento con una función de sondeo y si es una tabla encadenada deberá utilizar una función extra para insertarla en la estructura auxiliar

quitar(tabla, dato). Elimina y devuelve el elemento de la tabla en la posición indicada por la función hash, puede requerir además aplicar la función utilizada en la inserción para resolver colisiones para encontrar dicho elemento o una función extra si es una tabla encadenada. Si devuelve None significa que no se encontró el dato en la tabla –y por ende no se elimina nin- gún elemento–

buscar(tabla, dato). Devuelve la posición de la tabla en la que se encuentra el elemento busca- do, puede requerir utilizar la función utilizada en la inserción para resolver las colisiones –si es una tabla hash cerrada– o una función extra si es una tabla hash encadenada. Si devuelve None significa que no se encontró la clave en la lista

funcion_hash(dato, tamaño_tabla). Devuelve la posición que le corresponde al dato en el vec- tor. Es probable que se disponga de más de una función hash dado que no se utilizará siempre la misma y dependerá del dominio de los datos.



sondeo(posicion, tamaño_tabla). Devuelve la nueva posición que le corresponde al dato en la tabla, para poder resolver las colisiones, o estructura auxiliar que permita resolver las colisio- nes que ocurran.

 cantidad_elementos(tabla). Devuelve la cantidad de elementos en la tabla, puede requerir uti- lizar alguna función extra si es una tabla encadenada para contar los elementos de la estruc- tura auxiliar.



A diferencia de los TDA anteriores no es necesario definir una estructura de datos –dado que solo se utilizará un vector–, por lo que en las figuras 7, 8, 9 y 10 se puede observar la implementación de las funciones mencionadas previamente, nótese que varias funciones están dos veces dado que se presentan las alternativas para tabla hash cerrada y encadenada –incluso algunas están incomple- tas–; además solo se presenta una función hash y quedará a cargo del alumno desarrollar las otras como también las funciones de sondeo para completar las que no están completas. Estos serán los eventos con los que contaremos para trabajar con las tablas hash.
