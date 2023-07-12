Build a local dev environment: docker build . -t spring-boot-dev-local <br />
Run Docker Container: docker run -d -p 8080:8080 spring-boot-dev-local <br /><br />

To obtain info on a given repository from "https://api.github.com/repos/{owner}/{repository-name}", please call this service with GET request to "/repositories/{owner}/{repository-name}".<br />
Tests for HTTP Client and service returning repository info in: src/test/java/critz/githubrepotest