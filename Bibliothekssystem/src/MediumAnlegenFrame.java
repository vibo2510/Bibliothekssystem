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
import java.awt.Color;
import java.awt.Dialog;

public class MediumAnlegenFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfLeihgebuehr;
	private JTextField tfTitel;
	private JTextField tfAutor;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MediumAnlegenFrame frame = new MediumAnlegenFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MediumAnlegenFrame(MedienVerwaltenFrame mframe) {
		setTitle("Medium Anlegen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMediumAnlegen = new JLabel("Medium anlegen");
		lblMediumAnlegen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMediumAnlegen.setBounds(10, 11, 119, 14);
		contentPane.add(lblMediumAnlegen);
		
		JLabel lbMedientyp = new JLabel("Medientyp");
		lbMedientyp.setBounds(10, 56, 72, 14);
		contentPane.add(lbMedientyp);
		
		JComboBox cbMedientyp = new JComboBox();
		cbMedientyp.setModel(new DefaultComboBoxModel(new String[] {"Buch", "DVD"}));
		cbMedientyp.setBounds(10, 81, 103, 20);
		contentPane.add(cbMedientyp);
		
		JLabel lbLeihgebuehr = new JLabel("Leihgeb\u00FChr \u20AC/pro Tag:");
		lbLeihgebuehr.setBounds(123, 56, 124, 14);
		contentPane.add(lbLeihgebuehr);
		
		tfLeihgebuehr = new JTextField();
		tfLeihgebuehr.setColumns(10);
		tfLeihgebuehr.setBounds(123, 81, 107, 20);
		contentPane.add(tfLeihgebuehr);
		
		JLabel lbTitel = new JLabel("Titel");
		lbTitel.setBounds(10, 112, 46, 14);
		contentPane.add(lbTitel);
		
		tfTitel = new JTextField();
		tfTitel.setColumns(10);
		tfTitel.setBounds(10, 137, 220, 20);
		contentPane.add(tfTitel);
		
		JLabel lbAutor = new JLabel("Autor");
		lbAutor.setBounds(10, 168, 46, 14);
		contentPane.add(lbAutor);
		
		JLabel lbFehler = new JLabel("");
		lbFehler.setForeground(Color.RED);
		lbFehler.setBounds(10, 36, 220, 14);
		contentPane.add(lbFehler);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(10, 193, 220, 20);
		contentPane.add(tfAutor);
		
		JButton btAnlegen = new JButton("Anlegen");
		btAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbFehler.setText("");
				String titel = tfTitel.getText().toString();
				String autor = tfAutor.getText().toString();
				String leihgebuehr = tfLeihgebuehr.getText().toString();
				String typ = cbMedientyp.getSelectedItem().toString(); 
				
				if(!(titel.isEmpty()&& autor.isEmpty()&& leihgebuehr.isEmpty())){
					Bibliothek bib = Bibliothek.getInstance();
					if(typ.equals("Buch")){
						Buch buch = new Buch(bib.erzeugeID("Medium"),titel,true,Float.parseFloat(leihgebuehr),autor,typ, new ArrayList<Ausleihe>());
						bib.mediumErstellen(buch);
						mframe.showTable(mframe.tbTrefferliste, mframe.bib.medien);
							
							JOptionPane.showMessageDialog(MediumAnlegenFrame.this, "Medium  wurde erfolgreich angelegt!","Hinweis",JOptionPane.PLAIN_MESSAGE);
						
					}
					
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
				MediumAnlegenFrame.this.dispose();
			}
		});
		btAbbrechen.setBounds(141, 224, 89, 23);
		contentPane.add(btAbbrechen);
		
		
	}

}
