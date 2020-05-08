package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import persistence.Asistente;

public interface IAsistente extends Remote{
	boolean registrarAEventos(int id_asistente) throws RemoteException;
	Asistente searchAsistente(int id_evento) throws RemoteException;
	boolean updateAsistente(int cedula,
						 String nombre, 
						 int celular, 
						 String email) throws RemoteException;
	boolean delAsistente(int id_evento)throws RemoteException;
	boolean addAsistente(int cedula,
			 String nombre, 
			 int celular, 
			 String email)throws RemoteException;
}
