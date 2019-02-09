package pt.ulusofona.lp2.crazyChess;

public class Sugestao implements Comparable<Sugestao>{
    int x;
    int y;
    int pontos;

    Sugestao(int xD, int yD, int valorRelativo){
        this.x = xD;
        this.y = yD;
        this.pontos = valorRelativo;
    }

    public int compareTo(Sugestao outra){
        if(this.pontos == outra.pontos){
            return 0;
        }
        if(this.pontos > outra.pontos){
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString(){
        return(x + ", " + y + ", " + pontos);
    }
}
