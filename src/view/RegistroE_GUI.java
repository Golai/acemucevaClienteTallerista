package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.EventoControl;
import persistence.Evento;

public class RegistroE_GUI {

	private JFrame frame;
	List<Evento> l;
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
					RegistroE_GUI window = new RegistroE_GUI();
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
	public RegistroE_GUI() throws RemoteException, NotBoundException {
		initialize();
		llenarTablaEventos();
		frame.setVisible(true);
	}
	
	public void llenarTablaEventos() throws RemoteException, NotBoundException {
		EventoControl mc = new EventoControl();
		l = mc.searchMiembros();
		
		for (int i = 0; i < l.size(); i++) {
			Object [] fila = new Object[10];
			fila[0] = l.get(i).getId_evento();
			fila[1] = l.get(i).getId_encargado();
			fila[2] = l.get(i).getNombre_evento();
			fila[3] = l.get(i).getDescripcion();
			fila[4] = l.get(i).getFecha();
			fila[5] = l.get(i).getLugar();
			fila[6] = l.get(i).getHora();
			fila[7] = l.get(i).getCupos();
			fila[8] = l.get(i).getPuntos();
			fila[9] = l.get(i).getTipo_evento();
			((DefaultTableModel) table.getModel()).addRow ( fila ); // Añade una fila al final
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 11, 924, 209);
	    frame.getContentPane().add(scrollPane);
	    
	    modelo = new DefaultTableModel();
	    table = new JTable (modelo);
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    			"Id_Evento","Id_Encargado","Nombre_Evento","Descripcion","Fecha","Lugar", "Hora", "Cupos", "Puntos", "Tipo_Evento" 
	    	}
	    ));
	    scrollPane.setViewportView(table);
	    
	    btnRegresar = new JButton("Regresar");
	    btnRegresar.setBounds(434, 243, 100, 30);
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
