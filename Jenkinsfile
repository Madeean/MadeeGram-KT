pipeline {
    agent any

    environment {
      ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
//       GRADLE_HOME = "C:\\Users\\ASUS\\.gradle"
      LOCATION_PROJECT = 'E:\\Jenkins_home\\workspace\\abc'
    }
    stages {
//         stage('Delete Workspace Dir') {
//             steps {
//                script {
//                    try {
//                        deleteDir()
//                    } catch (Exception e) {
//                        echo "Error deleting workspace: ${e.message}"
//                    }
//                }
//             }
//         }

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
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "./gradlew test"

                }
            }
        }

        stage('Build & Install') {
          steps{
            dir(env.LOCATION_PROJECT) {
              bat 'chmod +x gradlew && ./gradlew --no-daemon --stacktrace clean :app:assembleDevDebug :app:assembleDevDebugAndroidTest'
            }
          }
        //Build the apk and the test apk which will run the tests on the apk
//           bat 'chmod +x gradlew && ./gradlew --no-daemon --stacktrace clean :app:assembleDevDebug :app:assembleDevDebugAndroidTest'
        }

        stage('ui test') {
          steps{
            dir(env.LOCATION_PROJECT) {
              bat './gradlew --no-daemon --debug :app:connectedDevDebugAndroidTest'
            }
          }
        //Build the apk and the test apk which will run the tests on the apk
//           bat 'chmod +x gradlew && ./gradlew --no-daemon --stacktrace clean :app:assembleDevDebug :app:assembleDevDebugAndroidTest'
        }

//         stage('ui Tests') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat "./gradlew connectedDebugAndroidTest"
//
//                 }
//             }
//         }
    }
}



// pipeline {
//   agent any
//   environment {
//     APP_NAME = 'test'
//   }
//   options {
//     // Stop the build early in case of compile or test failures
//     skipStagesAfterUnstable()
//   }
//   stages {
//
//     stage('Compile') {
//       steps {
//         // Compile the app and its dependencies
//         bat './gradlew clean'
//       }
//     }
//     stage('test') {
//       steps {
//         // Compile the app and its dependencies
//         bat './gradlew test'
//       }
//     }
//   }
// }