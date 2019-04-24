#!/bin/bash -x

. set-env.sh

az group create --name "$RESOURCE_GROUP_NAME" --location "$LOCATION"

az aks create --resource-group "$RESOURCE_GROUP_NAME" --name "$CLUSTER_NAME" --node-count $INITIAL_NODE_COUNT --kubernetes-version $KUBERNETES_VERSION --generate-ssh-keys

kubectl create clusterrolebinding kubernetes-dashboard --clusterrole=cluster-admin --serviceaccount=kube-system:kubernetes-dashboard
