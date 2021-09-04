# moviestore-graphql-api

## application developed to provide a complete and understandable description of the data exposed in the API, thanks to the GraphQL language

### I start the new project with the scaffolding of the application:
```
mvn io.quarkus:quarkus-maven-plugin:2.2.1.Final:create -DprojectGroupId=local.moviestore -DprojectArtifactId=moviestore-graphql-api -DclassName="local.moviestore.MoviestoreAtWorkResource" -Dextensions="resteasy,graphql,quarkus-hibernate-validator,quarkus-jdbc-mariadb,quarkus-hibernate-orm-panache" -DnoExamples -DbuildTool=gradle
```

### I start a test session with:
```
./gradlew test
```

### I start a test native session with:
```
./gradlew testNative
```

### how to get a list of extensions available with:
```
./gradlew listExtensions
```

### for example, once I find the extension that interests me, I proceed with adding this dependency:
```
./gradlew addExtension --extensions="extension_name_of_interest"
```

### now I can start the application in development mode:
```
./gradlew quarkusDev
```
