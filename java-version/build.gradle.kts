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

import xyz.jpenilla.resourcefactory.bukkit.Permission

val pluginName = "${rootProject.name}-java"

tasks.jar {
    archiveBaseName = pluginName
    destinationDirectory.set(rootProject.layout.buildDirectory.dir("libs"))
}

tasks.shadowJar {
    archiveBaseName = pluginName
    destinationDirectory.set(rootProject.layout.buildDirectory.dir("libs"))
}

paperPluginYaml {
    name = pluginName
    main = "org.atg.chatColors.ChatColors"
    author = "AlexTheGood"
    apiVersion = "1.21.8"
    version = "1.1"
    permissions {
        register("chatcolors.colored") {
            description = "allows colors in chat"
            default = Permission.Default.OP
        }
    }
}
