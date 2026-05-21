pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    
    options {
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code...'
                checkout scm
            }
        }
        
        stage('Build & Tests') {
            steps {
                echo 'Compilation et tests...'
                sh 'mvn clean package'
            }
            post {
                success {
                    echo ' Build et tests réussis'
                }
                failure {
                    echo ' Build ou tests échoués'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse qualité...'
                withSonarQubeEnv('SonarQube') {
                    sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=factorial-back-2026 \
                        -Dsonar.projectName=factorial-back \
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml \
                        -Dsonar.qualitygate.wait=false
                    '''
                }
            }
        }
        
        stage('Deploy to Nexus') {
            steps {
                echo 'Publication sur Nexus...'
                sh 'mvn deploy -DskipTests -s settings.xml'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline réussi - artifact publié sur Nexus !'
            echo 'SonarQube: http://localhost:9000/dashboard?id=factorial-back-2026'
            echo 'Nexus: http://localhost:8081/repository/maven-snapshots/'
        }
        failure {
            echo ' Pipeline échoué !'
        }
    }
}
