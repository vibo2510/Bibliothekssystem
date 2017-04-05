import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AusleihenVerwaltenFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfSuchen;
	public JTable tbTrefferliste;
	public Bibliothek bib;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AusleihenVerwaltenFrame frame = new AusleihenVerwaltenFrame();
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
	public AusleihenVerwaltenFrame() {
		setTitle("Ausleihen Verwalten");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNeuesAusleihe = new JLabel("Neues Ausleihe anlegen");
		lbNeuesAusleihe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNeuesAusleihe.setBounds(14, 11, 159, 21);
		contentPane.add(lbNeuesAusleihe);
		
		JButton btNeuesAusleihe = new JButton("+ Neues Ausleihe");
		btNeuesAusleihe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AusleiheAnlegenFrame ausleiheAnlegen= new AusleiheAnlegenFrame(AusleihenVerwaltenFrame.this);
				ausleiheAnlegen.setVisible(true);
			}
		});
		btNeuesAusleihe.setToolTipText("");
		btNeuesAusleihe.setBounds(14, 38, 144, 23);
		contentPane.add(btNeuesAusleihe);
		
		JLabel lbAusleiheSuchen = new JLabel("Ausleihe suchen");
		lbAusleiheSuchen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbAusleiheSuchen.setBounds(14, 83, 112, 21);
		contentPane.add(lbAusleiheSuchen);
		
		JLabel lbSuchenNach = new JLabel("Suchen nach:");
		lbSuchenNach.setBounds(14, 108, 96, 14);
		contentPane.add(lbSuchenNach);
		
		JRadioButton rbId = new JRadioButton("ID");
		rbId.setSelected(true);
		rbId.setBounds(14, 132, 42, 23);
		contentPane.add(rbId);
		
		JRadioButton rbTitel = new JRadioButton("Titel");
		rbTitel.setBounds(68, 132, 58, 23);
		contentPane.add(rbTitel);
		
		ButtonGroup buttonGroup= new ButtonGroup();
		buttonGroup.add(rbId);
		buttonGroup.add(rbTitel);
		
		tfSuchen = new JTextField();
		tfSuchen.setColumns(10);
		tfSuchen.setBounds(14, 162, 133, 20);
		contentPane.add(tfSuchen);
		
		
		 bib = Bibliothek.getInstance();
		bib.init();
		tbTrefferliste = new JTable();
		
		tbTrefferliste.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		tbTrefferliste.setToolTipText("");
		tbTrefferliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbTrefferliste.setBounds(14, 238, 446, 145); 
		tbTrefferliste.setFillsViewportHeight(true);
		
		JScrollPane scroll= new JScrollPane(tbTrefferliste);
		scroll.setLocation(15, 242);
		scroll.setSize(442, 148);
		scroll.setViewportView(tbTrefferliste);
		contentPane.add(scroll);
		
		
		//tbTrefferliste.setModel(tableModel);
	
		

		
		showTable(tbTrefferliste,bib.ausleihen);
			
					
					
		
		
		
		
		JButton btSuchen = new JButton("Suchen");
		btSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String suche = tfSuchen.getText().toString();
				ArrayList<Ausleihe> trefferListe  = new ArrayList<Ausleihe>();
				String [] spalten = {"ID","Auleihdatum","AusleiherID", "MediumID"};
				trefferListe = bib.ausleiheSuchen(suche);
			
				
				showTable(tbTrefferliste, trefferListe);
							
							
				
				//tbTrefferliste.setModel(tableModel);
				
				
				
				
				
			}
		});
		
		
		btSuchen.setBounds(157, 161, 89, 23);
		contentPane.add(btSuchen);
		
		JLabel lbTrefferliste = new JLabel("Ausleihen:");
		lbTrefferliste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbTrefferliste.setBounds(14, 227, 81, 14);
		contentPane.add(lbTrefferliste);
		
		JLabel lbAuswahl = new JLabel("Auswahl:");
		lbAuswahl.setBounds(10, 401, 63, 14);
		contentPane.add(lbAuswahl);
		
		JComboBox cbAuswahl = new JComboBox();
		cbAuswahl.setModel(new DefaultComboBoxModel(new String[] {"\u00C4ndern", "L\u00F6schen"}));
		cbAuswahl.setBounds(14, 426, 77, 20);
		contentPane.add(cbAuswahl);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aktion = cbAuswahl.getSelectedItem().toString();
				int id = (int) tbTrefferliste.getValueAt(tbTrefferliste.getSelectedRow(), 0);
				if(aktion.equals("Ändern")){
					
					AusleiheAendernFrame ausleiheAendernFrame = new AusleiheAendernFrame(id,AusleihenVerwaltenFrame.this);
					ausleiheAendernFrame.setVisible(true);
				}else{
					Bibliothek bib = Bibliothek.getInstance();
					bib.ausleiheLoeschen(bib.getAusleiheById(id));
					JOptionPane.showMessageDialog(AusleihenVerwaltenFrame.this, "Ausleihe  wurde erfolgreich gelöscht!","Hinweis",JOptionPane.PLAIN_MESSAGE);
					
					showTable( tbTrefferliste,bib.ausleihen);
				}
			}
		
		});
		btOk.setBounds(98, 425, 89, 23);
		contentPane.add(btOk);
		
		
		
		}

	public void showTable(JTable tbTrefferliste,ArrayList<Ausleihe> tabelleninhalt){
		String [] spalten = {"ID","Auleihdatum","AusleiherID","MediumID"};
		DefaultTableModel tableModel = new DefaultTableModel(spalten, 0);
		for(int i=0;i<tabelleninhalt.size();++i){
			int id = tabelleninhalt.get(i).ausleiheID;
			String ausleihtag = tabelleninhalt.get(i).ausleihTag.toString();
			String ausleiherId = Integer.toString(tabelleninhalt.get(i).ausleiher.ausleiherID);
			String mediumId= Integer.toString(tabelleninhalt.get(i).medium.mediumID);
			Object[] ausleihe= {id,ausleihtag,ausleiherId, mediumId};
			tableModel.addRow(ausleihe);
		}
		tbTrefferliste.setModel(tableModel);
	}
}
