# movie store publisher

## scaffolding:
```
mvn io.quarkus:quarkus-maven-plugin:2.3.0.Final:create -DprojectGroupId=local.moviestore -DprojectArtifactId=publisher -Dextensions="resteasy,resteasy-jackson,quarkus-hibernate-validator,quarkus-jdbc-mariadb,quarkus-hibernate-orm-panache,quarkus-hibernate-orm-rest-data-panache" -DclassName="local.moviestore.publisher.SampleEndpoint" -Dpath="/sample" -DnoExamples
```

## after starting the application with the following command:
```
./mvnw compile quarkus:dev
```

## I try to connect to the store endpoint:
```
$ curl -w "\n" http://localhost:8080/store
[]
```
