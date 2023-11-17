# Capacitação Automação API em Gradle.
Os sub tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologia Utilizadas

- Java  https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
- Gradle  https://gradle.org/
- Criar Readme   https://stackedit.io/

##	Configurações de pastas do projeto:

##  Folder project:

- A pasta **src** tem a seguinte estrutura informada, **test** --> **java** --> **TestCases**, **TestSuites**, estrutura modelo utilizada na capacitação.

## No arquivo build.gradle encontram-se as dependecies utilizadas no proejto:
- Adicionardependecy.
- JUnit5 - testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.0-M1'
- JUnit4 - testImplementation 'junit:junit:4.13'
- api 'org.apache.commons:commons-math3:3.6.1'
- implementation 'com.google.guava:guava:29.0-jre' 
- implementation 'io.github.bonigarcia:webdrivermanager:5.4.1'


## Testes Automatizados
Testes automatizados para testar API, criar login, alterar, deletar produto

Observação

- Para clonar o projeto modelo Capacitação Web em Gradle no seu computador e executar, realize estes passos abaixo :

- - Open Git Bash here
- - Digitar: git clone git@github.com:francisgobbi/ProjetoModeloAPI.git
- - Projeto sera clonado no seu computador.

- Para executar o projeto, realize estes passo :

- - Gradle no Eclipse
- - Reload all Gradle Project
- - Executar os testes na pasta **src** -> **test** -> **TestCases** -->  **TestSuites**


## Notas Gerais
- BeforeEach e AfterEach (Anotações JUnit5)
- Design Patterns chamado page objetos. Foi criado classes específicas para cada página que você tem na aplicação. Para resolver um problema de reaproveitamento de código.
- Primeiro princípio do PageObject. Tenha um atributo da classe que seja WebDrive.
- Segundo tenha um construtor que recebe o estado atual do seu navegador de fora e jogue pra dentro deste navegador. Métodos de interação com cada método da tela. Fluente Page. 
