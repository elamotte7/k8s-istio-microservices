# POC Microservices with Node.js

Two microservices to test

![Node.js](https://nodejs.org/static/images/logos/nodejs-new-pantone-black.png)

### Introduction
Provides fast, reliable and extensible starter for the development of Microservices projects.

### How to start
**Note** that this project requires at least **node 10** and **npm 6**.

In order to start the project use:
```bash
$ git clone https://git.sedona.fr/architecture/ms-k8s-istio/node.git
$ cd node
# Build the project
$ npm install
# ...TODO
```

**Note** below replace `-x` by `-a` or `-b` depending on which service you want to work on.

### Service x

#### Run service x
$ cd microservice-node-x

#### Build the ms
$ npm install

#### Run the ms
$ npm start

#### ...TODO

### Running end-to-end tests

TODO.

### Further help

To get more info on the Node.js go check out the [Node.js documentation](https://nodejs.org/en/docs/).

## Docker

* `/bin/bash -c 'docker image push ms/microservice-node-x '`

### Building Images

* `mvn clean install`
* `docker image build -t ms/microservice-node-x .`

### Running Images

* `docker run -d --name=demo-node-x -p 80:8080 ms/microservice-node-x`
* `docker run -it --name=demo-node-x -p 80:8080 ms/microservice-node-x`

### Deploy to GCP docker registry

1- Tag the image with a registry name

* `docker tag ms/microservice-node-x gcr.io/[PROJECT-ID]/microservice-node-x:tag1`

where:

* [PROJECT-ID] is your Google Cloud Platform Console project ID, which you need to add to your command
* gcr.io is the hostname
* /microservice-node-x is the local image name
* tag1 is a tag you're adding to the Docker image. If you didn't specify a tag, Docker will apply the default tag latest.

2- Push the image to Container Registry

`docker push gcr.io/[PROJECT-ID]/microservice-node-x:tag1`
