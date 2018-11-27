package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    public class Posicao { // Posição das peças.
        int x;
        int y;
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

    public String getImagePNG(){
        return null;
    } // Getter da imagem.

    public String toString(){
        if(capturada) {
            return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (n/a)");
        }
        return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (" + posicao + ")");
    }
}
