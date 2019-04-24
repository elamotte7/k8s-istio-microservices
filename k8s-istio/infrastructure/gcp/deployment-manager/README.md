# Google Deployment Manager Template

![GCP](https://cloud.google.com/_static/3b8707bca0/images/cloud/cloud-logo.svg)

This directory contains a Google Cloud Deployment Manager template for getting
up-and-running with a Google Cloud Kubernetes Engine cluster with Istio
included.  

**Note** You need the Google Cloud SDK (>228.0.0) installed (get it [here](https://cloud.google.com/sdk/))

Don't forget to init your gcloud SDK :

```
$ gcloud init
```

If you want to select a specific account, do :

```
$ gcloud auth list
```

And set up the right account :

```
$ gcloud config set account <ACCOUNT>
```

You can create a new deployment via the command:

```
$ gcloud deployment-manager deployments create my-istio-deployment --config=infrastructure/gcp/deployment-manager/istio-cluster.yaml
```

**NOTE:** You must grant your default compute service account
the correct permissions before creating the deployment.
Otherwise, the installation will fail. Make sure that your
default compute service account (by default
`[PROJECT_NUMBER]-compute@developer.gserviceaccount.com`)
includes the following roles:
* `roles/container.admin` (Container Engine Admin)
* `roles/editor` (included by default)

You can set this permission by navigating to the [IAM
section](https://console.cloud.google.com/permissions/projectpermissions)
of the Google Cloud Console, viewing the permissions for your
default compute service account
(`[PROJECT_NUMBER]-compute@developer.gserviceaccount.com`), and
making sure that both Editor (`roles/editor`) and Container
Engine Admin (`roles/container.admin`) are selected.

## Changing parameters

See the file `istio-cluster.yaml` and `istio-cluster.schema` for details on customization. Note that you can override a parameter at the command line. For example:

```
$ gcloud deployment-manager deployments create my-istio-deployment --template=istio-cluster.jinja --properties enableMutualTLS:false,gkeClusterName:istio-gke
```

## Connect to the cluster

1 - Bootstrap kubectl for the cluster you just created and confirm the cluster is running and Istio is enabled

```
$ gcloud container clusters list --zone europe-west1-b
```

Output

```
NAME           LOCATION        MASTER_VERSION  MASTER_IP      MACHINE_TYPE   NODE_VERSION  NUM_NODES  STATUS
istio-cluster  europe-west1-b  1.11.2-gke.18   35.195.237.45  n1-standard-1  1.11.2-gke.18 3          RUNNING
```

2 - Finally, acquire the credentials to connect to the cluster.

```
$ gcloud container clusters get-credentials istio-cluster --region europe-west1-b
```

## Verify installation

Wait a few minutes to verify the installation, generally the set up takes 3 to 5 mn.

```
$ kubectl get deployments -n istio-system
```

Output.

```
NAME                     DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
grafana                  1         1         1            1           1m
istio-citadel            1         1         1            1           1m
istio-egressgateway      1         1         1            1           1m
istio-galley             1         1         1            1           1m
istio-ingressgateway     1         1         1            1           1m
istio-pilot              1         1         1            1           1m
istio-policy             1         1         1            1           1m
istio-sidecar-injector   1         1         1            1           1m
istio-telemetry          1         1         1            1           1m
istio-tracing            1         1         1            1           1m
kiali                    1         1         1            1           1m
prometheus               1         1         1            1           1m
servicegraph             1         1         1            1           1m
```

You are ready to use a Google Cloud K8s with Istio installed.
