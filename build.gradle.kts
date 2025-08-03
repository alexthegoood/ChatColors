// Copyright 2025 AlexTheGood
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

val javaVersion = 21

plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.0.0-rc3" apply false
    id("xyz.jpenilla.resource-factory-paper-convention") version "1.3.0" apply false
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "xyz.jpenilla.resource-factory-paper-convention")
    apply(plugin = "com.gradleup.shadow")

    dependencies { compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT") }
    repositories { maven("https://repo.papermc.io/repository/maven-public/") }

    tasks {
        compileJava { options.release = javaVersion }
        javadoc { options.encoding = Charsets.UTF_8.name() }
    }
}

tasks.jar { enabled = false }