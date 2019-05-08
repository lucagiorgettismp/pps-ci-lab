plugins {
    java
    scala
    id("org.scoverage") version "3.0.0"
    id("com.github.maiflai.scalatest") version "0.21"
}

repositories {
    jcenter()
}

val scalaMajor = "2.12"
val scalaMinor = "8"
val scalaVersion = "$scalaMajor.$scalaMinor"
val akkaVersion = "2.5.22"

dependencies {
    implementation("org.scala-lang:scala-library:$scalaVersion")

    implementation("com.typesafe.akka:akka-actor_$scalaMajor:$akkaVersion")
    implementation("com.typesafe.akka:akka-actor-typed_$scalaMajor:$akkaVersion")

    testImplementation("junit:junit:4.12")
    testImplementation("org.scalatest:scalatest_$scalaMajor:3.0.5")
    scoverage("org.scoverage:scalac-scoverage-plugin_2.12:1.3.1")
    scoverage("org.scoverage:scalac-scoverage-runtime_2.12:1.3.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


