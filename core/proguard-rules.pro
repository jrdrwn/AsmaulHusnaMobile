# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn java.lang.invoke.StringConcatFactory

-keep class com.asmaulhusna.core.di.** { *; }
-keepclassmembers class com.asmaulhusna.core.di.** { *; }

-keep class com.asmaulhusna.core.domain.repository.** { *; }
-keepclassmembers class com.asmaulhusna.core.domain.repository.** { *; }

-keep class com.asmaulhusna.core.domain.model.** { *; }
-keepclassmembers class com.asmaulhusna.core.domain.model.** { *; }

-keep class com.asmaulhusna.core.domain.usecase.** { *; }
-keepclassmembers class com.asmaulhusna.core.domain.usecase.** { *; }

-keep class com.asmaulhusna.core.databinding.** { *; }
-keepclassmembers class com.asmaulhusna.core.databinding.** { *; }

-keep class com.asmaulhusna.core.ui.** { *; }
-keepclassmembers class com.asmaulhusna.core.ui.** { *; }

-keep class com.asmaulhusna.core.data.** { *; }
-keepclassmembers class com.asmaulhusna.core.data.** { *; }

-keep class com.asmaulhusna.core.utils.** { *; }
-keepclassmembers class com.asmaulhusna.core.utils.** { *; }


-keep class androidx.viewbinding.ViewBinding { *; }