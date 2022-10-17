# Java-SpringData-Crud

### Ideia geral:
###### • A ideia do projeto é a utilização do framework de integração com banco de dados Spring Data, mais especificamente o Spring Data JPA.
###### • Foram usados diversos conceitos, claro, com o intuito de consolidar o conhecimento adquirido em cursos de Java JDBC, JPA com Hibernate e Spring Data JPA.
###### • A persistência é feita com o banco SQL, o MariaDB, rodando em localhost. A configuração é feita no arquivo [ application.properties ].
###### • As dependências e plugins do projeto estão no arquivo [ pom.xml ].
<br>

### Como funciona:
###### • O projeto possui 3 entidades, mapeadas entre si com cardinalidade definida.
    ♦ Funcionário             @ManyToOne -> Cargo | @ManyToMany -> Unidade de trabalho
    ♦ Cargo                   @OneToMany -> Funcionário
    ♦ Unidade de Trabalho     @ManyToMany -> Funcionário
###### • Para cada entidade, há a representação de uma classe que carrega a anotação @Entity, e os atributos que representam as suas devidas colunas.
###### • Há também uma interface para cada, que levam a anotação @Repository e estendem de outras interfaces que implementam métodos CRUD.
###### • Em CrudFuncionarioRepository.java, o repositório da entidade Funcionário, estendemos de PagingAndSortingRepository, onde além dos métodos de CRUD, temos métodos que possibilitam a paginação de consultas.
###### • Há também diferentes tipos de consultas, usando Derived Query, JDBC e nativeQuerys, para exemplificar os melhores momentos para utilização de cada uma.
###### • Por fim, é implementada uma funcionalidade de busca dinâmica. Com tecnologias como JDBC e JPA Hibernate, fazer buscas dinâmicas eram bastante trabalhosas, uma alternativa foi a criação da API Criteria mas que ainda assim era de difícil leitura e interpretação.
###### • Com a utilização do Spring Data JPA, buscas dinâmicas são extremamente simplificadas com a ferramenta Specifications, como é feito nesse projeto.
###### • O projeto funciona executando o arquivo [ SpringDataApplication.java ], que fornece um menu dinâmico para o usuário interagir com as funcionalidades.
<br>

## GIF mostrando o funcionamento: 
  ![](https://github.com/vitucomment/Java-SpringData-Crud/blob/master/gif/ExecutandoCrud.gif)
