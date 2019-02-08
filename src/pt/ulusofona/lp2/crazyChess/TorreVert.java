package pt.ulusofona.lp2.crazyChess;

public class TorreVert extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if(xD == xO) {
            return true;
        }
        return false;
    }
}
