package Listas_Simplemente_Enlazadas;



public class ListaEnlazada{

    private Nodo cabeza;
    private int size = 0;

    public static void main(String[] args) {
        
        ListaEnlazada Ls = new ListaEnlazada();

        Ls.addPrimero(2);
        Ls.addUltimo(4);
        Ls.addPrimero(1);
        Ls.addUltimo(5);
        Ls.addIndice(2,3);
        
        
        Ls.imprimirLista();
        
        /*Ls.eliminarPrimero();
        System.out.println("Eliminacion del primero");
        Ls.imprimirLista();
        System.out.println("Eliminacion del ultimo");
        Ls.eliminarUltimo();
        Ls.imprimirLista();*/
        System.out.println("Eliminacion del segundo");
        Ls.eliminarIndice(4);
        Ls.Modificar(5, 10);
        Ls.imprimirLista();
        //Ls.addUltimo(9);
        //Ls.imprimirLista();
    }


    public ListaEnlazada () {
        
        this.cabeza = null;
    
    }
    
    public boolean estaVacio(){
        
        if(cabeza == null){
            return true;
        }else{
            return false;
        }

    }

    //Metodos de Insercion-----------------------
    public void addPrimero(Object data) {
        
        if (cabeza == null) {
            cabeza  = new Nodo(data);           
        }else{
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(data);
            nuevo.enlazarSiguiente(temp);
            cabeza = nuevo;
        }

        size++;
    }

    public void addUltimo(Object data){

        Nodo temp = this.cabeza;
        while(temp.obtenerSiguiente() != null){
            temp = temp.obtenerSiguiente();
        }

        temp.enlazarSiguiente(new Nodo(data));
        size++;
    }

    public void addIndice(int index, Object data){
        Nodo temp = this.cabeza;

        for(int i = 0; i<index-1 && temp.obtenerSiguiente() != null; i++){
            temp = temp.obtenerSiguiente();
        }

        Nodo contenedor = temp.obtenerSiguiente();
        temp.enlazarSiguiente(new Nodo(data));
        temp.obtenerSiguiente().enlazarSiguiente(contenedor);

        size++;
    }
    //--------------------------------------------
    //Metodos de Eliminacion----------------------
    public void eliminarPrimero(){

        if(this.estaVacio()!= true){
            if(cabeza.obtenerSiguiente() != null && cabeza.obtenerSiguiente().obtenerSiguiente() != null){
                cabeza = cabeza.obtenerSiguiente();
                size--;
            }else{
                cabeza.enlazarSiguiente(null);
                size--;
            }    
        }
        
    } 

    public void eliminarUltimo(){

        Nodo temp = cabeza;
        
        if(this.estaVacio() != true){
            while(temp.obtenerSiguiente() != null){
                temp = temp.obtenerSiguiente();
            }
    
            Nodo temp2 = cabeza;
            while(temp2.obtenerSiguiente() != temp){
                temp2 = temp2.obtenerSiguiente();
            }
            temp2.enlazarSiguiente(null);
    
            size--;
        }
        
    }

    public void eliminarIndice(int index){

        if(this.estaVacio() != true){

            Nodo temp = cabeza;
            if (index == 0) {

                this.eliminarPrimero();
                size--;
                
            } else {
                
                if (index > size) {
                    
                    System.out.println("Nodo fuera de rango");
                
                } else {
                    
                    for(int i = 0; i<index-1 && temp.obtenerSiguiente()!=null;i++){

                        temp = temp.obtenerSiguiente();
        
                    }
        
                    if(temp.obtenerSiguiente().obtenerSiguiente() == null){
                        temp.enlazarSiguiente(null);
                        size--;
                    }else{
                        temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
                        size--;
                    }          
                    
                        
                    
                }        
            }
            
        }else{
            System.out.println("Lista Vacia");
        }
    }

    

    //--------------------------------------------
    //Metodo Modificar----------------------------
    public void Modificar(int index, Object data){
        
        if(this.estaVacio() != true){
            Nodo temp = cabeza;

            for(int i=0; i<index && temp.obtenerSiguiente() != null;i++){
                temp = temp.obtenerSiguiente();
            }

            temp.setValor(data);
            

        }else{
            System.out.println("Lista Vacia");
        }
        
        
    }
    
    public int size(){
        return size;
    }

    public Object obtenerValor(int index) {
        int contador = 0;
        Nodo temp = this.cabeza;
        while (contador < index){
            temp = temp.obtenerSiguiente();
            contador++;
        }
        return temp.obtenerValor();
    }   

    public void imprimirLista(){
        Nodo temp = this.cabeza;
        int contador = 0;
        while(contador<size){
            
            System.out.println(temp.obtenerValor());            
            temp = temp.obtenerSiguiente();
            contador++;
        }

    }
}