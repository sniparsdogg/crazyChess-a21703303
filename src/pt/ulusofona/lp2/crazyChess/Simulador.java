package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    File undo = new File("undo.txt");


   public Simulador(){

   }

   public boolean iniciaJogo(File ficheiroInicial){ // Função que inicia o jogo.
        try {
            pecas = new ArrayList<CrazyPiece>();
            pecasPretas = new ArrayList<CrazyPiece>();
            pecasBrancas = new ArrayList<CrazyPiece>();
            resultados = new Resultados();
            Scanner scannerFicheiro = new Scanner(ficheiroInicial);
            tamanho = Integer.parseInt(scannerFicheiro.nextLine());
            int pecasEmJogo = Integer.parseInt(scannerFicheiro.nextLine());
            for (int i = 0; i < pecasEmJogo; i++) {
                String linha = scannerFicheiro.nextLine();
                String coluna[] = linha.split(":");
                if (coluna.length == 4) {
                    switch(Integer.parseInt(coluna[1])){
                        case 0:
                            Rei rei = new Rei();
                            rei.setId(Integer.parseInt(coluna[0]));
                            rei.setIdTipo(Integer.parseInt(coluna[1]));
                            rei.setIdEquipa(Integer.parseInt(coluna[2]));
                            rei.setAlcunha(coluna[3]);
                            pecas.add(rei);
                            break;
                        case 1:
                            Rainha rainha = new Rainha();
                            rainha.setId(Integer.parseInt(coluna[0]));
                            rainha.setIdTipo(Integer.parseInt(coluna[1]));
                            rainha.setIdEquipa(Integer.parseInt(coluna[2]));
                            rainha.setAlcunha(coluna[3]);
                            pecas.add(rainha);
                            break;
                        case 2:
                            PoneiMagico ponei = new PoneiMagico();
                            ponei.setId(Integer.parseInt(coluna[0]));
                            ponei.setIdTipo(Integer.parseInt(coluna[1]));
                            ponei.setIdEquipa(Integer.parseInt(coluna[2]));
                            ponei.setAlcunha(coluna[3]);
                            pecas.add(ponei);
                            break;
                        case 3:
                            PadreVila padre = new PadreVila();
                            padre.setId(Integer.parseInt(coluna[0]));
                            padre.setIdTipo(Integer.parseInt(coluna[1]));
                            padre.setIdEquipa(Integer.parseInt(coluna[2]));
                            padre.setAlcunha(coluna[3]);
                            pecas.add(padre);
                            break;
                        case 4:
                            TorreHor torreh = new TorreHor();
                            torreh.setId(Integer.parseInt(coluna[0]));
                            torreh.setIdTipo(Integer.parseInt(coluna[1]));
                            torreh.setIdEquipa(Integer.parseInt(coluna[2]));
                            torreh.setAlcunha(coluna[3]);
                            pecas.add(torreh);
                            break;
                        case 5:
                            TorreVert torrev = new TorreVert();
                            torrev.setId(Integer.parseInt(coluna[0]));
                            torrev.setIdTipo(Integer.parseInt(coluna[1]));
                            torrev.setIdEquipa(Integer.parseInt(coluna[2]));
                            torrev.setAlcunha(coluna[3]);
                            pecas.add(torrev);
                            break;
                        case 6:
                            Lebre lebre = new Lebre();
                            lebre.setId(Integer.parseInt(coluna[0]));
                            lebre.setIdTipo(Integer.parseInt(coluna[1]));
                            lebre.setIdEquipa(Integer.parseInt(coluna[2]));
                            lebre.setAlcunha(coluna[3]);
                            pecas.add(lebre);
                            break;
                        case 7:
                            Joker joker = new Joker();
                            joker.setId(Integer.parseInt(coluna[0]));
                            joker.setIdTipo(Integer.parseInt(coluna[1]));
                            joker.setIdEquipa(Integer.parseInt(coluna[2]));
                            joker.setAlcunha(coluna[3]);
                            pecas.add(joker);
                            break;
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
                                if(getPecasMalucas().get(k).getIdEquipa() == 10) {
                                    pecasPretas.add(getPecasMalucas().get(k));
                                } else {
                                    pecasBrancas.add(getPecasMalucas().get(k));
                                }
                            }
                        }
                    }
                }
            }

            turno = 0;
            turnosSemCapturas = 0;

            if(scannerFicheiro.hasNextLine()){
                String linhaExtra = scannerFicheiro.nextLine();
                String coluna[] = linhaExtra.split(":");
                turno += Integer.parseInt(coluna[1]) + Integer.parseInt(coluna[4]);
                resultados.setValidasPretas(Integer.parseInt(coluna[1]));
                resultados.setCapturasPretas(Integer.parseInt(coluna[2]));
                resultados.setInvalidasPretas(Integer.parseInt(coluna[3]));
                resultados.setValidasBrancas(Integer.parseInt(coluna[4]));
                resultados.setCapturasBrancas(Integer.parseInt(coluna[5]));
                resultados.setInvalidasBrancas(Integer.parseInt(coluna[6]));
            }

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

            for (int i = 0; i < getPecasMalucas().size(); i++){
                if(getPecasMalucas().get(i).posicao.x == xO && getPecasMalucas().get(i).posicao.y == yO && getPecasMalucas().get(i).getIdEquipa() == getIDEquipaAJogar()){
                            CrazyPiece pecaAJogar = getPecasMalucas().get(i);
                            if(pecaAJogar.jogadaValida(xO, xD, yO, yD, this)){
                                gravarJogo(undo);
                                for (int j = 0; j < getPecasMalucas().size(); j++) {
                                        if (getPecasMalucas().get(j).posicao.x == xD && getPecasMalucas().get(j).posicao.y == yD && getPecasMalucas().get(j).getIdEquipa() != getIDEquipaAJogar()) {
                                            if(getPecasMalucas().get(j).getIdEquipa() == 10) {
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
                                    if(getIDEquipaAJogar() == 10) {
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
        if(getIDEquipaAJogar() == 10) {
            resultados.somaInvalidasPretas();
        } else {
            resultados.somaInvalidasBrancas();
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){ // Devolve as peças.
        ArrayList<CrazyPiece> pecasEmJogo = new ArrayList<CrazyPiece>();
        for(int i = 0; i < pecas.size();i++) {
            if(!(pecas.get(i).getCapturada())) {
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
        return autores;
    }

    public void anularJogadaAnterior(){
        iniciaJogo(undo);
    }

    public List<String> obterSugestoesJogada(int xO, int yO){
        ArrayList<String> sugestoes = new ArrayList<String>();
        CrazyPiece pecaASugerir = null;
        for(int i = 0; i < getPecasMalucas().size(); i++) {
            if(getPecasMalucas().get(i).getPosicao().x == xO && getPecasMalucas().get(i).getPosicao().y == yO){
                pecaASugerir = getPecasMalucas().get(i);
            }
        }
        if(pecaASugerir == null || pecaASugerir.getIdEquipa() != getIDEquipaAJogar()) {
            sugestoes.add("Pedido inválido.");
            return sugestoes;
        }
        for(int y = 0; y < getTamanhoTabuleiro(); y++){
            for(int x = 0; x < getTamanhoTabuleiro(); x++){
                if(pecaASugerir.jogadaValida(xO, x, yO, y, this)){
                    sugestoes.add(x + ", " + y);
                }
            }
        }
        return sugestoes;
    }

    public CrazyPiece pecaNaPosicao(int posX, int posY){
        CrazyPiece pecaPosicao = null;
        for(int i = 0; i < getPecasMalucas().size(); i++) {
            if(getPecasMalucas().get(i).getPosicao().x == posX && getPecasMalucas().get(i).getPosicao().y == posY){
                 pecaPosicao = getPecasMalucas().get(i);
            }
        }
    }

    public boolean gravarJogo (File ficheiroDestino) {
        String newLine = System.getProperty("line.separator");
        try {
            File output = new File(String.valueOf(ficheiroDestino));
            FileWriter writer = new FileWriter(output);

            writer.write(String.valueOf(this.getTamanhoTabuleiro()));
            System.out.println(this.getTamanhoTabuleiro());
            writer.write(newLine);
            writer.write(String.valueOf(this.getPecasMalucas().size()));
            writer.write(newLine);

            int[][] tabuleiro = new int[getTamanhoTabuleiro()][getTamanhoTabuleiro()];
            for(int i = 0; i < getPecasMalucas().size(); i++) {
                writer.write(String.valueOf(getPecasMalucas().get(i).getId()));
                writer.write(":");
                writer.write(String.valueOf(getPecasMalucas().get(i).getIdTipo()));
                writer.write(":");
                writer.write(String.valueOf(getPecasMalucas().get(i).getIdEquipa()));
                writer.write(":");
                writer.write(String.valueOf(getPecasMalucas().get(i).getAlcunha()));
                writer.write(newLine);
                tabuleiro[getPecasMalucas().get(i).getPosicao().y][getPecasMalucas().get(i).getPosicao().x] = getPecasMalucas().get(i).getId();
            }

            for(int i = 0; i < getTamanhoTabuleiro(); i++) {
                for(int j = 0; j < getTamanhoTabuleiro(); j++) {
                    writer.write(String.valueOf(tabuleiro[i][j]));
                    if(j != getTamanhoTabuleiro()-1) {
                        writer.write(":");
                    }
                }
                writer.write(newLine);
            }

            writer.write(String.valueOf(getIDEquipaAJogar()));
            writer.write(":");
            writer.write(String.valueOf(resultados.getValidasPretas()));
            writer.write(":");
            writer.write(String.valueOf(resultados.getCapturasPretas()));
            writer.write(":");
            writer.write(String.valueOf(resultados.getInvalidasPretas()));
            writer.write(":");
            writer.write(String.valueOf(resultados.getValidasBrancas()));
            writer.write(":");
            writer.write(String.valueOf(resultados.getCapturasBrancas()));
            writer.write(":");
            writer.write(String.valueOf(resultados.getInvalidasBrancas()));

            writer.close();
        }
        catch(IOException e) {
            System.out.println("Ocorreu um erro ao abrir o ficheiro.");
            return false;
        }
        return true;
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
            return 10;
        } else {
            return 20;
        }
    }
}
