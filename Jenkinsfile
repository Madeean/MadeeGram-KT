pipeline {
    agent any

    environment {
      ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
      LOCATION_PROJECT = 'E:\\Jenkins_home\\workspace\\abc'
    }
    parameters {
        string(defaultValue: '1', description: 'Version Code', name: 'Version_Code')
        string(defaultValue: '1', description: 'Version Name', name: 'Version_Name')
//         text(defaultValue: '', description: 'Release Notes', name: 'Release_Notes')
//         stashedFile(name: "local.properties", description: "local.properties")
//         stashedFile(name: "google-services.json", description: "google-services.json")
    }
    stages {
//       stage('Example') {
//         steps {
//           unstash 'local.properties'
//           bat 'type local.properties'
//
//           unstash 'google-services.json'
//           bat 'type google-services.json'
//
//           bat 'move google-services.json app'
//         }
//       }

//       stage('Multiple Job'){
//         parallel{
//           stage('first job'){
//             steps{
//               build([
//                   job       : 'def',
//                   wait      : false,
// //                   parameters: [
// //                       string(name: 'PARAM_1', value: "${PARAM_1}")
// //                   ]
//               ])
//             }
//           }
//           stage('second job'){
//             steps{
//               build([
//                 job: "master_vis",
//                 wait:false
//               ])
//             }
//           }
//         }
//       }

        stage('Clean Gradle Cache') {
            steps {
                script {
                  dir(env.LOCATION_PROJECT) {
                    bat "fastlane runClean"
                  }
                }
            }
        }
//
//         stage('ui Tests') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat 'gem -v'
//                     echo "fastlane build_and_screengrab"
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
                  echo "fastlane build_and_screengrab"
                }
              }
            }
          }
        }



//
//         stage('Compile & Build APK') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat 'java -version'
//                     bat 'fastlane runBuildApk'
//                 }
//             }
//         }
//

//         stage('Unit Test') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat 'fastlane runUnitTest'
//                 }
//             }
//         }
//
//         stage('Ui Test') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat 'fastlane build_and_screengrab'
//                 }
//             }
//         }

        stage('deploy ke firebase') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'fastlane distribute  Version_Code:${Version_Code} Version_Name:${params.Version_Name}'
                }
            }
        }


    }
}


// BAZEL
// pipeline {
//     agent any
//
//     environment {
//       ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
//       LOCATION_PROJECT = 'E:\\Jenkins_home\\workspace\\abc'
//     }
//     stages{
//       stage('verify bazel is installed') {
//             steps {
//               bat 'bazel version'
//             }
//           }
//       stage('Build the project') {
//         steps {
//           bat 'bazel build //:ProjectRunner'
//         }
//       }
//
//     }
// }