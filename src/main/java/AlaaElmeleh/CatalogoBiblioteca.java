package AlaaElmeleh;

import interfaces.Pubblicazione;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CatalogoBiblioteca {
    private static List<Libri> libri = new ArrayList<>();
    private static List<Riviste> riviste = new ArrayList<>();


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
    public Pubblicazione cercaPerCodiceISBN(long codiceISBN) {
        for (Libri libro : libri) {
            if (libro.getCodiceISBN() == codiceISBN) {
                return libro;
            }
        }

        for (Riviste rivista : riviste) {
            if (rivista.getCodiceISBN() == codiceISBN) {
                return rivista;
            }
        }

        return null;
    }
    public List<Libri> cercaPerAutore(String autore) {
        List<Libri> risultati = new ArrayList<>();

        for (Libri libro : libri) {
            if (libro.getAutore().equalsIgnoreCase(autore)) {
                risultati.add(libro);
            }
        }

        return risultati;
    }


    public  List<Pubblicazione> getCatalogo() {
        List<Pubblicazione> catalogoCompleto = new ArrayList<>();
        catalogoCompleto.addAll(libri);
        catalogoCompleto.addAll(riviste);
        return catalogoCompleto;
    }












    /////////////////METODO STAMPA
    public static void stampa (CatalogoBiblioteca catalogo) {
        List<Pubblicazione> catalogoLetto = catalogo.getCatalogo();
        File file = new File("src/output.txt");
        try{
            for (int i=0 ; i<catalogoLetto.size();i++){
                FileUtils.writeStringToFile(file,catalogoLetto.get(i).getTitolo()+ "@"+ catalogoLetto.get(i).getAutore()+"@"+catalogoLetto.get(i).getAnnoPubblicazione()+"@"+catalogoLetto.get(i).getCodiceISBN(),true);
            }
            String contenuto = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("nel file ho trovato: " + contenuto);
        }catch (IOException ex){
            ex.getMessage();
        }
    }
}





