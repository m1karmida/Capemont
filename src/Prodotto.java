import java.io.Serializable;

public class Prodotto implements Serializable {

    private String nome ;
    private String categoria ;
    private int quantita ;
    private float prezzo ;
    private int num_acquistato ;
    private boolean recente ;

    Prodotto( String nome, String categoria, int quantita, float prezzo, int num_acquistato, boolean recente ) {
        this.nome = nome ;
        this.categoria = categoria ;
        this.quantita = quantita ;
        this.prezzo = prezzo ;
        this.num_acquistato = num_acquistato ;
        this.recente = recente ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                ", num_acquistato=" + num_acquistato +
                ", recente=" + recente +
                '}';
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getNum_acquistato() {
        return num_acquistato;
    }

    public void setNum_acquistato(int num_acquistato) {
        this.num_acquistato = num_acquistato;
    }

    public boolean isRecente() {
        return recente;
    }

    public void setRecente(boolean recente) {
        this.recente = recente;
    }
}
