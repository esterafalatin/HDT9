/**
 * Esteban Rafael Barrera   - 13413
 * Jorge Daniel Mejia       - 13271
 * Diego Alejandro Juarez   - 13280
 */

public interface interfazG<Dato,Contenido> {

    // se agrega un nodo 
    public void nuevoN(Dato nodo);

    // se agrega una relacion entre nodos
    public void nuevaCon(Dato nodo1, Dato nodo2, Contenido dato);
    
    // Muestra el grafo
    public String MostrarG();
    
    // nos muestra la posicion de un nodo en especifico
    public int Posicion(Dato dato);
    
    // se obtiene el nodo en cierta posicion
    public Dato PosicionNodo(int etiqueta);
    
    // obtiene cuanto vale cada nodo
    public int ValorNodo(Dato dato1, Dato dato2);
    
    // nos dice si el nodo existe o no
    public boolean verificar(Dato dato);

    // nos muestra el tamaño del grafo
    public int tamanoG();
    
}
