import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ami {

	private JFrame frmAmi;
	private Font customFont;

	/**
	 * Launch the application.
	 */
	public static void ouvreAmi () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ami window = new Ami();
					window.frmAmi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ami() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmi = new JFrame();
		frmAmi.getContentPane().setBackground(new Color(0, 0, 0));
		frmAmi.setTitle("Ami");
		frmAmi.getContentPane().setLayout(null);
		
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
  		frmAmi.getContentPane().add(lblNewLabel);
  		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
  	  //-------------------------------------------------TITRE DE LA PAGE-----------------------------------------------------
		
        JLabel titreAmi = new JLabel("Affrontez/Contactez vos amis !");
        titreAmi.setHorizontalAlignment(SwingConstants.CENTER);
        titreAmi.setBounds(220, 25, 944, 45);
        titreAmi.setForeground(new Color(32, 102, 10));
        titreAmi.setFont(customFont.deriveFont(24f));
		frmAmi.getContentPane().add(titreAmi);
		
		//---------------------------------------------PANNEAU TROP DE RESERVISTE------------------------------------------------
		
        JTextField textField = new JTextField();
        textField.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		textField.setText(" ");
        	}
        });
        textField.setBounds(0, 0, 216, 38);
        textField.setColumns(20);
        textField.setText("Ajoutez ici...");
        textField.setBackground(Color.GRAY);
        textField.setFont(customFont.deriveFont(16f));
        textField.setOpaque(false);
        textField.setBorder(null);

		
		JPanel PanelAjout = new JPanel();
		PanelAjout.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		PanelAjout.setBackground(new Color(0, 0, 0));
		PanelAjout.setBounds(350, 196, 772, 419);
		PanelAjout.setVisible(false);
		frmAmi.getContentPane().add(PanelAjout);
		PanelAjout.setLayout(null);
		
		
		JLabel LabelContinuer = new JLabel("Continuer >");
		LabelContinuer.setHorizontalAlignment(SwingConstants.CENTER);
		LabelContinuer.setBounds(0, 0, 200, 38);
		LabelContinuer.setFont(customFont.deriveFont(20f));
		LabelContinuer.setForeground(Color.WHITE);
		
		JPanel PanelContinuer = new JPanel();
		PanelContinuer.setLayout(null);
		PanelContinuer.setBackground(Color.GRAY);
		PanelContinuer.setBounds(0,0, 200, 38);
		PanelContinuer.add(LabelContinuer);

		
		JButton ButtonCompris = new JButton("");
		ButtonCompris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAjout.setVisible(false);
			}
		});
		ButtonCompris.setLayout(null);
		ButtonCompris.setBounds(298, 296, 200, 38);
		ButtonCompris.setBackground(Color.GRAY);
		ButtonCompris.add(PanelContinuer);
		PanelAjout.add(ButtonCompris);
		
		
		JLabel Labelajout1 = new JLabel("Vous venez d'ajouter :");
		Labelajout1.setHorizontalAlignment(SwingConstants.CENTER);
		Labelajout1.setFont(customFont.deriveFont(20f));
		Labelajout1.setForeground(new Color(255, 255, 255));
		Labelajout1.setBounds(10, 49, 752, 46);
		PanelAjout.add(Labelajout1);
		
		JLabel Labelajout2 = new JLabel("à votre liste d'ami");
		Labelajout2.setHorizontalAlignment(SwingConstants.CENTER);
		Labelajout2.setForeground(Color.WHITE);
		Labelajout2.setFont(customFont.deriveFont(20f));
		Labelajout2.setBounds(10, 163, 752, 46);
		PanelAjout.add(Labelajout2);
		
		JLabel Labelajout3 = new JLabel("");
		Labelajout3.setHorizontalAlignment(SwingConstants.CENTER);
		Labelajout3.setForeground(new Color(0, 128, 0));
		Labelajout3.setFont(customFont.deriveFont(20f));
		Labelajout3.setBounds(10, 106, 752, 46);
		PanelAjout.add(Labelajout3);
				
		
		//------------------------------------------------BOUTON RETOUR--------------------------------------------------------

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
		frmAmi.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camp.ouvreCamp();
				frmAmi.dispose();
			}
		});	
		
		//--------------------------------------------------LISTE D'AMI----------------------------------------------------
		JPanel listeAmi = new JPanel();
		listeAmi.setLayout(new BoxLayout(listeAmi, BoxLayout.Y_AXIS));
        listeAmi.setOpaque(false);
        
		// Ajoutez des JPanel à votre liste
        for (int i = 1; i <= 15; i++) {
        	
            JPanel itemAmi = new JPanel(); 
            itemAmi.setLayout(null);
            itemAmi.setPreferredSize(new Dimension(800, 75));
            itemAmi.setBackground(Color.GRAY);
            
            JLabel label = new JLabel("Ami " + i);
            label.setBounds(50, 20, 100, 35);
            label.setFont(customFont.deriveFont(14f));
            label.setForeground(Color.WHITE);
            itemAmi.add(label);
            
            JLabel affrontement = new JLabel();
            affrontement.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\affrontement.png"));
            affrontement.setBackground(Color.GRAY);

            
            JButton affrontementButton = new JButton(); 
            affrontementButton.setBounds(650, 8, 60, 65);
            affrontementButton.setBackground(Color.GRAY); 
            affrontementButton.setBorder(null);
            affrontementButton.add(affrontement);
            itemAmi.add(affrontementButton);
        
            
            JLabel chat = new JLabel();
            chat.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\chat.png"));
            chat.setBackground(Color.GRAY);
            
            JButton chatButton = new JButton(); 
            chatButton.setBounds(750, 5, 70, 65);
            chatButton.setBackground(Color.GRAY); 
            chatButton.setBorder(null);
            chatButton.add(chat);
            itemAmi.add(chatButton);
            
            
            
            
            JPanel itemtransition = new JPanel();
            itemtransition.setPreferredSize(new Dimension(800, 15));
            itemtransition.setBackground(Color.BLACK);
            
            listeAmi.add(itemAmi);
            listeAmi.add(itemtransition);
        }
		
        JScrollPane scrollAmi = new JScrollPane(listeAmi);
        scrollAmi.setBounds(280,133,906,506);
        scrollAmi.setOpaque(false);
        scrollAmi.setBorder(null);
        frmAmi.getContentPane().add(scrollAmi);
        
        //--------------------------------------------CHAMPS POUR ENTRER UN NOM-----------------------------------------------
        
        JPanel PanelNomAmi = new JPanel();
        PanelNomAmi.setBackground(Color.GRAY);
        PanelNomAmi.setBounds(991, 738, 260, 38);
        frmAmi.getContentPane().add(PanelNomAmi);
        PanelNomAmi.setLayout(null);
        PanelNomAmi.setVisible(false);
        PanelNomAmi.add(textField);
        
      //-----------------------------------------------BOUTON AJOUT AMI-----------------------------------------------------
        
        JLabel AjoutAmi = new JLabel();
        AjoutAmi.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\ajout_ami.png"));
        AjoutAmi.setBackground(Color.BLACK);
        
        JButton AjoutAmiButton = new JButton(); 
        AjoutAmiButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PanelNomAmi.setVisible(true);
        	}
        });
        AjoutAmiButton.setBounds(1261,716, 83,82);
        AjoutAmiButton.add(AjoutAmi);
        AjoutAmiButton.setBackground(Color.BLACK);
        AjoutAmiButton.setBorder(null);
        frmAmi.getContentPane().add(AjoutAmiButton);
        
        JPanel Panelvalidation = new JPanel();
        Panelvalidation.setBackground(Color.GRAY);
        Panelvalidation.setBounds(850, 716, 38, 38);
        Panelvalidation.setLayout(null);
        
        JLabel labelValidation = new JLabel("");
        labelValidation.setBackground(Color.GRAY);
        labelValidation.setBounds(0, 0, 38, 38);
        Panelvalidation.add(labelValidation);
        labelValidation.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\valider.PNG"));
        
        JButton Buttonvalidation = new JButton("");
        Buttonvalidation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PanelNomAmi.setVisible(false);
        		Labelajout3.setText(textField.getText());
        		textField.setText("Ajoutez ici...");
        		PanelAjout.setVisible(true);
        	}
        });
        Buttonvalidation.setBounds(222, 0, 38, 38);
        Buttonvalidation.setBorder(null);
        Buttonvalidation.add(Panelvalidation);
        PanelNomAmi.add(Buttonvalidation);
        
        
        //-----------------------------------------------------------------------------------------------------------------------
        
        
		frmAmi.setBounds(-8, 0, 2880, 1800);
		frmAmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
