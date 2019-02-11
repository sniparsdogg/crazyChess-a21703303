package pt.ulusofona.lp2.crazyChess;

public class PadreVila extends CrazyPiece {
    int valorRelativo = 3;
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        for(int i = 0; i < 4; i++) {
            if((xD == xO + i || xD == xO - i) && (yD == yO + i || yD == yO - i)) {
                if ((xD == xO && yD == yO) || (xD < 0 || xD > simulador.getTamanhoTabuleiro() - 1) || (yD < 0 || yD > simulador.getTamanhoTabuleiro() - 1) ) {
                    return false;
                }
                for (int count = 0; count < simulador.getPecasEmJogo().size(); count++) {
                    if (simulador.getPecasEmJogo().get(count).getPosicao().x == xD && simulador.getPecasEmJogo().get(count).getPosicao().y == yD && simulador.getPecasEmJogo().get(count).getIdEquipa() == this.idEquipa) {
                        return false;
                    }
                }
                if(i >= 2){
                    if(xO - i == xD && yO - i == yD) { // diagonal noroeste
                        for(int j = 0; j < simulador.getPecasEmJogo().size(); j++){
                            for (int f = 1; f < i; f++) {
                                CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO - f, yO - f);
                                if (pecaAComparar != null) {
                                    return false;
                                }
                            }
                        }
                        return(verificaRainha(xD, yD, simulador));
                    } else if(xO + i == xD && yO - i == yD) { // diagonal nordeste
                        for(int j = 0; j < simulador.getPecasEmJogo().size(); j++){
                            for (int f = 1; f < i; f++) {
                                CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO + f, yO - f);
                                if (pecaAComparar != null) {
                                    return false;
                                }
                            }
                        }
                        return(verificaRainha(xD, yD, simulador));
                    } else if(xO - i == xD && yO + i == yD) { // diagonal sudoeste
                        for(int j = 0; j < simulador.getPecasEmJogo().size(); j++){
                            for (int f = 1; f < i; f++) {
                                CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO - f, yO + f);
                                if (pecaAComparar != null) {
                                    return false;
                                }
                            }
                        }
                        return(verificaRainha(xD, yD, simulador));
                    } else if(xO + i == xD && yO + i == yD) { // diagonal sudeste
                        for(int j = 0; j < simulador.getPecasEmJogo().size(); j++){
                            for (int f = 1; f < i; f++) {
                                CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO + f, yO + f);
                                if (pecaAComparar != null) {
                                    return false;
                                }
                            }
                        }
                        return(verificaRainha(xD, yD, simulador));
                    }
                    } else {
                    return(verificaRainha(xD, yD, simulador));
                }

                    }
                }
        return false;
    }

    public int getValorRelativo(){
        return valorRelativo;
    }

    public boolean verificaRainha(int xD, int yD, Simulador simulador){
        CrazyPiece pecaATestar = simulador.pecaNaPosicao(xD - 1, yD -1);
        if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa) ){
            pecaATestar = simulador.pecaNaPosicao(xD, yD - 1);
            if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)){
                pecaATestar = simulador.pecaNaPosicao(xD + 1, yD -1);
                if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)) {
                    pecaATestar = simulador.pecaNaPosicao(xD + 1, yD);
                    if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)){
                        pecaATestar = simulador.pecaNaPosicao(xD + 1, yD + 1);
                        if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)){
                            pecaATestar = simulador.pecaNaPosicao(xD, yD + 1);
                            if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)){
                                pecaATestar = simulador.pecaNaPosicao(xD - 1, yD + 1);
                                if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)){
                                    pecaATestar = simulador.pecaNaPosicao(xD - 1, yD);
                                    if(pecaATestar == null || pecaATestar.getIdTipo() != 1 || (pecaATestar.getIdTipo() == 1 && pecaATestar.getIdEquipa() == this.idEquipa)){
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

    @Override
    public String toString() {
        if (this.capturada) {
            return (this.id + " | Padre da Vila | 3 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | Padre da Vila | 3 | " + this.idEquipa + " | " + this.alcunha + " @ (" + this.posicao + ")");
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("padreVilaPreto.png");
        }
        return("padreVilaBranco.png");
    }

}
