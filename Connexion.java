import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Connexion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
    private Font customFont;

	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
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
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Charger la police depuis le fichier
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\fonts\\TT_Lakes_Neue_Trial_Expanded_Regular.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        }catch (IOException f) {
            f.printStackTrace();
        }
		
        
        //Creation du frame initial avec dimension
		frame = new JFrame();
		frame.setBounds(-8, 0, 2880, 1800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Creation du panel contenant le form de connexion
		JPanel panel = new JPanel();
		panel.setBounds(398, 143,615,346);
		panel.setBackground(new Color(32, 102, 10));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		//Zone de texte de l'identifiant
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBorder(null);
		textField.setText("  Identifiant");
	    textField.setInputVerifier(new InputVerifier() {
			 
			   @Override
			   public boolean verify(JComponent input) {
			      return ((JTextField)input).getText().length()>0;
			   }
			 
			});
		
		 final boolean clicked = false;
		textField.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
      
				if(!clicked){
                    textField.setText("");
                }                                           
            }
		});
		textField.setBackground(new Color(105, 105, 105));
		textField.setFont(customFont.deriveFont(15f));
		textField.setBounds(146, 164, 309, 20); // A FAIRE
		panel.add(textField);
		textField.setColumns(10);
		
	
		//Zone de texte du MDP
		
		textField_1 = new JTextField("  Mot de passe");
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBorder(null);
		textField_1.setInputVerifier(new InputVerifier() {
			 
			   @Override
			   public boolean verify(JComponent input) {
			      return ((JTextField)input).getText().length()>0;
			   }
			 
			});
		final boolean clicked1 = false;
		textField_1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
      
				if(!clicked1){
                    textField_1.setText("");
                }
            }
		});
		textField_1.setFont(customFont.deriveFont(15f));
		textField_1.setBackground(new Color(105, 105, 105));
		textField_1.setBounds(146, 217, 309, 20); // A FAIRE 
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		//Defintion du Jlabel pour Connectez 
		
		lblNewLabel_1 = new JLabel("Connectez-vous et");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(customFont.deriveFont(24f));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 37, 615, 20); //A FAIRE
		panel.add(lblNewLabel_1);
		
		//Defintion du Jlabel pour Defendez 
		
		lblNewLabel_2 = new JLabel("défendez votre camp !");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(customFont.deriveFont(24f));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 71, 615, 23); // A FAIRE
		panel.add(lblNewLabel_2);
		
		//Bouton connexion
		
		btnNewButton = new JButton("Connexion");
		btnNewButton.setBorder(null);
		btnNewButton.setFont(customFont.deriveFont(17f));
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setBounds(75, 282, 162, 23); // A FAIRE
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnNewButton.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				
				frame.dispose();
				Camp.ouvreCamp();
			}
		});
		
		
		//Bouton Inscription
		
		btnNewButton_1 = new JButton("Inscription");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(customFont.deriveFont(17f));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setBackground(Color.blue);
				btnNewButton.setBackground(new Color(105, 105, 105));
				
				frame.dispose();
				Inscription.ouvreInscription();
			
			}
		});
		
		btnNewButton_1.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(358, 282, 167, 23); // A FAIRE
		panel.add(btnNewButton_1);
		
		// logo 
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
		label.setBounds(638, 564, 192, 112);
		frame.getContentPane().add(label);
		
		// image utt
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\image-UTT.png"));
		lblNewLabel.setBounds(-8, 0, 1500,900);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(161, 229, 192, 160);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		frame.setBounds(-8, 0, 2880, 1800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

public JFrame getFrame() {
	return frame;
}
}
