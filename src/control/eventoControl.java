package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import interfaces.IEvento;
import persistence.Evento;

public class EventoControl {

	// private Miembro a = null;;
	private IEvento ie = null;

	public EventoControl() throws RemoteException, NotBoundException {
		Registry r = LocateRegistry.getRegistry(10000);
		ie = (IEvento) r.lookup("Evento");
	}
	
	public List<Evento> searchMiembros() throws RemoteException {
		List<Evento> l = null;
		l = ie.searchEventos();
		return l;
		
	}

}
