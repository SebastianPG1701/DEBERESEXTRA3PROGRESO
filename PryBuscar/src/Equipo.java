import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> lista;

    public Equipo(){
        lista=new ArrayList<>();
    }

    public void agregarJugador(Jugador j) throws Exception {
        for (Jugador x:lista){
            if (x.getCodigo()== j.getCodigo())
                throw new Exception("El codigo ya existe");
        }
        lista.add(j);
        ordenar();
    }

    public void ordenar(){
        Jugador aux;
        for (int i=0; i<lista.size()-1; i++)
            for (int j=i+1; j<lista.size();j++){
                if (lista.get(i).getCodigo()>lista.get(j).getCodigo()){
                    aux=lista.get(i);
                    lista.set(i,lista.get(j));
                    lista.set(j,aux);
                }
            }

    }

    public String listarJugadores(){
        StringBuilder sb=new StringBuilder();
        for (Jugador j:lista){
            sb.append(j.toString());
        }
        return sb.toString();
    }

    public Jugador buscarCodigo(int codigo) throws Exception {
        if (codigo<lista.getFirst().getCodigo() || codigo>lista.getLast().getCodigo()){
            throw  new Exception("El codigo no esta en la lista :(");
        }
        int inf=0;
        int sup=lista.size()-1;
        int cen;

        while (inf<=sup){
            cen=(inf+sup)/2;
            if (lista.get(cen).getCodigo()==codigo)
                return lista.get(cen);
            else if (codigo<lista.get(cen).getCodigo()) {
                sup=cen-1;
            }else{
                inf=cen+1;
            }

        }
        throw new Exception("No existe el codigo");
    }

    public void eliminarJugador(Jugador j) {
        lista.remove(j);
    }



}
