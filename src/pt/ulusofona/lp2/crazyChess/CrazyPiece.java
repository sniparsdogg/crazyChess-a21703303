package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {

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

    public void setIdTipo(int i) { // Setter do tipo da peça.
        this.idTipo = i;
    }

    public int getIdEquipa() { // Getter da equipa da peça.
        return idEquipa;
    }

    public void setIdEquipa(int i) { // Setter da equipa da peça.
        this.idEquipa = i;
    }

    public void setAlcunha(String s) { // Setter da alcunha.
        this.alcunha = s;
    }

    public String getAlcunha() { // Getter da alcunha.
        return alcunha;
    }

    public void setCapturada() { // Setter do estado de captura da peça.
        capturada = true;
    }

    public void setPosicao(int posX, int posY) { // Setter da posição da peça.
        this.posicao.x = posX;
        this.posicao.y = posY;
    }

    public Posicao getPosicao() { // Getter da posição da peça.
        return posicao;
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 0) {
            return("PecasPretas.png");
        }
        return("PecasBrancas.png");
    }

    public String toString(){ // Override da string da classe para podermos atribuir à mesma a string requerida pelo enunciado.
        if(capturada) {
            return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (n/a)");
        }
        return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (" + posicao + ")");
    }
}
