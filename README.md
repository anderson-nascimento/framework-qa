# framework-qa

# Acessos

O código fonte está disponível em um monorepo no github https://github.com/anderson-nascimento/framework-qa
O Front utilizado para testes pode ser acessado na url https://srbarriga.herokuapp.com/login
A API utilizada para testes pode acessada na uri http://barrigarest.wcaquino.me

# Requisitos para executar os testes

Baixar o codigo disponibilizado no repositorio do github
Via maven o teste pode ser executado passando o comando mvn test, dentro da pasta framework-qa.

# Detalhes da implementação

O projeto faz parte de uma iniciativa de estudo com o intuito de montar um framework basico para testes automatizados.
Este framework busca atender os testes WEB, API e Mobile.
Foi utilizado a lingaguem java para sua construção, utilizando bibliotecas do Selenium, Restassured entre outros.
Permite a geração de um report no formato Html, utilizando a biblioteca do Extent Reports.

# Ações Futuras
Complementar o framework com testes mobiles.
Melhorar o encapsulamentos dos metodos.
Buscar formas de executar o teste mais rapido
Virtualizar um ambiente de teste usando docker, onde contenha o framework pronto para uso.
Implementar no docker a esteira de execução usando o jenkins.
