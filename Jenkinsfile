pipeline {
    agent any

    environment {
      ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
      LOCATION_PROJECT = 'E:\\Jenkins_home\\workspace\\abc'
    }
    stages {
        stage('Clean Gradle Cache') {
            steps {
                script {
                  dir(env.LOCATION_PROJECT) {
                    bat "./gradlew clean"
                  }
                }
            }
        }

        stage('Compile & Build APK') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'java -version'
                    bat './gradlew clean assembleDebug'
                }
            }
        }

        stage('Unit Tests') {
            bat 'fastlane runUnitTest'
        }
    }
}