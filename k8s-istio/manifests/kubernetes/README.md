# Deploying services into Kubernetes cluster

![k8s](https://github.com/kubernetes/kubernetes/raw/master/logo/name_blue.png)

## Create Namespace

### create the namespace

```
$ kubectl create namespace services
```

### enable sidecar injection

```
$ kubectl label namespace services istio-injection=enabled
```

### set this namespace as the default one

```
$ kubectl config set-context $(kubectl config current-context) --namespace=services
```

## Deploy service-a

where -X is -node, -python, -spring or -thorntail

```
$ kubectl apply -f manifests/kubernetes/servicea-X.yml
```

## Deploy service-b

```
$ kubectl apply -f manifests/kubernetes/serviceb-X.yml
```

## UnDeploy service-x

```
$ kubectl delete -f manifests/kubernetes/servicex-X.yml
```
