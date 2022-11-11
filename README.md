# CalculatorSanitas-AngelMartinez

Proyecto Maven-springBoot para compilar en war
Java 1.8

Ejecutar en la clase com.operation.calculator.CalcApplication  con: Run "Spring Boot App" o "Java Application" 
el servicio se levatará en el puerto 8084

Host: localhost
port: 8084
Rest: calc

Invocaciñon a: http://localhost:8084/calc
parámetro de entrada String form-data  :  
	Key: RequestOperacion
	Value: <<String con la operación a realizar>>

Para mayor facilidad en pruebas en la raíz del proyecto se encuentra un fichero Postman "calc.postman_collection.json" para importar y realizar las invocaciones deseadas una vez levantado el Rest

Adicionalmente para probar gráficamente el ApiRest pueden utilizar la siguiente sentencia para abrir un HTML calculadora que he desarrollado y lo tengo en mi repositorio gitHub desplegado y lee en Rest en http://localhost:8084/calc
En Windows: Inicio/Ejecutar:
	chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security "https://angelmc1981.github.io/calculator/"



** Por otro lado Si se utilizan otro software que no sea postman para la invocación estos son los datos a configurar:
 
POST http://localhost:8084/calc
Request Headers
	User-Agent: PostmanRuntime/7.29.0
	Accept: */*
	Cache-Control: no-cache
	Host: localhost:8084
	Accept-Encoding: gzip, deflate, br
	Connection: keep-alive
	Content-Type: multipart/form-data
	Content-Length: ##
Request Body
	RequestOperacion: "2*7+100/2"