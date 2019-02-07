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
public class FraccionPotenciaTest {
    Fraccion a;
    int exponente;
    Fraccion resultadoEsperado; 
    
    public FraccionPotenciaTest(Fraccion a, int exponente, Fraccion resultadoEsperado) {
        this.a = a;
        this.exponente = exponente;
        this.resultadoEsperado = resultadoEsperado;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> datos(){
        int[] datosA = {2,3,7};        
        int[] datosB = {1,2,6};        
        int[] datosResult = {1, 2, 3, 6, 7};        
        
        Conjunto A = new Conjunto();
        Conjunto B = new Conjunto();
        Conjunto C = new Conjunto();
        
        for(int dato: datosA){
            A.añadir(dato);
        }
        
        for(int dato: datosB){
            B.añadir(dato);
        }
        
        for(int dato: datosResult){
            C.añadir(dato);
        }
       
        return (Arrays.asList(new Object[][] {
            {new Conjunto(new int[]{2,3,7}), new Conjunto(new int[]{1,2,6}), new Conjunto(new int[]{1,2,3,6,7})},
            {new Conjunto(new int[]{2,3,7}), new Conjunto(new int[]{1,2,6}), new Conjunto(new int[]{1,2,3,6,7})}
            /*
            {new Fraccion(2,3), 2, new Fraccion(4/9)},
            {new Fraccion(2,3), 1, new Fraccion(2/3)},
            {new Fraccion(1,2), 3, new Fraccion(1,8)}                
*/
        }));
    }
    
    @Test    
    public void testPotenciaParametrizado() {
        System.out.println(" Test prueba Potencia de a: "+a+" y b:"+ exponente + " es "+ resultadoEsperado);
        Fraccion resultado = Fraccion.potencia(a, exponente);        
        
        assertEquals(resultadoEsperado, resultado);        
    }

}
