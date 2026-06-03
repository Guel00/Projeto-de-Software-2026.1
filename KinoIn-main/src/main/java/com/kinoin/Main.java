package com.kinoin;

import com.kinoin.enums.MovieStatus;
import com.kinoin.model.*;
import com.kinoin.service.*;
// 🎯 AQUI: Importando a sua nova Facade
import com.kinoin.facade.CinemaFacade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Catalog catalog = new Catalog();
    static Feed feed = new Feed();
    
    // 🎯 AQUI: Inicializando a Facade e passando o feed para ela
    static CinemaFacade facade = new CinemaFacade(feed);

    static User user = new User("João", "joao@email.com");

    static Recommendation recommendation;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {

        setup();

        int option;

        do {
            int alertCount = getAlertCount();
            clearScreen();
            System.out.println("==================================");
            System.out.println("   🎬 KINOIN APP");
            System.out.println("==================================");
            System.out.println("1. Catálogo");
            System.out.println("2. Comprar ingresso");
            System.out.println("3. Avaliar filme");
            System.out.println("4. Feed");
            System.out.println("5. Recomendações");
            System.out.println("6. Meu Perfil");
            System.out.println("7. Alertas (" + alertCount + ")");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> { clearScreen(); catalogMenu(); waitEnter(); }
                case 2 -> { clearScreen(); buyTicket(); waitEnter(); }
                case 3 -> { clearScreen(); reviewMovie(); waitEnter(); }
                case 4 -> interactFeed();
                case 5 -> { clearScreen(); showRecommendations(); waitEnter(); }
                case 6 -> profileMenu();
                case 7 -> { clearScreen(); showAlerts(); waitEnter(); }
            }

        } while (option != 0);
    }

    static void setup() {

        Movie m1 = new Movie("Batman", "Ação", 14, MovieStatus.NOW_SHOWING);
        Movie m2 = new Movie("Interestelar", "Ficção", 10, MovieStatus.COMING_SOON);
        Movie m3 = new Movie("Toy Story", "Animação", 0, MovieStatus.NOW_SHOWING);
        Movie m4 = new Movie("Vingadores", "Ação", 12, MovieStatus.NOW_SHOWING);
        Movie m5 = new Movie("Invocação do Mal", "Terror", 16, MovieStatus.NOW_SHOWING);
        Movie m6 = new Movie("Avatar 3", "Ficção", 12, MovieStatus.COMING_SOON);
        Movie m7 = new Movie("Homem-Aranha", "Ação", 12, MovieStatus.NOW_SHOWING);
        Movie m8 = new Movie("Frozen 3", "Animação", 0, MovieStatus.COMING_SOON);
        Movie m9 = new Movie("John Wick 4", "Ação", 16, MovieStatus.NOW_SHOWING);
        Movie m10 = new Movie("It: A Coisa 3", "Terror", 18, MovieStatus.COMING_SOON);

        catalog.addMovie(m1);
        catalog.addMovie(m2);
        catalog.addMovie(m3);
        catalog.addMovie(m4);
        catalog.addMovie(m5);
        catalog.addMovie(m6);
        catalog.addMovie(m7);
        catalog.addMovie(m8);
        catalog.addMovie(m9);
        catalog.addMovie(m10);

        Cinema cinema = new Cinema("CineMax", "Centro");

        cinema.addSession(new Session(m1, LocalDateTime.now().plusHours(1),1,20,generateRoom()));
        cinema.addSession(new Session(m1, LocalDateTime.now().plusHours(3),2,22,generateRoom()));
        cinema.addSession(new Session(m3, LocalDateTime.now().plusHours(2),3,15,generateRoom()));
        cinema.addSession(new Session(m4, LocalDateTime.now().plusHours(4),4,25,
