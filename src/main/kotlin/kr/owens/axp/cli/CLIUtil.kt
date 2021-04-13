package kr.owens.axp.cli

import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options

/**
 * @author
 *
 * Created by owen151128@gmail.com on 2021/04/13 13:56
 *
 * Providing features related to CLIUtil class
 */
object CLIUtil {
    val options = Options()

    init {
        options.addOption(Option("h", "help", false, "print this message"))
        options.addOption("v", "version", false, "print version")
        options.addOption(Option("i", "input", true, "input file (apk / aab)"))
    }

    fun parseCommandLineArguments(args: Array<String>): CommandLine {
        return DefaultParser().parse(options, args)
    }
}