/**
 * Esteban Rafael Barrera   - 13413
 * Jorge Daniel Mejia       - 13271
 * Diego Alejandro Juarez   - 13280
 */

import java.io.*;
public class Datos{
    
    File archivo;
    FileReader flireReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    PrintWriter printWriter;
    MatrizGrafo grafo = new MatrizGrafo();
    // con este metodo se leen elos nombres de los nodos que se van a dibujar en el grafo
    public MatrizGrafo arrayNames() throws IOException
    {
        // se lee el archivo 
        flireReader = new FileReader (archivo);
        bufferedReader = new BufferedReader(flireReader);
        String fila;
        while((fila=bufferedReader.readLine())!=null)
        {
            // se van agregando al arreglo 
            String[] arreglo;
            arreglo=fila.split(" ");
            grafo.nuevoN(arreglo[0]);
            grafo.nuevoN(arreglo[1]);
        }
        // se regresa el grafo 
        return grafo;
    }
    // metodo en donde se va a ler el archivo 
    public void Leer() throws FileNotFoundException
    {
        // se crea una nueva ruta en donde se va a ir a leer el archivo
       String ruta = new File("datos.txt").getAbsolutePath(); 
       archivo=new File(ruta); 
    }  
    // obtiene los valores de las relaciones entre los nodos
    public MatrizGrafo valoresRelaciones() throws IOException
    {
        // Lectura del fichero
        flireReader = new FileReader (archivo);
        bufferedReader = new BufferedReader(flireReader);
        String fila;
        while((fila=bufferedReader.readLine())!=null)
        {
            String[] arreglo;
            arreglo=fila.split(" ");
            grafo.nuevaCon(arreglo[0], arreglo[1], arreglo[2]);
        }
        return grafo;
    }
    // escrive en el archivo
    public void escribir(String cadena) throws IOException
    {
        fileWriter = new FileWriter(archivo);
        printWriter = new PrintWriter(fileWriter);
        printWriter.println(cadena);
    }
}
