 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JTextField;
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

public class Inscription {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_6;
	private JButton btnNewButton_5;
	private JButton btnNewButton_4;
	private JButton btnNewButton_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton_7;
	private Font customFont;
	
	/**
	 * Launch the application.
	 */
	
	public static void ouvreInscription() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription window = new Inscription();
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
	public Inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(-8, 0, 2880, 1800);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Charger la police depuis le fichier
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\fonts\\TT_Lakes_Neue_Trial_Expanded_Regular.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        }catch (IOException f) {
            f.printStackTrace();
        }
		
      //-------------------------------------------------BOUTON RETOUR--------------------------------------------------------

      		JLabel LabelRetour = new JLabel("< Retour");
      		LabelRetour.setHorizontalAlignment(SwingConstants.CENTER);
      		LabelRetour.setBounds(0, 0, 186, 38);
      		LabelRetour.setFont(customFont.deriveFont(20f));
      		LabelRetour.setForeground(Color.WHITE);
      		
      		JPanel panelRetour = new JPanel();
      		panelRetour.setLayout(null);
      		panelRetour.setBackground(Color.GRAY);
      		panelRetour.setBounds(0,0, 186, 38);
      		panelRetour.add(LabelRetour);

      		
      		JButton ButtonRetour = new JButton("");
      		ButtonRetour.setLayout(null);
      		ButtonRetour.setBounds(45, 738, 186, 38);
      		ButtonRetour.setBackground(Color.GRAY);
      		ButtonRetour.add(panelRetour);
      		frame.getContentPane().add(ButtonRetour);
      		ButtonRetour.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				frame.dispose();
      			}
      		});	
		
		
		// Titre Inscription
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont(customFont.deriveFont(24f));
		lblInscription.setForeground(new Color(32, 102, 10));
		lblInscription.setBounds(0, 70, 1303, 23); //A FAIRE
		frame.getContentPane().add(lblInscription);
		
		// ZONE DE TEXTE POUR IDENTIFIANT
		
		
		textField = new JTextField("  Indentifiant");
		textField.setForeground(new Color(255, 255, 255));
		textField.setBorder(null);
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
		textField.setFont(customFont.deriveFont(17f));
		textField.setBounds(471, 180, 368, 29); // A FAIRE
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		// LOGO EN HAUT A GAUCHE
		
		
  		JLabel labellogo = new JLabel("");
  		labellogo.setBounds(10, 11, 135, 106);
  		frame.getContentPane().add(labellogo);
  		labellogo.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
		
		
		// ZONE DE TEXTE POUR MDP
		
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
		textField_1.setBackground(new Color(105, 105, 105));
		textField_1.setFont(customFont.deriveFont(17f));
		textField_1.setBounds(472, 259, 367, 29); // A FAIRE
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		// DE QUEL CAMP .......
		
		JLabel lblDeQuelCamp = new JLabel("De quel camp fais-tu partie ?");
		lblDeQuelCamp.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeQuelCamp.setFont(customFont.deriveFont(24f));
		lblDeQuelCamp.setForeground(new Color(32, 102, 10));
		lblDeQuelCamp.setBounds(0, 349, 1303, 29); // A FAIRE
		frame.getContentPane().add(lblDeQuelCamp);
		
		
		// BOUTTON A2I
		
		btnNewButton = new JButton("A2I");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(105, 105, 105));
				btnNewButton_2.setForeground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(105, 105, 105));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_4.setBackground(new Color(105, 105, 105));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton_5.setBackground(new Color(105, 105, 105));
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(new Color(105, 105, 105));
				btnNewButton_6.setForeground(Color.WHITE);
				
			}
		});
		btnNewButton.setFont(customFont.deriveFont(17f));
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(72, 461, 104, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton);
		  
		//BOUTTON ISI
		
		btnNewButton_1 = new JButton("ISI");
		btnNewButton_1.setFont(customFont.deriveFont(17f));
		btnNewButton_1.setBackground(new Color(105, 105, 105));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton_1.setBackground(Color.blue);
				btnNewButton.setBackground(new Color(105, 105, 105));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(105, 105, 105));
				btnNewButton_2.setForeground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(105, 105, 105));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_4.setBackground(new Color(105, 105, 105));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton_5.setBackground(new Color(105, 105, 105));
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(new Color(105, 105, 105));
				btnNewButton_6.setForeground(Color.WHITE);
			
			}
		});
		btnNewButton_1.setBounds(268, 461, 94, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton_1);
		
		// BOUTTON GI
		
		btnNewButton_2 = new JButton("GI");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(105, 105, 105));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(105, 105, 105));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_4.setBackground(new Color(105, 105, 105));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton_5.setBackground(new Color(105, 105, 105));
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(new Color(105, 105, 105));
				btnNewButton_6.setForeground(Color.WHITE);
			
				
			}
		});
		btnNewButton_2.setFont(customFont.deriveFont(17f));
		btnNewButton_2.setBackground(new Color(105, 105, 105));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(455, 461, 94, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton_2);
		
		// BOUTTON GM
		
		btnNewButton_3 = new JButton("GM");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(105, 105, 105));
				btnNewButton_2.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(105, 105, 105));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton_4.setBackground(new Color(105, 105, 105));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton_5.setBackground(new Color(105, 105, 105));
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(new Color(105, 105, 105));
				btnNewButton_6.setForeground(Color.WHITE);
			
				
			}
		});
		btnNewButton_3.setFont(customFont.deriveFont(17f));
		btnNewButton_3.setBackground(new Color(105, 105, 105));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(639, 461, 94, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton_3);
		
		// BOUTTON MTE
		
		btnNewButton_4 = new JButton("MTE");
		btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton_4.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(105, 105, 105));
				btnNewButton_2.setForeground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(105, 105, 105));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(105, 105, 105));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton_5.setBackground(new Color(105, 105, 105));
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(new Color(105, 105, 105));
				btnNewButton_6.setForeground(Color.WHITE);
			
				
			}
		});
		btnNewButton_4.setBackground(new Color(105, 105, 105));
		btnNewButton_4.setFont(customFont.deriveFont(17f));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(805, 461, 104, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		// BOUTTON RT
		
		btnNewButton_5 = new JButton("RT");
		btnNewButton_5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton_5.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(105, 105, 105));
				btnNewButton_2.setForeground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(105, 105, 105));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_4.setBackground(new Color(105, 105, 105));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(105, 105, 105));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(new Color(105, 105, 105));
				btnNewButton_6.setForeground(Color.WHITE);
			
				
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(customFont.deriveFont(17f));
		btnNewButton_5.setBackground(new Color(105, 105, 105));
		btnNewButton_5.setBounds(999, 461, 94, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton_5);
		
		// BOUTTON MM
		
		btnNewButton_6 = new JButton("MM");
		btnNewButton_6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton_6.setBackground(Color.blue);
				btnNewButton_1.setBackground(new Color(105, 105, 105));
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(105, 105, 105));
				btnNewButton_2.setForeground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(105, 105, 105));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_4.setBackground(new Color(105, 105, 105));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton_5.setBackground(new Color(105, 105, 105));
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(105, 105, 105));
				btnNewButton.setForeground(Color.WHITE);
			
				
			}
		});
		btnNewButton_6.setBackground(new Color(105, 105, 105));
		btnNewButton_6.setFont(customFont.deriveFont(17f));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBounds(1189, 461, 94, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton_6);
		
		// BOUTTON CONFIRMATION
		
		btnNewButton_7 = new JButton("Confirmation");
		btnNewButton_7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Confirmation.ouvreConfirmation();
				
				
			}
		});
		btnNewButton_7.setBackground(new Color(105, 105, 105));
		btnNewButton_7.setFont(customFont.deriveFont(17f));
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBounds(559, 555, 253, 23); // A FAIRE
		frame.getContentPane().add(btnNewButton_7);
	}

public JFrame getFrame() {
	return frame;
}
}