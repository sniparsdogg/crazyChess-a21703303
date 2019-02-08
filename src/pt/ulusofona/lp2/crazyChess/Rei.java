package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if((xD == xO+1 || xD == xO - 1) && (yD == yO+1 || yD == yO-1)) {
            return true;
        }
        return false;
    }
}
