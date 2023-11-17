# Capacita��o Automa��o API em Gradle.
Os sub t�picos abaixo descrevem algumas decis�es tomadas na estrutura��o do projeto.

## Tecnologia Utilizadas

- Java  https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
- Gradle  https://gradle.org/
- Criar Readme   https://stackedit.io/

##	Configura��es de pastas do projeto:

##  Folder project:

- A pasta **src** tem a seguinte estrutura informada, **test** --> **java** --> **TestCases**, **TestSuites**, estrutura modelo utilizada na capacita��o.

## No arquivo build.gradle encontram-se as dependecies utilizadas no proejto:
- Adicionardependecy.
- JUnit5 - testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.0-M1'
- JUnit4 - testImplementation 'junit:junit:4.13'
- api 'org.apache.commons:commons-math3:3.6.1'
- implementation 'com.google.guava:guava:29.0-jre' 
- implementation 'io.github.bonigarcia:webdrivermanager:5.4.1'


## Testes Automatizados
Testes automatizados para testar API, criar login, alterar, deletar produto

Observa��o

- Para clonar o projeto modelo Capacita��o Web em Gradle no seu computador e executar, realize estes passos abaixo :

- - Open Git Bash here
- - Digitar: git clone git@github.com:francisgobbi/ProjetoModeloAPI.git
- - Projeto sera clonado no seu computador.

- Para executar o projeto, realize estes passo :

- - Gradle no Eclipse
- - Reload all Gradle Project
- - Executar os testes na pasta **src** -> **test** -> **TestCases** -->  **TestSuites**


## Notas Gerais
- BeforeEach e AfterEach (Anota��es JUnit5)
- Design Patterns chamado page objetos. Foi criado classes espec�ficas para cada p�gina que voc� tem na aplica��o. Para resolver um problema de reaproveitamento de c�digo.
- Primeiro princ�pio do PageObject. Tenha um atributo da classe que seja WebDrive.
- Segundo tenha um construtor que recebe o estado atual do seu navegador de fora e jogue pra dentro deste navegador. M�todos de intera��o com cada m�todo da tela. Fluente Page. 
