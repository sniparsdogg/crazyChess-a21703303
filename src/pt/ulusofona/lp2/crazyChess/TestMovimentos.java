package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;


public class TestMovimentos {
    File ficheiroTeste = new File("test-files/teste.txt");
    Simulador simuladorTeste = new Simulador();

    @Test
    public void testeMovimentarRainhaBranca(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        boolean comportamentoEsperado = true;
        boolean comportamentoObtido = simuladorTeste.processaJogada(0, 3, 0, 6);
        assertEquals("A rainha não conseguiu movimentar-se da posição 0,3 para a posição 0,6.", comportamentoEsperado, comportamentoObtido);
    }

    @Test
    public void testeMovimentarRainhaPreta(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        boolean comportamentoEsperado = false;
        boolean comportamentoObtido = simuladorTeste.processaJogada(6, 6, 4, 4);
        assertEquals("A rainha movimentou-se num turno cuja equipa ativa não era a sua.", comportamentoEsperado, comportamentoObtido);

    }

    @Test
    public void testeMovimentarTorreHBranca(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        boolean comportamentoEsperado = true;
        boolean comportamentoObtido = simuladorTeste.processaJogada(1, 1, 5, 1);
        assertEquals("A TorreH não conseguiu movimentar-se da posição 1,1 para a posição 6,6.", comportamentoEsperado, comportamentoObtido);
    }

    @Test
    public void testeMovimentarPadreVilaPertoRainha(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        boolean comportamentoEsperado = false;
        boolean comportamentoObtido = simuladorTeste.processaJogada(8,6,7,5);
        assertEquals("O Padre da Vila aproximou-se da Rainha", comportamentoEsperado, comportamentoObtido);
    }

    @Test
    public void testeMovimentarReiBranca(){
        try{
            simuladorTeste.iniciaJogo(ficheiroTeste);
        } catch (IOException e){
            System.out.println("Ocorreu um erro ao ler o ficheiro.");
        }
        boolean comportamentoEsperado = true;
        boolean comportamentoObtido = simuladorTeste.processaJogada(1,3,1,4);
        assertEquals("O Rei falhou em capturar a torreV na posição 1,4", comportamentoEsperado, comportamentoObtido);
    }
}
