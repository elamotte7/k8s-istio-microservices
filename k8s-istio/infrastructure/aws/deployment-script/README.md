# AWS K8s/Istio deployment

![EKS](https://www.itopstimes.com/wp-content/uploads/2018/06/amazon-eks.png?raw=true)

**Note** this project requires  aws-cli (>1.16.89) and eksctl (>0.1.18).

Don't forget to login to your azure account :

```
$ aws configure
```

and follow the [instructions](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html)

and intall [aws-iam-authenticator](https://docs.aws.amazon.com/eks/latest/userguide/install-aws-iam-authenticator.html) 
kubectl needs to be able to present your AWS credentials to the cluster,

## Install K8s on AWS

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