# Java (Spring Boot, Microprofile) or Node.js or Python + Istio on Kubernetes (GKE, AKS, EKS)

Testing Microservices on k8s cluter with Istio. We have already tested/implemented Microservices but the tooling is very rich and complex. So we want to find/use a solution simpler than before, and it seems that k8s/Istio is the messi for us. In a few words : simply manage microservices.

## Table of content

- [Infrastructure - deploy k8s cluster with Istio]
    - [AWS](infrastructure/aws/deployment-script/README.md)
    - [Azure](infrastructure/azure/deployment-script/README.md)
    - [GCP](infrastructure/gcp/deployment-manager/README.md)
- [Deploy Microservices and configure Istio]
    - [Deploy MS in cluster k8s](manifests/kubernetes/README.md)
    - [Configure Istio](manifests/istio/README.md)
- [Secure Microservices with Keycloak]
    - [Set up keycloack/Istio](manifests/keycloak/README.md)

## Introduction

There are two different and super simple microservices in this system and they are chained together in the following sequence:

servicea → serviceb

Each service has his implementation in Spring, Microprofile, Node.js and Python. You can deploy both of them in the cluster k8s/Istio.

## Credits

This workshop is based on this great [tutorial](https://github.com/redhat-developer-demos/istio-tutorial) from Red Hat,
and this Sfeir [workshop](https://github.com/Sfeir/kubernetes-istio-workshop). 
We would like to thank all of its Red Hat [contributors](https://github.com/redhat-developer-demos/istio-tutorial/graphs/contributors) and all of its Sfeir [contributors](https://github.com/Sfeir/kubernetes-istio-workshop/graphs/contributors).