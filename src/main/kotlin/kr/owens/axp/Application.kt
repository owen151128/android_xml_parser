package kr.owens.axp

import kr.owens.axp.cli.CLIUtil
import kr.owens.axp.parser.aab.AndroidAABParser
import kr.owens.axp.parser.aab.data.AABManifestData
import kr.owens.axp.parser.apk.AndroidAPKParser
import net.dongliu.apk.parser.bean.ApkMeta
import org.apache.commons.cli.HelpFormatter
import java.io.File
import kotlin.reflect.full.memberProperties

/**
 * @author owen151128@gmail.com
 *
 * Created by owen151128@gmail.com on 2021/03/29 11:15
 *
 * Providing features related to Application class
 */
const val APPLICATION_NAME = "android xml parser"
const val VERSION = "1.0.0"

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    val cli = CLIUtil.parseCommandLineArguments(args)

    if (cli.hasOption("help")) {
        HelpFormatter().printHelp(APPLICATION_NAME, CLIUtil.options)

        return
    }

    if (cli.hasOption("version")) {
        println("$APPLICATION_NAME Version : $VERSION")

        return
    }

    if (!cli.hasOption("input")) {
        println(
            "Input option required...\n" +
                    "ex) -i example.apk or example.aab"
        )

        return
    }

    val inputPath = File(File(cli.getOptionValue("input")).absolutePath)

    if (!inputPath.exists()) {
        println("${inputPath.absolutePath} is not exist... please check input file...")

        return
    }

    if (inputPath.absolutePath.endsWith(".apk") || inputPath.absolutePath.endsWith(".APK")) {
        val apkParser = AndroidAPKParser(inputPath)
        val apkManifestData = apkParser.manifestData

        ApkMeta::class.java.declaredFields.forEach {
            it.isAccessible = true
            when (val value = it.get(apkManifestData)) {
                is MutableList<*> -> {
                    println("APK ${it.name} : [")
                    value.forEach { v ->
                        println(v)
                    }
                    println(
                        "]" +
                                "\n========================================"
                    )
                }
                else -> println(
                    "APK ${it.name} : $value" +
                            "\n========================================"
                )
            }
        }
    } else if (inputPath.absolutePath.endsWith(".aab") || inputPath.absolutePath.endsWith(".AAB")) {
        val aabParser = AndroidAABParser(inputPath)
        val aabManifestData = aabParser.parseAABManifest()

        AABManifestData::class.memberProperties.forEach {
            when (val value = it.get(aabManifestData)) {
                is String -> println(
                    "AAB ${it.name} : $value" +
                            "\n========================================"
                )
                is MutableList<*> -> {
                    println("AAB ${it.name} : [")
                    value.forEach { v ->
                        println(v)
                    }
                    println(
                        "]" +
                                "\n========================================"
                    )
                }
            }
        }
    } else {
        println(
            "${inputPath.absolutePath} is not support file." +
                    "\nandroid xml parser only support (apk/aab)." +
                    "\nplease check input file..."
        )
    }
}