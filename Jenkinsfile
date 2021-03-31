pipeline {
  agent any
   tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN"
    }
  stages {
    stage('Build') {
      steps {
        bat 'mvn test'
      }
    }

  }
}
