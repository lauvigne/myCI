My Docker Continuous Integration :

## Expose used port
VBoxManage controlvm boot2docker-vm natpf1 "portTcp9000Exposed,tcp,127.0.0.1,9000,,9000"
VBoxManage controlvm boot2docker-vm natpf1 "portTcp3306Exposed,tcp,127.0.0.1,3306,,3306"
VBoxManage controlvm boot2docker-vm natpf1 "portTcp8000Exposed,tcp,127.0.0.1,8000,,8000"
VBoxManage controlvm boot2docker-vm natpf1 "portTcp8080Exposed,tcp,127.0.0.1,8080,,8080"

## Run without specified volume (To test)
docker run -td -p 9000:9000 -p 3306:3306 -h sonar --name sonar batmat/sonarqube-mysql
docker run -td -p 8000:8080 -h jenkins --name jenkins --link sonar:sonar -d lauvigne/jenkins-mvn311-java8

#To test :
https://github.com/tqvarnst/docker-images/tree/master/demo-cd

