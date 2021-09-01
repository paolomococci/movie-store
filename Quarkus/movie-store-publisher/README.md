# movie store publisher

## scaffolding:
```
mvn io.quarkus:quarkus-maven-plugin:2.2.1.Final:create -DprojectGroupId=local.moviestore -DprojectArtifactId=publisher -Dextensions="resteasy,resteasy-jackson,quarkus-hibernate-validator,quarkus-jdbc-mariadb,quarkus-hibernate-orm-panache,quarkus-hibernate-orm-rest-data-panache" -DclassName="local.moviestore.publisher.SampleEndpoint" -Dpath="/sample" -DnoExamples
```

## As an example, I try to connect to the store endpoint:
```
$ curl -w "\n" http://localhost:8080/store
[]
```
