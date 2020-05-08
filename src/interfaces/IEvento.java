package interfaces;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import persistence.Evento;

public interface IEvento extends Remote{
	Evento searchEvento(int id_evento) throws RemoteException;
	boolean updateEvento(int id_evento,
						 int id_encargado, 
						 String nombre_evento,
						 String descripcion,
						 Date fecha, 
						 String lugar, 
						 String hora, 
						 int cupos, 
						 int puntos, 
						 String tipo_evento) throws RemoteException;
	boolean delEvento(int id_evento)throws RemoteException;
	boolean addEvento(int id_evento,
					 int id_encargado, 
					 String nombre_evento,
					 String descripcion,
					 Date fecha, 
					 String lugar, 
					 String hora, 
					 int cupos, 
					 int puntos, 
					 String tipo_evento)throws RemoteException;
	List <Evento> searchEventos() throws RemoteException;

}
