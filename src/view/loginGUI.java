package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import control.miembroControl;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class loginGUI {

	// private asistenteControl ac;
	private miembroControl mc;
	boolean entrar;
	private JFrame frame;
	private JTextField textField_cedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI window = new loginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginGUI() throws RemoteException, NotBoundException {
		initialize();
		// ac = new asistenteControl();
		mc = new miembroControl();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setBounds(195, 52, 44, 23);
		lblNewLabel_1.setRequestFocusEnabled(false);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setBounds(129, 89, 50, 14);
		panel.add(lblNewLabel);

		textField_cedula = new JTextField();
		textField_cedula.setBounds(186, 86, 104, 20);
		panel.add(textField_cedula);
		textField_cedula.setColumns(10);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(170, 121, 100, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Entre a la accion del boton");
				int login = Integer.parseInt(textField_cedula.getText());
				entrar = mc.login(login);

				if (entrar == true) {
					System.out.println("entraste");
					try {
						Menu m = new Menu();
						frame.dispose();
					} catch (RemoteException | NotBoundException e1) {
						e1.printStackTrace();
					}
					
				} else {
					System.out.println("yape");
				}
			}
		});
		panel.add(btnNewButton);

	}

}
