# Deploying services into Kubernetes cluster with Istio

![Istio](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJgSDA7IJOpm0a9LDLtt98v5gM44m7VKOA6Vy2XnGlXpNRCuIL)

## Expose service-a

### define the ingress gateway for the microservice a

```
$ kubectl apply -f manifests/istio/gateway/service-a-gateway.yml
```

or if you want to deploy the TLS Gateway check [TLS GAteway](gateway/README.md)

### confirm the gateway has been created

```
$ kubectl get gateway
```

### get the gateway informations

```
$ kubectl -n istio-system get service istio-ingressgateway
```

### set the INGRESS_HOST and INGRESS_PORT variables for accessing the gateway

```
export INGRESS_HOST=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].port}')
export SECURE_INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].port}')
```

### set GATEWAY_URL

```
$ export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT
```

### Proceed to confirm the app is running, below

```
$ curl -o /dev/null -s -w "%{http_code}\n" http://${GATEWAY_URL}/
```

### Then test the customer endpoint. Because of the route defined in the VirtualService (that we will see later), the URL of the customer service is mapped to the root URL of the gateway

```
$ export SERVICE_A_URL=$GATEWAY_URL
```

```
$ curl $SERVICE_A_URL
```

## Test the services via the browser

add <INGRESS_HOST> to /etc/hosts

retrieve the IP ingress :

```
$ kubectl -n istio-system get service istio-ingressgateway
```

On Mac OS do :

```
$ sudo vi /etc/hosts
```

and add :

```
<INGRESS_HOST>    servicea.sedona.fr
```

And test the url http://servicea.sedona.fr/service-a/hello/service-b in your favorite browser.
If everithing is good you will see the result :

```
The microservice B respond : [Hello World welcome to Thorntail Microservice B v1!!!!!]
```

## Load balancing

## Routing

### Simple routing

* Destination rules

* Virtual services

### Advanced routing

* Canary deployment

* Load balancer

## Mutual TLS

## Verify the microservice deployment with kiali

```
$ kubectl -n istio-system port-forward service/kiali 20001:20001
```

Then launch a browser and type :

```
http://localhost:20001
```

* login : admin
* password : admin

## Prometheus

```
$ kubectl -n istio-system port-forward service/prometheus 9090:9090
```

Then launch a browser and type :

```
http://localhost:9090
```

## Grafana

```
$ kubectl -n istio-system port-forward service/grafana 3000:3000
```

and open in your browser : 

```
http://localhost:3000/d/1/istio-mesh-dashboard
```

Then launch a browser and type :

```
http://localhost:3000
```

## Service graph

```
$ kubectl -n istio-system port-forward service/servicegraph 8088:8088
```

Then launch a browser and type :

```
http://localhost:8088/dotviz
```

and open in your browser : 

````
http://localhost:8088/dotviz
```

## Jaeger UI

```
$ kubectl -n istio-system port-forward service/jaeger-query 16686:16686
```

Then launch a browser and type :

```
http://localhost:16686
```
