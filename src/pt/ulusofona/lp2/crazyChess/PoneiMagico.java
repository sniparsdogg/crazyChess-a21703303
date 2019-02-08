package pt.ulusofona.lp2.crazyChess;

public class PoneiMagico extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {

        if((xD == xO + 2 || xD == xO - 2) && (yD == yO + 2 || yD == yO - 2)){
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro()) || (yD < 0 || yD > simulador.getTamanhoTabuleiro()) ) {
                return false;
            }
            if (xD == xO - 2 && yD == yO - 2) { // diagonal noroeste
                CrazyPiece pecaATestar = simulador.pecaNaPosicao(xO, yO - 1);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO, yO - 2);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO - 1, yO - 2);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }

                pecaATestar = simulador.pecaNaPosicao(xO - 1, yO);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO - 2, yO);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO - 2, yO - 1);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }
            } else if (xD == xO + 2 && yD == yO - 2) { // diagonal nordeste
                CrazyPiece pecaATestar = simulador.pecaNaPosicao(xO, yO - 1);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO, yO - 2);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO + 1, yO - 2);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }

                pecaATestar = simulador.pecaNaPosicao(xO + 1, yO);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO + 2, yO);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO + 2, yO - 1);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }
            } else if (xD == xO - 2 && yD == yO + 2) { // diagonal sudoeste
                CrazyPiece pecaATestar = simulador.pecaNaPosicao(xO, yO + 1);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO, yO + 2);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO - 1, yO - 2);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }

                pecaATestar = simulador.pecaNaPosicao(xO - 1, yO);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO - 2, yO);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO - 2, yO + 1);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }
            } else if (xD == xO + 2 && yD == yO + 2) { // diagonal sudeste
                CrazyPiece pecaATestar = simulador.pecaNaPosicao(xO, yO + 1);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO, yO + 2);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO + 1, yO - 2);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
                        }
                    }
                }

                pecaATestar = simulador.pecaNaPosicao(xO + 1, yO);
                if(pecaATestar.getIdTipo() != 0){
                    pecaATestar = simulador.pecaNaPosicao(xO + 2, yO);
                    if(pecaATestar.getIdTipo() != 0){
                        pecaATestar = simulador.pecaNaPosicao(xO + 2, yO + 1);
                        if(pecaATestar.getIdTipo() != 0) {
                            return true;
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
            return (this.id + "| Ponei Mágico | 5 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | Ponei Mágico | 5 | " + this.idEquipa + " | " + this.alcunha + " @ " + this.posicao);
    }

}
