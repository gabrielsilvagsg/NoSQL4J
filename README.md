# NoSQL4J

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)


Olá! esta é uma API para você usar em algum programa/app publico ou particular em que você não deseja estabelecer conexão com algum Banco de Dados dos tipos (MySQL, MongoDB e etc em que é preciso instalar ou ter algum servidor rodando)

Todos dados são armazenadas em Strings, podem ser convertidos livremente em seu código.

---------------------------------------------------------------------------------------------------------
Fiz testes de escrita e leitura com um SSD em meu computador particular e obtive os seguintes resultados:

Tempo de escritura de um documento: de 1000 nanossegundos ~ 3 milissegundos        
Tempo de leitura de um documento: de 1000 nanossegundos ~ 3 milissegundos
---------------------------------------------------------------------------------------------------------

Modos de utilização da API:

Para criar uma nova tabela:  

     TableManager.createTable("Nome da Tabela"); - Ela ira retornar true ou false para a sua operação

---------------------------------------------------------------------------------------------------------
Para criar um documento diretamente:

    Document document = new Document("Nome do Documento", "Nome da Tabela");
    document.put("nome", "Gabriel Silva"); - Método put para inserir chaves e valores ao documento.
    document.save(); - Salvar o documento
---------------------------------------------------------------------------------------------------------
Para obter um documento:

    Document document = DocumentManager.getDocument("Nome do Documento", "Nome da Tabela");
    - Aqui, você ja conseguiu obter/carregar o documento.
    - Caso o documento não exista, ele irá ser nulo.
    - Assim, você pode optar por ja criar, instanciando um novo Document, e inserindo os valores. 
    - Exemplo abaixo:

    if (document == null) {  
        document = new Document("Nome do Documento", "Nome da Tabela");
        document.put("nome", "Gabriel Silva");
        document.save();
    }

    System.out.println("Nome do cidadão: " + document.getValue("nome");

---------------------------------------------------------------------------------------------------------
