# Documentación de Uso

## Ejecución del Proyecto

### 1.Clonar el Repositorio:

`
git clone https://github.com/AngelVega22/java-api.git
`
### 2.Clonar el Repositorio:

La aplicación estará disponible en http://localhost:8080.
Uso del API
Crear un Tipo de Cambio
URL: http://localhost:8080/api/exchange-rates
Método: POST
Cuerpo de la Solicitud:

`
{
"sourceCurrency": "USD",
"targetCurrency": "EUR",
"exchangeRate": 0.85
}
`

Actualizar un Tipo de Cambio
URL: http://localhost:8080/api/exchange-rates/{id}
(Reemplaza {id} con el ID real del tipo de cambio que deseas actualizar)
Método: PUT
Cuerpo de la Solicitud:

`
{
"sourceCurrency": "USD",
"targetCurrency": "EUR",
"exchangeRate": 0.88
}
`

Obtener un Tipo de Cambio
URL: http://localhost:8080/api/exchange-rates?sourceCurrency=USD&targetCurrency=EUR
(Ajusta los valores de sourceCurrency y targetCurrency según tus necesidades)
Método: GET
Health Check
URL: http://localhost:8080/api/exchange-rates/health
Método: GET