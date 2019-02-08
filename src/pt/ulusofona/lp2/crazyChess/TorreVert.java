package pt.ulusofona.lp2.crazyChess;

public class TorreVert extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if(xD == xO) {
            if(yD < yO){
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            } else if (yD > yO) {
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
