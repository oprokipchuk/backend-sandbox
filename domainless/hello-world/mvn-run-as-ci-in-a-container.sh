docker run -it --rm \
  -u root \
  -v $(pwd):/usr/src/app \
  -v $HOME/.m2:/root/.m2 \
  -w /usr/src/app \
  -v /var/run/docker.sock:/var/run/docker.sock \
  maven:3.9.4-eclipse-temurin-17-alpine sh mvn-run-as-ci-does.sh
