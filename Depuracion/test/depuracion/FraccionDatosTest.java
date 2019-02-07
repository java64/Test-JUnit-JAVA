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
public class FraccionDatosTest {
    private String dato;
    private Fraccion resultExpect;
    
    public FraccionDatosTest(String a, Fraccion esperado) {
        dato = a;
        resultExpect = esperado;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> datos(){
        return (Arrays.asList(new Object[][] {
            {"2/3", new Fraccion(2/3)},
            {"3/13", new Fraccion(3/13)},
            {"-1/3", new Fraccion(-1/3)}            
        }));
    }
    
    @Test    
    public void testDatosParametrizado() {
        System.out.println(" Test prueba datos de a: "+dato+" es "+ resultExpect);
        Fraccion resultado = Fraccion.datos(dato);        
        
        assertEquals(resultExpect, resultado);        
    }


}
