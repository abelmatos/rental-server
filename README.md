# how to use

The App will start on local host.
You should be able to access by
http://localhost:8080/swagger-ui/index.html

start app locally

``./gradlew bootRun``

if you want to use composer/docker/ GraalVM you need to put the data Json file in a volume.
and see the environment variable
``-Drental.data.path="volumeMount""``

OR

`` RENTAL_DATA_PATH=VolumeMount ``
