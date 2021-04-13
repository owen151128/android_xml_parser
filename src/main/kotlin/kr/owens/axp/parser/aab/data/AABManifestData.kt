package kr.owens.axp.parser.aab.data

/**
 * @author
 *
 * Created by owen151128@gmail.com on 2021/04/09 14:11
 *
 * Providing features related to ProtoBufferXmlData class
 */
data class AABManifestData(
    var packageName: String = "",
    var versionCode: String = "",
    var versionName: String = "",
    var compileSdkVersion: String = "",
    var platformBuildVersionCode: String = "",
    var compileSdkVersionCodename: String = "",
    var platformBuildVersionName: String = "",
    var minSdkVersion: String = "",
    var targetSdkVersion: String = "",
    var applicationName: String = "",
    var permissionList: MutableList<String> = mutableListOf(),
    var activityList: MutableList<String> = mutableListOf(),
    var providerList: MutableList<String> = mutableListOf(),
    var serviceList: MutableList<String> = mutableListOf(),
    var receiverList: MutableList<String> = mutableListOf()
)
