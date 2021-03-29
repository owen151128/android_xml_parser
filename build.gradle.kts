plugins {
    java
    kotlin("jvm") version "1.4.31"
}

group = "kr.owens"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}
