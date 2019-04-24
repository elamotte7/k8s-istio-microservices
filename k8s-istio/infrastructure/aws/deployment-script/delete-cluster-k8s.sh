#!/bin/bash -x

. set-env.sh

eksctl delete cluster -n "$CLUSTER_NAME" -r "$LOCATION"