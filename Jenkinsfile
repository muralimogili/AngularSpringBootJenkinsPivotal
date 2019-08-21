pipeline {
    agent any
    tools {
        maven 'Maven3.6' 
    }

    stages {
        stage ('Compile Stage') {
            steps {
                bat "mvn clean install" 
            }
        }

        stage ('Testing Stage') {
            steps {
                bat "mvn test" 
            }
        }

        stage ('Deployment Stage') {
            steps {
		            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'PCF_LOGIN',
                            usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {

                    bat "C:/Users/VeeraswamyGatta/.jenkins/workspace/pivotal/cf login -a http://api.run.pivotal.io -u $USERNAME -p $PASSWORD"
					bat "C:/Users/VeeraswamyGatta/.jenkins/workspace/pivotal/cf target -s development"
			        bat "C:/Users/VeeraswamyGatta/.jenkins/workspace/pivotal/cf push"
                }
            }
        }
    }
}