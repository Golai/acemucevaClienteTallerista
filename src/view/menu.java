package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import control.eventoControl;
import control.miembroControl;
import persistence.Miembro;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class menu {
	
	private eventoControl ec;
	private miembroControl mc;
	private JFrame frame;
	private JTable table;
	List<Miembro> l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
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
	public menu() throws RemoteException, NotBoundException {
		initialize();
		ec = new eventoControl();
		mc = new miembroControl();
		llenarTabla();
	}

	public void llenarTabla() throws RemoteException, NotBoundException {
		l = mc.searchMiembros();
		
		for (int i = 0; i < l.size(); i++) {
			Object [] fila = new Object[3];
			fila[0] = l.get(i).getCedula();
			fila[1] = l.get(i).getNombre();
			fila[2] = l.get(i).getPuntos();
			((DefaultTableModel) table.getModel()).addRow ( fila ); // Añade una fila al final
		}
	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Ranking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(20, 127, 108, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eventos");
		btnNewButton_1.setBounds(20, 64, 108, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Entre a la accion del boton");
					table.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(416, 11, -251, 239);
	    table.setModel(new DefaultTableModel(
		    	new Object[][] {},
		    	new String[] {
		    		"Cedula","Nombre","Puntos" 
		    	}
		    ));
		    table.getColumnModel().getColumn(0).setPreferredWidth(100);
		    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		    table.getColumnModel().getColumn(2).setPreferredWidth(100);
		frame.getContentPane().add(table);
	}
}
