package interfaces;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Miembro;

public interface IMiembro extends Remote {
	Miembro searchMiembro(int cedula) throws RemoteException;
	boolean updateMiembro(int cedula,
						  int id_cargo, 
						  String nombre,
						  int celular,
						  int semestre, 
						  int puntos) throws RemoteException;
	boolean delMiembro(int cedula)throws RemoteException;
	boolean addEvento(int cedula,
			 		  int id_cargo, 
			 		  String nombre,
			 		  int celular,
			 		  int semestre, 
			 		  int puntos)throws RemoteException;
	List<Miembro> searchMiembros() throws RemoteException;
	boolean searchMiembro1(int cedula) throws RemoteException;


}
