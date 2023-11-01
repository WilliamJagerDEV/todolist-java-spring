# todolist-java-spring

## API REQUESTS

### Cadastro de Usuários
POST - url: http://localhost:8080/users/
Body - json
{
    "name": "William Jager",
    "username": "JagerDEV",
    "password": "100senha"
}

### Cadastro de Tarefas
Auth - Type: Basic Auth (username, password)

POST - url: http://localhost:8080/tasks/
{
    "description": "Ir para academia as 8h",
    "title": "Projeto TodoList Java Spring",
    "priority": "ALTA",
    "startAt": "2023-11-01T08:00:00", 
    "endAt": "2023-11-01T16:00:00", 
    "idUser": ""
}


### Buscar Tarefas
Auth - Type: Basic Auth (username, password)

GET - url: http://localhost:8080/tasks/

### Alterar Tarefa
Auth - Type: Basic Auth (username, password)

PUT - url: http://localhost:8080/tasks/8ceee112-df61-425d-872b-cc8a172083c4

{
    "title": "TodoList - Java Spring"
}

### H2 Database
- console: http://localhost:8080/h2-console/