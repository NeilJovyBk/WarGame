import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Defaite {

	private JFrame frame;
	private Font customFont;

	/**
	 * Launch the application.
	 */
	public static void ouvreDefaite() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Defaite window = new Defaite();
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
	public Defaite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(-8, 0, 2880, 1800);
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
		
		
		
		//PANEL CONTENENT LE MESSAGE DE VICTOIRE
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 102, 10));
		panel.setBounds(381, 147,615,346);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// LABEL DE VICTOIRE
		
		JLabel lblNewLabel = new JLabel("Défaite !!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 62, 615, 25); // A FAIRE
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(customFont.deriveFont(24f));
		panel.add(lblNewLabel);
		
		//LABEL POUR BRAVO,,,
		
		JLabel lblNewLabel_2 = new JLabel("Dommage ! L'adversaire a pris ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(customFont.deriveFont(24f));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 143, 615, 25); // A FAIRE
		panel.add(lblNewLabel_2);
		
		// LABEL POUR 3 ZONES
		
		JLabel lblZones = new JLabel("3 zones avant toi !");
		lblZones.setHorizontalAlignment(SwingConstants.CENTER);
		lblZones.setFont(customFont.deriveFont(24f));
		lblZones.setForeground(Color.WHITE);
		lblZones.setBounds(0, 192, 615, 35); // A FAIRE
		panel.add(lblZones);
		
		
		// IMG logo
	   JLabel label = new JLabel("");
	   label.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
	   label.setBounds(636, 564, 192, 112);
	   frame.getContentPane().add(label);

		// IMG UTT EN FOND
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\image-UTT.png"));
		lblNewLabel.setBounds(-8, 0, 1500,900);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
	public JFrame getFrame() {
		return frame;
}
}