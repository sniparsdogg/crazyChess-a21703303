package pt.ulusofona.lp2.crazyChess;

public class PadreVila extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        for(int i = 0; i < 3; i++) {
            if((xD == xO + i || xD == xO - i) && (yD == yO + i || yD == yO + i)) {
                return true;
            }
        }
        return false;
    }
}
