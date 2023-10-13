package AlaaElmeleh;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        CatalogoBiblioteca catalogo = new CatalogoBiblioteca();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il tipo di pubblicazione (1 per Libro, 2 per Rivista):");
        int tipoPubblicazione = scanner.nextInt();

        scanner.nextLine();

        if (tipoPubblicazione == 1) {

            System.out.println("Inserisci il codice ISBN del libro:");
            long codiceISBN = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Inserisci il titolo del libro:");
            String titolo = scanner.nextLine();

            System.out.println("inserisci l'anno di pubblicazione del libro:");
            int annoPubblicazione = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il numero di pagine del libro:");
            int numeroPagine = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci l'autore del libro:");
            String autore = scanner.nextLine();

            System.out.println("Inserisci il genere del libro:");
            String genere = scanner.nextLine();
            try {
                Libri libro = new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
                catalogo.aggiungiLibro(libro);
                System.out.println("Libro aggiunto al catalogo.");
            } catch (IllegalArgumentException e) {
                System.err.println("Errore nell'aggiunta del libro: " + e.getMessage());
            }


            //////////////////////// Aggiunta di una rivista////////////////////////////
    } else if (tipoPubblicazione == 2) {
            System.out.println("Inserisci il codice ISBN della rivista:");
            long codiceISBN = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Inserisci il titolo della rivista:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci l'anno di pubblicazione della rivista:");
            int annoPubblicazione = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il numero di pagine della rivista:");
            int numeroPagine = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Seleziona la periodicità della rivista (0 per Settimanale, 1 per Mensile, 2 per Semestrale):");
            int sceltaPeriodicita = scanner.nextInt();

            TipoPeriodicita periodicita = TipoPeriodicita.values()[sceltaPeriodicita];

            try {
                Riviste rivista = new Riviste(codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicita);
                catalogo.aggiungiRivista(rivista);
                System.out.println("Rivista aggiunta al catalogo.");
            } catch (IllegalArgumentException e) {
                System.err.println("Errore nell'aggiunta della rivista: " + e.getMessage());
            }
        }
        else {
            System.err.println("Tipo di pubblicazione non valido. Inserisci 1 per Libro o 2 per Rivista.");
        }
    }
}
