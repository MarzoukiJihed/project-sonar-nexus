pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    
    options {
        timeout(time: 30, unit: 'MINUTES')  // Timeout global
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
                timeout(time: 15, unit: 'MINUTES') {
                    sh 'mvn clean package'
                }
            }
            post {
                success {
                    echo '✅ Build et tests réussis'
                }
                failure {
                    echo '❌ Build ou tests échoués'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse qualité...'
                timeout(time: 10, unit: 'MINUTES') {
                    withSonarQubeEnv('SonarQube') {
                        sh '''
                            mvn sonar:sonar \
                            -Dsonar.projectKey=factorial-back-2026 \
                            -Dsonar.projectName=factorial-back \
                            -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                        '''
                    }
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                echo 'Vérification Quality Gate...'
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        stage('Deploy to Nexus') {
            steps {
                echo 'Publication sur Nexus...'
                timeout(time: 10, unit: 'MINUTES') {
                    sh 'mvn deploy -DskipTests'
                }
            }
        }
    }
    
    post {
        success {
            echo '🎉 Pipeline réussi - artifact publié sur Nexus !'
        }
        failure {
            echo '💥 Pipeline échoué !'
            // Option: ajouter une notification
        }
    }
}
