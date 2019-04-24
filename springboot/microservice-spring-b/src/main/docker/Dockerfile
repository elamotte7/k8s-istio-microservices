FROM registry.sedona.fr/images/java:8-oraclejdk

COPY microservice-spring-b.jar /usr/local/app/microservice-spring-b.jar
COPY entrypoint.sh /root/entrypoint.sh

RUN sh -c 'touch /usr/local/app/microservice-spring-b.jar' \
	&& chmod +x /root/entrypoint.sh

ENTRYPOINT [ \
	"/root/entrypoint.sh" \
]