package pt.ulusofona.lp2.crazyChess;

public class Posicao { // Posição das peças.
    Integer x;
    Integer y;

    Posicao(int x, int y) {
        this.x=x;
        this.y=y;
    }

    Posicao() {

    }

    public String toString(){
        return(x + ", " + y);
    }
}

