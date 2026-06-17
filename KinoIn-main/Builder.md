# KinoIn - Sistema de Gestão de Cinema

O **KinoIn** é uma aplicação Java projetada para gerenciar o catálogo de um cinema, a compra de ingressos e fornecer uma experiência de rede social onde amigos podem interagir através de um feed de filmes assistidos.

A arquitetura do projeto foi desenvolvida utilizando boas práticas de Programação Orientada a Objetos e foca na aplicação prática de três categorias de **Padrões de Projeto (Design Patterns)**: Criacional, Estrutural e Comportamental.

---

## 🛠️ Padrões de Projeto Implementados

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

