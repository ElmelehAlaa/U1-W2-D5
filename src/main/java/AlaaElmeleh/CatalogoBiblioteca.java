package AlaaElmeleh;

import interfaces.Pubblicazione;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBiblioteca {
    private List<Libri> libri = new ArrayList<>();
    private List<Riviste> riviste = new ArrayList<>();


    ////////////////// Metodo per aggiungere un libro al catalogo////////////
    public void aggiungiLibro(Libri libro) {
        libri.add(libro);
    }

    /////////// Metodo per aggiungere una rivista al catalogo/////////////////
    public void aggiungiRivista(Riviste rivista) {
        riviste.add(rivista);
    }

    public List<Pubblicazione> cercaPerAnnoPubblicazione(int anno) {
        List<Pubblicazione> risultati = new ArrayList<>();

        for (Libri libro : libri) {
            if (libro.getAnnoPubblicazione() == anno) {
                risultati.add(libro);
            }
        }

        for (Riviste rivista : riviste) {
            if (rivista.getAnnoPubblicazione() == anno) {
                risultati.add(rivista);
            }
        }

        return risultati;
    }

    public void mostraCatalogo() {
        List<Pubblicazione> catalogo = new ArrayList<>();
        catalogo.addAll(libri);
        catalogo.addAll(riviste);

        if (catalogo.isEmpty()) {
            System.out.println("Il catalogo è vuoto.");
        } else {
            System.out.println("Elementi nel catalogo:");
            for (Pubblicazione pubblicazione : catalogo) {
                if (pubblicazione instanceof Libri) {
                    System.out.println("Libro: " + pubblicazione);
                } else if (pubblicazione instanceof Riviste) {
                    System.out.println("Rivista: " + pubblicazione);
                }
            }
        }
    }

    public void rimuoviPerCodiceISBN(long codiceISBN) {
        for (Libri libro : libri) {
            if (libro.getCodiceISBN() == codiceISBN) {
                libri.remove(libro);
                return;
            }
        }

        for (Riviste rivista : riviste) {
            if (rivista.getCodiceISBN() == codiceISBN) {
                riviste.remove(rivista);
return;
            }
        }

        System.out.println("Nessun elemento trovato con il codice ISBN " + codiceISBN);
    }
}




