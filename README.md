# MIPS Assembly Language Plugin

MIPS assembly language plugin for [JetBrains](https://www.jetbrains.com/) IDEs
([PyCharm](https://www.jetbrains.com/pycharm/), [WebStorm](https://www.jetbrains.com/webstorm/), etc.).
The plugin uses [MARS](http://courses.missouristate.edu/kenvollmar/mars/index.htm) to assemble
and simulate MIPS assembly files.

**Note:** This is a fork of [equadon/intellij-mips](https://github.com/equadon/intellij-mips) to keep this plugin working on modern IntelliJ IDE/JetBrains IDEs.

## Building

This project has been migrated to use Gradle. To build the plugin:

```bash
./gradlew buildPlugin
```

The lexer and parser are automatically generated from `Mips.flex` and `Mips.bnf` files during compilation using Grammar-Kit and JFlex.

## Features

* Syntax highlighting
* Simulate MIPS programs
* Debugger
  * Breakpoints
* Registers tool window
* Structure view
* Goto symbol
* Code formatting
* Folding (only multi-line comments currently)
* Live and file templates
* Commenter
* Code completion

## Known issues

* Lexer and parser not implemented 100% to specification (but are functional and implemented using JFlex and Grammar-Kit)
