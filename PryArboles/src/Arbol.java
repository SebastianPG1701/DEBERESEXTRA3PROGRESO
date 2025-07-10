public class Arbol {
    private Nodo raiz;

    public Arbol(){
        raiz=null;
    }

    private void insertar(Nodo actual, Computador date){
        if (date.getCodigo()<actual.getComputador().getCodigo()){
            //izquierda
            if (actual.getIzquierda()==null){
                actual.setIzquierda(new Nodo(date));
            }else {
                //ocupado lado izquierdo
                insertar(actual.getIzquierda(), date);
            }
            }else {
                //derecho
                insertar(actual.getIzquierda(),date);
                if (actual.getDerecha()==null){
                    actual.setDerecha(new Nodo(date));

            } else{
                insertar(actual.getDerecha(),date);
            }
        }
    }

    public void insertar(Computador computador){
        if (raiz==null){
            raiz=new Nodo(computador);
        }else {
            insertar(raiz, computador); //recursivo
        }
    }

    private String inOrden(Nodo actual){
        if (actual!=null){
            return inOrden(actual.getIzquierda())+actual.getComputador()+ inOrden(actual.getDerecha());
        }else {
            return "";
        }
    }

    public String inOrden(){
        if (raiz==null){
            return "No hay elementos en el arbol";
        }else {
            return inOrden(raiz);
        }
    }
}
