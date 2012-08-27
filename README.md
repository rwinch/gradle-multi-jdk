This project demonstrates building with multiple JDK's in the same Gradle build. To set it up include jdk7Home and jdk6Home in your gradle.properties. An example is shown below:

**~/.gradle/gradle.properties**

    jdk6Home=/usr/lib/jvm/jdk1.6.0_32
    jdk7Home=/usr/lib/jvm/jdk1.7.0_06
