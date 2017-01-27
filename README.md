# 06Build It Bigger - Udacity Android Nanodegree Project 4
A simple joke retriever app that consist of 4 modules: A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Features
* Free/Paid product flavors
* Custom Java library that provides jokes to Android library via GCE
* Functional test for async task
* UI test using Espresso library

## Getting Started
This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio. Or clone this repository and import into **Android Studio**
```
git clone git@github.com:jinyoon0124/06BuildItBigger.git
```

## Generating signed APK
From Android Studio: 1. **_Build_** menu 2. **_Generate Signed APK_**... 3. Fill in the keystore information _(you only need to do this once manually and then let Android Studio remember it)_

## Libraries
* Google Play Service - AdMob
* [Testing Support Library](https://developer.android.com/topic/libraries/testing-support-library/index.html#AndroidJUnitRunner) including [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/)

## License
```
Copyright 2017 Jin Yoon

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
