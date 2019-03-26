FROM java:8

RUN mkdir -p /images

COPY bibliothequeWebApp-1.0.1-SNAPSHOT.war bibliothequeWebApp-1.0.1-SNAPSHOT.war

ADD https://drive.google.com/uc?authuser=0&id=1QxRj19U-d2dAWJaXNiY5LM_7ZTrpatjs&export=download /images/images.zip

RUN cd /images && unzip images.zip 	

ENTRYPOINT ["java","-jar","bibliothequeWebApp-1.0.1-SNAPSHOT.war"]
