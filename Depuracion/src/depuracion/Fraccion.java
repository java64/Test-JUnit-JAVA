/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depuracion;

/**
 *
 * <h1> Fraccion </h1>
 * <p>
 * Una fracción, número fraccionario, es la expresión de una cantidad dividida
 * entre otra cantidad; es decir que representa un cociente no efectuado de
 * números. Por razones históricas también se les llama fracción común, fracción
 * vulgar o fracción decimal. Las fracciones comunes se componen de: numerador,
 * denominador y línea divisora entre ambos (barra horizontal u oblicua). En una
 * fracción común a / b el denominador "b" expresa la cantidad de partes iguales
 * que representan la unidad, y el numerador "a" indica cuántas de ellas se
 * toman</p>
 *
 * @author franmatias
 * @see Tema de objetos
 * @version 1.5
 * @since version 1.1
 */
public class Fraccion {

    /**
     * Numerador de la fracción, un número entero, si es negativo lleva el signo
     * '-' delante. Por ej: -3
     */
    private int numerador;
    /**
     * Denominador de la fracción, un número entero distinto de 0 Una fracción
     * negativa se escribe con el signo menos delante de la fracción: -1/2, si
     * ambos números son negativos la fracción se quita el signo
     */
    private int denominador;

    /**
     * Construye un objeto fracción neutro, 0/1 = 0
     */
    public Fraccion() {
        this(0, 1);
    }

    /**
     * Construye una fracción con el númerador, el denominador se supone 1
     *
     * @param num, el numerador de la fracción
     */
    public Fraccion(int num) {
        this(num, 1);
    }

    /**
     * Construye una fracción dos números enteros
     *
     * @param numerador, el numerador de la fracción
     * @param denominador, no puede ser 0 (división entre 0)
     * @exception IllegalArgumentException, si el denominador es 0
     */
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        setDenominador(denominador);
    }

    /**
     * Obtiene el numerador
     * @return 
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * Obtiene el denominador
     * @return 
     */
    public int getDenominador() {
        return denominador;
    }
    
    /**
     * Establece un valor para el numerador
     * @param numerador 
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * Establece un valor para el denominador
     * @param denominador 
     * @throws IllegalArgumentException si el numerador es 0
     */
    public final void setDenominador(int denominador) {
        if(denominador == 0)
            throw new IllegalArgumentException("El denominador no puede ser 0");
        this.denominador = denominador;
    }
    
    

    /**
     * Genera una fracción a partir de un String. El String debe contener el
     * simbolo "/" para poder averigüar el númerador y el denominador. Si solo
     * contiene números se supondrá que este es el numerador y el denominador=1
     * La fracción se simplifica después de crearse.
     *
     * @param fraccionDato, la fracción almacenada en una cadena de la forma
 "numerador/denominador"
     * @return una fracción válida simplificada
     * @throws IllegalArgumentException si fraccionDato no cumple alguno de los
     * siguientes requisitos:
     * <ul>
     * <li>Es una cadena vacía</li>
     * <li>Si tiene valor null</li>
     * <li>Si antes del simbolo '/' no hay nada</li>
     * </ul>
     * @throws NumberFormatException si fraccionDato no es un número
     * @throws ArithmeticException si fraccionDato es cero
     */
    public static Fraccion datos(String fraccionDato) {
        String numc = "";
        String denomc = "";

        Fraccion fraccion;

        if(fraccionDato == null || fraccionDato.equals("")){
            throw new IllegalArgumentException("Cadena no válida");
        }
        // Buscamos el lugar que ocupa en la cadena el simbolo "/"
        int pos = fraccionDato.indexOf('/');
        
        if(pos == 0){
            throw new IllegalArgumentException("Cadena no válida");
        }

        // Si es un numero entero no se encuentra "/" y asigna a "pos" un -1 
        if (pos == -1) {
            int num1 = Integer.valueOf(fraccionDato.trim());
            fraccion = new Fraccion(num1);
        } else {
            for (int i = 0; i < pos; i++) {
                numc += fraccionDato.charAt(i);
            }

            // El denominador esta entre (pos+1) y la longitud de la cadena 
            for (int i = (pos + 1); i < fraccionDato.length(); i++) {
                denomc += fraccionDato.charAt(i);
            }

            // Convertimos las dos cadenas en los enteros numerador y denom 
            int num = Integer.valueOf(numc.trim());
            int denom = Integer.valueOf(denomc.trim());
            if (denom == 0){
                throw new ArithmeticException("denominador igual a 0");
            }
            fraccion = new Fraccion(num, denom);
        }
        return fraccion;
    }

    /**
     * Suma dos fracciones. Se devuelve una fracción, que es la suma de la
     * fraccion a y b pasadas en los argumentos.
     *
     * @param a, una fraccion
     * @param b, una fraccion
     * @return una fraccion simplificada, suma de a y b
     */
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        Fraccion c = new Fraccion();
        c.numerador = a.numerador * b.denominador + b.numerador * a.denominador;
        c.denominador = a.denominador * b.denominador;
        return c;
    }

    /**
     * Resta dos fracciones. Se devuelve una fracción, que es la resta de la
     * fraccion a y b pasadas en los argumentos.
     *
     * @param a, una fraccion
     * @param b, una fraccion
     * @return una fraccion simplificada, resta de a y b
     */
    public static Fraccion restar(Fraccion a, Fraccion b) {
        Fraccion c = new Fraccion();
        c.numerador = a.numerador * b.denominador - b.numerador * a.denominador;
        c.denominador = a.denominador * b.denominador;
        return c;
    }

    /**
     * Multiplica dos fracciones
     *
     * @param a, una fraccion
     * @param b, una fraccion
     * @return una fraccion simplificada, producto de a y b
     */
    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        return new Fraccion(a.numerador * b.numerador, a.denominador * b.denominador);
    }

    /**
     * La fracción inversa se obtiene cambiando numerador por denominador
     *
     * @param a, fraccion
     * @return Fraccion simplificada
     * @throws ArithmeticException si el numerador es cero
     */
    public static Fraccion inversa(Fraccion a) {
        return new Fraccion(a.denominador, a.numerador);
    }

    /**
     * Cociente de una fracción se define como la fraccion producto de la
     * primera fraccion, por la inversa de la segunda fraccion
     *
     * @param a, la fraccion numerador
     * @param b, la fraccion denominador
     * @return Una fracción simplificada
     *
     */
    public static Fraccion dividir(Fraccion a, Fraccion b) {
        return multiplicar(a, inversa(b));
    }

    /**
     * Calcula la potencia del tipo (numerador/denominador)^exp = (numerador^exp/denominador^exp)
     *
     * @param a, una fracción
     * @param exponente, un entero
     * @return La fraccion simplificada
     */
    public static Fraccion potencia(Fraccion a, int exponente) {

        Fraccion c = new Fraccion();
        c.numerador = (int) Math.pow((double) a.numerador, Math.abs(exponente));
        c.denominador = (int) Math.pow((double) a.denominador, Math.abs(exponente));

        if (exponente < 0) {
            c = Fraccion.inversa(c);
        }

        return c;
    }

    /**
     * Convierte una fracción a cadena con el formato: numerador/denominador
     *
     * @return Se devuelve una cadena con el numerador y denominador y en medio
     * el signo "/" de division
     */
    @Override
    public String toString() {
        if (denominador == 1) {
            return " " + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }

    /**
     * Calcula el Máximo Común Divisor del numérador y el denominador
     *
     * @return el mcd(numerador, denominador)
     */
    private int mcd() {
        int u = Math.abs(numerador);
        int v = Math.abs(denominador);
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    /**
     * Simplifica una fracción usando el mcd
     *
     * @return una fracción simplificada
     */
    public Fraccion simplificar() {
        int dividir = mcd();
        numerador /= dividir;
        denominador /= dividir;
        return this;
    }

    /**
     * Determina si dos fracciones son iguales
     *
     * @param obj
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!Fraccion.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Fraccion otra = (Fraccion) obj;

        return ((this.numerador == otra.numerador) && (this.denominador == otra.denominador));

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.numerador;
        hash = 11 * hash + this.denominador;
        return hash;
    }
}