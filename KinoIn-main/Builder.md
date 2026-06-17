
### 1. Builder (Padrão Criacional)
* **Conceito:** Separa a construção de um objeto complexo da sua representação, permitindo criá-lo passo a passo através de uma interface fluente. Resolve o problema de construtores gigantescos (*Telescoping Constructor*) e garante que o objeto só seja instanciado quando estiver totalmente configurado.
* **Onde está implementado:** * **Estrutura:** Classe estática interna `Builder` na classe `Movie.java` (`com.kinoin.model.Movie`). O construtor principal de `Movie` foi alterado para `private`, forçando o encapsulamento e a utilização exclusiva do Builder.
  * **Uso no código:** Na classe `Main.java`, dentro do método `setup()`.
* **Trechos do Código:**
  ```java
  // Localizado em Movie.java
  // Construtor privado que recebe o Builder
  private Movie(Builder builder) {
      this.title = builder.title;
      this.genre = builder.genre;
      this.ratingAge = builder.ratingAge;
      this.status = builder.status;
      // ...
  }


