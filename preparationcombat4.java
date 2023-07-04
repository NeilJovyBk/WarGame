import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class preparationcombat4 {

	private JFrame frmpreparationcombat;
	private Font customFont;
	private int next_x;

	

	/**
	 * Launch the application.
	 */
	public static void ouvrePreparation4 () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preparationcombat4 window = new preparationcombat4();
					window.frmpreparationcombat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static Boolean VerificationAllNumber(JFrame frame) {
		Boolean var1 = false;
		Boolean var4 = false;
		Component[] componentsJF = frame.getContentPane().getComponents();
		for(Component componentJF : componentsJF) {
			if(componentJF instanceof JPanel) {
				Component[] componentsJP1 = ((JPanel) componentJF).getComponents();
				for (Component componentJP1 : componentsJP1) {
					if(componentJP1 instanceof JPanel && componentJP1.getBackground().equals(Color.BLUE)) {
						Component[] componentsJP2 = ((JPanel) componentJP1).getComponents();
						for (Component componentJP2 : componentsJP2) {
							if(componentJP2 instanceof JLabel && ((JLabel) componentJP2).getText().equals("1")) {
								var1 = true;
							} else if (componentJP2 instanceof JLabel && ((JLabel) componentJP2).getText().equals("4")) {
								var4 = true;
							}
						}
					}
				}
			}
		}
		
		if (var1 && var4) {
			return true; 
		} else {
			return false;
		}
	}
	
	public static JButton getButton(JFrame frame, String nameButton) {
		Component[] componentsJF = frame.getContentPane().getComponents();
		for (Component componentJF : componentsJF) {
			if (componentJF instanceof JButton && ((JButton) componentJF).getActionCommand().equals(nameButton)) {
				JButton button = (JButton) componentJF;
				return button;
			}
		}
		return null;
	}
	
	public static JPanel getVisiblePanelChoix(JFrame frame) {
		Component[] componentsJF = frame.getContentPane().getComponents();
		for (Component componentJF : componentsJF) {
			if(componentJF instanceof JPanel) {
				Component[] componentsJP1 = ((JPanel)componentJF).getComponents();
				for(Component componentJP1 : componentsJP1) {
					if(componentJP1 instanceof JPanel) {
						Component[] componentsPanelChoix = ((JPanel)componentJP1).getComponents();
						for(Component componentPanelChoix : componentsPanelChoix) {
							if(componentPanelChoix instanceof JLabel && ((JLabel)componentPanelChoix).getText().equals("1") && ((JPanel)componentJF).isVisible()) {
								return (JPanel) componentJF;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public static JPanel getVisiblebordurebleu(JFrame frame) {
		Component[] componentsJF = frame.getContentPane().getComponents();
		for(Component componentJF : componentsJF) {
			if(componentJF instanceof JPanel && ((JPanel)componentJF).getBackground().equals(new Color(0,0,0,0)) && ((JPanel)componentJF).getBorder() instanceof LineBorder && ((JPanel)componentJF).isVisible()) {
				return (JPanel)componentJF;
			}
		}
		return null;
	}


	/**
	 * Create the application.
	 */
	public preparationcombat4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmpreparationcombat = new JFrame();
		frmpreparationcombat.setTitle("Préparation Combat");
		frmpreparationcombat.getContentPane().setBackground(new Color(0, 0, 0));
		frmpreparationcombat.getContentPane().setLayout(null);
		
		
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
	
		
        //-----------------------------------------PANNEAU TOUTES LES ZONES VALIDES--------------------------------------------
		JPanel PanelZoneNonValide = new JPanel();
		PanelZoneNonValide.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		PanelZoneNonValide.setBackground(new Color(0, 0, 0));
		PanelZoneNonValide.setBounds(304, 196, 772, 419);
		PanelZoneNonValide.setVisible(false);
		frmpreparationcombat.getContentPane().add(PanelZoneNonValide);
		PanelZoneNonValide.setLayout(null);
		
		
		JLabel LabelCompris = new JLabel("J'ai compris >");
		LabelCompris.setHorizontalAlignment(SwingConstants.CENTER);
		LabelCompris.setBounds(0, 0, 200, 38);
		LabelCompris.setFont(customFont.deriveFont(20f));
		LabelCompris.setForeground(Color.WHITE);
		
		JPanel PanelCompris = new JPanel();
		PanelCompris.setLayout(null);
		PanelCompris.setBackground(Color.GRAY);
		PanelCompris.setBounds(0,0, 200, 38);
		PanelCompris.add(LabelCompris);

		
		JButton ButtonCompris = new JButton("");
		ButtonCompris.setLayout(null);
		ButtonCompris.setBounds(298, 296, 200, 38);
		ButtonCompris.setBackground(Color.GRAY);
		ButtonCompris.add(PanelCompris);
		PanelZoneNonValide.add(ButtonCompris);
		
		
		JLabel lblNewLabel_1 = new JLabel("ATTENTION !! Vous devez positioner au moins ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(customFont.deriveFont(20f));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 49, 752, 46);
		PanelZoneNonValide.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("avant de commencer le combat !");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(customFont.deriveFont(20f));
		lblNewLabel_1_1.setBounds(10, 163, 752, 46);
		PanelZoneNonValide.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("1 combattant sur les zones conquis ou en combat");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_2.setFont(customFont.deriveFont(20f));
		lblNewLabel_1_2.setBounds(10, 106, 752, 46);
		PanelZoneNonValide.add(lblNewLabel_1_2);
		
		
		JLabel drapeau_victoire1 = new JLabel("");
		drapeau_victoire1.setBounds(269, 138, 40, 55);
		drapeau_victoire1.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\drapeau_victoire.PNG"));
		frmpreparationcombat.getContentPane().add(drapeau_victoire1);
		
		JLabel drapeau_defaite = new JLabel("");
		drapeau_defaite.setBounds(1226, 360, 40, 55);
		frmpreparationcombat.getContentPane().add(drapeau_defaite);
		drapeau_defaite.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\drapeau_defaite.PNG"));
		
		JLabel drapeau_victoire2 = new JLabel("");
		drapeau_victoire2.setBounds(815, 395, 40, 55);
		frmpreparationcombat.getContentPane().add(drapeau_victoire2);
		drapeau_victoire2.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\drapeau_victoire.PNG"));
		
        
    	  //-----------------------------------------------TITRE DE LA PAGE-----------------------------------------------------
        
		JLabel titrePage = new JLabel("C'est l'heure du combat !");
		titrePage.setHorizontalAlignment(SwingConstants.CENTER);
		titrePage.setBounds(246, 11, 944, 45);
		titrePage.setForeground(new Color(32, 102, 10));
		titrePage.setFont(customFont.deriveFont(24f));
		frmpreparationcombat.getContentPane().add(titrePage);
    		

      	  //-----------------------------------------------SOUS TITRE DE LA PAGE------------------------------------------------
          
		JLabel soustitrePage = new JLabel("Placez vos combattants sur les zones de combats !");
		soustitrePage.setHorizontalAlignment(SwingConstants.CENTER);
		soustitrePage.setBounds(246, 67, 944, 45);
		soustitrePage.setForeground(new Color(32, 102, 10));
		soustitrePage.setFont(customFont.deriveFont(24f));
		frmpreparationcombat.getContentPane().add(soustitrePage);
		
        //-------------------------------------------LOGO DU JEU EN HAUT A GAUCHE------------------------------------------------
    		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 135, 106);
		frmpreparationcombat.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
		
		
	  //-------------------------------------------------BOUTON CONTINUER--------------------------------------------------------

		JLabel LabelContinuer = new JLabel("Continuer >");
		LabelContinuer.setHorizontalAlignment(SwingConstants.CENTER);
		LabelContinuer.setBounds(0, 0, 186, 38);
		LabelContinuer.setFont(customFont.deriveFont(20f));
		LabelContinuer.setForeground(Color.WHITE);
		
		JPanel PanelContinuer = new JPanel();
		PanelContinuer.setLayout(null);
		PanelContinuer.setBackground(Color.GRAY);
		PanelContinuer.setBounds(0,0, 186, 38);
		PanelContinuer.add(LabelContinuer);

		
		JButton ButtonContinuer = new JButton("");
		ButtonContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VerificationAllNumber(frmpreparationcombat)) {
					animationcombat4.ouvreAnimation4();
					frmpreparationcombat.dispose();
				} else {
					PanelZoneNonValide.setVisible(true);
					ButtonContinuer.setVisible(false);
				}
			}
		});
		ButtonContinuer.setLayout(null);
		ButtonContinuer.setBounds(1220, 570, 186, 38);
		ButtonContinuer.setBackground(Color.GRAY);
		ButtonContinuer.add(PanelContinuer);
		frmpreparationcombat.getContentPane().add(ButtonContinuer);
		
		

		//----------------------------------------------------------------------------------------------------------------------
		
		JLabel schemaUTT = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\schemaUTT.png", 150, 150, 1150, 500);
		frmpreparationcombat.getContentPane().add(schemaUTT);
		
		next_x = 15;
		
		for (int i = 1; i <= 15; i++) {
			
		JButton ButtonSoldat = new JButton();
		ButtonSoldat.setBounds(next_x, 714, 65,100);
		ButtonSoldat.setBorder(null);
		ButtonSoldat.setLayout(null);
		ButtonSoldat.setActionCommand("Soldat_" + i);
		ButtonSoldat.setBackground(Color.GRAY);
		frmpreparationcombat.getContentPane().add(ButtonSoldat);
		
		next_x = next_x + ButtonSoldat.getWidth() + 6;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setVisible(false);
		panel.setBounds(ButtonSoldat.getX() - 26, 651, 129, 50);
		frmpreparationcombat.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel Panelchoix1 = new JPanel();
		Panelchoix1.setBorder(null);
		Panelchoix1.setBackground(Color.GRAY);
		Panelchoix1.setBounds(11, 15, 15, 20);
		Panelchoix1.setLayout(null);
		panel.add(Panelchoix1);
		JLabel choix1 = repartitionpoint.createLabelText("1", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix1.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix1.add(choix1);
		
		
		JPanel Panelchoix2 = new JPanel();
		Panelchoix2.setBackground(Color.GRAY);
		Panelchoix2.setBounds(34, 15, 15, 20);
		Panelchoix2.setLayout(null);
		panel.add(Panelchoix2);
		JLabel choix2 = repartitionpoint.createLabelText("2", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix2.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix2.add(choix2);
		
		JPanel Panelchoix3 = new JPanel();
		Panelchoix3.setBackground(Color.GRAY);
		Panelchoix3.setBounds(57, 15, 15, 20);
		Panelchoix3.setLayout(null);
		panel.add(Panelchoix3);
		JLabel choix3 = repartitionpoint.createLabelText("3", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix3.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix3.add(choix3);
		
		JPanel Panelchoix4 = new JPanel();
		Panelchoix4.setBackground(Color.GRAY);
		Panelchoix4.setBounds(80, 15, 15, 20);
		Panelchoix4.setLayout(null);
		panel.add(Panelchoix4);
		JLabel choix4 = repartitionpoint.createLabelText("4", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix4.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix4.add(choix4);
		
		JPanel Panelchoix5 = new JPanel();
		Panelchoix5.setBackground(Color.GRAY);
		Panelchoix5.setBounds(103, 15, 15, 20);
		Panelchoix5.setLayout(null);
		panel.add(Panelchoix5);
		JLabel choix5 = repartitionpoint.createLabelText("5", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix5.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix5.add(choix5);

		JLabel zone1 = new JLabel("1");
		zone1.setBounds(50, 0, 15, 20);
		zone1.setForeground(Color.WHITE);
		zone1.setFont(customFont.deriveFont(13f));
		zone1.setHorizontalAlignment(SwingConstants.CENTER);
		zone1.setVisible(false);
		ButtonSoldat.add(zone1);
		
		JLabel zone2 = new JLabel("2");
		zone2.setBounds(50, 0, 15, 20);
		zone2.setForeground(Color.WHITE);
		zone2.setFont(customFont.deriveFont(13f));
		zone2.setHorizontalAlignment(SwingConstants.CENTER);
		zone2.setVisible(false);
		ButtonSoldat.add(zone2);
		
		JLabel zone3 = new JLabel("3");
		zone3.setBounds(50, 0, 15, 20);
		zone3.setForeground(Color.WHITE);
		zone3.setFont(customFont.deriveFont(13f));
		zone3.setHorizontalAlignment(SwingConstants.CENTER);
		zone3.setVisible(false);
		ButtonSoldat.add(zone3);
		
		JLabel zone4 = new JLabel("4");
		zone4.setBounds(50, 0, 15, 20);
		zone4.setForeground(Color.WHITE);
		zone4.setFont(customFont.deriveFont(13f));
		zone4.setHorizontalAlignment(SwingConstants.CENTER);
		zone4.setVisible(false);
		ButtonSoldat.add(zone4);
		
		JLabel zone5 = new JLabel("5");
		zone5.setBounds(50, 0, 15, 20);
		zone5.setForeground(Color.WHITE);
		zone5.setFont(customFont.deriveFont(13f));
		zone5.setHorizontalAlignment(SwingConstants.CENTER);
		zone5.setVisible(false);
		ButtonSoldat.add(zone5);

		Panelchoix1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.BLUE);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(true);
				zone2.setVisible(false);
				zone3.setVisible(false);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.BLUE);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(true);
				zone3.setVisible(false);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.BLUE);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(false);
				zone3.setVisible(true);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.BLUE);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(false);
				zone3.setVisible(false);
				zone4.setVisible(true);
				zone5.setVisible(false);
			}
		});
//		Panelchoix5.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Panelchoix1.setBackground(Color.GRAY);
//				Panelchoix2.setBackground(Color.GRAY);
//				Panelchoix3.setBackground(Color.GRAY);
//				Panelchoix4.setBackground(Color.GRAY);
//				Panelchoix5.setBackground(Color.BLUE);
//				zone1.setVisible(false);
//				zone2.setVisible(false);
//				zone3.setVisible(false);
//				zone4.setVisible(false);
//				zone5.setVisible(true);
//			}
//		};

		
		JPanel PanelCombattant = new JPanel();
		PanelCombattant.setBorder(null);
		PanelCombattant.setOpaque(false);
		PanelCombattant.setBounds(0, 0, 65,100);
		ButtonSoldat.add(PanelCombattant);
		
		JLabel LabelImageSoldat = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\soldat_preparation.png", 0, 0, 65, 60);
		PanelCombattant.add(LabelImageSoldat);
		
		JProgressBar progressBar = repartitionpoint.createProgressBar(0, 100, 90, 0, 60, 65, 10);
		PanelCombattant.add(progressBar);
		
		JLabel LabelTextImage = repartitionpoint.createLabelText("Soldat " + i , customFont.deriveFont(10f), Color.WHITE, 0, 70,65,20);
		PanelCombattant.add(LabelTextImage);
		
		JPanel bordurebleu = new JPanel();
		bordurebleu.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		bordurebleu.setBounds(ButtonSoldat.getX()-2, ButtonSoldat.getY()-2, 69, 104);
		bordurebleu.setVisible(false);
		bordurebleu.setBackground(new Color(0,0,0,0));
		frmpreparationcombat.getContentPane().add(bordurebleu);
		
		
		ButtonSoldat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getVisiblePanelChoix(frmpreparationcombat) == null) {
					panel.setVisible(true);
					bordurebleu.setVisible(true);
				} else {
					getVisiblebordurebleu(frmpreparationcombat).setVisible(false);
					getVisiblePanelChoix(frmpreparationcombat).setVisible(false);
					panel.setVisible(true);
					bordurebleu.setVisible(true);
					}
				}
			});
		
		}
		
		
		//----------------------------------------------
		
		
		for (int i = 1; i <= 4; i++) {
			
		JButton ButtonSoldat = new JButton();
		ButtonSoldat.setBounds(next_x, 714, 65,100);
		ButtonSoldat.setBorder(null);
		ButtonSoldat.setLayout(null);
		ButtonSoldat.setActionCommand("Elite_" + i);
		ButtonSoldat.setBackground(Color.GRAY);
		frmpreparationcombat.getContentPane().add(ButtonSoldat);
		
		next_x = next_x + ButtonSoldat.getWidth() + 6;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setVisible(false);
		panel.setBounds(ButtonSoldat.getX() - 26, 651, 129, 50);
		frmpreparationcombat.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel Panelchoix1 = new JPanel();
		Panelchoix1.setBorder(null);
		Panelchoix1.setBackground(Color.GRAY);
		Panelchoix1.setBounds(11, 15, 15, 20);
		Panelchoix1.setLayout(null);
		panel.add(Panelchoix1);
		JLabel choix1 = repartitionpoint.createLabelText("1", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix1.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix1.add(choix1);
		
		
		JPanel Panelchoix2 = new JPanel();
		Panelchoix2.setBackground(Color.GRAY);
		Panelchoix2.setBounds(34, 15, 15, 20);
		Panelchoix2.setLayout(null);
		panel.add(Panelchoix2);
		JLabel choix2 = repartitionpoint.createLabelText("2", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix2.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix2.add(choix2);
		
		JPanel Panelchoix3 = new JPanel();
		Panelchoix3.setBackground(Color.GRAY);
		Panelchoix3.setBounds(57, 15, 15, 20);
		Panelchoix3.setLayout(null);
		panel.add(Panelchoix3);
		JLabel choix3 = repartitionpoint.createLabelText("3", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix3.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix3.add(choix3);
		
		JPanel Panelchoix4 = new JPanel();
		Panelchoix4.setBackground(Color.GRAY);
		Panelchoix4.setBounds(80, 15, 15, 20);
		Panelchoix4.setLayout(null);
		panel.add(Panelchoix4);
		JLabel choix4 = repartitionpoint.createLabelText("4", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix4.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix4.add(choix4);
		
		JPanel Panelchoix5 = new JPanel();
		Panelchoix5.setBackground(Color.GRAY);
		Panelchoix5.setBounds(103, 15, 15, 20);
		Panelchoix5.setLayout(null);
		panel.add(Panelchoix5);
		JLabel choix5 = repartitionpoint.createLabelText("5", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix5.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix5.add(choix5);

		JLabel zone1 = new JLabel("1");
		zone1.setBounds(50, 0, 15, 20);
		zone1.setForeground(Color.WHITE);
		zone1.setFont(customFont.deriveFont(13f));
		zone1.setHorizontalAlignment(SwingConstants.CENTER);
		zone1.setVisible(false);
		ButtonSoldat.add(zone1);
		
		JLabel zone2 = new JLabel("2");
		zone2.setBounds(50, 0, 15, 20);
		zone2.setForeground(Color.WHITE);
		zone2.setFont(customFont.deriveFont(13f));
		zone2.setHorizontalAlignment(SwingConstants.CENTER);
		zone2.setVisible(false);
		ButtonSoldat.add(zone2);
		
		JLabel zone3 = new JLabel("3");
		zone3.setBounds(50, 0, 15, 20);
		zone3.setForeground(Color.WHITE);
		zone3.setFont(customFont.deriveFont(13f));
		zone3.setHorizontalAlignment(SwingConstants.CENTER);
		zone3.setVisible(false);
		ButtonSoldat.add(zone3);
		
		JLabel zone4 = new JLabel("4");
		zone4.setBounds(50, 0, 15, 20);
		zone4.setForeground(Color.WHITE);
		zone4.setFont(customFont.deriveFont(13f));
		zone4.setHorizontalAlignment(SwingConstants.CENTER);
		zone4.setVisible(false);
		ButtonSoldat.add(zone4);
		
		JLabel zone5 = new JLabel("5");
		zone5.setBounds(50, 0, 15, 20);
		zone5.setForeground(Color.WHITE);
		zone5.setFont(customFont.deriveFont(13f));
		zone5.setHorizontalAlignment(SwingConstants.CENTER);
		zone5.setVisible(false);
		ButtonSoldat.add(zone5);

		Panelchoix1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.BLUE);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(true);
				zone2.setVisible(false);
				zone3.setVisible(false);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.BLUE);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(true);
				zone3.setVisible(false);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.BLUE);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(false);
				zone3.setVisible(true);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.BLUE);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(false);
				zone3.setVisible(false);
				zone4.setVisible(true);
				zone5.setVisible(false);
			}
		});
//		Panelchoix5.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Panelchoix1.setBackground(Color.GRAY);
//				Panelchoix2.setBackground(Color.GRAY);
//				Panelchoix3.setBackground(Color.GRAY);
//				Panelchoix4.setBackground(Color.GRAY);
//				Panelchoix5.setBackground(Color.BLUE);
//				zone1.setVisible(false);
//				zone2.setVisible(false);
//				zone3.setVisible(false);
//				zone4.setVisible(false);
//				zone5.setVisible(true);
//			}
//		});

		
		JPanel PanelCombattant = new JPanel();
		PanelCombattant.setBorder(null);
		PanelCombattant.setOpaque(false);
		PanelCombattant.setBounds(0, 0, 65,100);
		ButtonSoldat.add(PanelCombattant);
		
		JLabel LabelImageSoldat = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\elite_preparation.png", 0, 0, 65, 60);
		PanelCombattant.add(LabelImageSoldat);
		
		JProgressBar progressBar = repartitionpoint.createProgressBar(0, 100, 90, 0, 60, 65, 10);
		PanelCombattant.add(progressBar);
		
		JLabel LabelTextImage = repartitionpoint.createLabelText("Elite " + i , customFont.deriveFont(10f), Color.WHITE, 0, 70,65,20);
		PanelCombattant.add(LabelTextImage);
		
		JPanel bordurebleu = new JPanel();
		bordurebleu.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		bordurebleu.setBounds(ButtonSoldat.getX()-2, ButtonSoldat.getY()-2, 69, 104);
		bordurebleu.setVisible(false);
		bordurebleu.setBackground(new Color(0,0,0,0));
		frmpreparationcombat.getContentPane().add(bordurebleu);
		
		
		ButtonSoldat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getVisiblePanelChoix(frmpreparationcombat) == null) {
					panel.setVisible(true);
					bordurebleu.setVisible(true);
				} else {
					getVisiblebordurebleu(frmpreparationcombat).setVisible(false);
					getVisiblePanelChoix(frmpreparationcombat).setVisible(false);
					panel.setVisible(true);
					bordurebleu.setVisible(true);
					}
				}
			});
		
		}
		
		
		// ----------------------------
		
		
		
		JButton ButtonSoldat = new JButton();
		ButtonSoldat.setBounds(next_x, 714, 65,100);
		ButtonSoldat.setBorder(null);
		ButtonSoldat.setLayout(null);
		ButtonSoldat.setActionCommand("MDG");
		ButtonSoldat.setBackground(Color.GRAY);
		frmpreparationcombat.getContentPane().add(ButtonSoldat);
		
		next_x = next_x + ButtonSoldat.getWidth() + 5;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setVisible(false);
		panel.setBounds(ButtonSoldat.getX() - 45, 651, 129, 50);
		frmpreparationcombat.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel Panelchoix1 = new JPanel();
		Panelchoix1.setBorder(null);
		Panelchoix1.setBackground(Color.GRAY);
		Panelchoix1.setBounds(11, 15, 15, 20);
		Panelchoix1.setLayout(null);
		panel.add(Panelchoix1);
		JLabel choix1 = repartitionpoint.createLabelText("1", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix1.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix1.add(choix1);
		
		
		JPanel Panelchoix2 = new JPanel();
		Panelchoix2.setBackground(Color.GRAY);
		Panelchoix2.setBounds(34, 15, 15, 20);
		Panelchoix2.setLayout(null);
		panel.add(Panelchoix2);
		JLabel choix2 = repartitionpoint.createLabelText("2", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix2.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix2.add(choix2);
		
		
		JPanel Panelchoix3 = new JPanel();
		Panelchoix3.setBackground(Color.GRAY);
		Panelchoix3.setBounds(57, 15, 15, 20);
		Panelchoix3.setLayout(null);
		panel.add(Panelchoix3);
		JLabel choix3 = repartitionpoint.createLabelText("3", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix3.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix3.add(choix3);
		
		
		JPanel Panelchoix4 = new JPanel();
		Panelchoix4.setBackground(Color.GRAY);
		Panelchoix4.setBounds(80, 15, 15, 20);
		Panelchoix4.setLayout(null);
		panel.add(Panelchoix4);
		JLabel choix4 = repartitionpoint.createLabelText("4", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix4.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix4.add(choix4);
		
		
		JPanel Panelchoix5 = new JPanel();
		Panelchoix5.setBackground(Color.GRAY);
		Panelchoix5.setBounds(103, 15, 15, 20);
		Panelchoix5.setLayout(null);
		panel.add(Panelchoix5);
		JLabel choix5 = repartitionpoint.createLabelText("5", customFont.deriveFont(10f), Color.WHITE, 0, 0, 15, 20);
		choix5.setHorizontalAlignment(SwingConstants.CENTER);
		Panelchoix5.add(choix5);

		JLabel zone1 = new JLabel("1");
		zone1.setBounds(50, 0, 15, 20);
		zone1.setForeground(Color.WHITE);
		zone1.setFont(customFont.deriveFont(13f));
		zone1.setHorizontalAlignment(SwingConstants.CENTER);
		zone1.setVisible(false);
		ButtonSoldat.add(zone1);
		
		JLabel zone2 = new JLabel("2");
		zone2.setBounds(50, 0, 15, 20);
		zone2.setForeground(Color.WHITE);
		zone2.setFont(customFont.deriveFont(13f));
		zone2.setHorizontalAlignment(SwingConstants.CENTER);
		zone2.setVisible(false);
		ButtonSoldat.add(zone2);
		
		JLabel zone3 = new JLabel("3");
		zone3.setBounds(50, 0, 15, 20);
		zone3.setForeground(Color.WHITE);
		zone3.setFont(customFont.deriveFont(13f));
		zone3.setHorizontalAlignment(SwingConstants.CENTER);
		zone3.setVisible(false);
		ButtonSoldat.add(zone3);
		
		JLabel zone4 = new JLabel("4");
		zone4.setBounds(50, 0, 15, 20);
		zone4.setForeground(Color.WHITE);
		zone4.setFont(customFont.deriveFont(13f));
		zone4.setHorizontalAlignment(SwingConstants.CENTER);
		zone4.setVisible(false);
		ButtonSoldat.add(zone4);
		
		JLabel zone5 = new JLabel("5");
		zone5.setBounds(50, 0, 15, 20);
		zone5.setForeground(Color.WHITE);
		zone5.setFont(customFont.deriveFont(13f));
		zone5.setHorizontalAlignment(SwingConstants.CENTER);
		zone5.setVisible(false);
		ButtonSoldat.add(zone5);

		Panelchoix1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.BLUE);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(true);
				zone2.setVisible(false);
				zone3.setVisible(false);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.BLUE);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(true);
				zone3.setVisible(false);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.BLUE);
				Panelchoix4.setBackground(Color.GRAY);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(false);
				zone3.setVisible(true);
				zone4.setVisible(false);
				zone5.setVisible(false);
			}
		});
		Panelchoix4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panelchoix1.setBackground(Color.GRAY);
				Panelchoix2.setBackground(Color.GRAY);
				Panelchoix3.setBackground(Color.GRAY);
				Panelchoix4.setBackground(Color.BLUE);
				Panelchoix5.setBackground(Color.GRAY);
				zone1.setVisible(false);
				zone2.setVisible(false);
				zone3.setVisible(false);
				zone4.setVisible(true);
				zone5.setVisible(false);
			}
		});
//		Panelchoix5.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Panelchoix1.setBackground(Color.GRAY);
//				Panelchoix2.setBackground(Color.GRAY);
//				Panelchoix3.setBackground(Color.GRAY);
//				Panelchoix4.setBackground(Color.GRAY);
//				Panelchoix5.setBackground(Color.BLUE);
//				zone1.setVisible(false);
//				zone2.setVisible(false);
//				zone3.setVisible(false);
//				zone4.setVisible(false);
//				zone5.setVisible(true);
//			}
//		});
		
		JPanel PanelCombattant = new JPanel();
		PanelCombattant.setBorder(null);
		PanelCombattant.setOpaque(false);
		PanelCombattant.setBounds(0, 0, 65,100);
		ButtonSoldat.add(PanelCombattant);
		
		JLabel LabelImageSoldat = repartitionpoint.createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\MDG_preparation.png", 0, 0, 65, 60);
		PanelCombattant.add(LabelImageSoldat);
		
		JProgressBar progressBar = repartitionpoint.createProgressBar(0, 100, 90, 0, 60, 65, 10);
		PanelCombattant.add(progressBar);
		
		JLabel LabelTextImage = repartitionpoint.createLabelText("MDG", customFont.deriveFont(10f), Color.WHITE, 0, 70,65,20);
		PanelCombattant.add(LabelTextImage);
		
	
		JPanel bordurebleu = new JPanel();
		bordurebleu.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		bordurebleu.setBounds(ButtonSoldat.getX()-2, ButtonSoldat.getY()-2, 69, 104);
		bordurebleu.setVisible(false);
		bordurebleu.setBackground(new Color(0,0,0,0));
		frmpreparationcombat.getContentPane().add(bordurebleu);
		
		JLabel logoElimine = new JLabel("");
		logoElimine.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\croix_legende.PNG"));
		logoElimine.setBounds(10, 520, 40, 55);
		frmpreparationcombat.getContentPane().add(logoElimine);
		
		JLabel logoencombat = new JLabel("");
		logoencombat.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\poing_legende.PNG"));
		logoencombat.setBounds(10, 586, 40, 55);
		frmpreparationcombat.getContentPane().add(logoencombat);
		
		JLabel labelElimine= new JLabel("Eliminé");
		labelElimine.setFont(customFont.deriveFont(10f));
		labelElimine.setForeground(new Color(255, 255, 255));
		labelElimine.setBounds(60, 533, 106, 33);
		frmpreparationcombat.getContentPane().add(labelElimine);
		
		JLabel labelencombat = new JLabel("Toujours en combat");
		labelencombat.setFont(customFont.deriveFont(10f));
		labelencombat.setForeground(new Color(255, 255, 255));
		labelencombat.setBounds(60, 599, 154, 29);
		frmpreparationcombat.getContentPane().add(labelencombat);
		
		
		ButtonSoldat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getVisiblePanelChoix(frmpreparationcombat) == null) {
					panel.setVisible(true);
					bordurebleu.setVisible(true);
				} else {
					getVisiblebordurebleu(frmpreparationcombat).setVisible(false);
					getVisiblePanelChoix(frmpreparationcombat).setVisible(false);
					panel.setVisible(true);
					bordurebleu.setVisible(true);
					}
				}
			});
		
		ButtonCompris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelZoneNonValide.setVisible(false);
				ButtonContinuer.setVisible(true);
			}
		});
		String encombat[] = {"Soldat_2", "Soldat_4", "Soldat_6", "Soldat_7", "Soldat_9"};
		String elimines[] = {"Soldat_1", "Soldat_3", "Soldat_5", "Elite_2", "Elite_4", "Soldat_14", "Soldat_8", "Soldat_10", "Soldat_12"};
		
		for (String elimine : elimines) {
			JButton button = getButton(frmpreparationcombat, elimine);
			JPanel masque = new JPanel();
			masque.setBackground(Color.BLACK);
			masque.setBounds(0, 0, 65, 100);
			button.add(masque);
			button.setComponentZOrder(masque, 0);
			JLabel Labelelimine = new JLabel("");
			Labelelimine.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\elimination.PNG"));
			Labelelimine.setBounds(0, 0, 65, 100);
			button.add(Labelelimine);
			button.setComponentZOrder(Labelelimine, 0);
			button.setEnabled(false);
			button.setBackground(Color.BLACK);
		}
		
		for (String combat : encombat) {
			JButton button = getButton(frmpreparationcombat, combat);
			JPanel masque = new JPanel();
			masque.setBackground(Color.BLACK);
			masque.setBounds(0, 0, 65, 100);
			button.add(masque);
			button.setComponentZOrder(masque, 0);
			JLabel Labelencombat = new JLabel("");
			Labelencombat.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\encombat.PNG"));
			Labelencombat.setBounds(0, 0, 65, 100);
			button.add(Labelencombat);
			button.setComponentZOrder(Labelencombat, 0);
			button.setEnabled(false);
			button.setBackground(Color.BLACK);
		}
		
		
		frmpreparationcombat.setBounds(-8, 0, 2880, 1800);
		frmpreparationcombat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}