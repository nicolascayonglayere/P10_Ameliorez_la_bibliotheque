FROM java:8

ADD https://drive.google.com/uc?id=1jgC2FFMuvltJtbT1hgMlGRCnWzeXBPe-&export=download WS.zip

RUN unzip WS.zip

ENTRYPOINT ["java","-jar","bibliothequeWS-AppSpringBoot-1.0-RELEASE.jar"]
