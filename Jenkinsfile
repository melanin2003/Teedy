.pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                bat 'mvn -B -DskipTests clean package' 
	bat 'mvn clean -DskipTests install'

            }
        }
        stage('PMD') {
            steps {
                bat 'mvn pmd:pmd -Dformat=html'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test --fail-never'
            }
        }
        stage('Generate report'){
           steps{
	bat 'mvn surefire-report:report'
	}
        }
        stage('Generate Javadoc') {
            steps {
                bat 'mvn javadoc:jar -Dmaven.javadoc.failOnError=false'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
            archiveArtifacts artifacts: '**/target/site/apidocs/**', fingerprint: true
            archiveArtifacts artifacts: '**/target/pmd.html', fingerprint: true
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        }
    }
}