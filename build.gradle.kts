plugins {
    `java-library`
    id("com.vanniktech.maven.publish") version "0.28.0"
}

group = "com.lalilu"
version = "1.2.0"
description = "Java Foundation Access"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.java.dev.jna:jna:5.9.0:jpms")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
    withJavadocJar()
}

tasks.test {
    useJUnitPlatform()
}

mavenPublishing {
    coordinates(group.toString(), "jfa", version.toString())

    pom {
        name.set("JFA")
        description.set("Java Foundation Access")
        url.set("https://github.com/cy745/jfa")

        licenses {
            license {
                name.set("Apache 2.0")
                url.set("https://opensource.org/licenses/Apache-2.0")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("jan.gassen")
                name.set("Jan Gassen")
            }
        }

        scm {
            url.set("https://github.com/cy745/jfa")
        }
    }
}