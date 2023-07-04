import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MonCompte {

	private JFrame frmMonCompte;
	private Font customFont;

	/**
	 * Launch the application.
	 */
	public static void ouvreMonCompte () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonCompte window = new MonCompte();
					window.frmMonCompte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonCompte = new JFrame();
		frmMonCompte.setTitle("Mon Compte");
		frmMonCompte.getContentPane().setBackground(new Color(0, 0, 0));
		frmMonCompte.getContentPane().setLayout(null);
        
		// Charger la police depuis le fichier
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\fonts\\TT_Lakes_Neue_Trial_Expanded_Regular.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        }catch (IOException f) {
            f.printStackTrace();
        }
        
      //------------------------------------------LOGO DU JEU EN HAUT A GAUCHE---------------------------------------------
        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 135, 106);
		frmMonCompte.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
		
	  //-----------------------------------------------TITRE DE LA PAGE-----------------------------------------------------
        
		JLabel titrePageCompte = new JLabel("Mon compte");
		titrePageCompte.setHorizontalAlignment(SwingConstants.CENTER);
		titrePageCompte.setBounds(195, 25, 944, 45);
		titrePageCompte.setForeground(new Color(32, 102, 10));
		titrePageCompte.setFont(customFont.deriveFont(24f));
		frmMonCompte.getContentPane().add(titrePageCompte);
		
		//-------------------------------------------------TEXT IDENTIFIANT----------------------------------------------------
		
		JLabel txtIdentifiant = new JLabel("Identifiant : ");
		txtIdentifiant.setForeground(new Color(32, 102, 10));
		txtIdentifiant.setFont(customFont.deriveFont(22f));
		txtIdentifiant.setBounds(204, 238, 250, 45);
		frmMonCompte.getContentPane().add(txtIdentifiant);
		
		JLabel txtIdentifiantDB = new JLabel("[Identifiant joueur]");
		txtIdentifiantDB.setForeground(Color.WHITE);
		txtIdentifiantDB.setFont(customFont.deriveFont(22f));
		txtIdentifiantDB.setBounds(454, 238, 350, 45);
		frmMonCompte.getContentPane().add(txtIdentifiantDB);
	
		
		//-------------------------------------------------TEXT MOT DE PASSE---------------------------------------------------
		
		JLabel txtMotDepasse = new JLabel("Mot de passe : ");
		txtMotDepasse.setForeground(new Color(32, 102, 10));
		txtMotDepasse.setFont(customFont.deriveFont(22f));
		txtMotDepasse.setBounds(204, 340, 250, 45);
		frmMonCompte.getContentPane().add(txtMotDepasse);
		
		JLabel txtMotDepasseDB = new JLabel("[Mot de passe joueur]");
		txtMotDepasseDB.setForeground(Color.WHITE);
		txtMotDepasseDB.setFont(customFont.deriveFont(22f));
		txtMotDepasseDB.setBounds(454, 340, 350, 45);
		frmMonCompte.getContentPane().add(txtMotDepasseDB);
	
		
		//---------------------------------------------------TEXT BRANCHE-------------------------------------------------------
		
		
		JLabel txtBranche = new JLabel("Branche : ");
		txtBranche.setForeground(new Color(32, 102, 10));
		txtBranche.setFont(customFont.deriveFont(22f));
		txtBranche.setBounds(204, 445, 250, 45);
		frmMonCompte.getContentPane().add(txtBranche);
		
		JLabel txtBrancheDB = new JLabel("[Branche joueur]");
		txtBrancheDB.setForeground(Color.WHITE);
		txtBrancheDB.setFont(customFont.deriveFont(22f));
		txtBrancheDB.setBounds(454, 445, 350, 45);
		frmMonCompte.getContentPane().add(txtBrancheDB);
		
		//------------------------------------------------PANEL AVEC LES CONCTACTS-----------------------------------------------
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 102, 10));
		panel.setBounds(270, 600, 1077, 204);
		frmMonCompte.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel txtContact = new JLabel("Contactez-nous");
		txtContact.setForeground(Color.WHITE);
		txtContact.setFont(customFont.deriveFont(22f));
		txtContact.setBounds(433, 11, 243, 38);
		panel.add(txtContact);
		
		
		JLabel txtMail = new JLabel("Email : wargame.utt@utt.fr");
		txtMail.setForeground(Color.WHITE);
		txtMail.setFont(customFont.deriveFont(22f));
		txtMail.setBounds(26, 71, 527, 38);
		panel.add(txtMail);
		
		
		JLabel txtAdresse = new JLabel("Adresse : 12 rue Marie Curie, 10300, Troyes, France");
		txtAdresse.setForeground(Color.WHITE);
		txtAdresse.setFont(customFont.deriveFont(22f));
		txtAdresse.setBounds(26, 116, 755, 38);
		panel.add(txtAdresse);
	
		//------------------------------------------------BOUTON RETOUR----------------------------------------------------

		JLabel retour = new JLabel("< Retour");
		retour.setHorizontalAlignment(SwingConstants.CENTER);
		retour.setBounds(0, 0, 186, 38);
		retour.setFont(customFont.deriveFont(20f));
		retour.setForeground(Color.WHITE);
		
		JPanel panelRetour = new JPanel();
		panelRetour.setLayout(null);
		panelRetour.setBackground(Color.GRAY);
		panelRetour.setBounds(0,0, 186, 38);
		panelRetour.add(retour);

		
		JButton btnNewButton = new JButton("");
		btnNewButton.setLayout(null);
		btnNewButton.setBounds(45, 738, 186, 38);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.add(panelRetour);
		frmMonCompte.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camp.ouvreCamp();
				frmMonCompte.dispose();
			}
		});
		
		//-----------------------------------------------------------------------------------------------------------------
		
		
		frmMonCompte.setBounds(-8, 0, 2880, 1800);
		frmMonCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
