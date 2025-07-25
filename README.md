# Gestão de Benefícios

### Informações gerais
Esta aplicação visa gerir benefícios com endpoints usando arquitetura Rest.
* Versão do jdk: 24
* Spring boot: 3.5.4
* Banco de dados: H2

### Pontos de melhoria: 

* Criar controle e autenticação caso os endpoints sejam chamados fora do cluster.
* Leantar com time de negócios quais atributos fazem sentido na entidade Benefício.
* Não foi mapeado regras de negócio na especificação, poderia ser mapeado alguns detalhes de negócio.
* Não utilizar a entidade de domínio no body dos endpoints.
* Criar testes unitários.

