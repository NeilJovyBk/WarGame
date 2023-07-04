import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Confirmation {

	private JFrame frame;
	private Font customFont;

	/**
	 * Launch the application.
	 */
	public static void ouvreConfirmation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmation window = new Confirmation();
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
	public Confirmation() {
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
		
		// FRAME INITIAL
        
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(-8, 0, 2880, 1800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//LABEL DE CONFIRMATION
		
		JLabel lblNewLabel = new JLabel("VOTRE INSCRIPTION EST BIEN ENREGISTREE !");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 314, 1443, 35); // A FAIRE
		lblNewLabel.setFont(customFont.deriveFont(24f));
		lblNewLabel.setForeground(new Color(32, 102, 10));
		frame.getContentPane().add(lblNewLabel);
		
		// BOUTTON GO !!!
		
		JButton btnNewButton = new JButton("GO !!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Camp.ouvreCamp();
			}
		});
		btnNewButton.setBounds(614, 607, 135, 25); // A FAIRE
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setFont(customFont.deriveFont(24f));
		btnNewButton.setForeground(Color.WHITE);
		frame.getContentPane().add(btnNewButton);
		
		
		// LOGO EN HAUT A GAUCHE
  		JLabel labellogo = new JLabel("");
  		labellogo.setBounds(10, 11, 135, 106);
  		frame.getContentPane().add(labellogo);
  		labellogo.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
		
		
	}
	public JFrame getFrame() {
		return frame;
	}
}
