pipeline {
    agent any 
    stages{
        stage('Package') { 
            steps {
              checkout scmGit(branches: [[name: '*/master']], extensions: [], 
userRemoteConfigs: [[url: 'https://github.com/melanin2003/Teedy.git']])
              sh 'mvn -B -DskipTests clean package' 
            }
        }
        // Building Docker images
        stage('Building image') {
          steps{
             sh 'docker build -t teedy:new .'
            }  
          }
    
        // Uploading Docker images into Docker Hub
        stage('Upload image') {
          steps{ 
               //your command
               sh 'docker tag teedy:new melanin2003/nodes:v2'
               sh 'docker login -u melanin2003 -p 9621135238690sty'
               sh 'docker push melanin2003/nodes:v2'
            }
          }
          
          //Running Docker container
         stage('Run containers'){
            steps{
                
                sh 'docker run -d -p 8084:8080 --name teedy01 teedy:new'
                sh 'docker run -d -p 8082:8080 --name teedy02 teedy:new'
                sh 'docker run -d -p 8083:8080 --name teedy03 teedy:new'
                    //your command
         
            }
        }
    }
 }
