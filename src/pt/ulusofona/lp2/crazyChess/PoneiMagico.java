package pt.ulusofona.lp2.crazyChess;

public class PoneiMagico extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if((xD == xO + 2 || xD == xO - 2 || xD == xO) && (yD == yO + 2 || yD == yO - 2 || yD == yO) && (xD == xO || yD == yO)){
            return true;
        }
        return false;
    }
}
