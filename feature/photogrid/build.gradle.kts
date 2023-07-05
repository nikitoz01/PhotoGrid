plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "kg.npml.feature.photogrid"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.foundation.get()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":core:domain"))
    implementation(project(":core:common"))

    implementation(libs.androidx.ktx)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)


    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.coil.kt.compose)

    implementation(libs.accompanist.swiperefresh)


    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp)

    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
}