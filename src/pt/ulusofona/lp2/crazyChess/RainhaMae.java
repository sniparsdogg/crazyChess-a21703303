package pt.ulusofona.lp2.crazyChess;
public class RainhaMae extends CrazyPiece {
    int valorRelativo = 7;
    int movimentos = 0;
    public void somarMovimentos(){
        movimentos++;
    }

    public void setTurnoMovido(int turno){
        this.turnoMovido = turno;
    }

    @Override
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if(((xD <= xO + 4 && xD >= xO - 4) || (yD <= yO + 4 && yD >= yO - 4))) {
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro() - 1) || (yD < 0 || yD > simulador.getTamanhoTabuleiro() - 1) ) {
                return false;
            }
            for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                if (simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && simulador.getPecasEmJogo().get(i).getIdEquipa() == this.idEquipa) {
                    return false;
                }
            }
            for (int count = 0; count <= 4; count++) {
                if ((xO + count == xD && yO == yD) && ((xD - xO) % 2 == 0 )) { // horizontal este
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if (simulador.getPecasEmJogo().get(i).getPosicao().x > xO && simulador.getPecasEmJogo().get(i).getPosicao().x < xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9 ) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);
                } else if ((xO - count == xD && yO == yD)  && ((xO - xD) % 2 == 0 )) { // horizontal oeste
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if (simulador.getPecasEmJogo().get(i).getPosicao().x < xO && simulador.getPecasEmJogo().get(i).getPosicao().x > xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9 ) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);
                } else if ((xO == xD && yO - count == yD)  && ((yO - yD) % 2 == 0 )) { // vertical norte
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if (simulador.getPecasEmJogo().get(i).getPosicao().y < yO && simulador.getPecasEmJogo().get(i).getPosicao().y > yD && simulador.getPecasEmJogo().get(i).getPosicao().x == xD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9 ) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);
                } else if ((xO == xD && yO + count == yD)  && ((yD - yO) % 2 == 0 )) { // vertical sul
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if (simulador.getPecasEmJogo().get(i).getPosicao().y > yO && simulador.getPecasEmJogo().get(i).getPosicao().y < yD && simulador.getPecasEmJogo().get(i).getPosicao().x == xD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);

                } else if ((xO + count == xD && yO - count == yD)  && (((xD - xO) % 2 == 0 ) && ((yO - yD) % 2 == 0))) { // diagonal nordeste
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO + f, yO - f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9 ) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);

                } else if ((xO - count == xD && yO - count == yD)  && (((xO - xD) % 2 == 0 ) && ((yO - yD) % 2 == 0))) { // diagonal noroeste
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO - f, yO - f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9 ) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);

                } else if ((xO + count == xD && yO + count == yD)  && (((xD - xO) % 2 == 0 ) && ((yD - yO) % 2 == 0))) { // diagonal sudeste
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO + f, yO + f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);

                } else if ((xO - count == xD && yO + count == yD)  && (((xO - xD) % 2 == 0 ) && ((yD - yO) % 2 == 0))) { // diagonal sudoeste
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO - f, yO + f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasEmJogo().size(); i++) {
                        if ((simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && ((simulador.getPecasEmJogo().get(i).getIdTipo() == 1 || simulador.getPecasEmJogo().get(i).getIdTipo() == 9 ) || simulador.getPecasEmJogo().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return verificaPadre(xD, yD, simulador);
                }
            }
        }
        return false;
    }

    public boolean verificaPadre(int xD, int yD, Simulador simulador){
        CrazyPiece pecaATestar = simulador.pecaNaPosicao(xD - 1, yD -1);
        if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa) ){
            pecaATestar = simulador.pecaNaPosicao(xD, yD - 1);
            if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)){
                pecaATestar = simulador.pecaNaPosicao(xD + 1, yD -1);
                if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)) {
                    pecaATestar = simulador.pecaNaPosicao(xD + 1, yD);
                    if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)){
                        pecaATestar = simulador.pecaNaPosicao(xD + 1, yD + 1);
                        if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)){
                            pecaATestar = simulador.pecaNaPosicao(xD, yD + 1);
                            if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)){
                                pecaATestar = simulador.pecaNaPosicao(xD - 1, yD + 1);
                                if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)){
                                    pecaATestar = simulador.pecaNaPosicao(xD - 1, yD);
                                    if(pecaATestar == null || pecaATestar.getIdTipo() != 3 || (pecaATestar.getIdTipo() == 3 && pecaATestar.getIdEquipa() == this.idEquipa)){
                                        somarMovimentos();
                                        if(this.turnoMovido == null){
                                            setTurnoMovido(simulador.turno);
                                        }
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int getValorRelativo(){
        return valorRelativo;
    }

    @Override
    public String toString() {
      //  if (this.capturada) {
            return (this.id + " " + this.idEquipa + " 7 " + this.alcunha + " " + this.movimentos);
      //  }
      //  return (this.id + " | Rainha Mãe | 7 | " + this.idEquipa + " | " + this.alcunha + " @ " + this.posicao);
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("rainhaMaePreta.png");
        }
        return("rainhaMaeBranca.png");
    }

}

