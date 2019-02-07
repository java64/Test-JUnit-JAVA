/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depuracion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author usuario
 */
public class CalculadoraTest {

    private  Calculadora calcu;
    private int resultado;
    //Calculadora calcu;
    int a = 20;
    int b = 10;

    public CalculadoraTest() {

    }
/*
    @BeforeClass
    public static void creaCalculadora() {
        calcu = new Calculadora(a, b);
        System.out.println("Esto es lo primero");
    }

    @AfterClass
    public static void borraCalculadora() {
        calcu = null;
        System.out.println("Esto es lo último");
    }
   */ 

    @Before
    public void creaCalculadora2() {
        calcu = new Calculadora(a, b);
        System.out.println("Hola soy before");
    }   

    @After
    public void borraCalculadora2() {
        calcu = null;
        System.out.println("Adios soy after");
    }

    /**
     * Test of suma method, of class Calculadora.
     */
    @Test
    public void testSuma() {
        System.out.println("Probando la suma de " + a + " y " + b);
        //Calculadora calcu = new Calculadora(2,3);
        int expResult = 30;
        int result = calcu.suma();
        assertEquals(expResult, result);
    }

    @Test
    public void testSumaNegativos() {
        System.out.println("Probando la suma de negativos");
        calcu = new Calculadora(-1, -4);
        int expResult = -5;
        int result = calcu.suma();
        assertEquals(expResult, result);
    }

    /**
     * Test of resta method, of class Calculadora.
     */
    @Test
    public void testResta() {

        System.out.println("Test resta de " + a + " y " + b);
        //Calculadora calcu = new Calculadora(a, b);
        int expResult = 10;
        int result = calcu.resta();
        assertEquals(expResult, result);

    }

    /**
     * Test of multiplica method, of class Calculadora.
     */
    @Test
    public void testMultiplica() {
        System.out.println("Test multiplica de " + a + " y " + b);
        //Calculadora calcu = new Calculadora(2, 3);
        int expResult = 200;
        int result = calcu.multiplica();
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class Calculadora.
     */
    @Test
    public void testDivide() {
        System.out.println("Test de la division de " + a + " / " + b);
        //Calculadora calcu = new Calculadora(6, 3);
        int expResult = 2;
        int result = calcu.divide();
        assertEquals("Hubo un error", expResult, result);

    }

    /**
     * Prueba de excepciones
     */
    @Test(expected = java.lang.ArithmeticException.class)
    public void testExcepcionDivide0() {
        calcu = new Calculadora(20, 0);
        calcu.divide();
        fail("Fallo, debería haber lanzado la excepción");

    }
    
    @Test
    public void testExcepcion() {
        try {
            calcu = new Calculadora(20, 0);
            resultado = calcu.divide();
            fail("Fallo, debería haber lanzado la excepción");
        } catch (ArithmeticException e) {
            //Prueba satisfactoria
        }
    }



}
