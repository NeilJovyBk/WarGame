import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class repartitionpoint {

	private JFrame frmRepartition;
	private Font customFont;
	private int points;

	/**
	 * Launch the application.
	 */
	public static void ouvreRepartition () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					repartitionpoint window = new repartitionpoint();
					window.frmRepartition.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public repartitionpoint() {
		initialize();
	}
	
	public static JProgressBar createProgressBar(int min, int max, int value, int x, int y, int width, int height) {
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(min);
		progressBar.setMaximum(max);
		progressBar.setValue(value);
		progressBar.setBounds(x, y, width, height);
		
		return progressBar;
	}
	
	public static JLabel createLabelImage(String lien, int x, int y, int width, int height) {
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(lien));
		label.setBounds(x, y, width, height);
		return label;
	}
	
	public static JLabel createLabelText(String text, Font font, Color color, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setFont(font);
		label.setForeground(color);
		label.setBounds(x, y, width, height);
		
		return label;
	}

    public static JPanel getPanelByName(JLayeredPane layeredPane, String name) {
        Component[] components = layeredPane.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel && component.getName().equals(name)) {
                return (JPanel) component;
            }
        }
        return null;
    }
    
    public static JButton getButtonByName(JPanel panel, String name) {
    	Component[] components = panel.getComponents();
    	for(Component component : components) {
    		if(component instanceof JButton) {
    			JButton button = (JButton) component;
    			if(button.getActionCommand().equals(name)) {
    				return button;
    			}
    		}
    		 
    	}
    	return null;
    }
    
    public static JPanel getPanelByButton(JPanel panel, String name) {
    	Component[] components = panel.getComponents();
    	for(Component component : components) {
    		if(component instanceof JButton) {
    			JButton button = (JButton) component;
    			if(button.getActionCommand().equals(name)) {
    				Component[] componentsButton = button.getComponents();
    				for(Component componentButton : componentsButton) {
    					if(componentButton instanceof JPanel) {
    						return (JPanel) componentButton;
    					}
    				}
    			}
    		}
    		 
    	}
    	return null;
    }
    
    public static int CompterNbReserviste(JFrame frame) {
    	int nbreserviste = 0;
    	Component[] componentsJF = frame.getContentPane().getComponents();
    	for(Component componentJF : componentsJF) {
    		if(componentJF instanceof JLayeredPane) {
    			Component[] componentsJL = ((JLayeredPane) componentJF).getComponents();
    			for (Component componentJL : componentsJL) {
    				if(componentJL instanceof JPanel) {
    					Component[] componentsJP = ((JPanel) componentJL).getComponents();
    					for (Component componentJP : componentsJP) {
    						if (componentJP instanceof JCheckBox) {
    							if(((JCheckBox)componentJP).isSelected()) {
    								nbreserviste++;
    							}
    						}
    					}	
    				}
    			}
    		}
    	}
    	return nbreserviste;
    }
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		points = 400;
		
		frmRepartition = new JFrame();
		frmRepartition.setTitle("Répartitions des points");
		frmRepartition.getContentPane().setBackground(new Color(0, 0, 0));
		frmRepartition.getContentPane().setLayout(null);
		
		
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
		
  	  //-----------------------------------------------TITRE DE LA PAGE-----------------------------------------------------
        
  		JLabel titrePageReparatition = new JLabel("C'est ici que tu affectes tes points pour la bataille !");
  		titrePageReparatition.setHorizontalAlignment(SwingConstants.CENTER);
  		titrePageReparatition.setBounds(246, 27, 944, 45);
  		titrePageReparatition.setForeground(new Color(32, 102, 10));
  		titrePageReparatition.setFont(customFont.deriveFont(24f));
  		frmRepartition.getContentPane().add(titrePageReparatition);
		
      //-------------------------------------------LOGO DU JEU EN HAUT A GAUCHE---------------------------------------------
  		
  		JLabel lblNewLabel = new JLabel("");
  		lblNewLabel.setBounds(10, 11, 135, 106);
  		frmRepartition.getContentPane().add(lblNewLabel);
  		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\logo_projet.png"));
		
		
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
		frmRepartition.getContentPane().add(ButtonRetour);
		ButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camp.ouvreCamp();
				frmRepartition.dispose();
			}
		});	

        //-----------------------------------------PANNEAU TROP DE RESERVISTE--------------------------------------------
		JPanel PanelTropdereserviste = new JPanel();
		PanelTropdereserviste.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		PanelTropdereserviste.setBackground(new Color(0, 0, 0));
		PanelTropdereserviste.setBounds(350, 196, 772, 419);
		PanelTropdereserviste.setVisible(false);
		frmRepartition.getContentPane().add(PanelTropdereserviste);
		PanelTropdereserviste.setLayout(null);
		
		
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
		PanelTropdereserviste.add(ButtonCompris);
		
		
		JLabel lblNewLabel_1 = new JLabel("ATTENTION !! Vous devez selectionner");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(customFont.deriveFont(20f));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 49, 752, 46);
		PanelTropdereserviste.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trop de réservistes selectionnés");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(customFont.deriveFont(20f));
		lblNewLabel_1_1.setBounds(10, 163, 752, 46);
		PanelTropdereserviste.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("5 réservistes uniquement !");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_2.setFont(customFont.deriveFont(20f));
		lblNewLabel_1_2.setBounds(10, 106, 752, 46);
		PanelTropdereserviste.add(lblNewLabel_1_2);
		
		//-----------------------------------------PANNEAU PEU DE RESERVISTE--------------------------------------------
		JPanel PanelPeudereserviste = new JPanel();
		PanelPeudereserviste.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		PanelPeudereserviste.setBackground(new Color(0, 0, 0));
		PanelPeudereserviste.setBounds(350, 196, 772, 419);
		PanelPeudereserviste.setVisible(false);
		frmRepartition.getContentPane().add(PanelPeudereserviste);
		PanelPeudereserviste.setLayout(null);
		
		
		JLabel LabelCompris2 = new JLabel("J'ai compris >");
		LabelCompris2.setHorizontalAlignment(SwingConstants.CENTER);
		LabelCompris2.setBounds(0, 0, 200, 38);
		LabelCompris2.setFont(customFont.deriveFont(20f));
		LabelCompris2.setForeground(Color.WHITE);
		
		JPanel PanelCompris2 = new JPanel();
		PanelCompris2.setLayout(null);
		PanelCompris2.setBackground(Color.GRAY);
		PanelCompris2.setBounds(0,0, 200, 38);
		PanelCompris2.add(LabelCompris2);

		
		JButton ButtonCompris2 = new JButton("");
		ButtonCompris2.setLayout(null);
		ButtonCompris2.setBounds(298, 296, 200, 38);
		ButtonCompris2.setBackground(Color.GRAY);
		ButtonCompris2.add(PanelCompris2);
		PanelPeudereserviste.add(ButtonCompris2);
		
		
		JLabel labelAttreserviste = new JLabel("ATTENTION !! Vous devez selectionner");
		labelAttreserviste.setHorizontalAlignment(SwingConstants.CENTER);
		labelAttreserviste.setFont(customFont.deriveFont(20f));
		labelAttreserviste.setForeground(new Color(255, 255, 255));
		labelAttreserviste.setBounds(10, 49, 752, 46);
		PanelPeudereserviste.add(labelAttreserviste);
		
		JLabel labelAttreserviste1 = new JLabel("Pas assez de réservistes selectionnés");
		labelAttreserviste1.setHorizontalAlignment(SwingConstants.CENTER);
		labelAttreserviste1.setForeground(Color.WHITE);
		labelAttreserviste1.setFont(customFont.deriveFont(20f));
		labelAttreserviste1.setBounds(10, 163, 752, 46);
		PanelPeudereserviste.add(labelAttreserviste1);
		
		JLabel labelAttreserviste2 = new JLabel("5 réservistes uniquement !");
		labelAttreserviste2.setHorizontalAlignment(SwingConstants.CENTER);
		labelAttreserviste2.setForeground(new Color(0, 128, 0));
		labelAttreserviste2.setFont(customFont.deriveFont(20f));
		labelAttreserviste2.setBounds(10, 106, 752, 46);
		PanelPeudereserviste.add(labelAttreserviste2);

   
	  //----------------------------------------BOUTON CONFIRMATION--------------------------------------

		JLabel LabelConfirmation = new JLabel("Confirmation >");
		LabelConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		LabelConfirmation.setBounds(0, 0, 220, 38);
		LabelConfirmation.setFont(customFont.deriveFont(20f));
		LabelConfirmation.setForeground(Color.WHITE);
		
		JPanel PanelConfirmation = new JPanel();
		PanelConfirmation.setLayout(null);
		PanelConfirmation.setBackground(Color.GRAY);
		PanelConfirmation.setBounds(0,0, 220, 38);
		PanelConfirmation.add(LabelConfirmation);

		
		JButton ButtonConfirmation = new JButton("");
		ButtonConfirmation.setLayout(null);
		ButtonConfirmation.setVisible(true);
		ButtonConfirmation.setBounds(1175, 738, 220, 38);
		ButtonConfirmation.setBackground(Color.GRAY);
		ButtonConfirmation.add(PanelConfirmation);
		frmRepartition.getContentPane().add(ButtonConfirmation);
		ButtonConfirmation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CompterNbReserviste(frmRepartition) == 5) {
					preparationcombat.ouvrePreparation();
					frmRepartition.dispose();
				}
				else if (CompterNbReserviste(frmRepartition) > 5) {
					ButtonConfirmation.setVisible(false);
					PanelTropdereserviste.setVisible(true);
				} 
				else {
					ButtonConfirmation.setVisible(false);
					PanelPeudereserviste.setVisible(true);
				}
			}
		});	
		
		JLabel LabelImagePoints = new JLabel("");
		LabelImagePoints.setIcon(new ImageIcon("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\points.PNG"));
		LabelImagePoints.setBounds(1388, 68, 34, 34);
		frmRepartition.getContentPane().add(LabelImagePoints);
		
	
  	  //---------------------------------------------------------------------------------------------------------------------
		
		JLabel LabelAffichagePoint = new JLabel("");
		LabelAffichagePoint.setText(""+ points);
		LabelAffichagePoint.setBounds(1320, 66, 68, 38);
		LabelAffichagePoint.setFont(customFont.deriveFont(20f));
		LabelAffichagePoint.setForeground(Color.WHITE);
		frmRepartition.getContentPane().add(LabelAffichagePoint);
		
		//--------------------------------------PANNEAU LATERAL CHOIX COMBATTANT--------------------------------------------
		
		JScrollPane scrollPaneChoixCombattant = new JScrollPane();
		scrollPaneChoixCombattant.setBounds(31, 168, 157, 500);
		scrollPaneChoixCombattant.setBorder(null);
		frmRepartition.getContentPane().add(scrollPaneChoixCombattant);
		
		
		
		JPanel PanelChoixCombattant = new JPanel();
		PanelChoixCombattant.setPreferredSize(new Dimension(140, 1200));
		PanelChoixCombattant.setLayout(new BoxLayout(PanelChoixCombattant, BoxLayout.Y_AXIS));
		scrollPaneChoixCombattant.setViewportView(PanelChoixCombattant);
		
		for (int i = 1; i <= 15; i++) {
		
			JButton ButtonSoldat = new JButton();
			ButtonSoldat.setAlignmentX(Component.CENTER_ALIGNMENT);
			ButtonSoldat.setMaximumSize(new Dimension(140, 40));
			ButtonSoldat.setBorder(null);
			ButtonSoldat.setActionCommand("soldat_" + i); //ID = soldat_i
			PanelChoixCombattant.add(ButtonSoldat);
			
			JPanel PanelSoldat = new JPanel();
			PanelSoldat.setPreferredSize(new Dimension(140, 40));
			PanelSoldat.setLayout(null);
			PanelSoldat.setBackground(Color.GRAY);
			ButtonSoldat.add(PanelSoldat);
			
			JLabel LabelSoldat = new JLabel("Soldat "+i);
			LabelSoldat.setBounds(0,0,140,40);
			LabelSoldat.setHorizontalAlignment(SwingConstants.CENTER);
			LabelSoldat.setFont(customFont.deriveFont(16f));
			LabelSoldat.setForeground(Color.WHITE);
			PanelSoldat.add(LabelSoldat);
			
			JPanel PanelNoir = new JPanel();
			PanelNoir.setBackground(Color.BLACK);
			PanelNoir.setMaximumSize(new Dimension(140, 20));
			PanelChoixCombattant.add(PanelNoir);
			
		}
		
		for (int i = 1; i <= 4; i++) {
			
			JButton ButtonSoldatElite = new JButton();
			ButtonSoldatElite.setAlignmentX(Component.CENTER_ALIGNMENT);
			ButtonSoldatElite.setMaximumSize(new Dimension(140, 40));
			ButtonSoldatElite.setBorder(null);
			ButtonSoldatElite.setActionCommand("elite_" + i); // ID = elite_i
			PanelChoixCombattant.add(ButtonSoldatElite);
			
			JPanel PanelSoldatElite = new JPanel();
			PanelSoldatElite.setPreferredSize(new Dimension(140, 40));
			PanelSoldatElite.setLayout(null);
			PanelSoldatElite.setBackground(Color.GRAY);
			ButtonSoldatElite.add(PanelSoldatElite);
			
			JLabel LabelSoldatElite = new JLabel("Elite "+i);
			LabelSoldatElite.setBounds(0,0,140,40);
			LabelSoldatElite.setHorizontalAlignment(SwingConstants.CENTER);
			LabelSoldatElite.setFont(customFont.deriveFont(16f));
			LabelSoldatElite.setForeground(Color.WHITE);
			PanelSoldatElite.add(LabelSoldatElite);
			
			JPanel PanelNoir = new JPanel();
			PanelNoir.setBackground(Color.BLACK);
			PanelNoir.setMaximumSize(new Dimension(140, 20));
			PanelChoixCombattant.add(PanelNoir);
			
		}
		
		JButton ButtonMaitre = new JButton();
		ButtonMaitre.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonMaitre.setMaximumSize(new Dimension(140, 40));
		ButtonMaitre.setBorder(null);
		ButtonMaitre.setActionCommand("maitre"); //ID = maitre
		PanelChoixCombattant.add(ButtonMaitre);
		
		JPanel PanelMaitre = new JPanel();
		PanelMaitre.setPreferredSize(new Dimension(140, 40));
		PanelMaitre.setLayout(null);
		PanelMaitre.setBackground(Color.GRAY);
		ButtonMaitre.add(PanelMaitre);
		
		JLabel LabelMaitre = new JLabel("Maître");
		LabelMaitre.setBounds(0,0,140,40);
		LabelMaitre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMaitre.setFont(customFont.deriveFont(16f));
		LabelMaitre.setForeground(Color.WHITE);
		PanelMaitre.add(LabelMaitre);
		
		JPanel PanelNoir = new JPanel();
		PanelNoir.setBackground(Color.BLACK);
		PanelNoir.setMaximumSize(new Dimension(140, 20));
		PanelChoixCombattant.add(PanelNoir);
	//-------------------------------------------------CHANGEMENT DE COULEUR------------------------------------------------
		
		String liste[] = {"soldat_1", "soldat_2", "soldat_3", "soldat_4", "soldat_5", "soldat_6", "soldat_7", "soldat_8", "soldat_9", "soldat_10", "soldat_11", "soldat_12", "soldat_13", "soldat_14", "soldat_15", "elite_1", "elite_2", "elite_3", "elite_4", "maitre" };
		
		for(String i : liste) {
			getButtonByName(PanelChoixCombattant, i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (String j : liste) {
						if (j == i) {
							getPanelByButton(PanelChoixCombattant, j).setBackground(Color.BLUE);
						} else {
							getPanelByButton(PanelChoixCombattant, j).setBackground(Color.GRAY);
						}
					}
				}
			});	
			
		}
		
		
		
		
		
	//-------------------------------------------------CREATION D'UN PANEL---------------------------------------------------
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		layeredPane.setBounds(246, 126, 1105, 602);
		frmRepartition.getContentPane().add(layeredPane);
		

		
		for (int i = 1; i <= 15; i++) {
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0,0, 1105, 602);
		panel.setName("Soldat_" + i);
		layeredPane.add(panel, new Integer(i-1));
		panel.setLayout(null);
		
		JLabel labelTitreSoldat = new JLabel("Soldat " + i);
		labelTitreSoldat.setBounds(421, 11, 157, 45);
		panel.add(labelTitreSoldat);
		labelTitreSoldat.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitreSoldat.setForeground(Color.WHITE);
		labelTitreSoldat.setFont(customFont.deriveFont(20f));

		JLabel lblNewLabel_2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\soldat.PNG",47, 168, 224, 218);
		panel.add(lblNewLabel_2);
		

		
		JLabel image_moins1 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 101, 25, 25);
		panel.add(image_moins1);
		JProgressBar progressBar1 = createProgressBar(0, 100, 30, 517, 101, 543, 15);
		panel.add(progressBar1);
		JLabel image_plus1 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 101, 25, 25);
		panel.add(image_plus1);
		JLabel LabelPDV = createLabelText("PointsDeVie(30)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 101, 175, 25);
		panel.add(LabelPDV);
		image_moins1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar1.getValue() > progressBar1.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar1.setValue(progressBar1.getValue()-1);
					LabelPDV.setText("PointsDeVie("+ (progressBar1.getValue()) + ")");
				}
			}
		});
		
		image_plus1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar1.getValue() < progressBar1.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar1.setValue(progressBar1.getValue()+1);
					LabelPDV.setText("PointsDeVie("+ (progressBar1.getValue()) + ")");
					
				}
			}
		});
		
		
		JLabel image_moins2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 145, 25, 25);
		panel.add(image_moins2);
		JProgressBar progressBar2 = createProgressBar(0, 10, 0, 517, 145, 543, 15);
		panel.add(progressBar2);
		JLabel image_plus2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 145, 25, 25);
		panel.add(image_plus2);
		JLabel LabelForce = createLabelText("Force(0)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 145, 175, 25);
		panel.add(LabelForce);
		image_moins2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar2.getValue() > progressBar2.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar2.setValue(progressBar2.getValue()-1);
					LabelForce.setText("Force("+ (progressBar2.getValue()) +")");
				}
			}
		});
		
		image_plus2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar2.getValue() < progressBar2.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar2.setValue(progressBar2.getValue()+1);
					LabelForce.setText("Force("+ progressBar2.getValue() +")");
					
				}
			}
		});
		
		JLabel image_moins3 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 190, 25, 25);
		panel.add(image_moins3);
		JProgressBar progressBar3 = createProgressBar(0, 10, 0, 517, 190, 543, 15);
		panel.add(progressBar3);
		JLabel image_plus3 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 190, 25, 25);
		panel.add(image_plus3);
		JLabel LabelDextérité = createLabelText("Dextérité(0)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 190, 175, 25);
		panel.add(LabelDextérité);
		image_moins3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar3.getValue() > progressBar3.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar3.setValue(progressBar3.getValue()-1);
					LabelDextérité.setText("Dextérité("+ progressBar3.getValue() +")");
				}
			}
		});
		
		image_plus3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar3.getValue() < progressBar3.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar3.setValue(progressBar3.getValue()+1);
					LabelDextérité.setText("Dextérité("+ progressBar3.getValue() +")");
					
				}
			}
		});
		
		
		JLabel image_moins4 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 242, 25, 25);
		panel.add(image_moins4);
		JProgressBar progressBar4 = createProgressBar(0, 10, 0, 517, 242, 543, 15);
		panel.add(progressBar4);
		JLabel image_plus4 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 242, 25, 25);
		panel.add(image_plus4);
		JLabel LabelRésistance = createLabelText("Résistance(0)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 242, 175, 25);
		panel.add(LabelRésistance);
		image_moins4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar4.getValue() > progressBar4.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar4.setValue(progressBar4.getValue()-1);
					LabelRésistance.setText("Résistance("+ progressBar4.getValue() +")");
				}
			}
		});
		
		image_plus4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar4.getValue() < progressBar4.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar4.setValue(progressBar4.getValue()+1);
					LabelRésistance.setText("Résistance("+ progressBar4.getValue() +")");	
				}
			}
		});
		
		JLabel image_moins5 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 293, 25, 25);
		panel.add(image_moins5);
		JProgressBar progressBar5 = createProgressBar(0, 30, 0, 517, 293, 543, 15);
		panel.add(progressBar5);
		JLabel image_plus5 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 293, 25, 25);
		panel.add(image_plus5);
		JLabel LabelConstitution = createLabelText("Constitution(0)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 293, 175, 25);
		panel.add(LabelConstitution);
		image_moins5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar5.getValue() > progressBar5.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar5.setValue(progressBar5.getValue()-1);
					LabelConstitution.setText("Constitution("+ progressBar5.getValue() +")");
				}
			}
		});
		image_plus5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar5.getValue() < progressBar5.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar5.setValue(progressBar5.getValue()+1);
					LabelConstitution.setText("Constitution("+ progressBar5.getValue() +")");
					
				}
			}
		});
		
		
		
		JLabel image_moins6 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 345, 25, 25);
		panel.add(image_moins6);
		JProgressBar progressBar6 = createProgressBar(0, 10, 0, 517, 345, 543, 15);
		panel.add(progressBar6);
		JLabel image_plus6 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 345, 25, 25);
		panel.add(image_plus6);
		JLabel LabelInitiative = createLabelText("Initiative(0)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 345, 175, 25);
		panel.add(LabelInitiative);
		image_moins6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar6.getValue() > progressBar6.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar6.setValue(progressBar6.getValue()-1);
					LabelInitiative.setText("Initiative("+ progressBar6.getValue() +")");
				}
			}
		});
		image_plus6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar6.getValue() < progressBar6.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar6.setValue(progressBar6.getValue()+1);
					LabelInitiative.setText("Initiative("+ progressBar6.getValue() +")");
					
				}
			}
		});
	
		
		JLabel LabelIA = createLabelText("Intelligence Artificielle",customFont.deriveFont(15f), new Color(48, 179, 9),281, 395, 224, 25);
		panel.add(LabelIA);
		
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(581, 394, 100, 25);
		panel.add(panel_1);
		panel_1.setBackground(new Color(48, 179, 9));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Offensif");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 100, 25);
		lblNewLabel_5.setFont(customFont.deriveFont(15f));
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(744, 394, 100, 25);
		panel.add(panel_2);
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Defensif");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 100, 25);
		lblNewLabel_6.setFont(customFont.deriveFont(15f));
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(907, 394, 100, 25);
		panel.add(panel_3);
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Aléatoire");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 100, 25);
		lblNewLabel_7.setFont(customFont.deriveFont(15f));
		panel_3.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(713, 443, 25, 33);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setFont(customFont.deriveFont(15f));
		chckbxNewCheckBox.setForeground(new Color(48, 179, 9));
		chckbxNewCheckBox.setBorder(null);
		panel.add(chckbxNewCheckBox);
		
		JLabel LabelReserviste = new JLabel("Réserviste");
		LabelReserviste.setFont(customFont.deriveFont(15f));
		LabelReserviste.setForeground(new Color(48, 179, 9));
		LabelReserviste.setBounds(731, 443, 145, 33);
		panel.add(LabelReserviste);
	
		
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(48, 179, 9));
				panel_2.setBackground(new Color(192, 192, 192));
				panel_3.setBackground(new Color(192, 192, 192));
			}
		});
		
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(192, 192, 192));
				panel_2.setBackground(new Color(48, 179, 9));
				panel_3.setBackground(new Color(192, 192, 192));
			}
		});
		
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(192, 192, 192));
				panel_2.setBackground(new Color(192, 192, 192));
				panel_3.setBackground(new Color(48, 179, 9));
			}
		});
		
		}
		//-----------------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------------
		for (int i = 16; i <= 20; i++) {
			
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(105, 105, 105));
			panel.setBounds(0,0, 1105, 602);
			panel.setName("Elite_" + (i-15));
			layeredPane.add(panel, new Integer(i-1));
			panel.setLayout(null);
			
			JLabel labelTitreSoldat = new JLabel("Elite " + (i-15));
			labelTitreSoldat.setBounds(421, 11, 157, 45);
			panel.add(labelTitreSoldat);
			labelTitreSoldat.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitreSoldat.setForeground(Color.WHITE);
			labelTitreSoldat.setFont(customFont.deriveFont(20f));

			JLabel lblNewLabel_2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\Elite.PNG",47, 168, 200, 300);
			panel.add(lblNewLabel_2);
			

			
			JLabel image_moins1 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 101, 25, 25);
			panel.add(image_moins1);
			JProgressBar progressBar1 = createProgressBar(0, 100, 30, 517, 101, 543, 15);
			panel.add(progressBar1);
			JLabel image_plus1 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 101, 25, 25);
			panel.add(image_plus1);
			JLabel LabelPDV = createLabelText("PointsDeVie(30)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 101, 175, 25);
			panel.add(LabelPDV);
			image_moins1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar1.getValue() > progressBar1.getMinimum()) && (points >= 0) && (points < 400)) {
						points++;
						LabelAffichagePoint.setText(""+ points);
						progressBar1.setValue(progressBar1.getValue()-1);
						LabelPDV.setText("PointsDeVie("+ (progressBar1.getValue()) + ")");
					}
				}
			});
			
			image_plus1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar1.getValue() < progressBar1.getMaximum()) && (points > 0) && (points <= 400)) {
						points--;
						LabelAffichagePoint.setText(""+ points);
						progressBar1.setValue(progressBar1.getValue()+1);
						LabelPDV.setText("PointsDeVie("+ (progressBar1.getValue()) + ")");
						
					}
				}
			});
			
			
			JLabel image_moins2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 145, 25, 25);
			panel.add(image_moins2);
			JProgressBar progressBar2 = createProgressBar(0, 10, 1, 517, 145, 543, 15);
			panel.add(progressBar2);
			JLabel image_plus2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 145, 25, 25);
			panel.add(image_plus2);
			JLabel LabelForce = createLabelText("Force(1)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 145, 175, 25);
			panel.add(LabelForce);
			image_moins2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar2.getValue() > progressBar2.getMinimum()) && (points >= 0) && (points < 400)) {
						points++;
						LabelAffichagePoint.setText(""+ points);
						progressBar2.setValue(progressBar2.getValue()-1);
						LabelForce.setText("Force("+ (progressBar2.getValue()) +")");
					}
				}
			});
			
			image_plus2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar2.getValue() < progressBar2.getMaximum()) && (points > 0) && (points <= 400)) {
						points--;
						LabelAffichagePoint.setText(""+ points);
						progressBar2.setValue(progressBar2.getValue()+1);
						LabelForce.setText("Force("+ progressBar2.getValue() +")");
						
					}
				}
			});
			
			JLabel image_moins3 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 190, 25, 25);
			panel.add(image_moins3);
			JProgressBar progressBar3 = createProgressBar(0, 10, 1, 517, 190, 543, 15);
			panel.add(progressBar3);
			JLabel image_plus3 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 190, 25, 25);
			panel.add(image_plus3);
			JLabel LabelDextérité = createLabelText("Dextérité(1)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 190, 175, 25);
			panel.add(LabelDextérité);
			image_moins3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar3.getValue() > progressBar3.getMinimum()) && (points >= 0) && (points < 400)) {
						points++;
						LabelAffichagePoint.setText(""+ points);
						progressBar3.setValue(progressBar3.getValue()-1);
						LabelDextérité.setText("Dextérité("+ progressBar3.getValue() +")");
					}
				}
			});
			
			image_plus3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar3.getValue() < progressBar3.getMaximum()) && (points > 0) && (points <= 400)) {
						points--;
						LabelAffichagePoint.setText(""+ points);
						progressBar3.setValue(progressBar3.getValue()+1);
						LabelDextérité.setText("Dextérité("+ progressBar3.getValue() +")");
						
					}
				}
			});
			
			
			JLabel image_moins4 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 242, 25, 25);
			panel.add(image_moins4);
			JProgressBar progressBar4 = createProgressBar(0, 10, 1, 517, 242, 543, 15);
			panel.add(progressBar4);
			JLabel image_plus4 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 242, 25, 25);
			panel.add(image_plus4);
			JLabel LabelRésistance = createLabelText("Résistance(1)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 242, 175, 25);
			panel.add(LabelRésistance);
			image_moins4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar4.getValue() > progressBar4.getMinimum()) && (points >= 0) && (points < 400)) {
						points++;
						LabelAffichagePoint.setText(""+ points);
						progressBar4.setValue(progressBar4.getValue()-1);
						LabelRésistance.setText("Résistance("+ progressBar4.getValue() +")");
					}
				}
			});
			
			image_plus4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar4.getValue() < progressBar4.getMaximum()) && (points > 0) && (points <= 400)) {
						points--;
						LabelAffichagePoint.setText(""+ points);
						progressBar4.setValue(progressBar4.getValue()+1);
						LabelRésistance.setText("Résistance("+ progressBar4.getValue() +")");	
					}
				}
			});
			
			JLabel image_moins5 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 293, 25, 25);
			panel.add(image_moins5);
			JProgressBar progressBar5 = createProgressBar(0, 30, 5, 517, 293, 543, 15);
			panel.add(progressBar5);
			JLabel image_plus5 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 293, 25, 25);
			panel.add(image_plus5);
			JLabel LabelConstitution = createLabelText("Constitution(5)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 293, 175, 25);
			panel.add(LabelConstitution);
			image_moins5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar5.getValue() > progressBar5.getMinimum()) && (points >= 0) && (points < 400)) {
						points++;
						LabelAffichagePoint.setText(""+ points);
						progressBar5.setValue(progressBar5.getValue()-1);
						LabelConstitution.setText("Constitution("+ progressBar5.getValue() +")");
					}
				}
			});
			image_plus5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar5.getValue() < progressBar5.getMaximum()) && (points > 0) && (points <= 400)) {
						points--;
						LabelAffichagePoint.setText(""+ points);
						progressBar5.setValue(progressBar5.getValue()+1);
						LabelConstitution.setText("Constitution("+ progressBar5.getValue() +")");
						
					}
				}
			});
			
			
			
			JLabel image_moins6 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 345, 25, 25);
			panel.add(image_moins6);
			JProgressBar progressBar6 = createProgressBar(0, 10, 1, 517, 345, 543, 15);
			panel.add(progressBar6);
			JLabel image_plus6 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 345, 25, 25);
			panel.add(image_plus6);
			JLabel LabelInitiative = createLabelText("Initiative(1)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 345, 175, 25);
			panel.add(LabelInitiative);
			image_moins6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar6.getValue() > progressBar6.getMinimum()) && (points >= 0) && (points < 400)) {
						points++;
						LabelAffichagePoint.setText(""+ points);
						progressBar6.setValue(progressBar6.getValue()-1);
						LabelInitiative.setText("Initiative("+ progressBar6.getValue() +")");
					}
				}
			});
			image_plus6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if((progressBar6.getValue() < progressBar6.getMaximum()) && (points > 0) && (points <= 400)) {
						points--;
						LabelAffichagePoint.setText(""+ points);
						progressBar6.setValue(progressBar6.getValue()+1);
						LabelInitiative.setText("Initiative("+ progressBar6.getValue() +")");
						
					}
				}
			});
		
			
			JLabel LabelIA = createLabelText("Intelligence Artificielle",customFont.deriveFont(15f), new Color(48, 179, 9),281, 395, 224, 25);
			panel.add(LabelIA);
			
			
			Panel panel_1 = new Panel();
			panel_1.setBounds(581, 394, 100, 25);
			panel.add(panel_1);
			panel_1.setBackground(new Color(48, 179, 9));
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Offensif");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(0, 0, 100, 25);
			lblNewLabel_5.setFont(customFont.deriveFont(15f));
			panel_1.add(lblNewLabel_5);
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			
			Panel panel_2 = new Panel();
			panel_2.setBounds(744, 394, 100, 25);
			panel.add(panel_2);
			panel_2.setBackground(new Color(192, 192, 192));
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Defensif");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(0, 0, 100, 25);
			lblNewLabel_6.setFont(customFont.deriveFont(15f));
			panel_2.add(lblNewLabel_6);
			lblNewLabel_6.setForeground(new Color(255, 255, 255));
			
			Panel panel_3 = new Panel();
			panel_3.setBounds(907, 394, 100, 25);
			panel.add(panel_3);
			panel_3.setBackground(new Color(192, 192, 192));
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_7 = new JLabel("Aléatoire");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setBounds(0, 0, 100, 25);
			lblNewLabel_7.setFont(customFont.deriveFont(15f));
			panel_3.add(lblNewLabel_7);
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			chckbxNewCheckBox.setBounds(713, 443, 25, 33);
			chckbxNewCheckBox.setOpaque(false);
			chckbxNewCheckBox.setFont(customFont.deriveFont(15f));
			chckbxNewCheckBox.setForeground(new Color(48, 179, 9));
			chckbxNewCheckBox.setBorder(null);
			panel.add(chckbxNewCheckBox);
			
			JLabel LabelReserviste = new JLabel("Réserviste");
			LabelReserviste.setFont(customFont.deriveFont(15f));
			LabelReserviste.setForeground(new Color(48, 179, 9));
			LabelReserviste.setBounds(731, 443, 145, 33);
			panel.add(LabelReserviste);
		
			
			
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel_1.setBackground(new Color(48, 179, 9));
					panel_2.setBackground(new Color(192, 192, 192));
					panel_3.setBackground(new Color(192, 192, 192));
				}
			});
			
			panel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel_1.setBackground(new Color(192, 192, 192));
					panel_2.setBackground(new Color(48, 179, 9));
					panel_3.setBackground(new Color(192, 192, 192));
				}
			});
			
			panel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel_1.setBackground(new Color(192, 192, 192));
					panel_2.setBackground(new Color(192, 192, 192));
					panel_3.setBackground(new Color(48, 179, 9));
				}
			});
			
			}
		
		//-------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------------------------------------------
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0,0, 1105, 602);
		panel.setName("MDG");
		layeredPane.add(panel, new Integer(20));
		panel.setLayout(null);
		
		JLabel labelTitreSoldat = new JLabel("Maitre de guerre");
		labelTitreSoldat.setBounds(421, 11, 260, 45);
		panel.add(labelTitreSoldat);
		labelTitreSoldat.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitreSoldat.setForeground(Color.WHITE);
		labelTitreSoldat.setFont(customFont.deriveFont(20f));

		JLabel lblNewLabel_2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\MDG.PNG",20, 168, 250, 250);
		panel.add(lblNewLabel_2);
		

		
		JLabel image_moins1 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 101, 25, 25);
		panel.add(image_moins1);
		JProgressBar progressBar1 = createProgressBar(0, 100, 30, 517, 101, 543, 15);
		panel.add(progressBar1);
		JLabel image_plus1 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 101, 25, 25);
		panel.add(image_plus1);
		JLabel LabelPDV = createLabelText("PointsDeVie(30)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 101, 175, 25);
		panel.add(LabelPDV);
		image_moins1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar1.getValue() > progressBar1.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar1.setValue(progressBar1.getValue()-1);
					LabelPDV.setText("PointsDeVie("+ (progressBar1.getValue()) + ")");
				}
			}
		});
		
		image_plus1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar1.getValue() < progressBar1.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar1.setValue(progressBar1.getValue()+1);
					LabelPDV.setText("PointsDeVie("+ (progressBar1.getValue()) + ")");
					
				}
			}
		});
		
		
		JLabel image_moins2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 145, 25, 25);
		panel.add(image_moins2);
		JProgressBar progressBar2 = createProgressBar(0, 10, 2, 517, 145, 543, 15);
		panel.add(progressBar2);
		JLabel image_plus2 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 145, 25, 25);
		panel.add(image_plus2);
		JLabel LabelForce = createLabelText("Force(2)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 145, 175, 25);
		panel.add(LabelForce);
		image_moins2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar2.getValue() > progressBar2.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar2.setValue(progressBar2.getValue()-1);
					LabelForce.setText("Force("+ (progressBar2.getValue()) +")");
				}
			}
		});
		
		image_plus2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar2.getValue() < progressBar2.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar2.setValue(progressBar2.getValue()+1);
					LabelForce.setText("Force("+ progressBar2.getValue() +")");
					
				}
			}
		});
		
		JLabel image_moins3 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 190, 25, 25);
		panel.add(image_moins3);
		JProgressBar progressBar3 = createProgressBar(0, 10, 2, 517, 190, 543, 15);
		panel.add(progressBar3);
		JLabel image_plus3 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 190, 25, 25);
		panel.add(image_plus3);
		JLabel LabelDextérité = createLabelText("Dextérité(2)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 190, 175, 25);
		panel.add(LabelDextérité);
		image_moins3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar3.getValue() > progressBar3.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar3.setValue(progressBar3.getValue()-1);
					LabelDextérité.setText("Dextérité("+ progressBar3.getValue() +")");
				}
			}
		});
		
		image_plus3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar3.getValue() < progressBar3.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar3.setValue(progressBar3.getValue()+1);
					LabelDextérité.setText("Dextérité("+ progressBar3.getValue() +")");
					
				}
			}
		});
		
		
		JLabel image_moins4 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 242, 25, 25);
		panel.add(image_moins4);
		JProgressBar progressBar4 = createProgressBar(0, 10, 2, 517, 242, 543, 15);
		panel.add(progressBar4);
		JLabel image_plus4 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 242, 25, 25);
		panel.add(image_plus4);
		JLabel LabelRésistance = createLabelText("Résistance(2)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 242, 175, 25);
		panel.add(LabelRésistance);
		image_moins4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar4.getValue() > progressBar4.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar4.setValue(progressBar4.getValue()-1);
					LabelRésistance.setText("Résistance("+ progressBar4.getValue() +")");
				}
			}
		});
		
		image_plus4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar4.getValue() < progressBar4.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar4.setValue(progressBar4.getValue()+1);
					LabelRésistance.setText("Résistance("+ progressBar4.getValue() +")");	
				}
			}
		});
		
		JLabel image_moins5 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 293, 25, 25);
		panel.add(image_moins5);
		JProgressBar progressBar5 = createProgressBar(0, 30, 10, 517, 293, 543, 15);
		panel.add(progressBar5);
		JLabel image_plus5 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 293, 25, 25);
		panel.add(image_plus5);
		JLabel LabelConstitution = createLabelText("Constitution(10)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 293, 175, 25);
		panel.add(LabelConstitution);
		image_moins5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar5.getValue() > progressBar5.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar5.setValue(progressBar5.getValue()-1);
					LabelConstitution.setText("Constitution("+ progressBar5.getValue() +")");
				}
			}
		});
		image_plus5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar5.getValue() < progressBar5.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar5.setValue(progressBar5.getValue()+1);
					LabelConstitution.setText("Constitution("+ progressBar5.getValue() +")");
					
				}
			}
		});
		
		
		
		JLabel image_moins6 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\moins.PNG",471, 345, 25, 25);
		panel.add(image_moins6);
		JProgressBar progressBar6 = createProgressBar(0, 10, 2, 517, 345, 543, 15);
		panel.add(progressBar6);
		JLabel image_plus6 = createLabelImage("C:\\Users\\Neil Jovy\\eclipse-workspace\\EG23\\img\\plus.PNG",1070, 345, 25, 25);
		panel.add(image_plus6);
		JLabel LabelInitiative = createLabelText("Initiative(2)",customFont.deriveFont(15f), new Color(48, 179, 9),281, 345, 175, 25);
		panel.add(LabelInitiative);
		image_moins6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar6.getValue() > progressBar6.getMinimum()) && (points >= 0) && (points < 400)) {
					points++;
					LabelAffichagePoint.setText(""+ points);
					progressBar6.setValue(progressBar6.getValue()-1);
					LabelInitiative.setText("Initiative("+ progressBar6.getValue() +")");
				}
			}
		});
		image_plus6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((progressBar6.getValue() < progressBar6.getMaximum()) && (points > 0) && (points <= 400)) {
					points--;
					LabelAffichagePoint.setText(""+ points);
					progressBar6.setValue(progressBar6.getValue()+1);
					LabelInitiative.setText("Initiative("+ progressBar6.getValue() +")");
					
				}
			}
		});
	
		
		JLabel LabelIA = createLabelText("Intelligence Artificielle",customFont.deriveFont(15f), new Color(48, 179, 9),281, 395, 224, 25);
		panel.add(LabelIA);
		
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(581, 394, 100, 25);
		panel.add(panel_1);
		panel_1.setBackground(new Color(48, 179, 9));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Offensif");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 100, 25);
		lblNewLabel_5.setFont(customFont.deriveFont(15f));
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(744, 394, 100, 25);
		panel.add(panel_2);
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Defensif");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 100, 25);
		lblNewLabel_6.setFont(customFont.deriveFont(15f));
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(907, 394, 100, 25);
		panel.add(panel_3);
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Aléatoire");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 100, 25);
		lblNewLabel_7.setFont(customFont.deriveFont(15f));
		panel_3.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(713, 443, 25, 33);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setFont(customFont.deriveFont(15f));
		chckbxNewCheckBox.setForeground(new Color(48, 179, 9));
		chckbxNewCheckBox.setBorder(null);
		panel.add(chckbxNewCheckBox);
		
		JLabel LabelReserviste = new JLabel("Réserviste");
		LabelReserviste.setFont(customFont.deriveFont(15f));
		LabelReserviste.setForeground(new Color(48, 179, 9));
		LabelReserviste.setBounds(731, 443, 145, 33);
		panel.add(LabelReserviste);
	
		
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(48, 179, 9));
				panel_2.setBackground(new Color(192, 192, 192));
				panel_3.setBackground(new Color(192, 192, 192));
			}
		});
		
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(192, 192, 192));
				panel_2.setBackground(new Color(48, 179, 9));
				panel_3.setBackground(new Color(192, 192, 192));
			}
		});
		
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(192, 192, 192));
				panel_2.setBackground(new Color(192, 192, 192));
				panel_3.setBackground(new Color(48, 179, 9));
			}
		});
		
		
		//-------------------------------------------CHANGEMENT DE PLACE DES BOUTONS-----------------------------------------
		
		
		ButtonMaitre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "MDG"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_1").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_1"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_2").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_2"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_3").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_3"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_4").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_4"), layeredPane.highestLayer() + 1);
			}
		});
		getButtonByName(PanelChoixCombattant, "soldat_5").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_5"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_6").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_6"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_7").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_7"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_8").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_8"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_9").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_9"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_10").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_10"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_11").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_11"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_12").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_12"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_13").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_13"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_14").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_14"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "soldat_15").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Soldat_15"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "elite_1").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Elite_1"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "elite_2").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Elite_2"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "elite_3").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Elite_3"), layeredPane.highestLayer() + 1);
			}
		});
		
		getButtonByName(PanelChoixCombattant, "elite_4").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(getPanelByName(layeredPane, "Elite_4"), layeredPane.highestLayer() + 1);
			}
		});
	 //----------------------------------------------------------------------------------------------------------------------
		ButtonCompris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelTropdereserviste.setVisible(false);
				ButtonConfirmation.setVisible(true);
			}
		});
		
		ButtonCompris2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPeudereserviste.setVisible(false);
				ButtonConfirmation.setVisible(true);
			}
		});
		
		
		
		
		frmRepartition.setBounds(-8, 0, 2880, 1800);
		frmRepartition.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
