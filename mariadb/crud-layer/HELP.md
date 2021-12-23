# Example of use

## RESTful perspective:

```shell
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

```shell
MariaDB [moviestoredb]> select * from category;
+-------+--------+---------------------+---------------------+
| id    | name   | description         | updated             |
+-------+--------+---------------------+---------------------+
| 10001 | action | simple action movie | 2020-04-07 08:06:04 |
+-------+--------+---------------------+---------------------+
1 row in set (0.000 sec)
```

# Iso3166 data:

```
$ curl -v -i http://127.0.0.1:8080/countryCodes
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /countryCodes HTTP/1.1
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
< Date: Fri, 10 Apr 2020 07:32:24 GMT
Date: Fri, 10 Apr 2020 07:32:24 GMT

< 
{
  "_embedded" : {
    "iso3166s" : [ {
      "name" : "Afghanistan",
      "code" : 4,
      "signature" : "AFG",
      "updated" : "2020-04-10T04:59:54.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14002"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14002"
        }
      }
    }, {
      "name" : "Albania",
      "code" : 8,
      "signature" : "ALB",
      "updated" : "2020-04-10T05:03:33.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14003"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14003"
        }
      }
    }, {
      "name" : "Antarctica",
      "code" : 10,
      "signature" : "ATA",
      "updated" : "2020-04-10T05:04:16.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14004"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14004"
        }
      }
    }, {
      "name" : "Algeria",
      "code" : 12,
      "signature" : "DZA",
      "updated" : "2020-04-10T05:09:09.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14005"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14005"
        }
      }
    }, {
      "name" : "American_Samoa",
      "code" : 16,
      "signature" : "ASM",
      "updated" : "2020-04-10T05:10:04.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14006"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14006"
        }
      }
    }, {
      "name" : "Andorra",
      "code" : 20,
      "signature" : "AND",
      "updated" : "2020-04-10T05:10:57.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14007"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14007"
        }
      }
    }, {
      "name" : "Angola",
      "code" : 24,
      "signature" : "AGO",
      "updated" : "2020-04-10T05:11:41.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14008"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14008"
        }
      }
    }, {
      "name" : "Antigua_and_Barbuda",
      "code" : 28,
      "signature" : "ATG",
      "updated" : "2020-04-10T05:12:40.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14009"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14009"
        }
      }
    }, {
      "name" : "Azerbaijan",
      "code" : 31,
      "signature" : "AZE",
      "updated" : "2020-04-10T05:13:26.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14010"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14010"
        }
      }
    }, {
      "name" : "Argentina",
      "code" : 32,
      "signature" : "ARG",
      "updated" : "2020-04-10T05:14:02.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14011"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14011"
        }
      }
    }, {
      "name" : "Australia",
      "code" : 36,
      "signature" : "AUS",
      "updated" : "2020-04-10T05:24:49.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14012"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14012"
        }
      }
    }, {
      "name" : "Austria",
      "code" : 40,
      "signature" : "AUT",
      "updated" : "2020-04-10T05:29:01.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14013"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14013"
        }
      }
    }, {
      "name" : "Bahamas",
      "code" : 44,
      "signature" : "BHS",
      "updated" : "2020-04-10T05:32:13.000+0000",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14014"
        },
        "iso3166" : {
          "href" : "http://127.0.0.1:8080/countryCodes/14014"
        }
      }
    } ]
  },
...
```

```shell
MariaDB [moviestoredb]> select * from iso3166;
+-------+---------------------+------+-----------+---------------------+
| id    | name                | code | signature | updated             |
+-------+---------------------+------+-----------+---------------------+
| 14002 | Afghanistan         |    4 | AFG       | 2020-04-10 06:59:54 |
| 14003 | Albania             |    8 | ALB       | 2020-04-10 07:03:33 |
| 14004 | Antarctica          |   10 | ATA       | 2020-04-10 07:04:16 |
| 14005 | Algeria             |   12 | DZA       | 2020-04-10 07:09:09 |
| 14006 | American_Samoa      |   16 | ASM       | 2020-04-10 07:10:04 |
| 14007 | Andorra             |   20 | AND       | 2020-04-10 07:10:57 |
| 14008 | Angola              |   24 | AGO       | 2020-04-10 07:11:41 |
| 14009 | Antigua_and_Barbuda |   28 | ATG       | 2020-04-10 07:12:40 |
| 14010 | Azerbaijan          |   31 | AZE       | 2020-04-10 07:13:26 |
| 14011 | Argentina           |   32 | ARG       | 2020-04-10 07:14:02 |
| 14012 | Australia           |   36 | AUS       | 2020-04-10 07:24:49 |
| 14013 | Austria             |   40 | AUT       | 2020-04-10 07:29:01 |
| 14014 | Bahamas             |   44 | BHS       | 2020-04-10 07:32:13 |
...
```

