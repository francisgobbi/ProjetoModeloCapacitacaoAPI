# Capacitação Automação API em Gradle.
Os sub tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologia Utilizadas

- Java  https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
- Gradle  https://gradle.org/
- Criar Readme   https://stackedit.io/
- RestAssured https://rest-assured.io/


##	Configurações de pastas do projeto:

##  Folder project:

- - Executar os testes na pasta **src** -> **test** -> **TestCases** 
- - Executar os testes na pasta **src** -> **test** -> **TestSuites** -->  **AllTests**

## No arquivo build.gradle encontram-se as dependecies utilizadas no proejto:
- Adicionardependecy.
- JUnit5 - testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.0-M1'
- JUnit4 - testImplementation 'junit:junit:4.13'
- api 'org.apache.commons:commons-math3:3.6.1'
- implementation 'com.google.guava:guava:29.0-jre' 
// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-engine
- implementation 'org.junit.platform:junit-platform-suite-engine:1.9.0-M1'
// https://mvnrepository.com/artifact/io.rest-assured/rest-assured
- implementation 'io.rest-assured:rest-assured:5.3.2'
- implementation 'org.junit.platform:junit-platform-suite-api:1.10.0'

## Testes Automatizados
Testes automatizados para API, criar, alterar usuario, criar alterar produtos na API https://souceapi.docs.apiary.io/#reference/product/apiproduct/put?console=1, acessar a API e realizar operações. 

## Observação

- Para clonar o projeto modelo Capacitação Web em Gradle no seu computador e executar, realize estes passos abaixo :

- - Open Git Bash here
- - Digitar: git clone https://github.com/francisgobbi/ProjetoModeloCapacitacaoAPI.git
- - Projeto sera clonado no seu computador.

- Para executar o projeto, realize estes passo :

- - Gradle no Eclipse
- - Reload all Gradle Project
- - Executar os testes na pasta **src** -> **test** -> **TestCases** 
- - Executar os testes na pasta **src** -> **test** -> **TestSuites** -->  **AllTests**


## Notas Gerais
- BeforeEach e AfterEach (Anotações JUnit5)
- Design Patterns chamado page objetos. Foi criado classes específicas para cada página que você tem na aplicação. Para resolver um problema de reaproveitamento de código.
- Primeiro princípio do PageObject. Tenha um atributo da classe que seja WebDrive.
- Segundo tenha um construtor que recebe o estado atual do seu navegador de fora e jogue pra dentro deste navegador. Métodos de interação com cada método da tela. Fluente Page. 