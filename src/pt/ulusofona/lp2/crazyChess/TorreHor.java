package pt.ulusofona.lp2.crazyChess;

public class TorreHor extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if(yO == yD) {
            return true;
        }
        return false;
    }
}
