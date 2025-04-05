package cambiavaluta;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CambiaValuta {

    private JFrame frame;
    private JTextField txtImporto;
    private JTextField txtConversione;
    private JComboBox<String> cmbValuta;
    private JComboBox<Double> cmbTassoValuta;
    
    // array
    private final String[] valute = {"$", "YEN", "£"};
    private final Double[] tassi = {1.18, 156.0, 0.75};
    	
    	
   
   

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CambiaValuta window = new CambiaValuta();
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
    public CambiaValuta() {
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

        JLabel lblDa = new JLabel("Da Euro a:");
        lblDa.setBounds(40, 60, 80, 22);
        frame.getContentPane().add(lblDa);

        cmbValuta = new JComboBox<>(valute);
        cmbValuta.setBounds(130, 60, 94, 22);
        frame.getContentPane().add(cmbValuta);

        JLabel lblA = new JLabel("Tasso di Cambio:");
        lblA.setBounds(240, 60, 100, 22);
        frame.getContentPane().add(lblA);

        JLabel lblImporto = new JLabel("Importo in Euro:");
        lblImporto.setBounds(40, 120, 100, 14);
        frame.getContentPane().add(lblImporto);

        txtImporto = new JTextField();
        txtImporto.setBounds(150, 117, 86, 20);
        frame.getContentPane().add(txtImporto);
        txtImporto.setColumns(10);

        txtConversione = new JTextField();
        txtConversione.setEditable(false);
        txtConversione.setBounds(150, 150, 86, 20);
        frame.getContentPane().add(txtConversione);
        txtConversione.setColumns(10);

        JLabel lblRisultato = new JLabel("Valuta convertita:");
        lblRisultato.setBounds(40, 153, 100, 14);
        frame.getContentPane().add(lblRisultato);
        
        cmbTassoValuta = new JComboBox<>(tassi);
        cmbTassoValuta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int index = cmbTassoValuta.getSelectedIndex();
        	}
        });
        cmbTassoValuta.setBounds(335, 60, 71, 22);
        frame.getContentPane().add(cmbTassoValuta);

        // Aggiornare il tasso di cambio in base alla selezione
        cmbValuta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//peschiamo l'indice selezionato
            	int index = cmbValuta.getSelectedIndex();
            	//per fare i calcoli dopo
            	String valutaSelezionata = valute[index];
            	double tassoDiCambio = tassi[index];
            	//cambiamo il secondo combo box
            	cmbTassoValuta.setSelectedIndex(index);
                //Conversioni
                try {
                	double euro = Double.parseDouble(txtImporto.getText());
                	double convertiti = euro*tassoDiCambio;
                	txtConversione.setText(valutaSelezionata+" "+convertiti);
                }
                catch(NumberFormatException exc) {
                	exc.printStackTrace();
                	JOptionPane.showMessageDialog(null, "Errore, formato non valido");
                }
                
                
            }
        });
    }
}
