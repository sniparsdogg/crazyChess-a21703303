package pt.ulusofona.lp2.crazyChess;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSimulador {
    @Test
    public void testeMovimento(){
        Simulador simuladorTeste = new Simulador();
        simuladorTeste.turno = 3;
        int equipaEsperada = 1;
        assertEquals(equipaEsperada, simuladorTeste.getIDEquipaAJogar(), "A equipa esperada era a 1!");
    }
}
