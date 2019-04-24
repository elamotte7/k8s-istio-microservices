#!/bin/sh

JAVA_OPTS="${JAVA_OPTS:-}"

OPTS="${OPTS:-}"

OPTS="${OPTS} -Djava.security.egd=file:/dev/./urandom"

if [ ! -z "${DEBUG:-}" ]
then
  DEBUG_PORT=${DEBUG_PORT:-5005}
  echo "Debug mode will be enabled on port ${DEBUG_PORT}"
  OPTS="${OPTS} -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=${DEBUG_PORT}"
fi

sleep ${START_DELAY:-0}
java $JAVA_OPTS -jar $OPTS /usr/local/app/microservice-spring-b.jar
