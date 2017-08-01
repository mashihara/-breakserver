./mvnw package
docker-compose build
docker tag brester:0.0.1 247691179398.dkr.ecr.ap-northeast-1.amazonaws.com/brester:0.0.1
$(aws ecr get-login --no-include-email --region ap-northeast-1)
docker push 247691179398.dkr.ecr.ap-northeast-1.amazonaws.com/brester:0.0.1
