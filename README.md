# Calculator

Microservicio para la implementaci贸n de una calculadora.

##  馃殌 Ejecuci贸n del proyecto

### 馃敡 Instalaci贸n

Para ejecutar el proyecto se deben tener los siguientes requerimientos:
- OpenJDK 17
- Maven 3.8.4

IDE usado: Spring Tool Suite 4 

### Ejecutar proyecto

1 - Descargar el proyecto, instalarlo como proyecto maven y realizar "update project" con maven
2 - Compilar con maven install
3 - Ejecutar como "Spring boot app"

### 鈿欙笍 Ejecutar tests
```
maven test
```
### EndPoint

La direcci贸n de despliegue es "localhost:9090/api/operation"

## 馃洜 Technical design

### Layers

Los paquetes del proyecto se encuentran estructurados de la siguinte forma:

- /controller: Implementaci贸n del REST API.
- /controller.exceptions: Controller advice para manejar excepciones.
- /enums: Enum para almacenar las distintas operaciones.
- /exceptions: Excepciones personalizadas del proyecto.
- /factories: Clases para la creaci贸n de las distintas operaciones.
- /request: Petici贸n que debe enviar el usuario al endpoint del servicio REST API.
- /service: Capa en la que se encuentran los servicios del proyecto para realizar las operaciones.

## 锔? Author
* **Santiago Fraga**
