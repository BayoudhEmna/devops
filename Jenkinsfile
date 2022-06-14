pipeline {
     environment { 
3
        registry = "emna22/firstrep1" 
4
        registryCredential = 'dockerhub_id' 
5
        dockerImage = '' 
6
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
15
            steps { 
16
                script { 
17
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
18
                }
19
            } 
20
        }
21
        stage('Deploy our image') { 
22
            steps { 
23
                script { 
24
                    docker.withRegistry( '', registryCredential ) { 
25
                        dockerImage.push() 
26
                    }
27
                } 
28
            }
29
        } 
30
        stage('Cleaning up') { 
31
            steps { 
32
                sh "docker rmi $registry:$BUILD_NUMBER" 
33
            }
34
        } 
35
    }
}
