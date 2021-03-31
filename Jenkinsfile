pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool(name: 'MAVEN', type: 'maven')
        bat 'mvn test'
      }
    }

  }
}