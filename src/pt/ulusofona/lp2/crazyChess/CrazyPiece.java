package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    public class Posicao {
        int x;
        int y;
        Posicao() {

        }
        public void setPosicao(int posX, int posY) {
            this.x = posX;
            this.y = posY;
        }
    }

    int id;
    int idTipo;
    int idEquipa;
    String alcunha;
    Posicao posicao;


    CrazyPiece(){
        posicao = new Posicao();
    }

    public int getID(){
        return id;
    }

    public void setId(int i){
        this.id = i;
    }

    public void setIdTipo(int i) {
        this.idTipo = i;
    }

    public void setIdEquipa(int i) {
        this.idEquipa = i;
    }

    public void setAlcunha(String s) {
        this.alcunha = s;
    }

    public String getImagePNG(){
        return null;
    }

    public String toString(){
        return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha);
    }

}
