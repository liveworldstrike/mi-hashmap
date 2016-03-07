import java.util.Arrays;

/**
 * Write a description of class MiHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiHashMap
{
    // arrays que guarda los valores k introducimos 
    private int [] numeros;
    //arrays que guarda las claves 
    private String[] claves ;
    /**
     * Constructor for objects of class MiHashMap
     */
    public MiHashMap()
    {
        numeros = new int[0];
        claves = new String[0];
    }
    
    /**
     * Asocia el valor especificado con la clave especificada.
     * Si la clave existía, entonces sobreescribe su valor y devuelve el valor antiguo.
     * Si no existía devuelve -1.
     */
    public int put(String clave, int valor)
    {
        boolean encontrado = false;
        int valorAnterior = -1;
        String[]nuevaClave = new String[claves.length + 1];           
        int[]nuevosNumeros = new int[numeros.length +1 ];
        //recorremos el array y miramos si existe 
        for(int a = 0; a < claves.length; a++){
            //agregamos los viejos elementos al nuevo mapa
            nuevaClave[a] = claves [a];
            nuevosNumeros[a] = numeros[a];
            //si esta repetido combiamos el valor 
            if(claves[a] == clave && !encontrado)
            {
                valorAnterior = numeros[a];
                numeros[a] = valor; 
                encontrado = true;
            }
        }
        //si no existe creamos una nueva 
        if(!encontrado){
            nuevaClave[nuevaClave.length -1] = clave;
            nuevosNumeros[nuevosNumeros.length - 1] = valor;
            //lo guardamos
            claves = nuevaClave;
            numeros = nuevosNumeros;
        }
        return valorAnterior;
        
    }
    
    /**
     * Devuelve el valor asociado con la clave especificada 
     * -1 en caso de que la clave no exista.
     */
    public int get(String clave)
    {
        int valor = -1;
        boolean contiene = false;
        for(int a= 0; a < claves.length && !contiene; a++ )
        {
            if (claves[a] == clave){
                valor = numeros[a];
                contiene = true;
            }
        }
        return valor;
    }
    
    /**
     * devuelve true si el mapa no contiene elementos.
     */
    public boolean isEmpty()
    {
        //metodo sacado de array list int que nos hace lo que nos pide 
        return (claves.length == 0);
    
    }
    
    
  
}
