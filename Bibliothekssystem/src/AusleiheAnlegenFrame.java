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
import java.awt.Color;
import java.awt.Dialog;

public class AusleiheAnlegenFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfRueckgabe;
	private JTextField tfMedium;
	private JTextField tfAusleiher;
	private JTextField tfAusleihTag;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AusleiheAnlegenFrame(AusleihenVerwaltenFrame vFrame) {
		setTitle("Ausleihe Anlegen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAusleiheAnlegen = new JLabel("Ausleihe anlegen");
		lblAusleiheAnlegen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAusleiheAnlegen.setBounds(10, 11, 119, 14);
		contentPane.add(lblAusleiheAnlegen);
		
		JLabel lbAusleihTag = new JLabel("Ausleihtag");
		lbAusleihTag.setBounds(10, 56, 72, 14);
		contentPane.add(lbAusleihTag);
		
		JLabel lbRückgabeDatum = new JLabel("Sp\u00E4teste R\u00FCckgabe");
		lbRückgabeDatum.setBounds(123, 56, 124, 14);
		contentPane.add(lbRückgabeDatum);
		
		tfRueckgabe = new JTextField();
		tfRueckgabe.setColumns(10);
		tfRueckgabe.setBounds(123, 81, 107, 20);
		contentPane.add(tfRueckgabe);
		
		JLabel lbMedium = new JLabel("Medium ID");
		lbMedium.setBounds(10, 112, 72, 14);
		contentPane.add(lbMedium);
		
		tfMedium = new JTextField();
		tfMedium.setColumns(10);
		tfMedium.setBounds(10, 137, 220, 20);
		contentPane.add(tfMedium);
		
		JLabel lbAusleiher = new JLabel("Ausleiher  ID");
		lbAusleiher.setBounds(10, 168, 72, 14);
		contentPane.add(lbAusleiher);
		
		JLabel lbFehler = new JLabel("");
		lbFehler.setForeground(Color.RED);
		lbFehler.setBounds(10, 36, 220, 14);
		contentPane.add(lbFehler);
		
		tfAusleiher = new JTextField();
		tfAusleiher.setColumns(10);
		tfAusleiher.setBounds(10, 193, 220, 20);
		contentPane.add(tfAusleiher);
		
		JButton btAnlegen = new JButton("Anlegen");
		btAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbFehler.setText("");
				String mediumID = tfMedium.getText().toString();
				String ausleiherID = tfAusleiher.getText().toString();
				String rueckgabe = tfRueckgabe.getText().toString();
				String ausleihDatum = tfAusleihTag.getText().toString();
				SimpleDateFormat sdate= new SimpleDateFormat("dd.mm.yyyy");
				 
				if(!(mediumID.isEmpty()&& ausleiherID.isEmpty()&& rueckgabe.isEmpty()&&ausleihDatum.isEmpty())){
					Bibliothek bib = Bibliothek.getInstance();
					
						Ausleihe ausleihe;
						try {
							ausleihe = new Ausleihe(bib.erzeugeID("Ausleihe"),sdate.parse(ausleihDatum),sdate.parse(rueckgabe),3.5F,bib.getMediumById(Integer.parseInt(mediumID)),bib.getAusleiherByID(Integer.parseInt(ausleiherID)));
							bib.ausleiheErstellen(ausleihe);
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
							vFrame.showTable(vFrame.tbTrefferliste, vFrame.bib.ausleihen);
							JOptionPane.showMessageDialog(AusleiheAnlegenFrame.this, "Ausleihe  wurde erfolgreich angelegt!","Hinweis",JOptionPane.PLAIN_MESSAGE);
						
					
					
				}else{
					lbFehler.setText("Bitte füllen Sie alle Eingabefelder aus.");
				}
			}
		});
		btAnlegen.setBounds(42, 224, 89, 23);
		contentPane.add(btAnlegen);
		
		JButton btAbbrechen = new JButton("Abbrechen");
		btAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AusleiheAnlegenFrame.this.dispose();
			}
		});
		btAbbrechen.setBounds(141, 224, 89, 23);
		contentPane.add(btAbbrechen);
		
		tfAusleihTag = new JTextField();
		tfAusleihTag.setBounds(10, 81, 86, 20);
		contentPane.add(tfAusleihTag);
		tfAusleihTag.setColumns(10);
		
		
	}

}
