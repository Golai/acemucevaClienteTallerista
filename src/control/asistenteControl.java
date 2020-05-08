package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IAsistente;
import persistence.Asistente;

public class asistenteControl {
	
	private Asistente a = null;;
	private IAsistente ia = null;
	
	public asistenteControl()throws RemoteException, NotBoundException {
		Registry r = LocateRegistry.getRegistry(10000);
		ia = (IAsistente) r.lookup("Asistente");
	}
	
	public void login(int cedula) {
		try {
			a = ia.searchAsistente(cedula);
		} catch (RemoteException e) {
			e.printStackTrace();
			a = null;
		}
		
		if(a!=null)
			System.out.println("El usuario si existe");
		else
			System.out.println("Error, tu cedula no esta registrada");
	}
}
