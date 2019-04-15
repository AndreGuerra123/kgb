import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.amyris.kgb"
version = "0.0.1"

//Project
val kotlinVersion = "1.3.30" //Change Below
val gradleVersion = "5.3.1"

//CLI
val cliktVersion = "1.7.0"

//Linting
val detektVersion = "1.0.0-RC14" //Change Below

//Docs
val dokkaVersion = "0.9.18"//Change Below

//Testing
val jUnitVersion = "5.4.2"

//Coverage
val jacocoVersion = "0.8.3"

//Shadow
val shadowVersion = "5.0.0"//Change Below

plugins {
    application
    java
    kotlin("jvm") version "1.3.30"
    id("io.gitlab.arturbosch.detekt").version("1.0.0-RC14")
    id("org.jetbrains.dokka").version("0.9.18")
    id("com.github.johnrengelman.shadow").version("5.0.0")
    jacoco
}

application {
    mainClassName = "com.amyris.kgb.CliKt"
}

tasks.withType<KotlinCompile> {

    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"

    kotlinOptions {
        jvmTarget = "1.8"
        apiVersion = "1.3"
        languageVersion = "1.3"
        allWarningsAsErrors = true
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.ajalt:clikt:$cliktVersion")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:$dokkaVersion")
    implementation("com.github.jengelman.gradle.plugins:shadow:$shadowVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")

}


tasks.detekt {
    group = "Linting"
    config = files("$rootDir/detekt.yml")
}

tasks.dokka {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
}

tasks.test {
    group="testing"
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
    finalizedBy(tasks.detekt,tasks.dokka,tasks.jacocoTestReport,tasks.shadowJar)

}

tasks.jacocoTestReport {
    group = "coverage"
    reports {
        xml.isEnabled = false
        html.isEnabled = true
        csv.isEnabled = false
    }
}













