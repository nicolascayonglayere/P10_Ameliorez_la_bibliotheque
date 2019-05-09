FROM java:8

RUN mkdir -p /images

ADD https://drive.google.com/uc?id=1aX1jjQJWWdUNgzMzbDgiTkhxPBmNFtis&export=download WEBAPP.zip

RUN unzip WEBAPP.zip

ADD https://drive.google.com/uc?authuser=0&id=1QxRj19U-d2dAWJaXNiY5LM_7ZTrpatjs&export=download /images/images.zip

RUN cd /images && unzip images.zip && cd..	

ENTRYPOINT ["java","-jar","bibliothequeWebApp-1.1.0-RELEASE.war"]
