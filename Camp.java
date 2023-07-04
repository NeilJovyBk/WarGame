import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Camp {

	private JFrame frmCampDeBase;
    private Font customFont;
	
	/**
	 * Launch the application.
	 */
    public static void ouvreCamp ()  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Camp window = new Camp();
					window.frmCampDeBase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Camp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCampDeBase = new JFrame();
		frmCampDeBase.setTitle("Camp");
		frmCampDeBase.getContentPane().setBackground(new Color(0, 0, 0));
		frmCampDeBase.getContentPane().setLayout(null);
		
		
		
		// Forcer le look and feel par défaut
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		// Charger la police depuis le fichier
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\fonts\\TT_Lakes_Neue_Trial_Expanded_Regular.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        }catch (IOException f) {
            f.printStackTrace();
        }
		
		//--------------------------------------------TITRE DE LA PAGE ------------------------------------------------------
		JLabel titrePageCamp = new JLabel("[Prénom joueur], bienvenue sur le camp !");
		titrePageCamp.setHorizontalAlignment(SwingConstants.CENTER);
		titrePageCamp.setBounds(226, 11, 944, 45);
		titrePageCamp.setForeground(new Color(32, 102, 10));
		titrePageCamp.setFont(customFont.deriveFont(24f));
		frmCampDeBase.getContentPane().add(titrePageCamp);
		
		//------------------------------------------LOGO DU JEU EN HAUT A GAUCHE---------------------------------------------
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 135, 106);
		frmCampDeBase.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));

		
		//----------------------------------------------BOUTON BATTEZVOUS----------------------------------------------------
		//Panel qui regoupe le Text et le logo de battezVous
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(296, 24, 192, 131);
		panel_1.setLayout(null);
		
		// Text "battezBous"
		JLabel lblNewLabel_2 = new JLabel("Battez-vous !");
		lblNewLabel_2.setBounds(20, 100, 151, 25);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(customFont.deriveFont(17f));
		
		// Logo battez-vous
		JLabel logo_battez_vous = new JLabel("");
		logo_battez_vous.setBounds(52, 11, 87, 84);
		panel_1.add(logo_battez_vous);
		logo_battez_vous.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\battez_vous.png"));
		
		
		//Button qui comporte le Panel
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repartitionpoint.ouvreRepartition();
				frmCampDeBase.dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(1241, 689, 192, 131);
		btnNewButton.setBorder(null);
		btnNewButton.add(panel_1);
		frmCampDeBase.getContentPane().add(btnNewButton);
		
				
			
		//--------------------------------------------BOUTON MON COMPTE---------------------------------------------------
		
		//Panel qui regroupe le label moncompte et le logo bonhomme
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(40,213,276,74);

        //Label mon Compte
        JLabel lblNewLabel_3 = new JLabel("Mon Compte");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(customFont.deriveFont(24f));
        lblNewLabel_3.setBackground(new Color(32, 102, 10));
        lblNewLabel_3.setBounds(10,10,220, 55);
        panel.add(lblNewLabel_3);
        
        
        //Label image bonhomme
        JLabel bonhomme1 = new JLabel();
        bonhomme1.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\bonhomme.PNG"));
        bonhomme1.setBounds(227,10,40,55);
        panel.add(bonhomme1);
        
        //Button qui comprend le JLabel
        JButton moncompteButton = new JButton();
        moncompteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MonCompte.ouvreMonCompte();
        		frmCampDeBase.dispose();
        	}
        });
        moncompteButton.setBounds(1157, 55, 276, 74);
        moncompteButton.setBackground(new Color(32, 102, 10));
        moncompteButton.setBorder(null);
        moncompteButton.add(panel);
        frmCampDeBase.getContentPane().add(moncompteButton);
      
        //---------------------------------------------------BOUTON AMI--------------------------------------------------------
        JPanel panelAmi = new JPanel(); 
        panelAmi.setLayout(null);
        panelAmi.setBounds(40,213,192,60);
        panelAmi.setOpaque(false);
        
        
        JLabel labelAmi = new JLabel("Ami(s)");
        labelAmi.setBounds(30, 10, 77, 41);
        panelAmi.add(labelAmi);
        labelAmi.setBackground(Color.GRAY);
        labelAmi.setFont(customFont.deriveFont(17f));
        labelAmi.setForeground(Color.WHITE);
        
        
        JLabel ImageAmi = new JLabel();
        ImageAmi.setBounds(147, 2, 35, 54);
        panelAmi.add(ImageAmi);
        ImageAmi.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\bonhomme.png"));
        
        
		JButton btnAmi = new JButton();
		btnAmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ami.ouvreAmi();
				frmCampDeBase.dispose();
			}
		});
		btnAmi.setBackground(Color.GRAY);
		btnAmi.setBounds(1241,618,192,60);
		btnAmi.add(panelAmi);
		btnAmi.setBorder(null);
		frmCampDeBase.getContentPane().add(btnAmi);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\elite_preparation.PNG"));
		lblNewLabel_1.setBounds(99, 300, 68, 106);
		frmCampDeBase.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\soldat_preparation.PNG"));
		lblNewLabel_4.setBounds(565, 560, 80, 106);
		frmCampDeBase.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\soldat_preparation.PNG"));
		lblNewLabel_5.setBounds(834, 593, 80, 64);
		frmCampDeBase.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\soldat_preparation.PNG"));
		lblNewLabel_6.setBounds(1100, 560, 70, 74);
		frmCampDeBase.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\elite_preparation.PNG"));
		lblNewLabel_7.setBounds(199, 560, 68, 85);
		frmCampDeBase.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\elite_preparation.PNG"));
		lblNewLabel_8.setBounds(1354, 423, 79, 74);
		frmCampDeBase.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\Elite.PNG"));
		lblNewLabel_9.setBounds(848, 158, 178, 300);
		frmCampDeBase.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\soldat.PNG"));
		lblNewLabel_10.setBounds(539, 220, 224, 251);
		frmCampDeBase.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\MDG.PNG"));
		lblNewLabel_11.setBounds(257, 177, 255, 209);
		frmCampDeBase.getContentPane().add(lblNewLabel_11);
		
		// image utt
		
		JLabel labelfond = new JLabel("New label");
		labelfond.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\image-UTT.png"));
		labelfond.setBounds(-8, 0, 1500,900);
		frmCampDeBase.getContentPane().add(labelfond);
		//---------------------------------------------------------------------------------------------------------------------
		
		
		
		frmCampDeBase.setBounds(-8, 0, 2880, 1800);
		frmCampDeBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
