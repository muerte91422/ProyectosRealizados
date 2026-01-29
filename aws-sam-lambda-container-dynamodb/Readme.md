# Battery Catalog API - Serverless con AWS SAM y Lambda Container Image

API RESTful serverless para gestionar un catálogo de baterías (ejemplo educativo/demo).  
Construida con **AWS SAM CLI**, **AWS Lambda** (usando container image con Python 3.12), **Amazon API Gateway** y **DynamoDB**.

## Características principales

- CRUD completo de ítems de baterías
- Tabla DynamoDB con clave primaria `batt_id` y varios **Global Secondary Indexes** (GSI)
- Lambda empaquetada como **container image** (Docker)
- Despliegue mediante **AWS SAM CLI**
- Uso de variables de entorno para configuración
- Respuestas JSON consistentes y manejo básico de errores
- Permisos mínimos con IAM (DynamoDBCrudPolicy)

## Tecnologías utilizadas

- AWS SAM CLI
- AWS Lambda (Python 3.12 – container image)
- Amazon API Gateway (REST)
- Amazon DynamoDB (on-demand)
- Docker
- boto3

## Estructura del proyecto
.
├── hello_world/              # Carpeta con el código de la Lambda (puedes renombrar a battery-api/)
│   ├── app.py                # Código principal de la Lambda
│   ├── requirements.txt      # Dependencias (boto3)
│   └── Dockerfile            # Definición de la imagen Lambda
├── template.yaml             # Plantilla SAM (CloudFormation)
├── samconfig.toml            # (opcional) Configuración de despliegue
└── README.md

## Endpoints disponibles

| Método | Ruta                  | Descripción                          |
|--------|-----------------------|--------------------------------------|
| GET    | `/hello`              | Listar todas las baterías            |
| GET    | `/hello/{id}`         | Obtener una batería por ID           |
| POST   | `/hello`              | Crear una nueva batería              |
| PUT    | `/hello`              | Crear o actualizar batería (upsert)  |
| DELETE | `/hello/{id}`         | Eliminar batería por ID              |

**Recomendación:** Cambia las rutas a `/batteries` y `/batteries/{id}` para que sea más semántico antes de usar en producción o mostrarlo públicamente.

## Requisitos previos

- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html) configurada
- [SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html) ≥ 1.50
- Docker (necesario para construir la imagen)
- Cuenta AWS con permisos para: Lambda, API Gateway, DynamoDB, IAM, CloudFormation

## Instalación y pruebas locales

1. Clonar el repositorio
   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repo.git
   cd nombre-del-repo
2.Construir  la aplicacion
  sam build
3.Iniciar entorno local (con hot-reload)
  sam local start-api
4.Probar endpoints (ejemplos con curl):
  # Listar todas
curl http://127.0.0.1:3000/hello

# Obtener una por ID
curl http://127.0.0.1:3000/hello/bat-001

# Crear una batería (ejemplo)
curl -X POST http://127.0.0.1:3000/hello \
  -H "Content-Type: application/json" \
  -d '{
    "batt_id": "bat-001",
    "battery_name": "PowerWall Demo",
    "brand": "Tesla",
    "model": "PW2025",
    "capacity_kwh": "13.5",
    "power_output": "5",
    "type_device": "home"
  }'

## Despliegue en AWS
1. Construir
  sam build
2.Desplegar (primera vez crea el stack)
  sam deploy --guided
3.Obtendrás la URL de la API en la salida, algo parecido a:
  API Gateway endpoint: https://xxxxxx.execute-api.eu-west-1.amazonaws.com/Prod/hello/

## Limpieza (eliminar recursos)
  sam delete
  O desde la consola AWS → CloudFormation → eliminar el stack.


