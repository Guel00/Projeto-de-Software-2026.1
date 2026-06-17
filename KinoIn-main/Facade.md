
Estrutural

## 📖 O Conceito
O padrão **Facade** fornece uma interface unificada e simplificada para um conjunto de interfaces mais complexas em um subsistema. Ele atua como uma "fachada", escondendo a complexidade das regras de negócio (como orquestração de várias classes) da interface de usuário ou do cliente que está consumindo o código. Isso reduz o acoplamento e facilita a manutenção, centralizando múltiplas chamadas em um único ponto de acesso.

## 💻 Onde e como foi aplicado no KinoIn
A Facade foi aplicada para resolver a complexidade da compra de ingressos. Em vez da classe `Main` precisar gerenciar sessões, polimorfismo de tickets e atualizações de feed, tudo foi encapsulado no método `realizarCompra` da classe `CinemaFacade`.

### Trecho do Código

**1. A classe Facade (O encapsulamento):**
```java
// Pacote: com.kinoin.facade
public class CinemaFacade {
    // A Facade gerencia as dependências complexas internamente
    public Ticket realizarCompra(User user, Session session, int row, int col, boolean isConcession, boolean selected) {
        // Lógica complexa de verificação de assento, geração do ticket correto 
        // e postagem no feed encapsulada aqui...
        return ticket;
    }
}
