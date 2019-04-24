FROM registry.sedona.fr/images/java:8-oraclejdk

COPY microprofile-thorntail-b-thorntail.jar /usr/local/app/microprofile-thorntail-b-thorntail.jar
COPY entrypoint.sh /root/entrypoint.sh

RUN sh -c 'touch /usr/local/app/microprofile-thorntail-b-thorntail.jar' \
	&& chmod +x /root/entrypoint.sh

ENTRYPOINT [ \
	"/root/entrypoint.sh" \
]