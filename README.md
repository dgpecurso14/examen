# examen
Se asume que se clono el projecto de github del profesor

Generar un archivo llamado Dockerfile con este contenido
FROM kebblar/jdk18-utf8-debug-maven
COPY /vertx/vertx-sample/target/sample-1.0-SNAPSHOT-fat.jar /codigo
RUN apt-get update
RUN apt-get install nano
RUN apt-get update \
  && DEBIAN_FRONTEND=noninteractive apt-get install -y \
    net-tools \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*
EXPOSE 8080
CMD java -jar /codigo/target/sample-1.0-SNAPSHOT-fat.jar


------------
Generar una imagen con el comando
Docker build -t examen .
En otro caso se puede hacer docker pull mmorgado/examen1 
Despues ejecutar el comando
docker run -it -d -p 8080:8081
docker run -it -d -p 8081:8081

docker run -it -d -p 8082:8081

Para balancear estos tres dockers configurar en el archivo /etc/haproxy/haproxy.cfg
agregar estas lìneas

frontend www
        bind 0.0.0.0:9090
	default_backend site-backend
	
backend site-backend
	mode http
	balance roundrobin
	stats enable
        stats uri /haproxy?stats
	server lamp1 localhost:8080 check
	server lamp2 localhost:8081 check
	server lamp3 localhost:8082 check

