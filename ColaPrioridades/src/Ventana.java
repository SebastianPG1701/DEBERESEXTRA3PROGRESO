import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JPanel principal;
    private JComboBox cboPrioridad;
    private JTextField txtNombre;
    private JTextField txtSintomas;
    private JButton btnRegistrar;
    private JList lstPacientes;
    private JButton btnAtender;
    private Clinica clinica=new Clinica();
    public void llenar(){
        DefaultListModel modelo=new DefaultListModel();
        List<Paciente> orden=clinica.listarPacientes();
        Collections.sort(orden);
        for (Paciente p:orden){
            modelo.addElement(p.toString());
        }
        lstPacientes.setModel(modelo);
    }
    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p=Integer.parseInt(cboPrioridad.getSelectedItem().toString());
                String n=txtNombre.getText();
                String s=txtSintomas.getText();
                clinica.encolar(new Paciente(p,n,s));
                llenar();
            }
        });
        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente atendido=clinica.atender();
                    JOptionPane.showMessageDialog(null,"Atendido "+atendido);
                    llenar();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
