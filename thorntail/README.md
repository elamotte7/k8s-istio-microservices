# POC Microservices with Thorntail

Two microservices to test

![Thorntail: Rightsize your JavaEE Applications](http://thorntail.io/images/thorntail_horizontal_rgb_600px_reverse.png)

### Introduction
Provides fast, reliable and extensible starter for the development of Microservices projects.

`microprofile-thorntail` provides the following features:
- Different fractions

### How to start
**Note** that this project requires **java 8** and **maven 3.3.9**.

In order to start the project use:
```bash
$ git clone https://git.sedona.fr/architecture/ms-k8s-istio/thorntail.git
$ cd microprofile-thorntail
# Build the project
$ mvn clean install
# ...TODO
```

**Note** below replace `-x` by `-a` or `-b` depending on which service you want to work on.

### Service x

#### Run service x
$ cd microprofile-thorntail-x

#### Build the ms
$ mvn clean install

#### Run the ms
$ mvn thorntail:run

#### ...TODO

### Running Microservice in IntelliJ
Import the source code of `org.wildfly.swarm.runner.Runner` : 
* On mac OS `cmd + shift + o` and include non project file.

Then import the source code.
Go to Run/Debug Configurations, create an Application configuration 
and set the following parameters in it : 
* Main class : `org.wildfly.swarm.runner.Runner`
* Working directory : `../microprofile-thorntail/microprofile-thorntail-x`
* Use classpath of module : `microprofile-thorntail-x`

### Running end-to-end tests

TODO.

### Further help

To get more info on the thorntail microprofile go check out the [Thorntail documentation](https://docs.thorntail.io/2.2.1.Final/#specifying-a-bom-in-your-application_thorntail).

## Docker

* `/bin/bash -c 'docker image push wwf/crowdacting-frontend '`

### Building Images

* `mvn clean install`
* `docker image build -t ms/microprofile-thorntail-x .`

### Running Images

* `docker run -d --name=demo-thorntail-x -p 80:8080 ms/microprofile-thorntail-x`
* `docker run -it --name=demo-thorntail-x -p 80:8080 ms/microprofile-thorntail-x`

### Deploy to GCP docker registry

1- Tag the image with a registry name

* `docker tag ms/microprofile-thorntail-x gcr.io/[PROJECT-ID]/microprofile-thorntail-x:tag1`

where:

* [PROJECT-ID] is your Google Cloud Platform Console project ID, which you need to add to your command
gcr.io is the hostname
* microprofile-thorntail-x is the local image name
* tag1 is a tag you're adding to the Docker image. If you didn't specify a tag, Docker will apply the default tag latest.

2- Push the image to Container Registry

`docker push gcr.io/[PROJECT-ID]/microprofile-thorntail-x:tag1`
