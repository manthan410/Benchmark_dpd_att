# Verbose output for easier debugging
-verbose

# Input and Output JAR files
-injars app.jar
-outjars obfuscated_project.jar

# Standard library for Java classes (adjust path as needed)
-libraryjars "<java.home>/jmods/java.base.jmod"


-printmapping out.map


# Obfuscation settings
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers

# Suppress warnings for known unresolved classes (optional)
#-dontwarn org.eclipse.emf.**
#-dontwarn java.lang.Object



# Keep attributes used for reflection
#-keepattributes *Annotation*
#-keep,allowobfuscation class org.jabylon.users.** { *; }


# Enable aggressive name obfuscation for comprehensive renaming
-overloadaggressively

# Disable shrinking and optimization, focusing only on name obfuscation
-dontoptimize
-dontshrink
-dontwarn
