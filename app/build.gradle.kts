plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.soar.cloud"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.soar.cloud"
        minSdk = 24
        targetSdk = 33
        versionCode = 100
        versionName  ="1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    kapt {
        arguments {
            arg("AROUTER_MODULE_NAME", project.getName())
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

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    //retrofit2
    implementation(libs.retrofit2)
    implementation(libs.conconverterGson)
    implementation(libs.adapterRxjava2)

    //rxjava2
    implementation(libs.rxjava2)
    implementation(libs.rxandroid)
    //Rxlifecycle2
    implementation(libs.rxlifecycle2)
    //ARouter
    implementation(libs.arouterApi)
    kapt(libs.arouterCompiler)
    //banner轮播
    implementation(libs.banner)
    //Glide
    implementation(libs.glide)
    //SmartRefreshLayout
    implementation(libs.smartRefreshLayout)
    implementation(libs.smartRefreshHeader)
    //BottomNavigationViewEx
    implementation(libs.bottomNavigationViewEx)
    //flowlayout
    implementation(libs.flowlayout)
    //PhotoView
    implementation(libs.photoView)
    //AndPermission
    implementation(libs.andPermission)
}