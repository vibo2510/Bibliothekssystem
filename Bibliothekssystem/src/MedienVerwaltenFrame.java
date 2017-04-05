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

public class MedienVerwaltenFrame extends JFrame {

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
					MedienVerwaltenFrame frame = new MedienVerwaltenFrame();
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
	public MedienVerwaltenFrame() {
		setTitle("Medien Verwalten");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNeuesMedium = new JLabel("Neues Medium anlegen");
		lbNeuesMedium.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNeuesMedium.setBounds(14, 11, 159, 21);
		contentPane.add(lbNeuesMedium);
		
		JButton btNeuesMedium = new JButton("+ Neues Medium");
		btNeuesMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MediumAnlegenFrame mediumAnlegen= new MediumAnlegenFrame(MedienVerwaltenFrame.this);
				mediumAnlegen.setVisible(true);
			}
		});
		btNeuesMedium.setToolTipText("");
		btNeuesMedium.setBounds(14, 38, 144, 23);
		contentPane.add(btNeuesMedium);
		
		JLabel lbMediumSuchen = new JLabel("Medium suchen");
		lbMediumSuchen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMediumSuchen.setBounds(14, 83, 112, 21);
		contentPane.add(lbMediumSuchen);
		
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
	
		

		
		showTable(tbTrefferliste,bib.medien);
			
					
					
		
		
		
		
		JButton btSuchen = new JButton("Suchen");
		btSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String suche = tfSuchen.getText().toString();
				ArrayList<Medium> trefferListe  = new ArrayList<Medium>();
				String [] spalten = {"ID","Titel","Medientyp","Verfuegbarkeit"};
				if(rbId.isSelected()){
					trefferListe = bib.mediumSuchen(suche, Suchtyp.MEDIUM_ID);
				}else{
					trefferListe = bib.mediumSuchen(suche, Suchtyp.MEDIUM_TITEL);
				}
				
				showTable(tbTrefferliste, trefferListe);
							
							
				
				//tbTrefferliste.setModel(tableModel);
				
				
				
				
				
			}
		});
		
		
		btSuchen.setBounds(157, 161, 89, 23);
		contentPane.add(btSuchen);
		
		JLabel lbTrefferliste = new JLabel("Medien:");
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
					
					MediumAendernFrame mediumAendernFrame = new MediumAendernFrame(id,MedienVerwaltenFrame.this);
					mediumAendernFrame.setVisible(true);
				}else{
					Bibliothek bib = Bibliothek.getInstance();
					bib.mediumLoeschen(bib.getMediumById(id));
					JOptionPane.showMessageDialog(MedienVerwaltenFrame.this, "Medium  wurde erfolgreich gelöscht!","Hinweis",JOptionPane.PLAIN_MESSAGE);
					
					showTable( tbTrefferliste,bib.medien);
				}
			}
		
		});
		btOk.setBounds(98, 425, 89, 23);
		contentPane.add(btOk);
		
		
		
		}

	public void showTable(JTable tbTrefferliste, ArrayList<Medium> tabelleninhalt){
		String [] spalten = {"ID","Titel","Medientyp","Verfuegbarkeit"};
		DefaultTableModel tableModel = new DefaultTableModel(spalten, 0);
		for(int i=0;i<tabelleninhalt.size();++i){
			int id = tabelleninhalt.get(i).mediumID;
			String titel = tabelleninhalt.get(i).titel;
			String typ = tabelleninhalt.get(i).medientyp;
			Boolean boo = tabelleninhalt.get(i).verfuegbarkeit;
			Object[] medium= {id,titel,typ,boo};
			tableModel.addRow(medium);
		}
		tbTrefferliste.setModel(tableModel);
	}
}
