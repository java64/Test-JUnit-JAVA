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

/**
 *
 * @author usuario
 */

@RunWith(Parameterized.class)
public class TestProducto {

    private int nume1;
    private int nume2;
    private int resulEsperado;

    public TestProducto(int nume1, int nume2, int resulEsperado) {
        this.nume1 = nume1;
        this.nume2 = nume2;
        this.resulEsperado = resulEsperado; // Resultado de la operación
    }

    @Parameterized.Parameters
    public static Collection<Object[]> numeros() {
        return Arrays.asList(new Object[][]{
            {20, 10, 200}, 
            {0, 0, 0}, 
            {-2, -2, 4},
            {-2, 1, -2},
            {0, -2, 0},            
            {5, 2, 10}
        });
    }

    @Test
    public void testProducto() {
        System.out.println("Test producto op1: " + nume1+ " operando2: "+ nume2 );
        Calculadora calcu = new Calculadora(nume1, nume2);
        int resultado = calcu.multiplica();
        assertEquals(resulEsperado, resultado);
    }
}
