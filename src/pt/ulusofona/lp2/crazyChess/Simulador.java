package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import static java.util.stream.Collectors.summingInt;

public class Simulador {

    int tamanho; // Tamanha do tabuleiro.
    ArrayList<CrazyPiece> pecas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasPretas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasBrancas = new ArrayList<CrazyPiece>();
    int turno;
    int turnosSemCapturas;
    Resultados resultados = new Resultados();
    File undo = new File("undo.txt");
    boolean capturaEfectuada;
    boolean temReiBranca;
    boolean temReiPreta;


   public Simulador(){

   }

   public void iniciaJogo(File ficheiroInicial) throws IOException, InvalidSimulatorInputException { // Função que inicia o jogo.
        try {
            pecas = new ArrayList<CrazyPiece>();
            pecasPretas = new ArrayList<CrazyPiece>();
            pecasBrancas = new ArrayList<CrazyPiece>();
            resultados = new Resultados();
            capturaEfectuada = false;
            temReiBranca = false;
            temReiPreta = false;
            Scanner scannerFicheiro = new Scanner(ficheiroInicial);
            String linha = scannerFicheiro.nextLine();
            String coluna[] = linha.split(":");
            if (coluna.length != 1) {
                throw new InvalidSimulatorInputException(1, coluna.length);
            } else {
                tamanho = Integer.parseInt(coluna[0]);
            }
            linha = scannerFicheiro.nextLine();
            String coluna2[] = linha.split(":");
            int pecasEmJogo;
            if (coluna2.length != 1) {
                throw new InvalidSimulatorInputException(2, coluna2.length);
            } else {
                pecasEmJogo = Integer.parseInt(coluna2[0]);
            }
            for (int i = 0; i < pecasEmJogo; i++) {
                linha = scannerFicheiro.nextLine();
                String coluna3[] = linha.split(":");
                if (coluna3.length != 4) {
                    throw new InvalidSimulatorInputException(i + 2, coluna3.length);
                } else {
                    switch (Integer.parseInt(coluna3[1])) {
                        case 0:
                            Rei rei = new Rei();
                            rei.setId(Integer.parseInt(coluna3[0]));
                            rei.setIdTipo(Integer.parseInt(coluna3[1]));
                            rei.setIdEquipa(Integer.parseInt(coluna3[2]));
                            rei.setAlcunha(coluna3[3]);
                            pecas.add(rei);
                            break;
                        case 1:
                            Rainha rainha = new Rainha();
                            rainha.setId(Integer.parseInt(coluna3[0]));
                            rainha.setIdTipo(Integer.parseInt(coluna3[1]));
                            rainha.setIdEquipa(Integer.parseInt(coluna3[2]));
                            rainha.setAlcunha(coluna3[3]);
                            pecas.add(rainha);
                            break;
                        case 2:
                            PoneiMagico ponei = new PoneiMagico();
                            ponei.setId(Integer.parseInt(coluna3[0]));
                            ponei.setIdTipo(Integer.parseInt(coluna3[1]));
                            ponei.setIdEquipa(Integer.parseInt(coluna3[2]));
                            ponei.setAlcunha(coluna3[3]);
                            pecas.add(ponei);
                            break;
                        case 3:
                            PadreVila padre = new PadreVila();
                            padre.setId(Integer.parseInt(coluna3[0]));
                            padre.setIdTipo(Integer.parseInt(coluna3[1]));
                            padre.setIdEquipa(Integer.parseInt(coluna3[2]));
                            padre.setAlcunha(coluna3[3]);
                            pecas.add(padre);
                            break;
                        case 4:
                            TorreHor torreh = new TorreHor();
                            torreh.setId(Integer.parseInt(coluna3[0]));
                            torreh.setIdTipo(Integer.parseInt(coluna3[1]));
                            torreh.setIdEquipa(Integer.parseInt(coluna3[2]));
                            torreh.setAlcunha(coluna3[3]);
                            pecas.add(torreh);
                            break;
                        case 5:
                            TorreVert torrev = new TorreVert();
                            torrev.setId(Integer.parseInt(coluna3[0]));
                            torrev.setIdTipo(Integer.parseInt(coluna3[1]));
                            torrev.setIdEquipa(Integer.parseInt(coluna3[2]));
                            torrev.setAlcunha(coluna3[3]);
                            pecas.add(torrev);
                            break;
                        case 6:
                            Lebre lebre = new Lebre();
                            lebre.setId(Integer.parseInt(coluna3[0]));
                            lebre.setIdTipo(Integer.parseInt(coluna3[1]));
                            lebre.setIdEquipa(Integer.parseInt(coluna3[2]));
                            lebre.setAlcunha(coluna3[3]);
                            pecas.add(lebre);
                            break;
                        case 7:
                            Joker joker = new Joker();
                            joker.setId(Integer.parseInt(coluna3[0]));
                            joker.setIdTipo(Integer.parseInt(coluna3[1]));
                            joker.setIdEquipa(Integer.parseInt(coluna3[2]));
                            joker.setAlcunha(coluna3[3]);
                            joker.setJoker();
                            pecas.add(joker);
                            break;
                        case 9:
                            RainhaMae rainhamae = new RainhaMae();
                            rainhamae.setId(Integer.parseInt(coluna3[0]));
                            rainhamae.setIdTipo(Integer.parseInt(coluna3[1]));
                            rainhamae.setIdEquipa(Integer.parseInt(coluna3[2]));
                            rainhamae.setAlcunha(coluna3[3]);
                            pecas.add(rainhamae);
                            break;
                    }


                }
            }
            for (int i = 0; i < tamanho; i++) {
                String linha2 = scannerFicheiro.nextLine();
                String coluna4[] = linha2.split(":");
                for (int j = 0; j < tamanho; j++) {
                    if (!(Integer.parseInt(coluna4[j]) == 0)) {
                        for (int k = 0; k < getPecasEmJogo().size(); k++) {
                            if (Integer.parseInt(coluna4[j]) == getPecasEmJogo().get(k).getId()) {
                                getPecasEmJogo().get(k).setPosicao(j, i);
                                if (getPecasEmJogo().get(k).getIdEquipa() == 10) {
                                    pecasPretas.add(getPecasEmJogo().get(k));
                                } else {
                                    pecasBrancas.add(getPecasEmJogo().get(k));
                                }
                            }
                        }
                    }
                }
            }

            turno = 0;
            turnosSemCapturas = 0;

            if (scannerFicheiro.hasNextLine()) {
                String linhaExtra = scannerFicheiro.nextLine();
                String coluna5[] = linhaExtra.split(":");
                turno += Integer.parseInt(coluna5[1]) + Integer.parseInt(coluna5[4]);
                resultados.setValidasPretas(Integer.parseInt(coluna5[1]));
                resultados.setCapturasPretas(Integer.parseInt(coluna5[2]));
                resultados.setInvalidasPretas(Integer.parseInt(coluna5[3]));
                resultados.setValidasBrancas(Integer.parseInt(coluna5[4]));
                resultados.setCapturasBrancas(Integer.parseInt(coluna5[5]));
                resultados.setInvalidasBrancas(Integer.parseInt(coluna5[6]));
                if(coluna5.length == 8){
                    turnosSemCapturas = Integer.parseInt(coluna5[7]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: o ficheiro " + ficheiroInicial + " não foi encontrado.");
            throw new IOException();
        } catch (IOException exception) {
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
    }

    public int getTamanhoTabuleiro(){
        return tamanho;
    } // Função que permite obter o tamanho do tabuleiro.

    public boolean processaJogada(int xO, int yO, int xD, int yD){

            for (int i = 0; i < getPecasEmJogo().size(); i++){
                if(getPecasEmJogo().get(i).posicao.x == xO && getPecasEmJogo().get(i).posicao.y == yO && getPecasEmJogo().get(i).getIdEquipa() == getIDEquipaAJogar()){
                            CrazyPiece pecaAJogar = getPecasEmJogo().get(i);
                            if(pecaAJogar.jogadaValida(xO, xD, yO, yD, this)){
                                gravarJogo(undo);
                                for (int j = 0; j < getPecasEmJogo().size(); j++) {
                                    CrazyPiece pecaJ = getPecasEmJogo().get(j);
                                        if (pecaJ.posicao.x == xD && pecaJ.posicao.y == yD && pecaJ.getIdEquipa() != getIDEquipaAJogar()) {
                                            if(getPecasEmJogo().get(j).getIdEquipa() == 10) {
                                                for(int k = 0; k < getPecasPretas().size(); k++){
                                                    if(pecaJ.getId() == (getPecasPretas().get(k).getId())){
                                                        getPecasPretas().remove(k);
                                                        resultados.somaCapturasBrancas();
                                                    }
                                                }
                                            }
                                            else {
                                                for(int k = 0; k < getPecasBrancas().size(); k++) {
                                                    if(getPecasEmJogo().get(j).getId() == (getPecasBrancas().get(k).getId())){
                                                        getPecasBrancas().remove(k);
                                                        resultados.somaCapturasPretas();
                                                    }
                                                }
                                            }
                                            pecaJ.setCapturada();
                                            turnosSemCapturas = 0;
                                            pecaAJogar.somaCapturas();
                                            pecaAJogar.somaPontos(pecaJ.getValorRelativo());
                                        }
                                    }
                                    if(getIDEquipaAJogar() == 10) {
                                        resultados.somaValidasPretas();
                                    } else {
                                        resultados.somaValidasBrancas();
                                    }
                                    pecaAJogar.somaMoveValidos();
                                    for(int k = 0; k < getPecasEmJogo().size();k++) {
                                        if(pecaAJogar.getId() == getPecasEmJogo().get(k).getId()) {
                                            getPecasEmJogo().get(k).setPosicao(xD, yD);
                                        }
                                    }
                                    turno++;
                                    if(!capturaEfectuada) {
                                        capturaEfectuada = true;
                                    }
                                    if(capturaEfectuada) {
                                        turnosSemCapturas++;
                                    }
                                    for(int count = 0; count < getPecasEmJogo().size(); count++){
                                        if(getPecasEmJogo().get(count).getJoker() == true){
                                            getPecasEmJogo().get(count).incrementaTipoJoker();
                                        }
                                    }

                                    return true;
                            }
                    pecaAJogar.somaMoveInvalidos();
                }

            }
        if(getIDEquipaAJogar() == 10) {
            resultados.somaInvalidasPretas();
        } else {
            resultados.somaInvalidasBrancas();
        }
        return false;
    }

    public List<CrazyPiece> getPecasEmJogo(){
        ArrayList<CrazyPiece> pecasEmJogo = new ArrayList<CrazyPiece>();
        for(int i = 0; i < pecas.size();i++) {
            if(!(pecas.get(i).getCapturada())) {
                pecasEmJogo.add(pecas.get(i));
            }
        }
        return pecasEmJogo;
    }

    public List<CrazyPiece> getPecasMalucas(){ // Devolve as peças.
        return pecas;
    }

    public List<CrazyPiece> getPecasBrancas(){
        return pecasBrancas;
    }

    public List<CrazyPiece> getPecasPretas(){
        return pecasPretas;
    }

    public boolean jogoTerminado() {  // Função que determina se o jogo terminou.
        temReiPreta = false;
        temReiBranca = false;
        if(getPecasBrancas().size() == 0 || getPecasPretas().size() == 0){
            return true;
        } else if (pecasPretas.size() == 1 && pecasBrancas.size() == 1) {
            return true;
        } else if (turnosSemCapturas >= 11 && capturaEfectuada == true){
            return true;
        }
        for(int i = 0; i < getPecasPretas().size(); i++){
            if(getPecasPretas().get(i).getIdTipo() == 0){
                temReiPreta = true;
            }
        }
        for(int i = 0; i < getPecasBrancas().size(); i++){
            if(getPecasBrancas().get(i).getIdTipo() == 0){
                temReiBranca = true;
            }
        }
        if(!temReiBranca || !temReiPreta){
            return true;
        }
        return false;
    }

    public List<String> getAutores(){
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("Augusto Gouveia - 21703303");
        return autores;
    }

    public void anularJogadaAnterior() {
            try {
                iniciaJogo(undo);
            } catch (IOException e){
                System.out.println("Ocorreu um erro ao ler o ficheiro.");
            }
    }

    public List<Comparable> obterSugestoesJogada(int xO, int yO){
        ArrayList<Comparable> sugestoes = new ArrayList<Comparable>();
        CrazyPiece pecaASugerir = null;
        for(int i = 0; i < getPecasEmJogo().size(); i++) {
            if(getPecasEmJogo().get(i).getPosicao().x == xO && getPecasEmJogo().get(i).getPosicao().y == yO){
                pecaASugerir = getPecasEmJogo().get(i);
            }
        }
        if(pecaASugerir == null || pecaASugerir.getIdEquipa() != getIDEquipaAJogar()) {
            return sugestoes;
        }
        for(int y = 0; y < getTamanhoTabuleiro(); y++){
            for(int x = 0; x < getTamanhoTabuleiro(); x++){
                if(pecaASugerir.jogadaValida(xO, x, yO, y, this)){
                    CrazyPiece existePeca = pecaNaPosicao(x,y);
                    if(existePeca == null) {
                        sugestoes.add(new Sugestao(x, y, 0));
                    } else {
                        sugestoes.add(new Sugestao(x, y, existePeca.getValorRelativo()));
                    }
                }
            }
        }
        Collections.sort(sugestoes);
        return sugestoes;
    }

    public CrazyPiece pecaNaPosicao(int posX, int posY){
        CrazyPiece pecaPosicao = null;
        for(int i = 0; i < getPecasEmJogo().size(); i++) {
            if(getPecasEmJogo().get(i).getPosicao().x == posX && getPecasEmJogo().get(i).getPosicao().y == posY){
                 pecaPosicao = getPecasEmJogo().get(i);
            }
        }
        return pecaPosicao;
    }

    public boolean gravarJogo (File ficheiroDestino) {
        String newLine = System.getProperty("line.separator");
        try {
            File output = new File(String.valueOf(ficheiroDestino));
            FileWriter writer = new FileWriter(output);

            writer.write(String.valueOf(this.getTamanhoTabuleiro()));
            System.out.println(this.getTamanhoTabuleiro());
            writer.write(newLine);
            writer.write(String.valueOf(this.getPecasEmJogo().size()));
            writer.write(newLine);

            int[][] tabuleiro = new int[getTamanhoTabuleiro()][getTamanhoTabuleiro()];
            for(int i = 0; i < getPecasEmJogo().size(); i++) {
                writer.write(String.valueOf(getPecasEmJogo().get(i).getId()));
                writer.write(":");
                if(getPecasEmJogo().get(i).getJoker()) {
                    writer.write("7");
                } else {
                    writer.write(String.valueOf(getPecasEmJogo().get(i).getIdTipo()));
                }
                writer.write(":");
                writer.write(String.valueOf(getPecasEmJogo().get(i).getIdEquipa()));
                writer.write(":");
                writer.write(String.valueOf(getPecasEmJogo().get(i).getAlcunha()));
                writer.write(newLine);
                tabuleiro[getPecasEmJogo().get(i).getPosicao().y][getPecasEmJogo().get(i).getPosicao().x] = getPecasEmJogo().get(i).getId();
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
            writer.write(":");
            writer.write(String.valueOf(turnosSemCapturas));

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
        } else if(!temReiBranca){
            resultadoFinal.add("Resultado: VENCERAM AS PRETAS");
        } else if (!temReiPreta){
            resultadoFinal.add("Resultado: VENCERAM AS BRANCAS");

        }
        resultadoFinal.add("---");
        resultadoFinal.add("Equipa das Pretas");
        resultadoFinal.add(" Capturas: " + Integer.toString(resultados.getCapturasPretas()));
        resultadoFinal.add(" Jogadas válidas: " + Integer.toString(resultados.getValidasPretas()));
        resultadoFinal.add(" Tentativas inválidas: " + String.valueOf(resultados.getInvalidasPretas()));
        resultadoFinal.add("Equipa das Brancas");
        resultadoFinal.add(" Capturas: " + String.valueOf(resultados.getCapturasBrancas()));
        resultadoFinal.add(" Jogadas válidas: " + String.valueOf(resultados.getValidasBrancas()));
        resultadoFinal.add(" Tentativas inválidas: " + String.valueOf(resultados.getInvalidasBrancas()));
        return resultadoFinal;

    }

    public List<String> top5Capturas() {
        List<String> query = new ArrayList<>();
        pecas.stream()
                .sorted((c1, c2) -> c1.getAlcunha().compareTo(c2.getAlcunha()))
                .sorted((p1, p2) -> p2.getCapturas() - p1.getCapturas())
                .limit(5)
                .forEach((p) -> query.add(p.getIdEquipa() + ":" + p.getAlcunha() + ":" + p.getPontos() + ":" + p.getCapturas()));
        return query;
    }

    public List<String> top5Pontos(){
        List<String> query = new ArrayList<>();
        pecas.stream()
                .sorted((c1, c2) -> c1.getAlcunha().compareTo(c2.getAlcunha()))
                .sorted((p1, p2) -> p2.getPontos() - p1.getPontos())
                .limit(5)
                .forEach((p) -> query.add(p.getIdEquipa() + ":" + p.getAlcunha() + ":" + p.getPontos() + ":" + p.getCapturas()));
        return query;
    }

    public List<String> pecasMais5Capturas(){
        List<String> query = new ArrayList<>();
        pecas.stream()
                .filter((p) -> p.getCapturas() >= 5)
                .sorted((p1, p2) -> p2.getCapturas() - p1.getCapturas())
                .forEach((p) -> query.add(p.getIdEquipa() + ":" + p.getAlcunha() + ":" + p.getPontos() + ":" + p.getCapturas()));
        return query;
    }

    public List<String> pecasMaisBaralhadas(){
        List<String> query = new ArrayList<>();
        pecas.stream()
                .sorted(Comparator.comparingDouble(CrazyPiece::getRacioMoves))
                .limit(3)
                .forEach((p) -> query.add(p.getIdEquipa() + ":" + p.getAlcunha() + ":" + p.getPontos() + ":" + p.getCapturas()));
        return query;
    }

    public List<String> tiposPecaCapturados(){
        List<String> query = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            int count = i;
            int somaCapturas = pecas.stream()
                    .filter((p) -> p.getIdTipo() == count)
                    .collect(summingInt(CrazyPiece::getCapturas));
            if(somaCapturas != 0){
                query.add(i + ":" + String.valueOf(somaCapturas));
            }
        }
        return query;
    }

    public List<String> segundasEscolhas(){
        List<String> query = new ArrayList<>();
        pecas.stream()
                .filter((p) -> p.moveValidos == 0)
                .sorted((p1,p2) -> p1.getAlcunha().compareTo(p2.getAlcunha()))
                .forEach((p) -> query.add(p.getIdEquipa() + ":" + p.getId() + ":" + p.getAlcunha()));
        return query;
    }

    public List<String> mostValuableCrazyPiece(){
        List<String> query = new ArrayList<>();
        pecas.stream()
                .filter((p) -> p.getCapturas() != 0)
                .sorted((p1, p2) -> Double.compare(p2.getRacioPontos(), p1.getRacioPontos()))
                .limit(3)
                .forEach((p) -> query.add(p.getIdEquipa() + ":" + p.getId() + ":" + p.getAlcunha() + ":" + p.getPontos() + ":" + p.getCapturas()));
        return query;
    }




    public Map<String,List<String>> getEstatisticas() {
        HashMap<String, List<String>> estatisticas = new HashMap<>();
        estatisticas.put("top5Capturas", top5Capturas());
        estatisticas.put("top5Pontos", top5Pontos());
        estatisticas.put("pecasMais5Capturas", pecasMais5Capturas());
        estatisticas.put("3PecasMaisBaralhadas",pecasMaisBaralhadas());
        estatisticas.put("tiposPecaCapturados", tiposPecaCapturados());
        estatisticas.put("segundas-escolhas", segundasEscolhas());
        estatisticas.put("most-valuable-crazy-piece", mostValuableCrazyPiece());
        return estatisticas;
    }



    public int getIDPeca (int x, int y){ // Obtém o ID da peça nas coordenadas dadas.
        for (int i = 0; i < getPecasEmJogo().size(); i++){
            if(getPecasEmJogo().get(i).posicao.x == x && getPecasEmJogo().get(i).posicao.y == y){
                return getPecasEmJogo().get(i).getId();
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
