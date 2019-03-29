# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#保留选项
#-----------------------------1.实体类-----------------------------------------------

#实现Serializable接口的JavaBean
#-keep class com.looper.ultimate.bean.** { *; }

#-----------------------------2.第三方包---------------------------------------------

#glide
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}
#-keep class com.bumptech.glide.** { *; }

#retrofit2
#-dontwarn retrofit2.**
#-keep class retrofit2.** { *; }
#-keepattributes Signature
#-keepattributes Exceptions

#-dontwarn org.robovm.**
#-keep class org.robovm.** { *; }

#rxjava
#-dontwarn rx.**
#-keep class rx.** { *; }
#
#-dontwarn sun.misc.**
#-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
# long producerIndex;
# long consumerIndex;
#}
#-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
# rx.internal.util.atomic.LinkedQueueNode producerNode;
#}
#-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
# rx.internal.util.atomic.LinkedQueueNode consumerNode;
#}

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-ignorewarnings

#okhttputils
-dontwarn com.zhy.http.**
-keep class com.zhy.http.**{*;}

#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-dontwarn okhttp3.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
#okio
-dontwarn okio.**
-keep class okio.**{*;}

#umeng
-dontwarn com.umeng.**
-keep class com.umeng.**{*;}
-keep class u.aly.**{*;}
-keep class com.google.**{*;}

#ali oss
-keep class com.alibaba.sdk.android.oss.** { *; }
-dontwarn org.apache.commons.codec.binary.**

-dontwarn com.taobao.**
-dontwarn anet.channel.**
-dontwarn anetwork.channel.**
-dontwarn org.android.**
-dontwarn com.xiaomi.**
-dontwarn com.huawei.**
-dontwarn org.apache.thrift.**

-keepattributes *Annotation*

-keep class com.taobao.** {*;}
-keep class org.android.** {*;}
-keep class anet.channel.** {*;}
-keep class com.umeng.** {*;}
-keep class com.xiaomi.** {*;}
-keep class com.huawei.** {*;}
-keep class org.apache.thrift.** {*;}
-keep class com.alibaba.sdk.android.**{*;}
-keep class com.ut.**{*;}
-keep class com.ta.**{*;}

-keep public class com.umeng.message.example.example.R$*{
   public static final int *;
}

#Bugly
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

#butterknife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-dontwarn butterknife.compiler.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}
#nineold androids
-dontwarn com.nineoldandroids.*
-keep class com.nineoldandroids.** { *;}

#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

#picasso
-dontwarn com.squareup.picasso.**

### greenDAO 3
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties
-keep class org.greenrobot.greendao.** { *; }
-dontwarn org.greenrobot.greendao.**
-keep class android.databinding.** { *; }
-dontwarn android.databinding.**

### alipay
#-libraryjars libs/alipaySDK-20170309.jar

-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IAlixPay$Stub{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
-keep class com.alipay.sdk.app.PayTask{ public *;}
-keep class com.alipay.sdk.app.AuthTask{ public *;}
-keep class com.alipay.android.phone.** { *; }
-keep class android.net.SSLCertificateSocketFactory{*;}
-keep class com.alipay.android.phone.mrpc.core.AndroidHttpClient$1{*;}
-keep class com.alipay.android.phone.mrpc.core.AndroidHttpClient$2{*;}
-keep class com.alipay.android.phone.mrpc.core.AndroidHttpClient$2$2{*;}
-keep class com.alipay.android.phone.mrpc.core.AndroidHttpClient$2$1{*;}
-dontwarn com.alipay.android.phone.**
-dontwarn android.net.**

### UShare
-dontusemixedcaseclassnames
-dontshrink
-dontoptimize
-dontwarn com.google.android.maps.**
-dontwarn android.webkit.WebView
-dontwarn com.umeng.**
-dontwarn com.tencent.weibo.sdk.**
-dontwarn com.facebook.**
-keep public class javax.**
-keep public class android.webkit.**
-dontwarn android.support.v4.**
-keep enum com.facebook.**
-keepattributes Exceptions,InnerClasses,Signature
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-keep public interface com.facebook.**
-keep public interface com.tencent.**
-keep public interface com.umeng.socialize.**
-keep public interface com.umeng.socialize.sensor.**
-keep public interface com.umeng.scrshot.**
-keep class com.android.dingtalk.share.ddsharemodule.** { *; }
-keep public class com.umeng.socialize.* {*;}


-keep class com.umeng.scrshot.**
-keep public class com.tencent.** {*;}
-keep class com.umeng.socialize.sensor.**
-keep class com.umeng.socialize.handler.**
-keep class com.umeng.socialize.handler.*
-keep class com.umeng.weixin.handler.**
-keep class com.umeng.weixin.handler.*
-keep class com.umeng.qq.handler.**
-keep class com.umeng.qq.handler.*
-keep class UMMoreHandler{*;}
-keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.modelmsg.** implements   com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
-keep class com.tencent.mm.sdk.** {
 *;
}
-keep class com.tencent.mm.opensdk.** {
*;
}

-keep class com.tencent.** {*;}
-dontwarn com.tencent.**
-keep public class com.umeng.com.umeng.soexample.R$*{
public static final int *;
}
-keepclassmembers enum * {
public static **[] values();
public static ** valueOf(java.lang.String);
}

-keep class com.tencent.open.TDialog$*
-keep class com.tencent.open.TDialog$* {*;}
-keep class com.tencent.open.PKDialog
-keep class com.tencent.open.PKDialog {*;}
-keep class com.tencent.open.PKDialog$*
-keep class com.tencent.open.PKDialog$* {*;}

-keep class com.sina.** {*;}
-dontwarn com.sina.**
-keep class  com.alipay.share.sdk.** {
   *;
}
-keepnames class * implements android.os.Parcelable {
public static final ** CREATOR;
}

-keepattributes Signature

### 高德地图 定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}

#amap 2d
-keep class com.amap.api.maps2d.overlay.**{ *; }
-dontwarn com.amap.api.maps2d.overlay.**
-keep class com.amap.api.mapcore2d.**{ *; }
-dontwarn com.amap.api.mapcore2d.**
-keep class com.amap.api.maps.**{ *; }
-dontwarn com.amap.api.maps.**

### JPush
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-keep class * extends cn.jpush.android.helpers.JPushMessageReceiver { *; }

-dontwarn cn.jiguang.**
-keep class cn.jiguang.** { *; }

-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-keep class com.google.protobuf.** {*;}

#---------------------------------3.默认保留区---------------------------------
# 保持以下类不被混淆
-keep class com.google.common.** { *; }
-dontwarn com.google.common.**
-keep class com.google.auto.common.** { *; }
-dontwarn com.google.auto.common.**
-keep class com.google.auto.service.** { *; }
-dontwarn com.google.auto.service.**
-keep class com.squareup.javapoet.** { *; }
-dontwarn com.squareup.javapoet.**
-keep class com.loc.** { *; }
-dontwarn com.loc.**

-keep class javax.annotation.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
#保留support下的所有类及其内部类
-keep class android.support.** {*;}
-keep public class * extends android.os.IInterface

#保留我们自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#保持 Serializable 不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#不混淆资源类
-keep class **.R$* {
 *;
}
#对于带有回调函数的onXXEvent的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
}

# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
 native <methods>;
}

#保留在Activity中的方法参数是view的方法，
#这样以来我们在layout中写的onClick就不会被影响
-keepclassmembers class * extends android.app.Activity {
 public void *(android.view.View);
}

# 保持枚举 enum 类不被混淆
-keepclassmembers enum * {
 public static **[] values();
 public static ** valueOf(java.lang.String);
}

-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}

-keep public class com.anyihao.ayb.R$*{
    public static final int *;
}

# 保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
 public static final android.os.Parcelable$Creator *;
}
#---------------------------------webview------------------------------------
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

#--------------- BEGIN: Gson防混淆 ----------
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.idea.fifaalarmclock.entity.***
-keep class com.google.gson.stream.** { *; }
#--------------- END ----------

#--------------- BEGIN: 返回到页面的自定义Java对象防混淆 ----------
-keepclassmembers class cn.pedant.SafeWebViewBridge.sample.HostJsScope$RetJavaObj{ *; }
#--------------- END ----------

#--------------- BEGIN: 注入到页面的接口类防混淆 ----------
-keepclassmembers class cn.pedant.SafeWebViewBridge.sample.HostJsScope{ *; }
#--------------- END ----------


#---------------------------------4.基本指令区----------------------------------
#不进行代码压缩
-dontoptimize
#不去忽略非公共的库类
-dontskipnonpubliclibraryclassmembers
#混淆前后的映射
-printmapping mapping.txt
#混淆时所采用的算法
-optimizations !code/simplification/cast,!field/*,!class/merging/*
#保护注解
-keepattributes *Annotation*,InnerClasses
#保护反射
-keepattributes EnclosingMethod
-keepattributes InnerClasses
#保护签名
-keepattributes Signature
#抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

#如果有警告也不终止
-dontwarn
#包名不混合大小写
-dontusemixedcaseclassnames
#不做预校验
-dontpreverify
#混淆时是否记录日志
-verbose
#忽略警告
-ignorewarning
#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#----------------------------------------------------------------------------

#----------------------------------------------------------------------------
#umeng 分享
#-----start-----
 -dontusemixedcaseclassnames
 -dontshrink
 -dontoptimize
 -dontwarn com.google.android.maps.**
 -dontwarn android.webkit.WebView
 -dontwarn com.umeng.**
 -dontwarn com.tencent.weibo.sdk.**
 -dontwarn com.facebook.**
 -keep public class javax.**
 -keep public class android.webkit.**
 -dontwarn android.support.v4.**
 -keep enum com.facebook.**
 -keepattributes Exceptions,InnerClasses,Signature
 -keepattributes *Annotation*
 -keepattributes SourceFile,LineNumberTable

 -keep public interface com.facebook.**
 -keep public interface com.tencent.**
 -keep public interface com.umeng.socialize.**
 -keep public interface com.umeng.socialize.sensor.**
 -keep public interface com.umeng.scrshot.**
 -keep class com.android.dingtalk.share.ddsharemodule.** { *; }
 -keep public class com.umeng.socialize.* {*;}


 -keep class com.facebook.**
 -keep class com.facebook.** { *; }
 -keep class com.umeng.scrshot.**
 -keep public class com.tencent.** {*;}
 -keep class com.umeng.socialize.sensor.**
 -keep class com.umeng.socialize.handler.**
 -keep class com.umeng.socialize.handler.*
 -keep class com.umeng.weixin.handler.**
 -keep class com.umeng.weixin.handler.*
 -keep class com.umeng.qq.handler.**
 -keep class com.umeng.qq.handler.*
 -keep class UMMoreHandler{*;}
 -keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
 -keep class com.tencent.mm.sdk.modelmsg.** implements   com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
 -keep class im.yixin.sdk.api.YXMessage {*;}
 -keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
 -keep class com.tencent.mm.sdk.** {
  *;
 }
 -keep class com.tencent.mm.opensdk.** {
*;
 }
 -dontwarn twitter4j.**
 -keep class twitter4j.** { *; }

 -keep class com.tencent.** {*;}
 -dontwarn com.tencent.**
 -keep public class com.umeng.com.umeng.soexample.R$*{
 public static final int *;
 }
 -keep public class com.linkedin.android.mobilesdk.R$*{
 public static final int *;
     }
 -keepclassmembers enum * {
 public static **[] values();
 public static ** valueOf(java.lang.String);
 }

 -keep class com.tencent.open.TDialog$*
 -keep class com.tencent.open.TDialog$* {*;}
 -keep class com.tencent.open.PKDialog
 -keep class com.tencent.open.PKDialog {*;}
 -keep class com.tencent.open.PKDialog$*
 -keep class com.tencent.open.PKDialog$* {*;}

 -keep class com.sina.** {*;}
 -dontwarn com.sina.**
 -keep class  com.alipay.share.sdk.** {
    *;
 }
 -keepnames class * implements android.os.Parcelable {
 public static final ** CREATOR;
 }

 -keep class com.linkedin.** { *; }
 -keepattributes Signature
#-----end-----



#--------------------------proguard语法解释--------------------------------------------------
#-include {filename}    从给定的文件中读取配置参数
#-basedirectory {directoryname}    指定基础目录为以后相对的档案名称
#-injars {class_path}    指定要处理的应用程序jar,war,ear和目录
#-outjars {class_path}    指定处理完后要输出的jar,war,ear和目录的名称
#-libraryjars {classpath}    指定要处理的应用程序jar,war,ear和目录所需要的程序库文件
#-dontskipnonpubliclibraryclasses    指定不去忽略非公共的库类。
#-dontskipnonpubliclibraryclassmembers    指定不去忽略包可见的库类的成员。
#
#保留选项
#-keep {Modifier} {class_specification}    保护指定的类文件和类的成员
#-keepclassmembers {modifier} {class_specification}    保护指定类的成员，如果此类受到保护他们会保护的更好
#-keepclasseswithmembers {class_specification}    保护指定的类和类的成员，但条件是所有指定的类和类成员是要存在。
#-keepnames {class_specification}    保护指定的类和类的成员的名称（如果他们不会压缩步骤中删除）
#-keepclassmembernames {class_specification}    保护指定的类的成员的名称（如果他们不会压缩步骤中删除）
#-keepclasseswithmembernames {class_specification}    保护指定的类和类的成员的名称，如果所有指定的类成员出席（在压缩步骤之后）
#-printseeds {filename}    列出类和类的成员-keep选项的清单，标准输出到给定的文件
#
#压缩
#-dontshrink    不压缩输入的类文件
#-printusage {filename}
#-dontwarn   如果有警告也不终止
#-whyareyoukeeping {class_specification}
#
#优化
#-dontoptimize    不优化输入的类文件
#-assumenosideeffects {class_specification}    优化时假设指定的方法，没有任何副作用
#-allowaccessmodification    优化时允许访问并修改有修饰符的类和类的成员
#
#混淆
#-dontobfuscate    不混淆输入的类文件
#-printmapping {filename}
#-applymapping {filename}    重用映射增加混淆
#-obfuscationdictionary {filename}    使用给定文件中的关键字作为要混淆方法的名称
#-overloadaggressively    混淆时应用侵入式重载
#-useuniqueclassmembernames    确定统一的混淆类的成员名称来增加混淆
#-flattenpackagehierarchy {package_name}    重新包装所有重命名的包并放在给定的单一包中
#-repackageclass {package_name}    重新包装所有重命名的类文件中放在给定的单一包中
#-dontusemixedcaseclassnames    混淆时不会产生形形色色的类名
#-keepattributes {attribute_name,...}    保护给定的可选属性，例如LineNumberTable, LocalVariableTable, SourceFile, Deprecated, Synthetic, Signature, and
#
#InnerClasses.
#-renamesourcefileattribute {string}    设置源文件中给定的字符串常量