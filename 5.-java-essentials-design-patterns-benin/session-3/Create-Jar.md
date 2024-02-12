# Creating a JAR file

## Steps to produce a JAR file

- `../cd session-1`
- `echo "Main-Class: Example_1" > manifest.txt`
- `rm *.class`
- `javac Example_1.java`
- `jar cfmv example.jar manifest.txt Example_1.class Example_2.class`

## Using the JAR file

- `mkdir temp`
- `mv example.jar temp`
- `java -jar example.jar 1`
