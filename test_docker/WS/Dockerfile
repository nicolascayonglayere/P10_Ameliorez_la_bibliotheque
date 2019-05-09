FROM java:8

ADD https://drive.google.com/uc?id=1lrRu4ltnSEInx39PfbGgykNd4z9lSPlS&export=download WS.zip

RUN unzip WS.zip

ENTRYPOINT ["java","-jar","bibliothequeWS-AppSpringBoot-1.1.0-RELEASE.jar"]
