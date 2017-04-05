import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MediumAendernFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfLeihgebuehr;
	private JTextField tfTitel;
	private JTextField tfAutor;
	private   int id;
	private JTextField tfAusleihe;
	private Bibliothek bib;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MediumAendernFrame frame = new MediumAendernFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MediumAendernFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Medium \u00E4ndern");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 11, 119, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setBounds(10, 36, 23, 14);
		contentPane.add(label_1);
		
		JLabel lbId = new JLabel("1");
		lbId.setBounds(36, 36, 46, 14);
		contentPane.add(lbId);
		
		JLabel lblVerfuegbarkeit = new JLabel("Verfuegbarkeit:");
		lblVerfuegbarkeit.setBounds(10, 56, 119, 14);
		contentPane.add(lblVerfuegbarkeit);
		
		JComboBox cbVerfuegbarkeit = new JComboBox();
		cbVerfuegbarkeit.setModel(new DefaultComboBoxModel(new String[] {"verfuegbar", "nicht verfuegbar"}));
		cbVerfuegbarkeit.setBounds(10, 81, 103, 20);
		contentPane.add(cbVerfuegbarkeit);
		
		JLabel label_4 = new JLabel("Leihgeb\u00FChr \u20AC/pro Tag:");
		label_4.setBounds(123, 56, 124, 14);
		contentPane.add(label_4);
		
		tfLeihgebuehr = new JTextField();
		tfLeihgebuehr.setColumns(10);
		tfLeihgebuehr.setBounds(123, 81, 107, 20);
		contentPane.add(tfLeihgebuehr);
		
		JLabel label_5 = new JLabel("Titel");
		label_5.setBounds(10, 112, 46, 14);
		contentPane.add(label_5);
		
		tfTitel = new JTextField();
		tfTitel.setColumns(10);
		tfTitel.setBounds(10, 137, 220, 20);
		contentPane.add(tfTitel);
		
		JLabel label_6 = new JLabel("Autor");
		label_6.setBounds(10, 168, 46, 14);
		contentPane.add(label_6);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(10, 193, 220, 20);
		contentPane.add(tfAutor);
		
		JButton btAendern = new JButton("Aendern");
		
		btAendern.setBounds(40, 287, 89, 23);
		contentPane.add(btAendern);
		
		JButton btAbbrechen = new JButton("Abbrechen");
		btAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MediumAendernFrame.this.dispose();
				
				
			}
		});
		btAbbrechen.setBounds(141, 287, 89, 23);
		contentPane.add(btAbbrechen);
		
		tfAusleihe = new JTextField();
		tfAusleihe.setBounds(10, 245, 220, 20);
		contentPane.add(tfAusleihe);
		tfAusleihe.setColumns(10);
		
		JLabel lblAusleihe = new JLabel("Ausleihe");
		lblAusleihe.setBounds(10, 224, 46, 14);
		contentPane.add(lblAusleihe);
	}
	
	public MediumAendernFrame(int id, MedienVerwaltenFrame mFrame) {
		this.id = id;
		bib = Bibliothek.getInstance();
		Buch altesMedium=(Buch) bib.getMediumById(id);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Medium \u00E4ndern");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 11, 119, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setBounds(10, 36, 23, 14);
		contentPane.add(label_1);
		
		JLabel lbId = new JLabel(Integer.toString(id));
		lbId.setBounds(36, 36, 46, 14);
		contentPane.add(lbId);
		
		JLabel lblVerfuegbarkeit = new JLabel("Verfuegbarkeit:");
		lblVerfuegbarkeit.setBounds(10, 56, 119, 14);
		contentPane.add(lblVerfuegbarkeit);
		
		JComboBox cbVerfuegbarkeit = new JComboBox();
		cbVerfuegbarkeit.setModel(new DefaultComboBoxModel(new String[] {"verfuegbar", "nicht verfuegbar"}));
		if(altesMedium.verfuegbarkeit){
			cbVerfuegbarkeit.setSelectedIndex(0);
		}else{
			cbVerfuegbarkeit.setSelectedIndex(1);
		}
		cbVerfuegbarkeit.setBounds(10, 81, 103, 20);
		contentPane.add(cbVerfuegbarkeit);
		
		JLabel label_4 = new JLabel("Leihgeb\u00FChr \u20AC/pro Tag:");
		label_4.setBounds(123, 56, 124, 14);
		contentPane.add(label_4);
		
		tfLeihgebuehr = new JTextField(Float.toString(altesMedium.leihgebuehr));
		tfLeihgebuehr.setColumns(10);
		tfLeihgebuehr.setBounds(123, 81, 107, 20);
		contentPane.add(tfLeihgebuehr);
		
		JLabel label_5 = new JLabel("Titel");
		label_5.setBounds(10, 112, 46, 14);
		contentPane.add(label_5);
		
		tfTitel = new JTextField(altesMedium.titel);
		tfTitel.setColumns(10);
		tfTitel.setBounds(10, 137, 220, 20);
		contentPane.add(tfTitel);
		
		JLabel label_6 = new JLabel("Autor");
		label_6.setBounds(10, 168, 46, 14);
		contentPane.add(label_6);
		
		tfAutor = new JTextField(altesMedium.autor);
		tfAutor.setColumns(10);
		tfAutor.setBounds(10, 193, 220, 20);
		contentPane.add(tfAutor);
		
		JButton btAendern = new JButton("\u00C4ndern");
		btAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verfueg = cbVerfuegbarkeit.getSelectedItem().toString();
				String titel = tfTitel.getText().toString();
				String leihg = tfLeihgebuehr.getText().toString();
				String autor = tfAutor.getText().toString();
				String ausleiheId = tfAusleihe.getText().toString();
				
				System.out.println("wurde ausgeführt");
				if(!(titel.isEmpty()&& autor.isEmpty()&& leihg.isEmpty())){
					
						ArrayList<Medium> buchliste= bib.mediumSuchen(Integer.toString(id), Suchtyp.MEDIUM_ID);
						Buch buch = (Buch) buchliste.get(0);
						buch.autor= autor;
						buch.leihgebuehr= Float.parseFloat(leihg);
						if(verfueg.equals("verfuegbar")){
							buch.verfuegbarkeit= true;
						}else{
							buch.verfuegbarkeit= false;
						}
						
						buch.titel= titel;
						if(ausleiheId.equals("")){
							
						}else{
							ArrayList<Ausleihe> ausleihen = bib.ausleiheSuchen(ausleiheId);
							buch.ausleihen.add(ausleihen.get(0));
						}
						bib.mediumAendern(bib.getMediumById(id), buch);
						mFrame.showTable(mFrame.tbTrefferliste, mFrame.bib.medien);
						JOptionPane.showMessageDialog(MediumAendernFrame.this, "Medium  wurde erfolgreich geändert!","Hinweis",JOptionPane.PLAIN_MESSAGE);
						
					
				}
			}
		});
		btAendern.setBounds(40, 287, 89, 23);
		contentPane.add(btAendern);
		
		JButton btAbbrechen = new JButton("Abbrechen");
		btAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MediumAendernFrame.this.dispose();
				
				
			}
		});
		btAbbrechen.setBounds(141, 287, 89, 23);
		contentPane.add(btAbbrechen);
		
		
	}
}
