FROM openjdk:8
RUN mkdir weather
COPY target/weather-0.1.0.jar /weather
WORKDIR /weather
CMD ["java", "-jar", "weather-0.1.0.jar"]
