#!/bin/bash -x

. set-env.sh

eksctl create cluster -n "$CLUSTER_NAME" -N $INITIAL_NODE_COUNT -r "$LOCATION" --version $KUBERNETES_VERSION