## java-playground

Various simple stuff to get myself comfortable in Javaland.

This project was initialized using Maven:

    mvn archetype:generate -DgroupId=org.mkscrg -DartifactId=java-playground -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Compile everything:

    mvn compile

### Geocoder

Makes calls to the Google Geocoding API.

Run it:

    mvn -q exec:java -Dexec.mainClass=org.mkscrg.java_playground.Geocoder

Type an address (no linebreaks) and Google's JSON response is printed.

### MongoRW

Reads and writes docs to/from MongoDB.

Run it:

    mvn -q exec:java -Dexec.mainClass=org.mkscrg.java_playground.MongoRW

Each line of `stdin` is inserted as a doc like this:

    { "_id" : ObjectId("..."), "txt" : "You wrote this on stdin!" }
