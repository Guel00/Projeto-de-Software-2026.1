
## 📖 O Conceito
O padrão **Observer** define uma dependência de "um-para-muitos" entre objetos. Quando o objeto principal (o *Subject*) muda de estado, todos os seus dependentes (os *Observers*) são notificados e atualizados automaticamente de forma reativa. Ele resolve o problema de comunicação ineficiente e evita o desperdício de recursos gerado por checagens contínuas (*polling*).

## 💻 Onde e como foi aplicado no KinoIn
Foi utilizado no sistema de `Wishlist` (Lista de desejos). O filme (`Movie`) atua como o sujeito observado. Quando seu status muda para "Em cartaz" (`NOW_SHOWING`), ele notifica automaticamente todos os usuários (`User`) que o adicionaram à lista, disparando alertas sem que o sistema precise ficar verificando os filmes a todo momento.

### Trechos do Código

**1. O vínculo (O usuário começa a observar o filme):**
```java
// Arquivo: Main.java -> método catalogMenu()
// Ao adicionar à wishlist, registramos o usuário como observador do filme
user.addToWishlist(movies.get(c));
movies.get(c).addObserver(user); 
