import com.android.build.api.variant.BuildConfigField

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

androidComponents {
    onVariants {
        it.buildConfigFields.put(
            "API_KEY", BuildConfigField(
                "String", "\"XiIznkJSVu73Vhvcav6i3g4yJZNrmvQmvd1I3TRiJwuOG2bd67JAfYsa\"", ""
            )
        )
    }
}


android {
    namespace = "kg.npml.core.photonetwork"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":core:common"))

    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)


    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.koin.core)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp)
}