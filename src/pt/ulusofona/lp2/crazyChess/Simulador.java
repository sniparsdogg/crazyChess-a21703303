package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {

    int tamanho; // Tamanha do tabuleiro.
    ArrayList<CrazyPiece> pecas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasPretas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasBrancas = new ArrayList<CrazyPiece>();
    int turno;
    int turnosSemCapturas;
    Resultados resultados = new Resultados();


   public Simulador(){

   }
   public boolean iniciaJogo(File ficheiroInicial){ // Função que inicia o jogo.
        try {
            Scanner scannerFicheiro = new Scanner(ficheiroInicial);
            tamanho = Integer.parseInt(scannerFicheiro.nextLine());
            int pecasEmJogo = Integer.parseInt(scannerFicheiro.nextLine());
            for (int i = 0; i < pecasEmJogo; i++) {
                String linha = scannerFicheiro.nextLine();
                String coluna[] = linha.split(":");
                if (coluna.length == 4) {
                    CrazyPiece peca = new CrazyPiece();
                    peca.setId(Integer.parseInt(coluna[0]));
                    peca.setIdTipo(Integer.parseInt(coluna[1]));
                    peca.setIdEquipa(Integer.parseInt(coluna[2]));
                    peca.setAlcunha(coluna[3]);
                    pecas.add(peca);
                    if(peca.idEquipa == 0) {
                        pecasPretas.add(peca);
                    } else {
                        pecasBrancas.add(peca);
                    }
                }
            }
            for(int i = 0; i < tamanho; i++) {
                String linha = scannerFicheiro.nextLine();
                String coluna[] = linha.split(":");
                for(int j = 0; j < tamanho; j++) {
                    if(!(Integer.parseInt(coluna[j]) == 0)){
                        for(int k = 0; k < getPecasMalucas().size(); k++) {
                            if (Integer.parseInt(coluna[j]) == getPecasMalucas().get(k).getId()) {
                                getPecasMalucas().get(k).setPosicao(j, i);
                            }
                        }
                    }
                }
            }
            turno = 0;
            turnosSemCapturas = 0;
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: o ficheiro " + ficheiroInicial + " não foi encontrado.");
            return false;
        }
        return true;
    }

    public int getTamanhoTabuleiro(){
        return tamanho;
    } // Função que permite obter o tamanho do tabuleiro.

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        if((xD == xO || xD == xO+1 || xD == xO - 1) && (yD == yO || yD == yO+1 || yD == yO-1)) {
            for (int i = 0; i < getPecasMalucas().size(); i++){
                if(getPecasMalucas().get(i).posicao.x == xO && getPecasMalucas().get(i).posicao.y == yO && getPecasMalucas().get(i).getIdEquipa() == getIDEquipaAJogar()){
                        if (xD == xO && yD == yO) {
                            return false;
                        } else {
                            CrazyPiece pecaAJogar = getPecasMalucas().get(i);
                            for (int j = 0; j < getPecasMalucas().size(); j++) {
                                if (getPecasMalucas().get(j).posicao.x == xD && getPecasMalucas().get(j).posicao.y == yD && getPecasMalucas().get(j).getIdEquipa() != getIDEquipaAJogar()) {
                                    if(getPecasMalucas().get(j).getIdEquipa() == 0) {
                                        for(int k = 0; k < getPecasPretas().size(); k++){
                                            if(getPecasMalucas().get(j).getAlcunha().equals(getPecasPretas().get(k).getAlcunha())){
                                                getPecasPretas().remove(k);
                                                resultados.somaCapturasBrancas();
                                            }
                                        }
                                    }
                                    else {
                                        for(int k = 0; k < getPecasBrancas().size(); k ++) {
                                            if(getPecasMalucas().get(j).getAlcunha().equals(getPecasBrancas().get(k).getAlcunha())){
                                                getPecasBrancas().remove(k);
                                                resultados.somaCapturasPretas();
                                            }
                                        }
                                    }
                                    getPecasMalucas().get(j).setCapturada();
                                    turnosSemCapturas = 0;
                                }
                            }
                            if(getIDEquipaAJogar() == 0) {
                                resultados.somaValidasPretas();
                            } else {
                                resultados.somaValidasBrancas();
                            }
                            for(int k = 0; k < getPecasMalucas().size();k++) {
                                if(pecaAJogar.getId() == getPecasMalucas().get(k).getId()) {
                                    getPecasMalucas().get(k).setPosicao(xD, yD);
                                }
                            }
                            turno++;
                            turnosSemCapturas++;
                            return true;
                        }
                    }
            }
        }
        if(getIDEquipaAJogar() == 0) {
            resultados.somaInvalidasPretas();
        } else {
            resultados.somaInvalidasBrancas();
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){ // Devolve as peças.
        ArrayList<CrazyPiece> pecasEmJogo = new ArrayList<CrazyPiece>();
        for(int i = 0; i < pecas.size();i++) {
            if(!(pecas.get(i).capturada)) {
                pecasEmJogo.add(pecas.get(i));
            }
        }
        return pecasEmJogo;
    }

    public List<CrazyPiece> getPecasBrancas(){
        return pecasBrancas;
    }

    public List<CrazyPiece> getPecasPretas(){
        return pecasPretas;
    }

    public boolean jogoTerminado() {  // Função que determina se o jogo terminou.
        if(getPecasBrancas().size() == 0 || getPecasPretas().size() == 0){
            return true;
        } else if (pecasPretas.size() == 1 && pecasBrancas.size() == 1) {
            return true;
        } else if (turnosSemCapturas == 11){
            return true;
        }
        return false;
    }

    public List<String> getAutores(){
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("Augusto Gouveia - 21703303");
        autores.add("Renato Cruz - 21705487");
        return autores;
    }

    public List<String> getResultados(){
        ArrayList<String> resultadoFinal = new ArrayList<String>();
        resultadoFinal.add("JOGO DE CRAZY CHESS");
        if(getPecasPretas().size() == getPecasBrancas().size() || turnosSemCapturas == 11 ) {
            resultadoFinal.add("Resultado: EMPATE");
        } else if(getPecasPretas().size() > getPecasBrancas().size()){
            resultadoFinal.add("Resultado: VENCERAM AS PRETAS");
        } else if (getPecasPretas().size() < getPecasBrancas().size()){
            resultadoFinal.add("Resultado: VENCERAM AS BRANCAS");

        }
        resultadoFinal.add("---");
        resultadoFinal.add("Equipa das Pretas");
        resultadoFinal.add(Integer.toString(resultados.getCapturasPretas()));
        resultadoFinal.add(Integer.toString(resultados.getValidasPretas()));
        resultadoFinal.add(String.valueOf(resultados.getInvalidasPretas()));
        resultadoFinal.add("Equipa das Brancas");
        resultadoFinal.add(String.valueOf(resultados.getCapturasBrancas()));
        resultadoFinal.add(String.valueOf(resultados.getValidasBrancas()));
        resultadoFinal.add(String.valueOf(resultados.getInvalidasBrancas()));
        return resultadoFinal;

    }

    public int getIDPeca (int x, int y){ // Obtém o ID da peça nas coordenadas dadas.
        for (int i = 0; i < getPecasMalucas().size(); i++){
            if(getPecasMalucas().get(i).posicao.x == x && getPecasMalucas().get(i).posicao.y == y){
                return getPecasMalucas().get(i).getId();
            }
        }

        return 0;
    }

    public int getIDEquipaAJogar() { // Função que retorna qual é a equipa a jogar.
        if(turno % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
