# Aplicativo de Lista de Tarefas  
Este projeto é um aplicativo simples de lista de tarefas desenvolvido em Java e Spring Boot, permitindo que os usuários gerenciem suas atividades diárias de forma eficiente, adicionando, visualizando e removendo itens conforme necessário.  

## Funcionalidades  
- **Adicionar Tarefas**: Permite aos usuários incluir novas tarefas na lista.  
- **Visualizar Tarefas**: Exibe todas as tarefas adicionadas no formato da lista.  
- **Alterar Tarefas**: Atualiza informações de uma tarefa já existente.  
- **Remover Tarefas**: Possibilidade de exclusão de tarefas da lista quando concluídas ou não mais permitidas.  

## Pré-requisitos  
- **Java Development Kit (JDK)**: Certifique-se de que o JDK esteja instalado em sua máquina.  
- **Maven**: Este projeto utiliza o Maven para gerenciamento de dependências; Certifique-se de que o Maven está instalado.
- **PostgreSQL Local**: É necessário ter o PostgreSQL instalado localmente. Crie um banco de dados para o aplicativo e configure as credenciais no arquivo application.properties do Spring Boot.

## Como Começar  

1. **Clonar o Repositório**:  
   
   ```bash
   git clone https://github.com/santjonatas/todo-list.git
   ```  

2. **Navegar até o Diretório do Projeto**:  
   
   ```bash
   cd todo-list
   ```  

3. **Construir o Projeto**: Utilize o Maven para construir o projeto.  
   
   ```bash
   mvn clean install
   ```  

4. **Executar o Aplicativo**: Após a construção bem-sucedida, execute o aplicativo com o seguinte comando:  
   
   ```bash
   mvn exec:java -Dexec.mainClass="com.seu.pacote.Main"
   ```  
   Substitua `"com.seu.pacote.Main"` pelo nome completo da classe principal do seu aplicativo.  

## Estrutura do Projeto  
O projeto segue a estrutura padrão do Maven:  

```
todo-list/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       └── resources/
├── .gitignore
├── pom.xml
└── README.md
```  

- **src/main/java**: Contém o código-fonte principal do aplicativo.  
- **src/main/resources**: Inclui recursos como arquivos de configuração.  
- **src/test/java**: Contém os testes unitários do aplicativo.  
- **src/test/resources**: Inclui recursos necessários para os testes.  
