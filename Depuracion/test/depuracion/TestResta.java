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
public class TestResta {
    private int operando1;
    private int operando2;
    private int resultadoEsperado;
    
    public TestResta(int operando1, int operando2, int resultado) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultadoEsperado = resultado;
    }
    
    @Parameters
    public static Collection<Object[]> datos(){
        return Arrays.asList(new Object[][] {
            {-1, 2, -3},
            {-1, 0, -1},
            {-2, -1, -1},
            {0 , 0, 0},
            {2, -100, 102}        
        });
    }
    
    @Test
    public void testRestaParametrizada(){
        System.out.println("Test resta op1: " + operando1+ " operando2: "+ operando2 );
        Calculadora calcu = new Calculadora(operando1, operando2);        
        
        int resultado = calcu.resta();
        assertEquals(resultadoEsperado, resultado);

    }
    
}
