package control;

import java.util.List;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IMiembro;
import persistence.Miembro;

public class MiembroControl {
	
	//private Miembro a = null;;
	private IMiembro im = null;
	
	public MiembroControl() throws RemoteException, NotBoundException {
			Registry r = LocateRegistry.getRegistry(10000);
			im = (IMiembro) r.lookup("Miembro");
	}
	
	public boolean login(int cedula) {
		boolean existe;
		try {
			if(im.searchMiembro(cedula) != null)
				existe = true; 
				else
					existe = false;
		} catch (RemoteException e) {
			e.printStackTrace();
			existe = false; 
		}
		return existe;
	}
	
	public List<Miembro> searchMiembros() throws RemoteException {
		List<Miembro> l = null;
		l = im.searchMiembros();
		return l;
	}
	
	
}
