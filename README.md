# android_xml_parser
### Parser for Android binary xml(apk) & ProtocolBuffer xml(aab) use Kotlin

## Overview
parse xml elements for Android apk & aab archive

## Example
Parse android archive apk manifest xml
```kotlin
val apkParser = AndroidAPKParser(inputPath)
val apkManifestData = apkParser.manifestData
```

Parse android archive aab manifest xml
```kotlin
val aabParser = AndroidAABParser(inputPath)
val aabManifestData = aabParser.parseAABManifest()
```

## APK Data
- String packageName
- String label
- String icon
- String versionName
- Long versionCode
- Long revisionCode
- String sharedUserId
- String sharedUserLabel
- String split
- String configForSplit
- boolean isFeatureSplit
- boolean isSplitRequired
- boolean isolatedSplits
- String installLocation
- String minSdkVersion
- String targetSdkVersion
- String maxSdkVersion
  - Nullable
- String compileSdkVersion
  - Nullable
- String compileSdkVersionCodename
  - Nullable
- String platformBuildVersionCode
  - Nullable
- String platformBuildVersionName
  - Nullable
- String applicationName
- GlEsVersion glEsVersion
- boolean anyDensity
- boolean smallScreens
- boolean normalScreens
- boolean largeScreens
- boolean debuggable
- List<String> usesPermissions
- List<UseFeature> usesFeatures
- List<Permission> permissions
- List<String> activityList
- List<String> providerList
- List<String> serviceList
- List<String> receiverList
## AAB Data
- String packageName
- String versionCode
- String versionName
- String compileSdkVersion
- String platformBuildVersionCode
- String compileSdkVersionCodename
- String platformBuildVersionName
- String minSdkVersion
- String targetSdkVersion
- String applicationName
- List<String> permissionList
- List<String> activityList
- List<String> providerList
- List<String> serviceList
- List<String> receiverList
### it contains method
- AndroidAPKParser
  - constructor(apkFile)
  - manifestData
- AndroidAABParser
  - constructor(aabFile)
  - parseAABManifest()

## Project Structure:
```
.
├── LICENSE
├── README.md
├── build.gradle.kts
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── src
    └── main
        ├── java
        │   └── net
        │       └── dongliu
        │           └── apk
        │               └── parser
        │                   ├── AbstractApkFile.java
        │                   ├── ApkFile.java
        │                   ├── ApkParsers.java
        │                   ├── ByteArrayApkFile.java
        │                   ├── bean
        │                   │   ├── AdaptiveIcon.java
        │                   │   ├── ApkMeta.java
        │                   │   ├── ApkSignStatus.java
        │                   │   ├── ApkSigner.java
        │                   │   ├── ApkV2Signer.java
        │                   │   ├── CertificateMeta.java
        │                   │   ├── ColorIcon.java
        │                   │   ├── DexClass.java
        │                   │   ├── GlEsVersion.java
        │                   │   ├── Icon.java
        │                   │   ├── IconFace.java
        │                   │   ├── IconPath.java
        │                   │   ├── Permission.java
        │                   │   └── UseFeature.java
        │                   ├── cert
        │                   │   ├── asn1
        │                   │   │   ├── Asn1BerParser.java
        │                   │   │   ├── Asn1Class.java
        │                   │   │   ├── Asn1DecodingException.java
        │                   │   │   ├── Asn1DerEncoder.java
        │                   │   │   ├── Asn1EncodingException.java
        │                   │   │   ├── Asn1Field.java
        │                   │   │   ├── Asn1OpaqueObject.java
        │                   │   │   ├── Asn1TagClass.java
        │                   │   │   ├── Asn1Tagging.java
        │                   │   │   ├── Asn1Type.java
        │                   │   │   └── ber
        │                   │   │       ├── BerDataValue.java
        │                   │   │       ├── BerDataValueFormatException.java
        │                   │   │       ├── BerDataValueReader.java
        │                   │   │       ├── BerEncoding.java
        │                   │   │       ├── ByteBufferBerDataValueReader.java
        │                   │   │       └── InputStreamBerDataValueReader.java
        │                   │   ├── package-info.java
        │                   │   └── pkcs7
        │                   │       ├── AlgorithmIdentifier.java
        │                   │       ├── Attribute.java
        │                   │       ├── ContentInfo.java
        │                   │       ├── EncapsulatedContentInfo.java
        │                   │       ├── IssuerAndSerialNumber.java
        │                   │       ├── Pkcs7Constants.java
        │                   │       ├── SignedData.java
        │                   │       ├── SignerIdentifier.java
        │                   │       └── SignerInfo.java
        │                   ├── exception
        │                   │   └── ParserException.java
        │                   ├── parser
        │                   │   ├── AdaptiveIconParser.java
        │                   │   ├── ApkMetaTranslator.java
        │                   │   ├── ApkSignBlockParser.java
        │                   │   ├── AttributeValues.java
        │                   │   ├── BCCertificateParser.java
        │                   │   ├── BinaryXmlParser.java
        │                   │   ├── CertificateMetas.java
        │                   │   ├── CertificateParser.java
        │                   │   ├── CompositeXmlStreamer.java
        │                   │   ├── DexParser.java
        │                   │   ├── JSSECertificateParser.java
        │                   │   ├── ResourceTableParser.java
        │                   │   ├── StringPoolEntry.java
        │                   │   ├── XmlNamespaces.java
        │                   │   ├── XmlStreamer.java
        │                   │   ├── XmlTranslator.java
        │                   │   └── package-info.java
        │                   ├── struct
        │                   │   ├── AndroidConstants.java
        │                   │   ├── ChunkHeader.java
        │                   │   ├── ChunkType.java
        │                   │   ├── ResValue.java
        │                   │   ├── ResourceValue.java
        │                   │   ├── StringPool.java
        │                   │   ├── StringPoolHeader.java
        │                   │   ├── dex
        │                   │   │   ├── DexClassStruct.java
        │                   │   │   └── DexHeader.java
        │                   │   ├── package-info.java
        │                   │   ├── resource
        │                   │   │   ├── Densities.java
        │                   │   │   ├── LibraryEntry.java
        │                   │   │   ├── LibraryHeader.java
        │                   │   │   ├── NullHeader.java
        │                   │   │   ├── PackageHeader.java
        │                   │   │   ├── ResTableConfig.java
        │                   │   │   ├── ResourceEntry.java
        │                   │   │   ├── ResourceMapEntry.java
        │                   │   │   ├── ResourcePackage.java
        │                   │   │   ├── ResourceTable.java
        │                   │   │   ├── ResourceTableHeader.java
        │                   │   │   ├── ResourceTableMap.java
        │                   │   │   ├── Type.java
        │                   │   │   ├── TypeHeader.java
        │                   │   │   ├── TypeSpec.java
        │                   │   │   └── TypeSpecHeader.java
        │                   │   ├── signingv2
        │                   │   │   ├── ApkSigningBlock.java
        │                   │   │   ├── Digest.java
        │                   │   │   ├── Signature.java
        │                   │   │   └── SignerBlock.java
        │                   │   ├── xml
        │                   │   │   ├── Attribute.java
        │                   │   │   ├── Attributes.java
        │                   │   │   ├── NullHeader.java
        │                   │   │   ├── XmlCData.java
        │                   │   │   ├── XmlHeader.java
        │                   │   │   ├── XmlNamespaceEndTag.java
        │                   │   │   ├── XmlNamespaceStartTag.java
        │                   │   │   ├── XmlNodeEndTag.java
        │                   │   │   ├── XmlNodeHeader.java
        │                   │   │   ├── XmlNodeStartTag.java
        │                   │   │   └── XmlResourceMapHeader.java
        │                   │   └── zip
        │                   │       └── EOCD.java
        │                   └── utils
        │                       ├── Buffers.java
        │                       ├── Inputs.java
        │                       ├── Locales.java
        │                       ├── Pair.java
        │                       ├── ParseUtils.java
        │                       ├── ResourceFetcher.java
        │                       ├── ResourceLoader.java
        │                       ├── Strings.java
        │                       ├── Unsigned.java
        │                       ├── package-info.java
        │                       └── xml
        │                           ├── AggregateTranslator.java
        │                           ├── CharSequenceTranslator.java
        │                           ├── CodePointTranslator.java
        │                           ├── EntityArrays.java
        │                           ├── LookupTranslator.java
        │                           ├── NumericEntityEscaper.java
        │                           ├── UnicodeUnpairedSurrogateRemover.java
        │                           └── XmlEscaper.java
        ├── kotlin
        │   └── kr
        │       └── owens
        │           └── axp
        │               ├── Application.kt
        │               ├── cli
        │               │   └── CLIUtil.kt
        │               └── parser
        │                   ├── aab
        │                   │   ├── AndroidAABParser.kt
        │                   │   └── data
        │                   │       ├── AABManifestData.kt
        │                   │       └── AABPath.kt
        │                   └── apk
        │                       └── AndroidAPKParser.kt
        ├── proto
        │   ├── Configuration.proto
        │   └── Resources.proto
        └── resources
            ├── r_styles.ini
            └── r_values.ini
```
## Library used:
- Kotlin-stdlib
- Kotlin-reflect
- Donliu-apk-parser
- Apache commons-cli 1.4
- Bouncycastle-bcpkix 1.68
- Bouncycastle-bcprov 1.68
- Protobuf-java 3.15.6
- Protobuf-java-util 3.15.6
- Protoc 3.15.6
