package AlaaElmeleh;

import interfaces.Pubblicazione;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBiblioteca {
    private List<Libri> libri = new ArrayList<>();
    private List<Riviste> riviste = new ArrayList<>();
    private List<Riviste> catalogo = new ArrayList<>();

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

        for (Pubblicazione pubblicazione : catalogo) {
            if (pubblicazione.getAnnoPubblicazione() == anno) {
                risultati.add(pubblicazione);
            }
        }

        return risultati;
    }


};
