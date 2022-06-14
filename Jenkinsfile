pipeline {
     environment { 

        registry = "emna22/firstrep1" 

        registryCredential = 'dockerhub_id' 

       dockerImage = '' 

    }
    agent any 
    stages {
        stage ('GIT') {
            steps {
                echo "Getting Project from Git"; 
                git "https://github.com/BayoudhEmna/devops.git"; 
            }
        }
        stage ('MVN CLEAN') {
            steps {
                echo "Maven Clean"; 
                bat 'mvn clean'; 
            }
        }
        stage ('MVN TEST') {
            steps {
                echo "Maven Test JUnit"; 
                bat 'mvn test'; 
            }
        }  
        stage ('MVN SONAR') {
            steps {
                echo "Maven SONAR"; 
                bat 'mvn sonar:sonar'; 
            }
        }      
        stage ('MVN Nexus') {
            steps {
                echo "Maven Nexus"; 
                bat 'mvn deploy'; 
            }
           
        }
        
        stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 

                }

            } 

        }

        stage('Deploy our image') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 

                        dockerImage.push() 

                    }

                } 

            }

        } 

        stage('Cleaning up') { 

            steps { 

                sh "docker rmi $registry:$BUILD_NUMBER" 

            }

        } 

    }
}
