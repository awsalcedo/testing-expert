@file:Suppress("UnstableApiUsage")

val composeUiVersion = "1.4.3"

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.devexperto.testingexpert"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.devexperto.testingexpert"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.devexperto.testingexpert.di.HiltTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(11)
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.fragment:fragment-ktx:1.6.0")
    implementation("androidx.room:room-ktx:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")
    implementation("com.google.dagger:hilt-android:2.46.1")
    kapt("com.google.dagger:hilt-android-compiler:2.46.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    ksp("com.github.bumptech.glide:compiler:4.15.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:$composeUiVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
    implementation("androidx.compose.material:material:$composeUiVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeUiVersion")
    implementation("androidx.navigation:navigation-compose:2.6.0")

    testImplementation(project(":appTestShared"))
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.0")
    testImplementation("app.cash.turbine:turbine:1.0.0")

    androidTestImplementation(project(":appTestShared"))
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-idling-resource:3.5.1")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.46.1")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.46.1")
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    androidTestImplementation("app.cash.turbine:turbine:1.0.0")

    debugImplementation("androidx.fragment:fragment-testing-manifest:1.6.0")
    androidTestImplementation("androidx.fragment:fragment-testing:1.6.0")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeUiVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeUiVersion")
}

kapt {
    correctErrorTypes = true
}