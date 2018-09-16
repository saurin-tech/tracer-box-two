# tracer-box-two

# Description

This project is a part of project which is meant to demonstrate [Istio](https://istio.io).
This project is a simple spring-boot project which makes a simple REST API call to [tracer-box-three](https://github.com/saurin-tech/tracer-box-three) depending on a random number generation.

## How to run

* To build this project cd into the root of the project.
    - Execute ./gradlew build docker command. This will build the docker image for you.
        To check if the docker image was build or not you can execute docker images command and it will list images for you.
