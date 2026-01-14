# MIPS Assembly Language Plugin

MIPS assembly language plugin for [JetBrains](https://www.jetbrains.com/) IDEs
([PyCharm](https://www.jetbrains.com/pycharm/), [WebStorm](https://www.jetbrains.com/webstorm/), etc.).
The plugin uses [MARS](http://courses.missouristate.edu/kenvollmar/mars/index.htm) to assemble
and simulate MIPS assembly files.

**Note:** This is a fork of [equadon/intellij-mips](https://github.com/equadon/intellij-mips) to keep this plugin working on modern IntelliJ IDE/JetBrains IDEs.

## Authors

- **Niklas Persson** - Original author ([equadon/intellij-mips](https://github.com/equadon/intellij-mips))
- **Gabriel Scarcella** ([@gascarcella](https://github.com/gascarcella)) - Current maintainer

## Building

This project has been migrated to use Gradle. The lexer and parser are automatically generated from `Mips.flex` and `Mips.bnf` files during compilation using Grammar-Kit and JFlex.

### Build the Plugin

To create a distributable plugin ZIP file:

```bash
./gradlew buildPlugin
```

The plugin ZIP will be created in `build/distributions/`.

### Run the Plugin Locally (Development Mode)

To test the plugin in a sandboxed IDE instance:

```bash
./gradlew runIde
```

This will launch an IntelliJ IDE with the plugin installed.

### Install the Plugin in Your IDE

After building the plugin, you can install it in any JetBrains IDE:

1. Open your JetBrains IDE (IntelliJ IDEA, PyCharm, WebStorm, etc.)
2. Press `Ctrl+Alt+S` (Windows/Linux) or `Cmd+,` (macOS) to open Settings
3. Navigate to **Plugins**
4. Click the gear icon ⚙️ and select **Install Plugin from Disk...**
5. Select the plugin ZIP file from `build/distributions/MIPS-0.1.zip`
6. Click **OK** and restart the IDE when prompted

**Note:** Plugins installed from disk do not receive automatic updates and must be updated manually.

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

## Contributing

We welcome contributions to the MIPS Assembly Language Plugin! Here's how you can help:

### Reporting Issues

If you encounter a bug or have a feature request:

1. Check the [Issues](https://github.com/gascarcella/intellij-mips/issues) page to see if it's already reported
2. If not, create a new issue with:
   - A clear, descriptive title
   - Detailed description of the problem or feature
   - Steps to reproduce (for bugs)
   - Your environment (IDE version, plugin version, OS)

### Contributing Code

1. **Fork the repository** to your GitHub account
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR-USERNAME/intellij-mips.git
   cd intellij-mips
   ```
3. **Create a feature branch** for your changes:
   ```bash
   git checkout -b feat/your-feature-name
   ```
4. **Make your changes** and test them using `./gradlew runIde`
5. **Commit your changes** with clear, descriptive commit messages
6. **Push to your fork**:
   ```bash
   git push origin feat/your-feature-name
   ```
7. **Open a Pull Request** from your fork to the main repository

Please ensure your code follows the existing style and includes appropriate tests where applicable.

## Known issues

* Lexer and parser not implemented 100% to specification (but are functional and implemented using JFlex and Grammar-Kit)
