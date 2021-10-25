## ECS CAR DEMO

# How to Run:
-- Need to have java 11 installed(JAVA_HOME environment variable should point to java installation directory)
1. Go to project root directory "/ecs"
2. Open terminal then type ./gradlew clean (for windows -> gradlew clean)
3. Then ./gradlew build (for windows -> gradlew build)
4. Finally ./gradlew bootRun (for windows -> gradlew bootRun)

By default it runs with embabded h2 databse but you can change it mysql profile change.

Application runs on port 8087. Application inserts some data into database at start up

**Please find attached postman collection and environment inside postman_collection folder "/ecs/postman_collection". 
Import them(collection and environment) in postman to run some http PUT,POST,DELETE request**

Log output to console and file both using spring logback, log file will be stored in logs folder inside project directory. 

## Urls:

http://localhost:8087/

All Car: http://localhost:8087/car

All make: http://localhost:8087/make

All model: http://localhost:8087/model

All car with audi make: http://localhost:8087/make/audi/car_list

All car with suv model: http://localhost:8087/model/suv/car_list


Contact:
Rana Ghosh - rudj.di@gmail.com
