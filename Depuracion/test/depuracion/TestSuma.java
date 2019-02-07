/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depuracion;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author usuario
 */
@RunWith(Parameterized.class)
public class TestSuma {

    private int nume1;
    private int nume2;
    private int resulEsperado;

    public TestSuma(int nume1, int nume2, int resulEsperado) {
        this.nume1 = nume1;
        this.nume2 = nume2;
        this.resulEsperado = resulEsperado; // Resultado de la operación
    }

    @Parameters
    public static Collection<Object[]> numeros() {
        return Arrays.asList(new Object[][]{
            {20, 10, 30}, 
            {0, 0, 0}, 
            {-2, -2, -4},
            {-2, 1, -1},
            {0, -2, -2},            
            {5, 2, 7}
        });
    }

    @Test
    public void testSuma() {
        System.out.println("suma");
        Calculadora calcu = new Calculadora(nume1, nume2);
        int resultado = calcu.suma();
        assertEquals(resulEsperado, resultado);
    }
}

