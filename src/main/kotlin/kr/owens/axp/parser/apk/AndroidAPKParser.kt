package kr.owens.axp.parser.apk

import net.dongliu.apk.parser.ApkFile
import net.dongliu.apk.parser.bean.ApkMeta
import java.io.File

/**
 * @author
 *
 * Created by owen151128@gmail.com on 2021/04/05 15:00
 *
 * Providing features related to AndroidAPKParser class
 */
class AndroidAPKParser(apkFile: File) {
    private val apk: ApkFile = ApkFile(apkFile)
    val manifestData: ApkMeta by lazy { apk.apkMeta }
}