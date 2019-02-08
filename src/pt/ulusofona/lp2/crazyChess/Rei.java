package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if((xD == xO+1 || xD == xO - 1) && (yD == yO+1 || yD == yO-1) && ((xD == xO && yD != yO) || (xD != xO && yD == yO))) {
            for(int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                if(simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}