Requisitos:
Um servidor postgres rodando no fundo na porta 5432.
username:postgres
senha:postgres


Database chamado "agenda" 

Openjdk8 

Como executar.
Você pode preparar o ambiente pelo STS.

ou

Abra um terminal nesta pasta (caso Powershell ou bash).

./mvnw package

Caso cmd

mvnw package

vá até a pasta target e execute

cd target
Java -jar turingtest-1.0.0-Release.jar

E estará rodando normalmente (caso o banco esteja rodando).