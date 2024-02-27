plugins {
//    id("java")
    application
    war
    id("org.gretty") version "4.1.0"
}

//group = "org.example"
//version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:11.0.0-M16")
//    implementation("org.apache.tomcat:tomcat-jasper:11.0.0-M16")
//    implementation("org.apache.tomcat:tomcat-jasper-el:11.0.0-M16")
//    implementation("org.apache.tomcat:tomcat-jsp-api:11.0.0-M16")
//    implementation("org.apache.tomcat.embed:tomcat-embed-core:11.0.0-M16")
//    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.1.17")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")

    implementation ("org.apache.tomcat.embed:tomcat-embed-core:10.1.5")
    implementation ("org.apache.tomcat.embed:tomcat-embed-jasper:10.1.5")

//    implementation 'org.apache.tomcat:tomcat-jasper:10.1.5'
//    implementation 'com.google.code.gson:gson:2.10.1'
//    implementation 'com.google.guava:guava:31.1-jre'

    implementation("javax.servlet:javax.servlet-api:4.0.1")
    testImplementation("junit:junit:4.13.2")
    implementation("org.postgresql:postgresql:42.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    // Define the main class for the application.
    mainClass = "org.cert.App"
}