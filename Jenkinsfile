pipeline {
    agent any

    environment {
      ANDROID_HOME = 'D:\\AndroidSdk\\Android\\Sdk'
      LOCATION_PROJECT = 'E:\\Jenkins_home\\workspace\\abc'
    }
    parameters {
      string(name: "VERSION_NAME", defaultValue: "4.21.12", trim: true, description: "ini version name")
      string(name: "VERSION_CODE", defaultValue: "4211200", trim: true, description: "ini version code")
      text(defaultValue: "NIT-209 - Penambahan Android ID di collection alfagift_member\nTASK-395 - Tampilan Alfastamp\nTASK-401 - Berikan informasi berapa msg blm terbaca di setiap tab.\nTASK-417 - Update Wording Email Alfacart -> Alfacare", description: 'ini release notes', name: 'RELEASE_NOTES')
      choice(name: "BUILD_VARIANT", choices: ["release", "beta", "debug"], description: "ini build variant")
      stashedFile 'local.properties'
      stashedFile 'google-services.json'
      string(defaultValue:'main', name:'GIT_BRANCH', description:'Branch Path', trim:true)
    }

    options{
        timestamps()
        skipDefaultCheckout()
        disableRestartFromStage()
    }


    stages {


      stage('Clone Repo'){
        steps{
           checkout scmGit(
              branches: [[name: "${params.GIT_BRANCH}"]],
              extensions: [],
              userRemoteConfigs:
              [[credentialsId: '9adccf1e-c175-4138-9608-b10f1ef7db09',
              url: 'https://github.com/Madeean/MadeeGram-KT.git']]
          )
        }
      }

       stage('Setup File'){
         steps{
             unstash 'local.properties'

             unstash 'google-services.json'

             dir(env.WORKSPACE){
               bat "move google-services.json app"
             }
         }
       }

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
                    echo 'fastlane runUnitTest'
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
//                     bat 'fastlane distribute  Version_Code:${Version_Code} Version_Name:${params.Version_Name}'
                    bat "fastlane deploy_to_firebase VERSION_NAME:${VERSION_NAME} VERSION_CODE:${VERSION_CODE} RELEASE_NOTES:\"${RELEASE_NOTES}\" BUILD_VARIANT:'${BUILD_VARIANT}'"
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