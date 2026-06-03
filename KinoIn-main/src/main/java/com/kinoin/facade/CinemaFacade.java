package com.kinoin.facade;

// Importando as classes que estão na sua pasta model
import com.kinoin.model.User;
import com.kinoin.model.Session;
import com.kinoin.model.Seat;
import com.kinoin.model.Transaction;
import com.kinoin.model.Ticket;

public class CinemaFacade {

    public CinemaFacade() {
        // Construtor vazio ou com inicialização de serviços de banco de dados, se houver.
    }

    // O método principal que a fachada expõe
    public Ticket buyTicket(User user, Session session, Seat seat) {
        System.out.println("--- INICIANDO COMPRA VIA FACADE ---");

        // 1. Verifica se o assento está disponível (lógica fictícia, adapte aos seus métodos)
        if (!seat.isAvailable()) { // Supondo que sua classe Seat tenha um método isAvailable()
            System.out.println("❌ Assento indisponível!");
            return null;
        }

        // 2. Processa a transação/pagamento
        Transaction transaction = new Transaction();
        // transaction.processPayment(user, session.getPrice()); // Exemplo de como seria

        // 3. Reserva o assento e gera o ingresso
        seat.setAvailable(false); // Marca como ocupado
        Ticket ticket = new Ticket(session, seat, user); 
        
        System.out.println("✅ Ingresso comprado com sucesso para: " + user.getName()); // Supondo getName()
        System.out.println("-----------------------------------");
        
        return ticket;
    }
}
