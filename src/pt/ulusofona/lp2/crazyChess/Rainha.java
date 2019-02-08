package pt.ulusofona.lp2.crazyChess;

public class Rainha extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if((xD <= xO + 5 && xD >= xO - 5) || (yD <= yO + 5 && yD >= yO - 5)) {
            if(xO > xD && yO == yD) { // horizontal oeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD  && simulador.getPecasMalucas().get(i).getPosicao().y == yD){
                        return false;
                    }
                }
            } else if(xO < xD && yO == yD) { // horizontal este
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD  && simulador.getPecasMalucas().get(i).getPosicao().y == yD){
                        return false;
                    }
                }
            } else if (xO == xD && yO > yD) { // vertical norte
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            } else if(xO == xD && yO < yD) { // vertical sul
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            } else if(xO > xD && yO > yD) { // diagonal noroeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD) && (simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD)){
                        return false;
                    }
                }
            } else if(xO < xD && yO > yD) { // diagonal nordeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD) && (simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD)){
                        return false;
                    }
                }
            } else if(xO > xD && yO < yD) { // diagonal sudoeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD) && (simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD)){
                        return false;
                    }
                }
            } else if(xO < xD && yO < yD) { // diagonal sudeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD) && (simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD)){
                        return false;
                    }
                }
            } else { // verificação se a peça a obter é rainha
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && (simulador.getPecasMalucas().get(i).getId() == 1 || simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa))){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}