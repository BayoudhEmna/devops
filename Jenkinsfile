pipeline {
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
    }
}
