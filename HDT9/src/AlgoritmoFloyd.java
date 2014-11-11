/**
 * Esteban Rafael Barrera   - 13413
 * Jorge Daniel Mejia       - 13271
 * Diego Alejandro Juarez   - 13280
 */

import java.io.File;
import java.io.IOException;

public class AlgoritmoFloyd {
    
    Archivo archivo= new Archivo();
    MatrizGrafo matrizA;
    int[][] matNodInt;
    int[] max;
    int center;
    int min=10000;
    String cenRegreso="";
    
    public AlgoritmoFloyd(){
        
        try {                        
            archivo.leer();
            archivo.arrayNames(); 
            matrizA = archivo.valoresRealciones(); 
            matNodInt = new int[25][25]; 
            max = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<archivo.grafo.tamanoGrafo();n++)
        {
            for(int m=0;m<archivo.grafo.tamanoGrafo();m++)
            {
                matNodInt[n][m]=10000;
            }
        }
    }

        public void intermedios(int num1, int num2)
    {
        if(matNodInt[num1][num2]!=10000)
        {
            intermedios(num1,matNodInt[num1][num2]);
            System.out.print(", "+matrizA.obtenerNodo(matNodInt[num1][num2]));
            intermedios(matNodInt[num1][num2],num2);
            return;
        }
        else return;
           
    }
    
    public void recorridoFacil()
    {
        for(int k=0;k<matrizA.tamanoGrafo();k++)
        {
            for(int i=0;i<matrizA.tamanoGrafo();i++)
            {
                for(int j=0;j<matrizA.tamanoGrafo();j++)
                {
                    if(matrizA.obtenerConexion(matrizA.obtenerNodo(i),matrizA.obtenerNodo(j))>(matrizA.obtenerConexion(matrizA.obtenerNodo(i), matrizA.obtenerNodo(k))+matrizA.obtenerConexion(matrizA.obtenerNodo(k), matrizA.obtenerNodo(j))))
                    {
                        matrizA.agregarConexion(matrizA.obtenerNodo(i), matrizA.obtenerNodo(j), (matrizA.obtenerConexion(matrizA.obtenerNodo(i), matrizA.obtenerNodo(k))+matrizA.obtenerConexion(matrizA.obtenerNodo(k), matrizA.obtenerNodo(j))));
                        matNodInt[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    public String medioGrafo(){
        recorridoFacil();
        int n=0;       
        // Encontrar los maximos de cada columna de la matrizA
        for(int i=0;i<matrizA.tamanoGrafo();i++){
            for(int j=0;j<matrizA.tamanoGrafo()-1;j++){
                int num1=matrizA.obtenerConexion(matrizA.obtenerNodo(j), matrizA.obtenerNodo(i));
                n=j;
                n++;
                int num2=matrizA.obtenerConexion(matrizA.obtenerNodo(n), matrizA.obtenerNodo(i));
                if(num1>num2){
                    max[i]=num1;
                }
                else{
                    max[i]=num2;
                }
            }
            n++;
        }
        for(int i=0;i<matrizA.tamanoGrafo();i++)
        {
            int num1=max[i];
            if(num1<min)
            {
                center=i;
                min=num1;
            }
        }
        cenRegreso="El centro del grafo es: "+matrizA.obtenerNodo(center);
        return cenRegreso;
        
    }
    

}

    

