FROM java:8

ADD https://drive.google.com/uc?id=1j1UwYtV0GvV30usgjBOCuvB5ZvYUhntH&export=download BATCH.zip

RUN unzip BATCH.zip

ENTRYPOINT ["java","-jar","bibliothequeBatch-1.0-RELEASE.jar"]
