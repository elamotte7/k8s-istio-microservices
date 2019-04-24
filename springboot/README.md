# POC Microservices with Spring Boot

Two microservices to test

![Spring Boot](https://spring.io/img/homepage/icon-spring-boot.svg)

### Introduction
Provides fast, reliable and extensible starter for the development of Microservices projects.

### How to start
**Note** that this project requires **java 8** and **maven 3.3.9**.

In order to start the project use:
```bash
$ git clone https://git.sedona.fr/architecture/ms-k8s-istio/springboot.git
$ cd springboot
# Build the project
$ mvn clean install
# ...TODO
```

**Note** below replace `-x` by `-a` or `-b` depending on which service you want to work on.

### Service x

#### Run service x
$ cd microservice-spring-x

#### Build the ms
$ mvn clean install

#### Run the ms
$ java -jar microservice-spring-x/target/microservice-spring-a.jar

#### ...TODO

### Running end-to-end tests

TODO.

### Further help

To get more info on the Spring Boot go check out the [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/).

## Docker

* `/bin/bash -c 'docker image push ms/microservice-spring-x '`

### Building Images

* `mvn clean install`
* `docker image build -t ms/microservice-spring-x .`

### Running Images

* `docker run -d --name=demo-spring-x -p 80:8080 ms/microservice-spring-x`
* `docker run -it --name=demo-spring-x -p 80:8080 ms/microservice-spring-x`

### Deploy to GCP docker registry

1- Tag the image with a registry name

* `docker tag ms/microservice-spring-x gcr.io/[PROJECT-ID]/microservice-spring-x:tag1`

where:

* [PROJECT-ID] is your Google Cloud Platform Console project ID, which you need to add to your command
* gcr.io is the hostname
* /microservice-spring-x is the local image name
* tag1 is a tag you're adding to the Docker image. If you didn't specify a tag, Docker will apply the default tag latest.

2- Push the image to Container Registry

`docker push gcr.io/[PROJECT-ID]/microservice-spring-x:tag1`
