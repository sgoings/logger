task glideInstall(type: Exec) {
  executable "glide"
  args "install", "--cache"
}

task resolve {
  dependsOn glideInstall
}

task goBuild(type: Exec) {
  executable "go"
  args "build", "./..."

  dependsOn resolve
}

task goTest(type: Exec) {
  executable "go"
  args "test", "./..."

  dependsOn resolve
}

task goLint(type: Exec) {
  executable "golint"
  args "./..."
}

task dockerBuild(type: Exec) {
  executable "docker"
  args "build", "-t", imageName, imageDir

  dependsOn resolve
}

task test {
  dependsOn goLint, goTest
}

task build {
  dependsOn dockerBuild, goBuild
}

task ci {
  dependsOn build, test
}
