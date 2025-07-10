public class Computador {
    private int codigo;
    private String marca;
    private String procesador;
    private int ram;  //en gigas

    public Computador(int codigo, String marca, String procesador, int ram) {
        this.codigo = codigo;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Computador " +
                "Codigo: " + codigo +
                ", Marca: " + marca +
                ", Procesador: " + procesador +
                ", Ram:" + ram + "GB\n";
    }
}
