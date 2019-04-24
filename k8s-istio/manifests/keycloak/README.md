## k8s

```
$ kubectl create namespace keycloak
```

```
$ kubectl label namespace keycloak istio-injection=enabled
```

```
$ kubectl config set-context $(kubectl config current-context) --namespace=keycloak
```

```
$ kubectl apply -f manifests/keycloak/keycloak.yml
```

## Istio Gateway

```
$ kubectl apply -f manifests/keycloak/keycloak-istio-ingress.yml
```

## Set Identitity provider

```
$ kubectl apply -f manifests/istio/jwt/services-api-auth_config.yml
```