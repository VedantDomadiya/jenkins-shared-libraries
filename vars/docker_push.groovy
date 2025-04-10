def call(String ImageName, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'DockerHubPass', usernameVariable: 'DockerHubUser')]) 
                  {
                        echo "Logging into Docker Hub"
                        sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"

                        echo "Tagging the Docker image"
                        sh "docker tag krishnaaicicd_krishna-ai:latest ${DockerHubUser}/krishna-ai:latest"

                        echo "Pushing the Docker image to Docker Hub"
                        sh "docker push ${DockerHubUser}/${ImageName}:$(ImageTag)"
                    }
}
