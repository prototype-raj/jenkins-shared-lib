def call(String projectName, String tagName) {
  echo "Pushing to Docker Hub!"
  withCredentials([usernamePassword(
      credentialsId:"dockerHubCred", 
      passwordVariable:"dockerHubPass", 
      usernameVariable:"dockerHubUser")]) {
           sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
           sh "docker image tag ${projectName}:latest ${env.dockerHubUser}/${projectName}:${tagName}"
           sh "docker push ${env.dockerHubUser}/${projectName}:${tagName}"
      }
  echo "Pushed to docker hub!"
}
