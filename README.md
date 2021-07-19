# curso-junit


docker pull postgres

docker run -d -p 5432:5432 <nome-qualquer> postgres
  
docker exec -it <id-conteiner> bash



dentro do docker:

psql -U postgres

CREATE DATABASE <nome-base>;
  
\q

Usuário e senha estão no arquivo application.properties
