
package Listas_Simplemente_Enlazadas;



public class Nodo {

    private Object data;
    private Nodo siguiente;

    public Nodo(Object data) {

        this.data = data;

    }

    public void modificarDato(Object data){
        this.data = data;
    }

    public Object obtenerValor(){
        return data;
    }

    public void enlazarSiguiente(Nodo n){
        this.siguiente = n;
    }

    public Nodo obtenerSiguiente(){
        return this.siguiente;
    }

    

}
