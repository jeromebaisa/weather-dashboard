
.PHONY: build run jar clean

build:
	./gradlew build

run:
	./gradlew run

jar:
	./gradlew shadowJar

clean:
	./gradlew clean
