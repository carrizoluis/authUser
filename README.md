# authUser
Aplicación de alta de usuarios.

## Tecnología
SpringBoot 2.7.1
Java 1.8
Gradle 7.6.2

## Instrucciones de despliegue en local
Para generar el .jar que luego desplegaremos en el tomcat se debe abrir el proyecto en IntelliJ Community y en la solapa de Gradle ejecutar la task de BUILD.

## Swagger
http://localhost:8087/swagger-ui/index.html

## Postman Collection
`
{
	"info": {
		"_postman_id": "d4ba5918-739a-4bba-8e39-8e99c417bcfd",
		"name": "userAuthGL",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Swagger",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8087/swagger-ui/index.html",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8087",
					"path": [
						"swagger-ui",
						"index.html"
					]
				}
			},
			"response": []
		},
		{
			"name": "SIGN-UP",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n  \"email\": \"mail@hotmail.com\",\r\n  \"name\": \"user\",\r\n  \"password\": \"1234\",\r\n  \"phones\": [\r\n    {\r\n      \"cityCode\": 2323,\r\n      \"countryCode\": \"+54\",\r\n      \"number\": 23234142\r\n    }\r\n  ]\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8087/v1/auth/sign-up",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8087",
					"path": [
						"v1",
						"auth",
						"sign-up"
					]
				}
			},
			"response": []
		}
	]
}
`
