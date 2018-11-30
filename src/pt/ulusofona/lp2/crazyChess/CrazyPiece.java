package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    public class Posicao { // Posição das peças.
        Integer x;
        Integer y;
        Posicao() {

        }
        public void setPosicao(int posX, int posY) { // Determina a posiçao das peças.
            this.x = posX;
            this.y = posY;
        }
        public String toString(){
            return(x + ", " + y);
        }
    }

    int id;
    int idTipo;
    int idEquipa;
    String alcunha;
    Posicao posicao = new Posicao();
    boolean capturada;
    int x;
    int y;

    CrazyPiece(){

    }

    public int getId(){ // Getter do ID.
        return id;
    }

    public void setId(int i){ // Setter do ID.
        this.id = i;
    }

    public void setIdTipo(int i) { // Setter do IDTipo.
        this.idTipo = i;
    }

    public int getIdEquipa() { // Getter do IDEquipa.
        return idEquipa;
    }

    public void setIdEquipa(int i) {
        this.idEquipa = i;
    } // Setter do IDEquipa.

    public void setAlcunha(String s) {
        this.alcunha = s;
    } // Setter da Alcunha.

    public String getAlcunha() {
        return alcunha;
    }

    public void setCapturada(){
        capturada = true;
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 0) {
            return("PecasPretas.png");
        }
        return("PecasBrancas.png");
    }

    public String toString(){
        if(capturada) {
            return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (n/a)");
        }
        return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (" + posicao + ")");
    }
}
