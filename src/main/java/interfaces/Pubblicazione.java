package interfaces;

public interface Pubblicazione {
    long getCodiceISBN();
    void setCodiceISBN(long codiceISBN);
    String getTitolo();
    int getAnnoPubblicazione();

    String getAutore();


    void setAnnoPubblicazione(int annoPubblicazione);

    int getNumeroPagine();
}
