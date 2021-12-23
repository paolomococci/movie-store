# crud-layer-h2

## address

```shell
curl -v -i http://localhost:8090/addresses
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /addresses HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:47:52 GMT
Date: Sun, 24 Jan 2021 17:47:52 GMT

< 
{
  "_embedded" : {
    "addresses" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/addresses"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/addresses"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## category

```shell
curl -v -i http://localhost:8090/categories
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /categories HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:54:14 GMT
Date: Sun, 24 Jan 2021 17:54:14 GMT

< 
{
  "_embedded" : {
    "categories" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/categories"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/categories"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## city

```shell
curl -v -i http://localhost:8090/cities
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /cities HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:54:41 GMT
Date: Sun, 24 Jan 2021 17:54:41 GMT

< 
{
  "_embedded" : {
    "cities" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/cities"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/cities"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## content

```shell
curl -v -i http://localhost:8090/contents
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /contents HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:55:07 GMT
Date: Sun, 24 Jan 2021 17:55:07 GMT

< 
{
  "_embedded" : {
    "contents" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/contents"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/contents"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## country

```shell
curl -v -i http://localhost:8090/countries
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /countries HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:55:32 GMT
Date: Sun, 24 Jan 2021 17:55:32 GMT

< 
{
  "_embedded" : {
    "countries" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/countries"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/countries"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## customer

```shell
curl -v -i http://localhost:8090/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /customers HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:55:56 GMT
Date: Sun, 24 Jan 2021 17:55:56 GMT

< 
{
  "_embedded" : {
    "customers" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/customers"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/customers"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## district

```shell
curl -v -i http://localhost:8090/districts
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /districts HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:56:44 GMT
Date: Sun, 24 Jan 2021 17:56:44 GMT

< 
{
  "_embedded" : {
    "districts" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/districts"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/districts"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## inventory

```shell
curl -v -i http://localhost:8090/inventories
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /inventories HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:57:08 GMT
Date: Sun, 24 Jan 2021 17:57:08 GMT

< 
{
  "_embedded" : {
    "inventories" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/inventories"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/inventories"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## iso3166

```shell
curl -v -i http://localhost:8090/countryCodes
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /countryCodes HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:57:36 GMT
Date: Sun, 24 Jan 2021 17:57:36 GMT

< 
{
  "_embedded" : {
    "iso3166s" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/countryCodes"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/countryCodes"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## language

```shell
curl -v -i http://localhost:8090/languages
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /languages HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:58:12 GMT
Date: Sun, 24 Jan 2021 17:58:12 GMT

< 
{
  "_embedded" : {
    "languages" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/languages"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/languages"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## movie

```shell
curl -v -i http://localhost:8090/movies
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /movies HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:58:38 GMT
Date: Sun, 24 Jan 2021 17:58:38 GMT

< 
{
  "_embedded" : {
    "movies" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/movies"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/movies"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## payment

```shell
curl -v -i http://localhost:8090/payments
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /payments HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:59:03 GMT
Date: Sun, 24 Jan 2021 17:59:03 GMT

< 
{
  "_embedded" : {
    "payments" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/payments"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/payments"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## player

```shell
curl -v -i http://localhost:8090/players
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /players HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 17:59:29 GMT
Date: Sun, 24 Jan 2021 17:59:29 GMT

< 
{
  "_embedded" : {
    "players" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/players"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/players"
    },
    "search" : {
      "href" : "http://localhost:8090/players/search"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## rental

```shell
curl -v -i http://localhost:8090/rentals
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rentals HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 18:00:03 GMT
Date: Sun, 24 Jan 2021 18:00:03 GMT

< 
{
  "_embedded" : {
    "rentals" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rentals"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/rentals"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## staff

```shell
curl -v -i http://localhost:8090/teams
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /teams HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 18:00:26 GMT
Date: Sun, 24 Jan 2021 18:00:26 GMT

< 
{
  "_embedded" : {
    "teams" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/teams"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/teams"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
## store

```shell
curl -v -i http://localhost:8090/stores
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /stores HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
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
< Date: Sun, 24 Jan 2021 18:00:50 GMT
Date: Sun, 24 Jan 2021 18:00:50 GMT

< 
{
  "_embedded" : {
    "stores" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/stores"
    },
    "profile" : {
      "href" : "http://localhost:8090/profile/stores"
    }
  },
  "page" : {
    "size" : 250,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
