# sample-payment-api

Coding exercise for REST API.

**Note**: Repository has some simplifications and is not **PRODUCTION** ready (i.e. missing DevOps part). Check `ToDo` section below for more details. 

Pre-requisites:

* Java 8
* Kotlin
* Maven
* Docker 
* MongoDB

Docker repository for [project](https://hub.docker.com/r/mwrona/sample-payments-api/) (see `pom` properties for more details).

## API

Generic error response codes:

* 415: for not defined/not supported resource operation

* 5xx: internal server errors (needed for DevOps, monitoring etc.)

##### Version 1

1) Create payment

**POST** `/v1/payments/` 

Sample response:

```bash
Creating valid payment...
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /v1/payments/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 1741
> Expect: 100-continue
>
< HTTP/1.1 100 Continue
* We are completely uploaded and fine
< HTTP/1.1 201 Created
< Location: /v1/payments/bb197ea8-70a3-44ae-b98d-90e924c67deb
< content-length: 0
<
* Connection #0 to host localhost left intact
```

Check `demo/payment-creare.sh` for more details.

Possible responses codes:

* 201: new payment created (location of created resource in header `Location`)

* 400: bad request (for invalid requests)

2) Update whole payment document

**PUT** `/v1/payments/{id}` 

Sample response:

```bash
Updating payment...
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> PUT /v1/payments/bb197ea8-70a3-44ae-b98d-90e924c67deb HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 1803
> Expect: 100-continue
>
< HTTP/1.1 100 Continue
* We are completely uploaded and fine
< HTTP/1.1 204 No Content
<
* Connection #0 to host localhost left intact
```

Check `demo/payment-update.sh` for more details.

Possible responses codes:

* 204: payment updated

* 400: bad request (for invalid requests)

* 404: not found for non-existing payments

3) Partial update of payment

**PATCH** `/v1/payments/{id}`

**Not supported yet** 

4) Delete payment

**DELETE** `/v1/payments/{id}` 

Check `demo/payment-delete.sh` for more details.

Possible responses codes:

* 204: payment deleted

* 404: not found for non-existing payments

4) Get single payment

**GET** `/v1/payments/{id}` 

Check `demo/payment-get.sh` for more details.

Possible responses codes:

* 200: payment data

* 404: not found for non-existing payments

5) Get all payments

**GET** `/v1/payments/` 

Check `demo/payment-list.sh` for more details.

Possible responses codes:

* 200: payment data

## Development

#### Local development

1) Run application

```bash
mvn spring-boot:run
``` 

2) Run tests

```
mvn test
```

**Note**: Integration tests will run `embedded MongoDB` 

#### Docker

1) Build docker image

```bash
mvn clean package docker:build
```

2) Build & publish docker image

```bash
mvn clean package docker:build docker:push
```

3) Run docker locally with all deps needed (DB etc.)

```bash
docker-compose up -d
```

and then for closing:

```bash
docker-compose down
```

## ToDo

* Add `PATCH` method to the API to support partial updates

* Format validation errors to user friendly format & hide tech stack for security reasons

* Change `400 Bad Request` status code for validation errors to `422 Unprocessable Entity`

* Add caching (using E-Tag headers etc.)

* Add end-points for health & and readiness probes (needed i.e. for `Kubernetes`) 

* Add DevOps for `Kubernetes`

* Add performance tests (i.e. using vegetta or gatling)

* Set-up CI (using CircleCI)

* Configure `Swagger` for Spring for REST API documentation

* Add end-point for printing version of running service (X.Y.Z and git-hash)

* Describe REST API on Wiki 

* Check whether HATEOAS is required (for multi-client support)

* Check whether list responses should be wrapped with JSON-doc instead of returning JSON-array (required for some JS clients)

* Add monitoring (metrics & producing logs in JSON format)

* Analyse whether API shouldn't be using `Protobuf` instead of REST.