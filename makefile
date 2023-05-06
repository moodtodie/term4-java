SHELL:=bash

run:
	java -jar target/lab1-0.0.1-SNAPSHOT.jar

rebuild:
	mvn clean package

clean:
	mvn clean
