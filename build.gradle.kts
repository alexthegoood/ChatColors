import xyz.jpenilla.resourcefactory.bukkit.Permission

plugins {
    `java-library`
    id("xyz.jpenilla.resource-factory-paper-convention") version "1.3.0"
}

val javaVersion = 21
java { toolchain.languageVersion = JavaLanguageVersion.of(javaVersion) }

repositories { maven("https://repo.papermc.io/repository/maven-public/") }
dependencies { compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT") }

tasks {
    compileJava { options.release = javaVersion }
    javadoc { options.encoding = Charsets.UTF_8.name() }
}

paperPluginYaml {
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
