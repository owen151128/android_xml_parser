import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    java
    kotlin("jvm") version "1.4.31"
    id("com.google.protobuf") version "0.8.15"
}

group = "kr.owens"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("commons-cli", "commons-cli", "1.4")
    implementation("org.bouncycastle", "bcpkix-jdk15on", "1.68")
    implementation("org.bouncycastle", "bcprov-jdk15on", "1.68")
    implementation("com.google.protobuf", "protobuf-java", "3.15.6")
    implementation("com.google.protobuf", "protobuf-java-util", "3.15.6")
    testCompile("junit", "junit", "4.12")
    protobuf(files("src/main/protoc"))
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.15.6"
    }
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "kr.owens.axp.ApplicationKt"
    }

    from(configurations.runtimeClasspath.get().map {
        exclude("META-INF/MANIFEST.MF", "META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
        if (it.isDirectory) it else zipTree(it)
    })
}