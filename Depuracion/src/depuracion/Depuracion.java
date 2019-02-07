/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depuracion;

/**
 *
 * @author usuario
 */
public class Depuracion {

    public static void main(String[] args) {
        int n = 50;
        int[] tabla; // = new int[n];
        tabla = LlenarNumeros.llenar(n);
        int suma = LlenarNumeros.sumar(tabla);
        System.out.println("La suma es: " + suma);
        double a = 10/0;
    }
    
}
