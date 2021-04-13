package kr.owens.axp.parser.aab

import com.android.aapt.Resources
import kr.owens.axp.parser.aab.data.AABManifestData
import kr.owens.axp.parser.aab.data.AABPath
import java.io.File
import java.util.zip.ZipFile

/**
 * @author
 *
 * Created by owen151128@gmail.com on 2021/04/09 11:21
 *
 * Providing features related to AndroidAABParser class
 */
class AndroidAABParser(aabFile: File) {
    private val aab = ZipFile(aabFile)
    private val xmlRootNode: Resources.XmlNode

    companion object {
        private class ParseException(cause: String) : Exception(cause)
    }

    init {
        val manifestEntry = aab.getEntry(AABPath.MANIFEST_PATH)
        val manifestInputStream = aab.getInputStream(manifestEntry)

        xmlRootNode = Resources.XmlNode.parseFrom(manifestInputStream.readBytes())

        if (!xmlRootNode.hasElement()) {
            throw ParseException("Root node has no element.")
        }
    }

    fun parseAABManifest(): AABManifestData {
        val aabManifestData = AABManifestData()
        traverseXmlNode(xmlRootNode, aabManifestData)

        return aabManifestData
    }

    private fun traverseXmlNode(xmlNode: Resources.XmlNode, aabManifestData: AABManifestData) {
        if (xmlNode.hasElement()) {
            val element = xmlNode.element
            parseElement(element, aabManifestData)
            val childCount = element.childCount
            if (childCount > 0) {
                val childList = element.childList
                for (i in 0 until childCount) {
                    traverseXmlNode(childList[i], aabManifestData)
                }
            }
        }
    }

    private fun parseElement(element: Resources.XmlElement, aabManifestData: AABManifestData) {
        var key = ""
        if (element.name != null && element.name != "") {
            key += "${element.name}."
        }

        if (element.attributeCount > 0) {
            for (a in element.attributeList) {
                when (key + a.name) {
                    "manifest.package" -> aabManifestData.packageName = a.value
                    "manifest.versionCode" -> aabManifestData.versionCode = a.value
                    "manifest.versionName" -> aabManifestData.versionName = a.value
                    "manifest.compileSdkVersion" -> aabManifestData.compileSdkVersion = a.value
                    "manifest.platformBuildVersionCode" -> aabManifestData.platformBuildVersionCode =
                        a.value
                    "manifest.compileSdkVersionCodename" -> aabManifestData.compileSdkVersionCodename =
                        a.value
                    "manifest.platformBuildVersionName" -> aabManifestData.platformBuildVersionName =
                        a.value
                    "uses-sdk.minSdkVersion" -> aabManifestData.minSdkVersion = a.value
                    "uses-sdk.targetSdkVersion" -> aabManifestData.targetSdkVersion = a.value
                    "uses-permission.name" -> aabManifestData.permissionList.add(a.value)
                    "application.name" -> aabManifestData.applicationName = a.value
                    "activity.name" -> aabManifestData.activityList.add(a.value)
                    "provider.name" -> aabManifestData.providerList.add(a.value)
                    "service.name" -> aabManifestData.serviceList.add(a.value)
                    "receiver.name" -> aabManifestData.receiverList.add(a.value)
                }
            }
        }
    }
}