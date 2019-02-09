package pt.ulusofona.lp2.crazyChess;


public class Joker extends CrazyPiece {

    int tipoJoker = 1;

    public void incrementaTipoJoker(){
        tipoJoker++;
        this.idTipo++;
        if(tipoJoker == 8){
            tipoJoker = 1;
            this.idTipo = 1;
        }
    }
     public String nomeTipoJoker(){
        switch(tipoJoker){
            case 1 :
                return "Rainha";
            case 2:
                return "Ponei Mágico";
            case 3:
                return "Padre da Vila";
            case 4:
                return "TorreH";
            case 5:
                return "TorreV";
            case 6:
                return "Lebre";
            case 7:
                return "Rainha Mãe";
        }
        return "Tipo invalido";
     }

    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        return false;
    }


    @Override
    public String toString(){
        if(capturada) {
            return (id + " | " + idTipo + "/" + nomeTipoJoker() + " | 4 | " + idEquipa + " | " + alcunha + " @ (n/a)");
        }
        return (id + " | " + idTipo + "/" + nomeTipoJoker() + " | 4 | " + idEquipa + " | " + alcunha + " @ (" + posicao + ")");
    }
}
