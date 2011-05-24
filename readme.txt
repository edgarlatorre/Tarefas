Como configiurar a aplicação:

Banco de dados:
Existem duas formas para gerar as   tabelas:
O primeiro passo é criar o banco de dados, depois seguir os seguintes passos:
  1. executar a classe br.com.edgarlatorre.tarefas.util.GeraBanco
  2. aplicar o dump tarefas_dump.sql 
    ex: mysql -u usuario tarefas < tarefas_dumpump.sql
  3. Configurar o arquivo WEB-INF/classes/hibernate.properties
    Por padrão o endereço está como localhost, usuário root e sem senha

Usando a aplicação:
    Primeiro é necessário cadastrar um usuário, onde o email será seu login
    Depois o usuario deve logar na aplicaçãoão com os dados que acabou de registrar
    A partir disso, é possível  criar tarefas, remover e editar.


Ant:
Configurar os diretórios no build.xml
ant deployWebApplication - compila e copia para o diretorio webapps do tomcat
