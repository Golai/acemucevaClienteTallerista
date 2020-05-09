package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import persistence.Miembro;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Menu {
	
	private JFrame frame;
	List<Miembro> l;
	DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() throws RemoteException, NotBoundException {
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 258);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Entre a la accion del boton");
				try {
					RankingGUI r = new RankingGUI();
					frame.dispose();
				} catch (RemoteException | NotBoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnRanking.setBounds(81, 113, 120, 33);
		frame.getContentPane().add(btnRanking);
		
		JButton btnEventos = new JButton("Eventos");
		btnEventos.setBounds(81, 69, 120, 33);
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Entre a la accion del boton");
				try {
					RegistroE_GUI r = new RegistroE_GUI();
					frame.dispose();
				} catch (RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEventos);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setBounds(100, 21, 78, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cerrar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoginGUI l = new LoginGUI();
				} catch (RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(81, 157, 120, 33);
		frame.getContentPane().add(btnNewButton);
		
	}
}
