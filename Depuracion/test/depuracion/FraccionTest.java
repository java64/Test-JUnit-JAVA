/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depuracion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class FraccionTest {
    
    public FraccionTest() {
    }

    /**
     * Test of getNumerador method, of class Fraccion.
     */
    @Test
    public void testGetNumerador() {
        System.out.println("getNumerador");
        Fraccion fraccion = new Fraccion(2, 3);
        int expResult = 2;
        int result = fraccion.getNumerador();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getDenominador method, of class Fraccion.
     */
    @Test
    public void testGetDenominador() {
        System.out.println("getDenominador");
        Fraccion fraccion = new Fraccion(2, 3);
        int expResult = 3;
        int result = fraccion.getDenominador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumerador method, of class Fraccion.
     */
    @Test
    public void testSetNumerador() {
        System.out.println("setNumerador");
        int numerador = 0;
        Fraccion fraccion = new Fraccion(5, 3);
        fraccion.setNumerador(4);
        int expResult = 4;
        int result = fraccion.getNumerador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDenominador method, of class Fraccion.
     */
    @Test
    public void testSetDenominador() {
        System.out.println("setDenominador");        
        Fraccion fraccion = new Fraccion(5, 3);
        int denominador = 5;
        fraccion.setDenominador(denominador);
        int expResult = denominador;
        int result = fraccion.getDenominador();
        assertEquals(expResult, result);
    }

    /**
     * Test of datos method, of class Fraccion.
     */
    @Test
    public void testDatos() {
        System.out.println("datos");
        String fraccionDato = "3/4";
        Fraccion expResult = new Fraccion(3,4);
        Fraccion result = Fraccion.datos(fraccionDato);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumar method, of class Fraccion.
     */
    @Test
    public void testSumar() {
        System.out.println("sumar");
        Fraccion a = new Fraccion(3, 5);
        Fraccion b = new Fraccion(1, 6);
        Fraccion expResult = new Fraccion(23, 30);
        Fraccion result = Fraccion.sumar(a, b);
        assertEquals(expResult, result);        
    }

    /**
     * Test of restar method, of class Fraccion.
     */
    @Test
    public void testRestar() {
        System.out.println("restar");        
        Fraccion a = new Fraccion(3, 5);
        Fraccion b = new Fraccion(1, 6);
        Fraccion expResult = new Fraccion(13, 30);
        Fraccion result = Fraccion.restar(a, b);
        assertEquals(expResult, result);    
    }

    /**
     * Test of multiplicar method, of class Fraccion.
     */
    @Test
    public void testMultiplicar() {
        System.out.println("multiplicar");
        Fraccion a = new Fraccion(3, 5);
        Fraccion b = new Fraccion(1, 6);
        Fraccion expResult = new Fraccion(1, 10);
        Fraccion result = Fraccion.multiplicar(a, b).simplificar();
        assertEquals(expResult, result);    
    }

    /**
     * Test of inversa method, of class Fraccion.
     */
    @Test
    public void testInversa() {
        System.out.println("inversa");
        Fraccion a = new Fraccion(3, 5);
        Fraccion expResult = new Fraccion(5, 3);
        Fraccion result = Fraccion.inversa(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of dividir method, of class Fraccion.
     */
    @Test
    public void testDividir() {
        System.out.println("dividir");
        Fraccion a = new Fraccion(3, 5);
        Fraccion b = new Fraccion(1, 6);
        Fraccion expResult = new Fraccion(18, 5);
        Fraccion result = Fraccion.dividir(a, b);
        assertEquals(expResult, result);   
    }

    /**
     * Test of potencia method, of class Fraccion.
     */
    @Test
    public void testPotencia() {
        System.out.println("potencia");
        Fraccion a = new Fraccion(3, 5);
        int exponente = 2;
        Fraccion expResult = new Fraccion(9, 25);
        Fraccion result = Fraccion.potencia(a, exponente);
        assertEquals(expResult, result);        
    }

    /**
     * Test of toString method, of class Fraccion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Fraccion fraccion = new Fraccion(1, 5);
        String expResult = "1/5";
        String result = fraccion.toString();
        assertEquals(expResult, result);        
    }

    /**
     * Test of simplificar method, of class Fraccion.
     */
    @Test
    public void testSimplificar() {
        System.out.println("simplificar");
        Fraccion instance = new Fraccion(25, 75);
        Fraccion expResult = new Fraccion(1, 3);
        Fraccion result = instance.simplificar();
        assertEquals(expResult, result);        
    }

    /**
     * Test of equals method, of class Fraccion.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Fraccion(2, 5);
        Fraccion fraccion = new Fraccion(2, 5);
        assertTrue(fraccion.equals(obj));        
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testDatosIllegalArgumentExcepcion(){
        System.out.println("TestDatosIllegalArgumentException");
        String fraccionDato = "/234";
        Fraccion fraccion = Fraccion.datos(fraccionDato);
        fail("Fallo, debería haber lanzado la excepción IllegalArgument");
    }
    /**
     * 
     */
    @Test(expected = java.lang.NumberFormatException.class)
    public void testDatosNumberFormatExcepcion(){
        System.out.println("TestDatosNumberFormatException");
        String fraccionDato = "a/3";
        Fraccion fraccion = Fraccion.datos(fraccionDato);
        fail("Fallo, debería haber lanzado la excepción NumberFormat");
    }
    
    @Test(expected = java.lang.ArithmeticException.class)
    public void testDatosArithmeticExcepcion(){
        System.out.println("TestDatosArithmeticException");
        String fraccionDato = "3/0";
        Fraccion fraccion = Fraccion.datos(fraccionDato);
        fail("Fallo, debería haber lanzado la excepción ArithmeticException");
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testSetDenominadorIllegalArgumentExcepcion(){
        System.out.println("Test setDenominador Illegal Argument exception");        
        Fraccion fraccion = new Fraccion(1, 2);
        fraccion.setDenominador(0);
        fail("Fallo, debería haber lanzado Illegal Argument exception");
    }


    
}
