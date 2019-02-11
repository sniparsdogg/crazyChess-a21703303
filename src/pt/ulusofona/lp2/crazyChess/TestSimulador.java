package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestSimulador { // Teste de funções do simulador.
    File ficheiroTeste = new File("test-files/teste.txt");
    Simulador simuladorTeste = new Simulador();
    @Test
    public void testeEquipaAJogar(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        int equipaEsperada = 20;
        assertEquals("Equipa incorreta! Expected: " + equipaEsperada + " but got: " + simuladorTeste.getIDEquipaAJogar(), equipaEsperada, simuladorTeste.getIDEquipaAJogar());
    }

    @Test
    public void testePecasEmJogo(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        int numPecasEsperadas = 14;
        assertEquals("Numero de pecas diferente das esperadas! Expected: " + numPecasEsperadas + "but got: " + simuladorTeste.getPecasEmJogo().size(), numPecasEsperadas, simuladorTeste.getPecasEmJogo().size());
    }

    @Test
    public void testeJogoTerminado(){
        try {
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        boolean jogoTerminadoEsperado = false;
        assertEquals("Jogo terminou antes do esperado! Expected: " + jogoTerminadoEsperado + "but got: " + simuladorTeste.jogoTerminado(), jogoTerminadoEsperado, simuladorTeste.jogoTerminado());
    }

    @Test
    public void testeGetAutores(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        List<String> autoresEsperados = new ArrayList<String>();
        autoresEsperados.add("Augusto Gouveia - 21703303");
        assertEquals("Autores incorretos! Expected: " + autoresEsperados + "but got: " + simuladorTeste.getAutores(), autoresEsperados, simuladorTeste.getAutores());
    }

    @Test
    public void testeGetTamanhoTabuleiro(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        int tabuleiroEsperado = 12;
        assertEquals("Tamanho do tabuleiro incorreto! Expected: " + tabuleiroEsperado + "but got: " + simuladorTeste.getTamanhoTabuleiro(), tabuleiroEsperado, simuladorTeste.getTamanhoTabuleiro());
    }
}
