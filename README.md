# TweetStats

Assignment for the Software Quality course at ECE Paris 2013 with Lom Hillah.


## Instructions for installation



## Instructions for build and development

Requires JDK 1.7.0 update 9 or higher and Maven 3.

1. Set your `JAVA_HOME` to JDK 1.7
2. Add javafx to Maven:

    - Read the version number of javafx in `${JDK7_HOME}/jre/lib/javafx.properties`

    - Run:

```
mvn install:install-file \
  -Dfile=${JDK7_HOME}/jre/lib/jfxrt.jar \
  -DgroupId=com.oracle \
  -DartifactId=javafx \
  -Dpackaging=jar \
  -Dversion=${JAVAFX_VERSION}
```
    
   Check the javafx version number in `pom.xml` (current is `2.2.45`) and update if needed.
    
You can now compile the project under Eclipse.

### Native installer

1. Install [JavaFX Maven Plugin](http://zenjava.com/javafx/maven/):

    - `mvn com.zenjava:javafx-maven-plugin:2.0:fix-classpath`

To compile the project as a native installer, run the `build.sh` script.