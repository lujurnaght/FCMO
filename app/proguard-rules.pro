-keepnames class com.lujurnaght.fractionalcmo.** { *; }
-keepattributes *Annotation*, InnerClasses, Signature, EnclosingMethod
-keepclassmembers @kotlinx.serialization.Serializable class com.lujurnaght.fractionalcmo.** {
    *** Companion;
    *** INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}
-keep,includedescriptorclasses class com.lujurnaght.fractionalcmo.**$$serializer { *; }
-keepclasseswithmembers class com.lujurnaght.fractionalcmo.** {
    kotlinx.serialization.KSerializer serializer(...);
}
