FROM registry.sedona.fr/images/java:8-oraclejdk

COPY microprofile-thorntail-a-thorntail.jar /usr/local/app/microprofile-thorntail-a-thorntail.jar
COPY entrypoint.sh /root/entrypoint.sh

RUN sh -c 'touch /usr/local/app/microprofile-thorntail-a-thorntail.jar' \
	&& chmod +x /root/entrypoint.sh

ENTRYPOINT [ \
	"/root/entrypoint.sh" \
]