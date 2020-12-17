# **sincronizacao-receita**

**Descrição:** Projeto criado para realizar a importação, envio a receita federal e exportação de arquivo com resultados das chamadas de envio a receita.

## **Arquitetura**
Java versão 8
Spring Boot
Utilizada classe ReceitaService conforme enviado no fluxo do desafio

### **Testes**
Testes de unidade na camada de processamento, importação, envio e geração do arquivo de retorno, além da classe utilitária de validação.

### **Jar**
Encontra-se no diretório target um jar gerado para execução com o nome de sincronizacao-receita-0.0.1-SNAPSHOT.jar

### **Execução**
Dentro da pasta target ou pasta qualquer para onde seja movido o arquivo .jar
java -jar sincronizacao-receita-0.0.1-SNAPSHOT.jar <<diretorio_arquivo>>