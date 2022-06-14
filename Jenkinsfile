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
            stage ('MVN Nexus') {
            steps {
                echo "Maven Nexus"; 
                bat 'mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=io.order.manager -DartifactId=food-order-manager -Dversion=0.0.1-SNAPSHOT -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-snapshots/ -Dfile=target/food-order-manager-0.0.1-SNAPSHOT.jar'; 
            }
        }
    }
}
