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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AusleiheAendernFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfRueckgabe;
	private JTextField tfMedium;
	private JTextField tfAusleiher;
	private   int id;
	private JTextField tfAusleihe;
	private Bibliothek bib;
	private JTextField tfAusleihDatum;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	
	public AusleiheAendernFrame(int id, AusleihenVerwaltenFrame mFrame) {
		this.id = id;
		bib = Bibliothek.getInstance();
		Ausleihe alteAusleihe=bib.getAusleiheById(id);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAusleihendern = new JLabel("Ausleihe \u00E4ndern");
		lblAusleihendern.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAusleihendern.setBounds(10, 11, 119, 14);
		contentPane.add(lblAusleihendern);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setBounds(10, 36, 23, 14);
		contentPane.add(label_1);
		
		JLabel lbId = new JLabel(Integer.toString(id));
		lbId.setBounds(36, 36, 46, 14);
		contentPane.add(lbId);
		
		JLabel lblVerfuegbarkeit = new JLabel("Ausleihdatum");
		lblVerfuegbarkeit.setBounds(10, 56, 119, 14);
		contentPane.add(lblVerfuegbarkeit);
		
		
		JLabel lblRckgabedatum = new JLabel("R\u00FCckgabedatum");
		lblRckgabedatum.setBounds(123, 56, 124, 14);
		contentPane.add(lblRckgabedatum);
		
		tfRueckgabe = new JTextField((alteAusleihe.spaetesteRueckgabe.toString()));
		tfRueckgabe.setColumns(10);
		tfRueckgabe.setBounds(123, 81, 107, 20);
		contentPane.add(tfRueckgabe);
		
		JLabel lblMediumId = new JLabel("Medium ID");
		lblMediumId.setBounds(10, 112, 72, 14);
		contentPane.add(lblMediumId);
		
		tfMedium = new JTextField(Integer.toString(alteAusleihe.medium.mediumID));
		tfMedium.setColumns(10);
		tfMedium.setBounds(10, 137, 220, 20);
		contentPane.add(tfMedium);
		
		JLabel lblAusleiherId = new JLabel("Ausleiher ID");
		lblAusleiherId.setBounds(10, 168, 86, 14);
		contentPane.add(lblAusleiherId);
		
		tfAusleiher = new JTextField(Integer.toString(alteAusleihe.ausleiher.ausleiherID));
		tfAusleiher.setColumns(10);
		tfAusleiher.setBounds(10, 193, 220, 20);
		contentPane.add(tfAusleiher);
		
		JButton btAendern = new JButton("\u00C4ndern");
		btAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aDatum = tfAusleihDatum.getText().toString();
				String mediumID = tfMedium.getText().toString();
				String rDatum = tfRueckgabe.getText().toString();
				String ausleiherID = tfAusleiher.getText().toString();
				SimpleDateFormat sdate = new SimpleDateFormat("dd.mm.yyyy");
				
				
				System.out.println("wurde ausgeführt");
				if(!(mediumID.isEmpty()&& ausleiherID.isEmpty()&& rDatum.isEmpty()&& aDatum.isEmpty())){
					for(Medium m: bib.medien){
						System.out.println("Medium"+m.mediumID);
						for(Ausleihe a: m.ausleihen){
							System.out.print("Ausleihe:"+a.ausleiheID+",");
						}
					}
							
					Ausleihe neueAusleihe;
					try {
						neueAusleihe = new Ausleihe(alteAusleihe.ausleiheID,sdate.parse(aDatum),sdate.parse(rDatum),4.5F,bib.getMediumById(Integer.parseInt(mediumID)),bib.getAusleiherByID(Integer.parseInt(ausleiherID)));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						neueAusleihe = null;
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						neueAusleihe = null;
					}
						
						
						bib.ausleiheAendern(alteAusleihe, neueAusleihe);
						mFrame.showTable(mFrame.tbTrefferliste, mFrame.bib.ausleihen);
						JOptionPane.showMessageDialog(AusleiheAendernFrame.this, "Medium  wurde erfolgreich geändert!","Hinweis",JOptionPane.PLAIN_MESSAGE);
						
						
						for(Medium m: bib.medien){
							System.out.println("Medium"+m.mediumID);
							for(Ausleihe a: m.ausleihen){
								System.out.println("Ausleihe:"+a.ausleiheID+",");
							}
						}
						
					
				}
			}
		});
		btAendern.setBounds(40, 287, 89, 23);
		contentPane.add(btAendern);
		
		JButton btAbbrechen = new JButton("Abbrechen");
		btAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AusleiheAendernFrame.this.dispose();
				
				
			}
		});
		btAbbrechen.setBounds(141, 287, 89, 23);
		contentPane.add(btAbbrechen);
		
		tfAusleihDatum = new JTextField((alteAusleihe.ausleihTag.toString()));
		tfAusleihDatum.setBounds(10, 81, 86, 20);
		contentPane.add(tfAusleihDatum);
		tfAusleihDatum.setColumns(10);
		
		
	}
}
