FROM registry.sedona.fr/images/java:8-oraclejdk

COPY microservice-spring-a.jar /usr/local/app/microservice-spring-a.jar
COPY entrypoint.sh /root/entrypoint.sh

RUN sh -c 'touch /usr/local/app/microservice-spring-a.jar' \
	&& chmod +x /root/entrypoint.sh

ENTRYPOINT [ \
	"/root/entrypoint.sh" \
]