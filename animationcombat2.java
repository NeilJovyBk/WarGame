import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class animationcombat2 {

	private JFrame frmAnimationDuCombat;
	private Font customFont;
	private boolean showFirstImage;
	private Timer timer;
	private Timer timer2;
    private JTextField txtEntrerVotreMessage;
    private int tour;
    
    
	/**
	 * Launch the application.
	 */
    public static void ouvreAnimation2 () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					animationcombat2 window = new animationcombat2();
					window.frmAnimationDuCombat.setVisible(true);
					window.startTimer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public animationcombat2() {
		initialize();
	}

	
    public void startTimer() {
        timer.start();
        timer2.start();
    } 
    
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int[] PVzone2 = {60, 70, 70, 80, 80, 70};
		int[] PVzone3 = {40, 40, 40, 30, 20, 15};
		int[] PVzone4 = {45, 40, 35, 30, 25, 20};
		int[] PVzone5 = {50, 40, 30, 20, 10, 0};
		
		
		frmAnimationDuCombat = new JFrame();
		frmAnimationDuCombat.setTitle("Animation du combat manche 2");
		frmAnimationDuCombat.getContentPane().setBackground(new Color(0, 0, 0));
		frmAnimationDuCombat.getContentPane().setLayout(null);
		
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
  		
  		
  	//------------------------------------------------CREATION DU CHAT--------------------------------------------------------
  		JPanel PanelChat = new JPanel();
  		PanelChat.setBackground(new Color(255, 255, 255));
  		PanelChat.setLayout(null);
  		PanelChat.setBounds(1092, 0, 350, 880);
  		PanelChat.setVisible(false);
  		frmAnimationDuCombat.getContentPane().add(PanelChat);
  		
  		JButton ButtonFermetureChat = new JButton();
  		ButtonFermetureChat.setOpaque(false);
  		ButtonFermetureChat.setBounds(1050,400,42,100);
  		ButtonFermetureChat.setBorder(null);
  		ButtonFermetureChat.setVisible(false);
		frmAnimationDuCombat.getContentPane().add(ButtonFermetureChat);
		
		JLabel ImageFermetureChat = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\fermeturechat.png", 1400, 400, 42, 100);
		ButtonFermetureChat.add(ImageFermetureChat);
  		

		JButton ButtonOuvertureChat = new JButton();
		ButtonOuvertureChat.setOpaque(false);
		ButtonOuvertureChat.setBounds(1400,400,42,100);
		ButtonOuvertureChat.setBorder(null);
		frmAnimationDuCombat.getContentPane().add(ButtonOuvertureChat);
		
		JLabel ImageOuvertureChat = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\ouverturechat.png", 1400, 400, 42, 100);
		ButtonOuvertureChat.add(ImageOuvertureChat);
		
		
		JLabel TextChat = new JLabel();
		TextChat.setHorizontalAlignment(SwingConstants.CENTER);
		TextChat.setText("Chat");
		TextChat.setForeground(new Color(32, 102, 10));
		TextChat.setFont(customFont.deriveFont(24f));
		TextChat.setBounds(0,11,350, 39);
		PanelChat.add(TextChat);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\Message1.PNG"));
		lblNewLabel_1.setBounds(0, 61, 350, 80);
		PanelChat.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\Message2.PNG"));
		lblNewLabel_2.setBounds(0, 152, 350, 80);
		PanelChat.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 767, 325, 39);
		PanelChat.add(panel_1);
		panel_1.setLayout(null);
		
		txtEntrerVotreMessage = new JTextField();
		txtEntrerVotreMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEntrerVotreMessage.setText("");
			}
		});
		txtEntrerVotreMessage.setText("Entrez votre message...");
		txtEntrerVotreMessage.setBackground(new Color(128, 128, 128));
		txtEntrerVotreMessage.setBounds(0, 0, 288, 39);
		txtEntrerVotreMessage.setFont(customFont.deriveFont(16f));
		panel_1.add(txtEntrerVotreMessage);
		txtEntrerVotreMessage.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(99, 598, 38, 38);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 38, 38);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\valider.PNG"));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEntrerVotreMessage.setText("Entrez votre message...");
			}
		});
		btnNewButton.setBounds(288, 0, 38, 39);
		panel_1.add(btnNewButton);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.add(panel_2);
	
	
		ButtonFermetureChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonFermetureChat.setVisible(false);
				ButtonOuvertureChat.setVisible(true);
				PanelChat.setVisible(false);
			}
		});
		
		ButtonOuvertureChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonFermetureChat.setVisible(true);
				ButtonOuvertureChat.setVisible(false);
				PanelChat.setVisible(true);
			}
		});
		
		
        //-----------------------------------------PANNEAU DE VICTOIRE--------------------------------------------
		JPanel PanelVictoire = new JPanel();
		PanelVictoire.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		PanelVictoire.setBackground(new Color(0, 0, 0));
		PanelVictoire.setBounds(350, 196, 772, 419);
		PanelVictoire.setVisible(false);
		frmAnimationDuCombat.getContentPane().add(PanelVictoire);
		PanelVictoire.setLayout(null);
	
		
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

		
		JButton ButtonContinuer = new JButton("");
		ButtonContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparationcombat3.ouvrePreparation3();
				frmAnimationDuCombat.dispose();
			}
		});
		ButtonContinuer.setLayout(null);
		ButtonContinuer.setBounds(298, 296, 200, 38);
		ButtonContinuer.setBackground(Color.GRAY);
		ButtonContinuer.add(PanelContinuer);
		PanelVictoire.add(ButtonContinuer);
		
		
		JLabel LabelVictoire1 = new JLabel("DOMMAGE !! Vous venez de perdre");
		LabelVictoire1.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVictoire1.setFont(customFont.deriveFont(20f));
		LabelVictoire1.setForeground(new Color(255, 255, 255));
		LabelVictoire1.setBounds(10, 118, 752, 46);
		PanelVictoire.add(LabelVictoire1);
		
		JLabel LabelVictoire2 = new JLabel("l'administration");
		LabelVictoire2.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVictoire2.setForeground(new Color(0, 128, 0));
		LabelVictoire2.setFont(customFont.deriveFont(20f));
		LabelVictoire2.setBounds(10, 175, 752, 46);
		PanelVictoire.add(LabelVictoire2);
        
      //-----------------------------------------------TITRE DE LA PAGE-----------------------------------------------------
        
  		JLabel titrePage = new JLabel("Les combats font rage !");
  		titrePage.setHorizontalAlignment(SwingConstants.CENTER);
  		titrePage.setBounds(246, 11, 944, 45);
  		titrePage.setForeground(new Color(32, 102, 10));
  		titrePage.setFont(customFont.deriveFont(24f));
  		frmAnimationDuCombat.getContentPane().add(titrePage);
      		
  	//----------------------------------------------LOGO DU JEU EN HAUT A GAUCHE------------------------------------------------
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 135, 106);
		frmAnimationDuCombat.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
 
		
	//-----------------------------------------------------ALTERNANCE D'IMAGE---------------------------------------------------
		
		
		JLabel eclatzone2_50 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat50.png",314, 282, 50, 50); 
		frmAnimationDuCombat.getContentPane().add(eclatzone2_50);
		JLabel eclatzone2_25 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat25.png",326, 295, 25, 25); 
		eclatzone2_25.setVisible(false);
		frmAnimationDuCombat.getContentPane().add(eclatzone2_25);
		
		JLabel eclatzone3_50 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat50.png",485, 165, 50, 50); 
		frmAnimationDuCombat.getContentPane().add(eclatzone3_50);
		JLabel eclatzone3_25 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat25.png",497, 178, 25, 25); 
		eclatzone3_25.setVisible(false);
		frmAnimationDuCombat.getContentPane().add(eclatzone3_25);
		
		JLabel eclatzone4_50 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat50.png",670, 420, 50, 50); 
		frmAnimationDuCombat.getContentPane().add(eclatzone4_50);
		JLabel eclatzone4_25 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat25.png",682, 433, 25, 25); 
		eclatzone4_25.setVisible(false);
		frmAnimationDuCombat.getContentPane().add(eclatzone4_25);
		
		JLabel eclatzone5_50 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat50.png",1210, 350, 50, 50); 
		frmAnimationDuCombat.getContentPane().add(eclatzone5_50);
		JLabel eclatzone5_25 = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\eclat25.png",1222, 363, 25, 25); 
		eclatzone5_25.setVisible(false);
		frmAnimationDuCombat.getContentPane().add(eclatzone5_25);
		
		timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showFirstImage) {
                	//zone2
                    eclatzone2_50.setVisible(true);
                    eclatzone2_25.setVisible(false);
                    //zone3
                    eclatzone3_50.setVisible(true);
                    eclatzone3_25.setVisible(false);
                    //zone4
                    eclatzone4_50.setVisible(true);
                    eclatzone4_25.setVisible(false);
                    //zone5
                    eclatzone5_50.setVisible(true);
                    eclatzone5_25.setVisible(false);
                } else {
                	//zone2
                	eclatzone2_50.setVisible(false);
                    eclatzone2_25.setVisible(true);
                    //zone3
                	eclatzone3_50.setVisible(false);
                    eclatzone3_25.setVisible(true);
                    //zone4
                	eclatzone4_50.setVisible(false);
                    eclatzone4_25.setVisible(true);
                    //zone5
                	eclatzone5_50.setVisible(false);
                    eclatzone5_25.setVisible(true);
                }
                showFirstImage = !showFirstImage;
            }
        });
		
		
	//------------------------------------------------------SCHEMA DE L'UTT----------------------------------------------------
		JLabel drapeau_victoire = new JLabel("");
		drapeau_victoire.setBounds(269, 138, 40, 55);
		drapeau_victoire.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\drapeau_victoire.PNG"));
		frmAnimationDuCombat.getContentPane().add(drapeau_victoire);
		
		JLabel schemaUTT = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\schemaUTT.png", 150, 150, 1150, 500);
		frmAnimationDuCombat.getContentPane().add(schemaUTT);

		
		JSlider slider2 = new JSlider();
		slider2.setPaintTicks(true);
		slider2.setEnabled(false);
		slider2.setForeground(new Color(255, 255, 255));
		slider2.setBackground(new Color(0, 0, 0));
		slider2.setBounds(311, 438, 161, 25);
		frmAnimationDuCombat.getContentPane().add(slider2);
		
		JLabel icon_victoire2 = new JLabel("");
		icon_victoire2.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_victoire.PNG"));
		icon_victoire2.setBounds(477, 438, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_victoire2);
		
		JLabel icon_defaite2 = new JLabel("");
		icon_defaite2.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_defaite.PNG"));
		icon_defaite2.setBounds(280, 438, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_defaite2);
		
		JSlider slider3 = new JSlider();
		slider3.setPaintTicks(true);
		slider3.setEnabled(false);
		slider3.setForeground(new Color(255, 255, 255));
		slider3.setBackground(new Color(0, 0, 0));
		slider3.setBounds(383, 141, 161, 25);
		frmAnimationDuCombat.getContentPane().add(slider3);
		
		JLabel icon_victoire3 = new JLabel("");
		icon_victoire3.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_victoire.PNG"));
		icon_victoire3.setBounds(546, 141, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_victoire3);
		
		JLabel icon_defaite3 = new JLabel("");
		icon_defaite3.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_defaite.PNG"));
		icon_defaite3.setBounds(352, 141, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_defaite3);
		
		JSlider slider4 = new JSlider();
		slider4.setEnabled(false);
		slider4.setPaintTicks(true);
		slider4.setBounds(685, 355, 161, 25);
		frmAnimationDuCombat.getContentPane().add(slider4);
		slider4.setForeground(new Color(255, 255, 255));
		slider4.setBackground(new Color(0, 0, 0));
		
		JLabel icon_defaite4 = new JLabel("");
		icon_defaite4.setBounds(654, 355, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_defaite4);
		icon_defaite4.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_defaite.PNG"));
		
		JLabel icon_victoire4 = new JLabel("");
		icon_victoire4.setBounds(856, 355, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_victoire4);
		icon_victoire4.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_victoire.PNG"));

		JSlider slider5 = new JSlider();
		slider5.setPaintTicks(true);
		slider5.setEnabled(false);
		slider5.setBounds(1107, 575, 161, 25);
		frmAnimationDuCombat.getContentPane().add(slider5);
		slider5.setForeground(new Color(255, 255, 255));
		slider5.setBackground(new Color(0, 0, 0));
		
		JLabel icon_defaite5 = new JLabel("");
		icon_defaite5.setBounds(1080,575, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_defaite5);
		icon_defaite5.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_defaite.PNG"));
		
		JLabel icon_victoire5 = new JLabel("");
		icon_victoire5.setBounds(1267,575, 25, 25);
		frmAnimationDuCombat.getContentPane().add(icon_victoire5);
		icon_victoire5.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\icon_victoire.PNG"));
		
		
		timer2 = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	slider2.setValue(PVzone2[tour]);
            	slider3.setValue(PVzone3[tour]);
            	slider4.setValue(PVzone4[tour]);
            	slider5.setValue(PVzone5[tour]);
            	if (slider5.getValue() == 0) {
            		timer.stop();
            		timer2.stop();
            		PanelVictoire.setVisible(true);
            	}
                tour++;
            }
        });
		
		
		frmAnimationDuCombat.setBounds(-8, 0, 2880, 1800);
		frmAnimationDuCombat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
