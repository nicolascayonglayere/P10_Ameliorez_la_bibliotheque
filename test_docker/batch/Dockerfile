FROM java:8

ADD https://drive.google.com/uc?id=10BgZ8eQu3SdoUu7iFBdFQI1Z6MaxObyV&export=download BATCH.zip

RUN unzip BATCH.zip

ENTRYPOINT ["java","-jar","bibliothequeBatch-1.1.0-RELEASE.jar"]
