package interfaces;

public interface Pubblicazione {
    long getCodiceISBN();
    void setCodiceISBN(long codiceISBN);
    String getTitolo();
    int getAnnoPubblicazione();


    void setAnnoPubblicazione(int annoPubblicazione);

    int getNumeroPagine();
}
