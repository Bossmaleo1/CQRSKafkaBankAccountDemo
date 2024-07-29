plugins {
    kotlin("jvm") version "1.9.24"
}

group = "com.techbank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

/*tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}*/