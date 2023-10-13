package AlaaElmeleh;


import interfaces.Pubblicazione;

public class Riviste implements Pubblicazione {
        private long codiceISBN;
        private String titolo;
        private int annoPubblicazione;
        private int numeroPagine;
        private TipoPeriodicita periodicita;


    public Riviste(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, TipoPeriodicita periodicita) {
        setCodiceISBN(codiceISBN);
        this.titolo=titolo;
        setAnnoPubblicazione(annoPubblicazione);
        this.numeroPagine=numeroPagine;
        this.periodicita= periodicita;
    }




    @Override
    public long getCodiceISBN() {
        return codiceISBN;
    }

    @Override
    public void setCodiceISBN(long codiceISBN) {
        if (codiceISBN <= 0) {
            throw new IllegalArgumentException("Il codice ISBN deve essere un valore positivo.");
        }
        this.codiceISBN = codiceISBN;
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public void setAnnoPubblicazione(int annoPubblicazione) {
        if (String.valueOf(annoPubblicazione).length() != 4) {
            throw new IllegalArgumentException("L'anno di pubblicazione deve contenere esattamente 4 cifre.");
        }
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public int getNumeroPagine() {
        return numeroPagine;
    }
}
