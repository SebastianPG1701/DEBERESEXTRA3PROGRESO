import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Clinica {
    PriorityQueue<Paciente> lista;

    public Clinica() {
        lista=new PriorityQueue<>();
    }

    public void encolar(Paciente dato){
        lista.add(dato);
    }

    public Paciente atender() throws Exception {
        if (lista.isEmpty())
            throw new Exception("No at elementos!");
        return lista.poll();
    }

    public List<Paciente> listarPacientes(){
        return lista.stream().collect(Collectors.toList());
    }

}
