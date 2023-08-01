pipeline {
    agent any

    environment {
      ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
//       GRADLE_HOME = "C:\\Users\\ASUS\\.gradle"
      LOCATION_PROJECT = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\abc'
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

//         stage('Clean Gradle Cache') {
//             steps {
//                 script {
//                   dir(env.LOCATION_PROJECT) {
//                     bat "gradlew.bat clean"
//                   }
//                 }
//             }
//         }

//         stage('Compile & Build APK') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat 'java -version'
//                     bat 'gradlew.bat clean assembleDebug'
//                 }
//             }
//         }

        stage('Unit Tests') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'java -version'
                    bat "./gradlew clean"
                    bat "./gradlew test"

                }

//                    sh './gradlew test'

            }
        }
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