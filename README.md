<<<<<<< HEAD
# portal-sira
=======
# Portal Sira Backend

Projeto backend em Java 7 (Spring MVC) para o sistema de Passagem de Serviço Sira CPD.

## Estrutura Sugerida

```
portal-sira-backend/
  ├── src/
  │   ├── main/
  │   │   ├── java/
  │   │   │   └── br/
  │   │   │       └── com/
  │   │   │           └── sira/
  │   │   │               ├── controller/
  │   │   │               ├── model/
  │   │   │               ├── repository/
  │   │   │               ├── service/
  │   │   │               └── util/
  │   │   ├── resources/
  │   │   │   └── db.properties
  │   │   └── webapp/
  │   │       ├── WEB-INF/
  │   │       │   ├── jsp/
  │   │       │   ├── web.xml
  │   │       │   ├── dispatcher-servlet.xml
  │   │       │   └── applicationContext.xml
  │   │       └── static/
  ├── pom.xml
  └── README.md
```

## Como iniciar

1. Configure o banco PostgreSQL e edite `src/main/resources/db.properties`.
2. Execute `mvn clean install` para baixar as dependências.
3. Implemente os módulos conforme a necessidade.
4. O deploy pode ser feito em um servidor Tomcat 7+.
>>>>>>> 2775b39 (Commit inicial do portal-sira-backend com estrutura e funcionalidades)
