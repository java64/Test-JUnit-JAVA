/*
 * Copyright (c) 2017, Entornos Programación - DAW. All rights reserved.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License
 */
package depuracion;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author franmatias
 */
public class Conjunto {

    /**
     * Array de enteros dónde se almacenarán los elementos del conjunto puede
     * contener de [0, n] elementos
     */
    int[] conjunto = null;

    /**
     * Inicia el conjunto con el conjunto vacio, sin ningún elemento
     */
    public Conjunto() {
        conjunto = new int[0];
    }

    /**
     * Crea un conjunto a partir de otro (Constructor de copia)
     *
     * @param a Conjunto de enteros.
     */
    public Conjunto(Conjunto a) {
        conjunto = a.conjunto;
    }
    
    public Conjunto(int [] a) {
        conjunto = new int[a.length];
        
        System.arraycopy(a, 0, conjunto, 0, a.length);
    }

    /**
     * Determina si el conjunto está vacio, un conjunto está vacío es no
     * contiene ningún elemento o es nulo
     *
     * @return true si el conjunto está vacío
     */
    public boolean vacio() {
        return (conjunto == null || conjunto.length == 0);
    }

    /**
     * Determina si un elemento está dentro del conjunto
     *
     * @param elemento, a buscar en el conjunto
     * @return true si está en el conjunto false si no lo está
     */
    public boolean contiene(int elemento) {
        if (vacio()) {
            return false;
        }

        for (int item : conjunto) {
            if (item == elemento) {
                return true;
            }
        }

        return false;
    }

    /**
     * Número de elementos de un conjunto
     *
     * @return los elementos de un conjunto
     */
    public int length() throws NullPointerException {
        if (conjunto == null) {
            return 0;
        }
        return conjunto.length;
    }

    /**
     * Añade un elemento al conjunto, se añade solo si no está presente en el
     * conjunto
     *
     * @param elemento, que se añadirá al curso
     * @return true si se añade el elemento, false de lo contrario
     */
    public boolean añadir(int elemento) {
        if (vacio() || !contiene(elemento)) {
            conjunto = Arrays.copyOf(conjunto, conjunto.length + 1);
            conjunto[conjunto.length - 1] = elemento;
            return true;
        }
        return false;
    }

    /**
     * Elimina un elemento del conjunto. Para poder eliminarlo debe estar
     * contenido en el conjunto
     *
     * @param elemento a eliminar
     * @return true si ha eliminado el elemento, false si el elemento no está
     * presente en el conjunto
     */
    public boolean eliminar(int elemento) {
        if (vacio() || !contiene(elemento)) {
            return false;
        }

        int[] aux = new int[conjunto.length - 1];

        for (int i = 0, j = 0; i < conjunto.length; i++) {
            if (conjunto[i] != elemento) {
                aux[j++] = conjunto[i];
            }
        }

        conjunto = aux;

        return true;
    }

    /**
     * Calcula la unión de dos conjuntos en otro conjunto La unión de dos
     * conjuntos son los elementos no repetidos de ambos conjuntos
     *
     * @param a conjunto operando 1
     * @param b conjunto operando 2
     * @return Un conjunto con la unión de los otros dos
     * @throws IllegalArgumentException si alguno de los conjuntos es nulo
     */
    public static Conjunto union(Conjunto a, Conjunto b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Error en los argumentos");
        }
        Conjunto aux = new Conjunto(a);
        for (int item : b.conjunto) {
            if (!aux.contiene(item)) {
                aux.añadir(item);
            }
        }
        return aux;
    }

    /**
     * Calcula la intersección de dos conjuntos en otro conjunto La
     * intersercción de conjuntos son los elementos que están presentes en ambos
     * conjuntos
     *
     * @param a conjunto operando 1
     * @param b conjunto operando 2
     * @return Un conjunto con la intersección de los otros dos
     * @throws IllegalArgumentException si alguno de los conjuntos es nulo
     */
    public static Conjunto interseccion(Conjunto a, Conjunto b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Error en los argumentos");
        }
        Conjunto aux = new Conjunto();
        for (int item : b.conjunto) {
            if (a.contiene(item)) {
                aux.añadir(item);
            }
        }
        return aux;
    }

    /**
     * Determina si dos conjuntos son iguales. Dos conjuntos son iguales si
     * tienen los mismos elementos
     *
     * @param a conjunto a comparar
     * @return true si los conjuntos son iguales
     */
    @Override
    public boolean equals(Object a) {
        if (a == null) {
            return false;
        }
        if (!Conjunto.class.isAssignableFrom(a.getClass())) {
            return false;
        }

        final Conjunto otro = (Conjunto) a;
        if (this.length() != otro.length()) {
            return false;
        }

        for (int item : otro.conjunto) {
            if (!contiene(item)) {
                return false;
            }
        }

        return true;

    }

    /**
     * Convierte a String un conjunto de elementos
     *
     * @return Una cadena con los elementos de un conjunto
     */
    @Override
    public String toString() {
        String result = "{ ";
        result += String.join(",", Arrays.toString(conjunto));
        result += " }";
        return result;
    }

    /**
     * Elimina todos los elementos de un conjunto dejandolo vacio
     */
    public void vaciar() {
        conjunto = new int[0];
    }

    /**
     * Ordena un conjunto
     *
     * @param c, conjunto origen a ordenar
     * @return Conjunto nuevo ordenado a partir de c
     * @throws IllegalArgumentException Si c es nulo
     */
    public static Conjunto ordenar(Conjunto c) {

        if (c == null) {
            throw new IllegalArgumentException("Error en los argumentos");
        }

        Conjunto result = new Conjunto(c);
        Arrays.sort(result.conjunto);

        return result;
    }

}
