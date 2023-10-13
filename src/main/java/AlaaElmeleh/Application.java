package AlaaElmeleh;

import interfaces.Pubblicazione;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        CatalogoBiblioteca catalogo = new CatalogoBiblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Aggiungi nuovo elemento al catalogo");
            System.out.println("2. Cerca per anno di pubblicazione");
            System.out.println("3. Esci");
            System.out.println("4. MostraCatalogo");
            System.out.println("5. Rimuovi per codice isbn");
            System.out.println("6. ricerca Elemento per isbn");
            System.out.println("7. Ricerca elemento per autore");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:

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
        break;
                case 2:
                    System.out.println("Inserisci l'anno di pubblicazione da cercare:");
                    int annoDaCercare = scanner.nextInt();
                    scanner.nextLine();
                    List<Pubblicazione> risultati = catalogo.cercaPerAnnoPubblicazione(annoDaCercare);

                    if (risultati.isEmpty()) {
                        System.out.println("Nessuna pubblicazione trovata per l'anno " + annoDaCercare);
                    } else {
                        System.out.println("Pubblicazioni trovate per l'anno " + annoDaCercare + ":");
                        for (Pubblicazione pubblicazione : risultati) {
                            if (pubblicazione instanceof Libri) {
                                System.out.println("Libro: " + pubblicazione);
                            } else if (pubblicazione instanceof Riviste) {
                                System.out.println("Rivista: " + pubblicazione);
                            }
                        }
                    }break;
                case 3:
                    continua =false;

                    System.out.println("Programma terminato");

                        break;
                case 4:
                    catalogo.mostraCatalogo();
                    break;
                case 5:
                    System.out.println("Inserisci il codice ISBN dell'elemento da rimuovere:");
                    long codiceISBNDaRimuovere = scanner.nextLong();
                    scanner.nextLine();

                    catalogo.rimuoviPerCodiceISBN(codiceISBNDaRimuovere);
                    System.out.println("Elemento eliminato dal Catalogo!");;
                    break;
                case 6:
                    System.out.println("Inserisci il codice ISBN dell'elemento da cercare:");
                    long codiceISBNDaCercare = scanner.nextLong();
                    scanner.nextLine();

                    Pubblicazione elementoPerCodiceISBN = catalogo.cercaPerCodiceISBN(codiceISBNDaCercare);
                    if (elementoPerCodiceISBN != null) {
                        System.out.println("Elemento trovato:");
                        if (elementoPerCodiceISBN instanceof Libri) {
                            System.out.println("Libro: " + elementoPerCodiceISBN);
                        } else if (elementoPerCodiceISBN instanceof Riviste) {
                            System.out.println("Rivista: " + elementoPerCodiceISBN);
                        }
                    } else {
                        System.out.println("Nessun elemento trovato con il codice ISBN " + codiceISBNDaCercare);
                    }
                    break;
                case 7:
                    System.out.println("Inserisci il nome dell'autore da cercare:");
                    String autoreDaCercare = scanner.nextLine();

                    List<Libri> libriPerAutore = catalogo.cercaPerAutore(autoreDaCercare);
                    if (!libriPerAutore.isEmpty()) {
                        System.out.println("Libri scritti da " + autoreDaCercare + ":");
                        for (Libri libro : libriPerAutore) {
                            System.out.println("Libro: " + libro);
                        }
                    } else {
                        System.out.println("Nessun libro trovato scritto da " + autoreDaCercare);
                    }
                    break;

                default:System.err.println("Scelta non valida. Inserisci un numero da 1 a 7.");
                    break;
    }
}}}
