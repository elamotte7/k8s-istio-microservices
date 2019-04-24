# Configure a TLS Gateway

follow the instruction [here](https://istio.io/docs/tasks/traffic-management/secure-ingress/#generate-client-and-server-certificates-and-keys)
to create certificates

and 
```$ kubectl create -n istio-system secret tls istio-ingressgateway-certs --key mtls-go-example/3_application/private/servicea.sedona.fr.key.pem --cert mtls-go-example/3_application/certs/servicea.sedona.fr.cert.pem
```

then 

```
$ kubectl apply -f manifests/istio/mutual-tls/authentication-enable-tls-permissive.yml
````

and

```$ kubectl apply -f manifests/istio/gateway/service-a-tls-gateway.yml
```