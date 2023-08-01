pipeline {
    agent any

    environment {
      ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
      LOCATION_PROJECT = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\test'
    }
    stages {
        stage('Delete Workspace Dir') {
            steps {
               script {
                   try {
                       deleteDir()
                   } catch (Exception e) {
                       echo "Error deleting workspace: ${e.message}"
                   }
               }
            }
        }

        stage('Clean Gradle Cache') {
            steps {
                script {
                  dir(env.LOCATION_PROJECT) {
                    bat "gradlew.bat clean"
                  }
                }
            }
        }

        stage('Compile & Build APK') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'java -version'
                    bat 'gradlew.bat clean assembleDebug'
                }
            }
        }

        stage('Unit Tests') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "gradlew.bat test"
                }
            }
        }
    }
}