# Albathanext
You have to cd to project root, have java and maven setup already
# build
  1. mvn clean package
  2. docker-compose build
# deploy
  1. docker-compose up
  2. for swagger got to http://localhost:8080/swagger-ui/index.html
# swagger
****
![Screenshot](albatha.png)

## target design

![Screenshot](albathanext.drawio.png)


Logged in as yaredngd@gmail.com
Creating app... done, ⬢ glacial-cliffs-85226
https://glacial-cliffs-85226.herokuapp.com/ | https://git.heroku.com/glacial-cliffs-85226.git


heroku create --no-remote
Creating app... done, ⬢ obscure-hollows-92403
https://obscure-hollows-92403.herokuapp.com/ | https://git.heroku.com/obscure-hollows-92403.git
yrd@yrd-mnt:~/Desktop/albathanext

heroku deploy:jar albathanext-0.0.1-SNAPSHOT.jar --app obscure-hollows-92403
Uploading albathanext-0.0.1-SNAPSHOT.jar
-----> Packaging application...
- app: obscure-hollows-92403
- including: albathanext-0.0.1-SNAPSHOT.jar
-----> Creating build...
- file: slug.tgz
- size: 54MB
-----> Uploading build...
