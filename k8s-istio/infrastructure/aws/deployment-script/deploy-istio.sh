#!/bin/bash -x

. set-env.sh

wget -P /tmp/istio https://github.com/istio/istio/releases/download/1.0.5/istio-1.0.5-linux.tar.gz
tar xf /tmp/istio/istio-1.0.5-linux.tar.gz  -C /tmp/istio

export PATH="/tmp/istio/istio-1.0.5/bin:$PATH"

cd /tmp/istio/istio-$ISTIO_RELEASE

kubectl create -f install/kubernetes/helm/helm-service-account.yaml

helm init --service-account tiller

kubectl create ns istio-system

helm template install/kubernetes/helm/istio --name istio --namespace istio-system  \
  --set global.controlPlaneSecurityEnabled=true \
  --set global.mtls.enabled=true \
  --set grafana.enabled=true \
  --set tracing.enabled=true \
  --set kiali.enabled=true \
  --set sidecar-injector.enabled=true \
  --set prometheus.enabled=true \
  --set servicegraph.enabled=true > istio.yaml

kubectl delete -f istio.yaml
kubectl apply -f istio.yaml
kubectl label namespace default istio-injection=enabled

rm -rf /tmp/istio

echo '--------------------------------------------------'
echo 'Cluster k8s/Istio ready to use on azure aks! Enjoy'
echo '--------------------------------------------------'