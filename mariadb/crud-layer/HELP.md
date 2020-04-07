# Example of use

## RESTful perspective:

```
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"action","description":"simple action movie"}' http://127.0.0.1:8080/categories
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /categories HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.61.1
> Accept: */*
> Content-Type:application/json
> Content-Length: 53
> 
* upload completely sent off: 53 out of 53 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8080/categories/10001
Location: http://127.0.0.1:8080/categories/10001
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 07 Apr 2020 08:06:04 GMT
Date: Tue, 07 Apr 2020 08:06:04 GMT

< 
{
  "name" : "action",
  "description" : "simple action movie",
  "updated" : null,
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/categories/10001"
    },
    "category" : {
      "href" : "http://127.0.0.1:8080/categories/10001"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/categories/10001
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /categories/10001 HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 07 Apr 2020 08:06:40 GMT
Date: Tue, 07 Apr 2020 08:06:40 GMT

< 
{
  "name" : "action",
  "description" : "simple action movie",
  "updated" : "2020-04-07T06:06:04.000+0000",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/categories/10001"
    },
    "category" : {
      "href" : "http://127.0.0.1:8080/categories/10001"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## database perspective:

```
MariaDB [moviestoredb]> select * from category;
+-------+--------+---------------------+---------------------+
| id    | name   | description         | updated             |
+-------+--------+---------------------+---------------------+
| 10001 | action | simple action movie | 2020-04-07 08:06:04 |
+-------+--------+---------------------+---------------------+
1 row in set (0.000 sec)
```
