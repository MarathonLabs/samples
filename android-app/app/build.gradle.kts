plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    buildToolsVersion = "33.0.0"
    compileSdk = 33

    namespace = "com.example"
    testNamespace = "com.example.test"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources.excludes.add("META-INF/INDEX.LIST")
        resources.excludes.add("META-INF/io.netty.versions.properties")
    }

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        applicationId = "com.example"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isMinifyEnabled = false
            enableAndroidTestCoverage = true
        }
    }
}

configurations {
    forEach { configuration ->
        //Because Google is using a library from 2016 for proto and can't update it
        //https://github.com/google/Accessibility-Test-Framework-for-Android/issues/38
        configuration.exclude(group = "com.google.protobuf", module = "protobuf-lite")
    }
}

dependencies {
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.kotlinStdLib)

    androidTestImplementation(TestLibraries.testOutputEnhancer)
    androidTestImplementation(TestLibraries.adamJunit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.testRules)
    androidTestImplementation(TestLibraries.extJunit)
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.kakao)
    androidTestImplementation(TestLibraries.allureKotlinCommon)
    androidTestImplementation(TestLibraries.allureKotlinModel)
    androidTestImplementation(TestLibraries.allureKotlinJunit4)
    androidTestImplementation(TestLibraries.allureKotlinAndroid)
    androidTestImplementation(TestLibraries.adamScreencapture)
}
