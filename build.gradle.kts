

// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false

    id("com.google.devtools.ksp") version "1.8.0-1.0.8" apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {

        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.8.10-1.0.9") // KSP plugin version
    }
}