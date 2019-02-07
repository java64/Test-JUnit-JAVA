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
public class FraccionMultiplicacionTest {
    Fraccion a;
    Fraccion b;
    Fraccion resultadoEsperado; 
    
    public FraccionMultiplicacionTest(Fraccion a, Fraccion b, Fraccion result) {        
        this.a = a;
        this.b = b;
        this.resultadoEsperado = result;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> datos(){
        return (Arrays.asList(new Object[][] {
            {new Fraccion(2,3), new Fraccion(4,5), new Fraccion(3/15)},
            
            {new Fraccion(1,2), new Fraccion(1,3), new Fraccion(5,6)}                
        }));
    }
    
    @Test    
    public void testMultiplicacionParametrizado() {
        Fraccion resultado = Fraccion.multiplicar(a, b).simplificar();
        System.out.println(" Test prueba multiplicación de a: "+a+" y b:"+ b + " es "+ resultadoEsperado);
        
        assertEquals(resultadoEsperado, resultado);        
    }
}
