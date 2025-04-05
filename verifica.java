import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class verifica {

    private JFrame frame;
    private JTextField textField;
    private JLabel lbl1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    verifica window = new verifica();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public verifica() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JComboBox cmbSconto = new JComboBox();
        cmbSconto.setModel(new DefaultComboBoxModel(new String[] {"", "non sconto", "10%", "30%"}));
        cmbSconto.setBounds(291, 56, 99, 22);
        frame.getContentPane().add(cmbSconto);
        
        JLabel lblimporto = new JLabel("Importo: ");
        lblimporto.setBounds(38, 60, 58, 14);
        frame.getContentPane().add(lblimporto);
        
        textField = new JTextField();
        textField.setBounds(106, 57, 69, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblTotale = new JLabel("Totale:");
        lblTotale.setBounds(38, 120, 46, 14);
        frame.getContentPane().add(lblTotale);
        
        JButton btnCalcola = new JButton("Calcola");
        btnCalcola.setBounds(236, 120, 82, 23);
        frame.getContentPane().add(btnCalcola);
        
        JButton btnEsci = new JButton("Esci");
        btnEsci.setBounds(337, 120, 74, 23);
        frame.getContentPane().add(btnEsci);
        
        lbl1 = new JLabel("");
        lbl1.setBounds(94, 120, 46, 14);
        frame.getContentPane().add(lbl1);

        // Add action listener to "Calcola" button
        btnCalcola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                   
                    double importo = Double.parseDouble(textField.getText());

                   
                    String sconto = (String) cmbSconto.getSelectedItem();
                    double totale = importo;

                   
                    if ("10%".equals(sconto)) {
                        totale = importo * 0.9;  
                    } else if ("30%".equals(sconto)) {
                        totale = importo * 0.7;  
                    } 
                    
                    lbl1.setText(String.format("%.2f", totale));
                } catch (NumberFormatException ex) {
                    lbl1.setText("Invalid input");
                }
            }
        });
        
        
        btnEsci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}