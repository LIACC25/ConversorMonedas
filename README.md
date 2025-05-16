Esta aplicación en java tiene un menu que permite realizar cambio de moneda y el valor de la moneda la obtiene a traves de un API.
API exchangerate
Uso java 17 gson para parsear a formato JSON
#funciones app
Uso un menu de 9 opciones la 9 es salir las conversiones que usa la app son USD, COP, BRL, ARS, CLP.
utiliza una entrada de datos para elegir una opcion del menu valida que el usuario ingrese un numero, en caso se limpia la consola y solicita de nuevo la respuesta del usuario.

<img width="602" alt="image" src="https://github.com/user-attachments/assets/5b3e0db5-2ec6-4e9c-a9f0-5e54341ee8cc" />


Tiene 3 clases y 1 clase principal
En la clase principal esta el menu con un switch para llamar para ingresar el valor de las monedas a convertir y a su vez hay otro metodo fuera de la clase principal que llama a la
API a traves de los parametros.

En la clase Monedas esta variable tipoMoneda y valor y sus dos funciones de conversion.
En la clase API se estable la conexión con API  exchangerate, instanciar a gson 
En la clase cambioTipo se realiza un mapeo de la conversiones que tiene la API 




