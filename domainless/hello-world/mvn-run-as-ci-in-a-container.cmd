docker run -it --rm ^
  -u root ^
  -v %cd%:/usr/src/app ^
  -v %USERPROFILE%/.m2:/root/.m2 ^
  -w /usr/src/app ^
  -e DOCKER_HOST=tcp://localhost:2375 ^
  maven:3.9.4-eclipse-temurin-17-alpine sh mvn-run-as-ci-does.sh
