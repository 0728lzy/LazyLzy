plugins {
    //alias(libs.plugins.androidApplication)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.mavenPublish)
}

group = "com.github.0728lzy"
version = "1.0.0"


afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.\
                // from(components["release"])
                // You can then customize attributes of the publication as shown below.
                groupId = (group.toString())
                artifactId = "LazyLzy"
                version = version
            }
        }
    }
}

android {
    namespace  = "com.example.wanandroidsdk"
    compileSdk =  34

    defaultConfig {
        //applicationId = "com.example.wanandroidsdk"
        minSdk = 24
        targetSdk = 34
        /*        versionCode = 1
                versionName = "1.0"*/

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            //isDebuggable = false
//            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
//dependencies {
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    implementation(libs.okhttp)
//    implementation(libs.logging.interceptor)
//    implementation(libs.utilcodex)
//    implementation(libs.rxjava)
//    implementation(libs.retrofit)
//    implementation(libs.adapter.rxjava2)
//    implementation(libs.converter.scalars)
//    implementation(libs.converter.gson)
//    implementation(libs.androidx.core.ktx)
//}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}