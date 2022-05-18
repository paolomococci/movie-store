# movie store publisher

## scaffolding:

```shell
mvn io.quarkus:quarkus-maven-plugin:2.9.1.Final:create -DprojectGroupId=local.moviestore -DprojectArtifactId=publisher -Dextensions="resteasy,resteasy-jackson,quarkus-hibernate-validator,quarkus-jdbc-mariadb,quarkus-hibernate-orm-panache,quarkus-hibernate-orm-rest-data-panache" -DclassName="local.moviestore.publisher.SampleEndpoint" -Dpath="/sample" -DnoExamples
```

## after starting the application with the following command:

```shell
./mvnw compile quarkus:dev
```

## I try to connect to the store endpoint:

```shell
$ curl -w "\n" http://localhost:8080/store
[]
```
