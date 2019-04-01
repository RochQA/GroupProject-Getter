FROM maven as build
WORKDIR /build
COPY pom.xml .
RUN mvn verify --fail-never
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/GroupProject-Getter-0.0.1-SNAPSHOT.jar Getter.jar
ENTRYPOINT ["java","-jar","GroupProject-Getter-0.0.1-SNAPSHOT.jar"]
