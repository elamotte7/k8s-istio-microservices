# POC Microservices with Puthon

Two microservices to test

![Python](https://www.python.org/static/community_logos/python-logo-master-v3-TM-flattened.png)

### Introduction
Provides fast, reliable and extensible starter for the development of Microservices projects.

### How to start
**Note** that this project requires at least **python 2.7**.

In order to start the project use:
```bash
$ git clone https://git.sedona.fr/architecture/ms-k8s-istio/python.git
$ cd python
# Install Flask
$ pip install Flask
# Install requests
$ pip install requests
# ...TODO
```

**Note** below replace `-x` by `-a` or `-b` depending on which service you want to work on.

### Service x

#### Run service x
$ cd microservice-python-x

#### Run the ms
$ python app.py

#### ...TODO

### Running end-to-end tests

TODO.

### Further help

To get more info on the Python go check out the [Python documentation](https://docs.python.org/2/index.html).

## Docker

* `/bin/bash -c 'docker image push ms/microservice-python-x '`

### Building Images

* `docker image build -t ms/microservice-python-x .`

### Running Images

* `docker run -d --name=demo-python-x -p 80:8080 ms/microservice-python-x`
* `docker run -it --name=demo-python-x -p 80:8080 ms/microservice-python-x`

### Deploy to GCP docker registry

1- Tag the image with a registry name

* `docker tag ms/microservice-python-x gcr.io/[PROJECT-ID]/microservice-python-x:tag1`

where:

* [PROJECT-ID] is your Google Cloud Platform Console project ID, which you need to add to your command
* gcr.io is the hostname
* /microservice-python-x is the local image name
* tag1 is a tag you're adding to the Docker image. If you didn't specify a tag, Docker will apply the default tag latest.

2- Push the image to Container Registry

`docker push gcr.io/[PROJECT-ID]/microservice-python-x:tag1`