import org.jetbrains.grammarkit.tasks.GenerateLexerTask
import org.jetbrains.grammarkit.tasks.GenerateParserTask

plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.2.1"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

group = "com.equadon.intellij.mips"
version = "0.1"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "gen")
        }
        resources {
            srcDirs("src/main/resources")
        }
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(providers.gradleProperty("platformVersion"))
        bundledPlugins(providers.gradleProperty("platformPlugins").map { it.split(',').map(String::trim).filter(String::isNotEmpty) })

        pluginVerifier()
        zipSigner()
    }

    // Mars MIPS simulator
    implementation(files("lib/Mars4_5.jar"))
}

intellijPlatform {
    pluginConfiguration {
        id = "com.equadon.intellij.mips"
        name = "MIPS"
        version = project.version.toString()
        description = "MIPS assembly language plugin for IntelliJ IDEA."

        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
            untilBuild = providers.gradleProperty("pluginUntilBuild")
        }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks {
    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }

    patchPluginXml {
        sinceBuild = providers.gradleProperty("pluginSinceBuild")
        untilBuild = providers.gradleProperty("pluginUntilBuild")
    }

    processResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}

// Grammar-Kit task for generating parser from BNF
val generateMipsParser = tasks.register<GenerateParserTask>("generateMipsParser") {
    sourceFile.set(file("grammar/Mips.bnf"))
    targetRootOutputDir.set(file("gen"))
    pathToParser.set("com/equadon/intellij/mips/lang/parser/_MipsParser.java")
    pathToPsiRoot.set("com/equadon/intellij/mips/lang/psi")
    purgeOldFiles.set(true)
}

// JFlex task for generating lexer
val generateMipsLexer = tasks.register<GenerateLexerTask>("generateMipsLexer") {
    sourceFile.set(file("src/main/java/com/equadon/intellij/mips/lang/lexer/Mips.flex"))
    targetOutputDir.set(file("gen/com/equadon/intellij/mips/lang/lexer"))
    purgeOldFiles.set(true)
}

// Ensure parser and lexer are generated before compiling
tasks.named("compileJava") {
    dependsOn("generateMipsParser", "generateMipsLexer")
}
