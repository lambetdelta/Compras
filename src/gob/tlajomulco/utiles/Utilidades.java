package gob.tlajomulco.utiles;
import java.util.Arrays;
import org.tempuri.CONCURSOSMODEL;
import gob.tlajomulco.config.Estatus;
public class Utilidades {

	public Utilidades(){
	}
	/**
	* Check if the given object is an array (primitve or native).
	*
	* @param obj  Object to test.
	* @return     True of the object is an array.
	* credits http://www.java2s.com/Code/Java/Reflection/Checkifthegivenobjectisanarrayprimitveornative.htm
	*/
	public static boolean isArray(final Object obj) {
		if (obj != null)
			return obj.getClass().isArray();
		return false;
	}
	public static String limpiar(String cadena){
		String cadena_limpia=cadena;
		String[] lista_negra={"select","insert","delete","update","drop","where","create","alter","index","show","execute","grant","super","lock","trigger","html","body","head","script","xml","version","encoding","style" ,"java"};
		int lenght=lista_negra.length;
		for (int i = 0; i < lenght; i++) {
			cadena_limpia = cadena_limpia.replace(lista_negra[i], "");
			
		}
		return cadena_limpia;
	}
	public static String asignarCadenaPorCoincidencia(String aguja, String[] pajar,String cadena){
		if (!Arrays.toString(pajar).matches(".*[\\[ ]" + aguja + "[\\],].*")) {
			cadena="";
		}
		return cadena;
	}
	public static CONCURSOSMODEL[] prepararRespuestaAjax(CONCURSOSMODEL[] data,Estatus status){
			int length=data.length;
			String url;
			for (int i = 0; i < length; i++) {
				url=status.getRepositorioLicitacionesPath() + data[i].getNUMERODOCUMENTO() + ".pdf";
				data[i].setTOTAL(url);
				if (Formatos.existeArchivo(url)){
					data[i].setArchivoDisponible(true);
				}
			}
			return data;
	}
}
