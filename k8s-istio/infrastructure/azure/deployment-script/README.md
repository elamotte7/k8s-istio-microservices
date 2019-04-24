# Azure K8s/Istio deployment

![AKS](https://1.bp.blogspot.com/-VosyXe-mfMY/Wcr-Llbhm0I/AAAAAAAAPXk/8zTQgb-T5s83chtF_AkhW4kNp6zhHTFIwCLcBGAs/s1600/Azure%2BContainer%2BService_COLOR.png)

**Note** this project requires  azure-cli (>2.0.54) and helm (>2.12.1).

Don't forget to login to your azure account :

```
$ az login
```

## Install K8s on azure

simply run the script :

```
$ ./create-cluster-k8s.sh
```

## Install Istio on k8s cluster

simply run the script :

```
$ ./deploy-istio.sh
```

## K8s dashboard

```
$ az aks get-credentials --resource-group "$RESOURCE_GROUP_NAME" --name "$CLUSTER_NAME" --overwrite-existing
```

The following command will open a browser on the k8s dashboard

```
$ az aks browse --resource-group "$RESOURCE_GROUP_NAME" --name "$CLUSTER_NAME"
```