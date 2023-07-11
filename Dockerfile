FROM openjdk:8-jdk-slim as build
MAINTAINER Krzysztof Lewandowski <mail@critz>

WORKDIR /src
COPY    . .
RUN     ./gradlew test build

FROM openjdk:8-jdk-slim as runtime
WORKDIR /app
COPY --from=build /src/build/libs/github-repo-test-app-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java"]
CMD ["-jar", "/app/github-repo-test-app-0.0.1-SNAPSHOT.jar"]
