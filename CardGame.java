package cardgame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Image;

public class CardGame {

    private JFrame frame;
    private int score = 0;
    private int attempts = 0;
    private final int maxAttempts = 5;
    private JLabel card1, card2, card3;
    private String[] cardImages = {"C:\\Users\\Studente\\Desktop\\eclipse\\asso.jpg", "C:\\Users\\Studente\\Desktop\\eclipse\\assomazze.jpg", "C:\\Users\\Studente\\Desktop\\eclipse\\re doro.jpg"};
    private String backImage = "C:\\Users\\Studente\\Desktop\\eclipse\\cartedietro.jpg";
    private int differentCardPosition;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CardGame window = new CardGame();
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
    public CardGame() {
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

        card1 = new JLabel();
        card1.setBounds(82, 70, 71, 92);
        card1.setIcon(resizeImageIcon(backImage, card1.getWidth(), card1.getHeight()));
        card1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                flipCard(0);
            }
        });
        frame.getContentPane().add(card1);

        card2 = new JLabel();
        card2.setBounds(208, 70, 71, 92);
        card2.setIcon(resizeImageIcon(backImage, card2.getWidth(), card2.getHeight()));
        card2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                flipCard(1);
            }
        });
        frame.getContentPane().add(card2);

        card3 = new JLabel();
        card3.setBounds(353, 70, 71, 92);
        card3.setIcon(resizeImageIcon(backImage, card3.getWidth(), card3.getHeight()));
        card3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                flipCard(2);
            }
        });
        frame.getContentPane().add(card3);

        JButton btnNewButton = new JButton("Avvia");
        btnNewButton.addActionListener(e -> playGame());
        btnNewButton.setBounds(121, 202, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Esci");
        btnNewButton_1.addActionListener(e -> System.exit(0));
        btnNewButton_1.setBounds(243, 202, 89, 23);
        frame.getContentPane().add(btnNewButton_1);
    }

    private void playGame() {
        Random rand = new Random();
        differentCardPosition = rand.nextInt(3); // Randomly choose the position of the different card

        card1.setIcon(resizeImageIcon(backImage, card1.getWidth(), card1.getHeight()));
        card2.setIcon(resizeImageIcon(backImage, card2.getWidth(), card2.getHeight()));
        card3.setIcon(resizeImageIcon(backImage, card3.getWidth(), card3.getHeight()));
    }

    private void flipCard(int index) {
        if (index == 0) {
            card1.setIcon(resizeImageIcon(cardImages[index], card1.getWidth(), card1.getHeight()));
        } else if (index == 1) {
            card2.setIcon(resizeImageIcon(cardImages[index], card2.getWidth(), card2.getHeight()));
        } else if (index == 2) {
            card3.setIcon(resizeImageIcon(cardImages[index], card3.getWidth(), card3.getHeight()));
        }

        if (index == differentCardPosition) {
            score++;
            JOptionPane.showMessageDialog(frame, "Corretto! Il tuo punteggio: " + score);
        } else {
            JOptionPane.showMessageDialog(frame, "Sbagliato! La carta diversa era in posizione: " + (differentCardPosition + 1));
        }

        attempts++;
        if (attempts >= maxAttempts) {
            JOptionPane.showMessageDialog(frame, "Game Over! Il tuo punteggio finale: " + score);
            resetGame();
        }
    }

    private void resetGame() {
        score = 0;
        attempts = 0;
        playGame();
    }

    private ImageIcon resizeImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
