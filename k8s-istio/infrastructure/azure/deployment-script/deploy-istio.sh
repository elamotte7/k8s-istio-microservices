#!/bin/bash -x

. set-env.sh

az aks get-credentials --resource-group "$RESOURCE_GROUP_NAME" --name "$CLUSTER_NAME" --overwrite-existing

kubectl create ns istio-system
# kubectl create ns tiller-world

# kubectl apply -f helm-rbac.yaml
# kubectl create -f role-tiller.yaml
# kubectl create -f rolebinding-tiller.yaml

wget -P /tmp/istio https://github.com/istio/istio/releases/download/1.0.5/istio-1.0.5-linux.tar.gz
tar xf /tmp/istio/istio-1.0.5-linux.tar.gz  -C /tmp/istio

# wget -P /tmp/helm/ https://storage.googleapis.com/kubernetes-helm/helm-v2.12.1-darwin-amd64.tar.gz
# tar xf /tmp/helm/helm-v2.9.1-linux-amd64.tar.gz  -C /tmp/helm/

# export PATH="$PATH:/tmp/istio-$ISTIO_RELEASE/bin::/tmp/helm/linux-amd64/"

export PATH="/tmp/istio/istio-1.0.5/bin:$PATH"
#chmod 777 /tmp/istio/istio-$ISTIO_RELEASE/bin/istioctl
#istioctl version

cd /tmp/istio/istio-$ISTIO_RELEASE

kubectl create -f install/kubernetes/helm/helm-service-account.yaml

#helm init --tiller-tls --tiller-tls-cert ./tiller.cert.pem --tiller-tls-key ./tiller.key.pem --tiller-tls-verify --tls-ca-cert ca.cert.pem --service-account tiller --tiller-namespace tiller-world
helm init --service-account tiller

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

rm -rf /tmp/istioctl

echo '--------------------------------------------------'
echo 'Cluster k8s/Istio ready to use on azure aks! Enjoy'
echo '--------------------------------------------------'