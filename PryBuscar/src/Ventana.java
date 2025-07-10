import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JSpinner spCodigo;
    private JTextField txtNombre;
    private JTextField txtRendimiento;
    private JComboBox cboPosicion;
    private JButton btnRegistrar;
    private JTextArea txtListado;
    private JButton btnBuscar;
    private JButton btnMostrar;
    private JSpinner spBuscar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private Equipo equipo1=new Equipo();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(spCodigo.getValue().toString());
                String nombre=txtNombre.getText();
                float ren=Float.parseFloat(txtRendimiento.getText());
                String pos=cboPosicion.getSelectedItem().toString();
                Jugador j=new Jugador(codigo,nombre,ren,pos);
                try {
                    equipo1.agregarJugador(j);
                    txtListado.setText(equipo1.listarJugadores());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(spBuscar.getValue().toString());
                try {
                    Jugador j=equipo1.buscarCodigo(codigo);
                    txtListado.setText(j.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListado.setText(equipo1.listarJugadores());
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(spBuscar.getValue().toString());
                try {
                    Jugador jugador = equipo1.buscarCodigo(codigo);

                    String nuevoNombre = txtNombre.getText().trim();
                    float nuevoRendimiento = Float.parseFloat(txtRendimiento.getText().trim());
                    String nuevaPosicion = cboPosicion.getSelectedItem().toString();

                    if (nuevoNombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                        return;
                    }

                    jugador.setNombre(nuevoNombre);
                    jugador.setRendimiento(nuevoRendimiento);
                    jugador.setPosicion(nuevaPosicion);

                    txtListado.setText(equipo1.listarJugadores());
                    JOptionPane.showMessageDialog(null, "Jugador editado exitosamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(spBuscar.getValue().toString());
                try {
                    Jugador jugador = equipo1.buscarCodigo(codigo);
                    equipo1.eliminarJugador(jugador);
                    txtListado.setText(equipo1.listarJugadores());
                    JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
