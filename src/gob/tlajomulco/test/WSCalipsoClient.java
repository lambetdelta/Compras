package gob.tlajomulco.test;

import java.rmi.RemoteException;

import org.tempuri.EstrucuraRetornoCATPROV;
import org.tempuri.ModelCatProveedores;
import org.tempuri.ProveedoresSoapProxy;

import gob.tlajomulco.utiles.Formatos;

public class WSCalipsoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoCATPROV prov;
		try {
			prov = ws.catalogoProveedores();
			
			for (int i = 0; i < prov.getDATOS_CONSULTA().length; i++) {
				ModelCatProveedores p = prov.getDATOS_CONSULTA()[i];
				
				System.out.println(p.getDENOMINACION());
				
			}
			
			System.out.println(Formatos.existeRemoto("https://compras.tlajomulco.gob.mx/documentos/Temp/DOCUMENTOADJUNTOINVITACION/0001701_2016.pdf"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
