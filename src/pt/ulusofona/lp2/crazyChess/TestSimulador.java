package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;


public class TestSimulador {
    @Test
    public void testeMovimento(){
        Simulador simuladorTeste = new Simulador();
        simuladorTeste.turno = 3;
        int equipaEsperada = 1;
        assertEquals(equipaEsperada, simuladorTeste.getIDEquipaAJogar());
    }
}
