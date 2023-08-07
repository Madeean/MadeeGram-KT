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
                    bat "fastlane runClean"
                  }
                }
            }
        }

//         stage('Unit Tests') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat 'gem -v'
//                     bat "fastlane runUnitTest"
//                 }
//             }
//         }

//         stage('Tests') {
//           steps {
//             parallel(
//               stage('Unit Test') {
//                 steps {
//                     dir(env.LOCATION_PROJECT) {
//                         bat 'gem -v'
//                         bat "fastlane runUnitTest"
//                     }
//                 }
//               }
//               stage('Ui Test') {
//                 steps {
//                     dir(env.LOCATION_PROJECT) {
//                         echo "ui test"
//                     }
//                 }
//               }
//             )
//           }
//         }

        stage('run-parallel-branches') {
          parallel{
            stage('Unit Test'){
              steps{
                dir(env.LOCATION_PROJECT) {
                    bat 'fastlane runUnitTest'
                }
              }
            }
            stage('Ui Test'){
              steps{
                dir(env.LOCATION_PROJECT){
                  echo "ui test"
                }
              }
            }
          }
        }

        stage('Compile & Build APK') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'java -version'
                    bat 'fastlane runBuildApk'
                }
            }
        }

        stage('deploy ke firebase') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'fastlane distribute'
                }
            }
        }


    }
}