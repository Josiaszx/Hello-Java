# Consumir API REST
[Implementacion en codigo](../api/src/main/java)

## Componentes

### 1. RequestBody.java

Clase POJO (Plain Old Java Object) que representa la estructura de datos para las peticiones y respuestas HTTP.

**Propiedades:**

- `id`: Identificador único de la transcripción
- `text`: Contenido de texto transcrito
- `audio_url`: URL del archivo de audio a procesar
- `status`: Estado actual del proceso de transcripción

## Flujo de proceso

### Configuración Inicial

**Dependencias utilizadas:**

- `HttpClient`: Cliente HTTP nativo de Java para ejecutar peticiones
- `HttpRequest`: Constructor de peticiones HTTP
- `HttpResponse`: Contenedor de respuestas HTTP
- `Gson`: Biblioteca de Google para serialización/deserialización JSON

**Parámetros de entrada:**
El programa recibe dos API keys como argumentos de línea de comandos:

- `args[0]`: API key de API-Football
- `args[1]`: API key de AssemblyAI

### Ejemplo 1: Petición GET

**API utilizada:** API-Football

**Proceso:**

1. **Construcción de la petición:**
    - Endpoint: `https://v3.football.api-sports.io/teams?id=1176`
    - Método: GET
    - Header de autenticación: `x-apisports-key` con el valor de la API key
2. **Ejecución:**
    - Se crea un cliente HTTP
    - Se envía la petición y se captura la respuesta como String
3. **Procesamiento de respuesta:**
    - Se extrae el body de la respuesta
    - Se muestra el JSON sin formato
    - Se formatea el JSON usando pretty printing para mejor legibilidad

### Ejemplo 2: Petición POST con Polling

**API utilizada:** AssemblyAI

**Proceso:**

### Fase 1: Iniciar transcripción (POST)

1. **Preparación del payload:**
    - Se crea una instancia de `RequestBody`
    - Se establece la URL del audio a transcribir
    - Se serializa el objeto a JSON usando Gson
2. **Construcción de la petición:**
    - Endpoint: `https://api.assemblyai.com/v2/transcript`
    - Método: POST
    - Header: `Authorization` con la API key
    - Body: JSON con la URL del audio
3. **Ejecución:**
    - Se envía la petición
    - Se recibe una respuesta que incluye el ID de la transcripción
4. **Extracción del ID:**
    - Se deserializa la respuesta JSON a un objeto `RequestBody`
    - Se obtiene el ID para consultas posteriores

### Fase 2: Consultar estado (GET con Polling)

1. **Construcción de petición de consulta:**
    - Endpoint: `https://api.assemblyai.com/v2/transcript/{id}`
    - Método: GET
    - Header: `Authorization` con la API key
2. **Loop de polling:**
    - Se ejecuta un bucle infinito que consulta el estado cada 2 segundos
    - En cada iteración:
        - Se envía la petición GET
        - Se deserializa la respuesta
        - Se verifica el campo `status`
3. **Condiciones de salida:**
    - **Status "completed":** Transcripción exitosa, se muestra el texto y termina el loop
    - **Status "error":** Fallo en la transcripción, se muestra error y termina el loop
    - **Cualquier otro status:** Continúa esperando
4. **Intervalo de espera:**
    - Se utiliza `Thread.sleep(2000)` para pausar 2 segundos entre consultas

## Ejecución

Para ejecutar el programa:

```bash
java RestApiCall <API_KEY_FOOTBALL> <API_KEY_ASSEMBLYAI>
```