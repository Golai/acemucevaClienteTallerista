package view;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.MiembroControl;
import persistence.Miembro;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankingGUI {
	
	private JFrame frame;
	List<Miembro> l;
	DefaultTableModel modelo;
	private JTable table;
	private JButton btnRegresar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingGUI window = new RankingGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	public RankingGUI() throws RemoteException, NotBoundException {
		initialize();
		llenarTablaRankig();
		frame.setVisible(true);
	}
	
	public void llenarTablaRankig() throws RemoteException, NotBoundException {
		MiembroControl mc = new MiembroControl();
		l = mc.searchMiembros();
		/*
		for (int i = 0; i < l.size(); i++) {
			Object [] fila = new Object[6];
			fila[0] = l.get(i).getCedula();
			fila[1] = l.get(i).getId_cargo();
			fila[2] = l.get(i).getNombre();
			fila[3] = l.get(i).getCelular();
			fila[4] = l.get(i).getSemestre();
			fila[5] = l.get(i).getPuntos();
			((DefaultTableModel) table.getModel()).addRow ( fila ); // Añade una fila al final
		}
		*/
		for (int i = 0; i < l.size(); i++) {
			Object [] fila = new Object[3];
			fila[0] = l.get(i).getNombre();
			fila[1] = l.get(i).getPuntos();
			((DefaultTableModel) table.getModel()).addRow ( fila ); // Añade una fila al final
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
		
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 11, 644, 198);
	    frame.getContentPane().add(scrollPane);
	    
	    modelo = new DefaultTableModel();
	    table = new JTable (modelo);
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    			"Nombre","Puntos" 
	    	}
	    ));
	    scrollPane.setViewportView(table);
	    
	    btnRegresar = new JButton("Regresar");
	    btnRegresar.setBounds(270, 220, 100, 30);
	    frame.getContentPane().add(btnRegresar);
	    btnRegresar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		try {
					Menu m = new Menu();
					frame.dispose();
				} catch (RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    });
	}
}
