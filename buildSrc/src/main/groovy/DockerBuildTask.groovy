import org.gradle.api.tasks.Exec

class DockerBuildTask extends Exec {

  String imageName
  String imageDir
  String executable = "docker"
  List<String> args = ["build", "-t", imageName, imageDir]
}
