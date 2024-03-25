plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // This is the plugin for adding ksp
    // ksp version should be matched with the Kotlin version we are using
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

android {
    namespace = "io.januda.buyer"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.januda.buyer"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        // We need to update the Java Version to 17 inorder to ksp to work.
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        // We need to update the Java Version to 17 inorder to ksp to work.
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Google Maps Integration
    implementation ("com.google.maps.android:maps-compose:4.3.3")


    // Added glide library into the project as a 3rd party library
    // Glide -> An image loading and caching library for Android focused on smooth scrolling
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

    // Added Retrofit as a 3rd party library inorder to add HTTP functionality to the project
    // This returns data in JSON ( Java Script Object Notation)
    // Retrofit -> A type-safe HTTP client for Android and the JVM
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // We need to convert the JSON data into Kotlin data objects
    // We can use Gson convertor here.
    implementation("com.squareup.retrofit2:converter-gson:2.0.0")

    // These are the dependencies for implementing ROOM - ORM
    // In OOP we have classes, object, fields
    // In Databases we have tables, rows, columns
    // We need to make the connection between these too
    // For bridging this and to make it easy ( We mostly don't need SQL knowledge to communicate with the DB) we use ORM tools.
    // The most popular ORM tool for android in ROOM ( For Java and Spring-boot -> Hibernate )
    implementation("androidx.room:room-runtime:2.6.1")
    // Kotlin symbol processing
    // This is gonna help us in annotation processing
    // Inorder to work with ksp we need to add that as a plugin in the plugins section
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    // This dependency is needed inorder to run viewModel injection
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}