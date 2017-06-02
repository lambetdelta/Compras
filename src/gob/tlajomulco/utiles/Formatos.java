package gob.tlajomulco.utiles;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.classfile.Field;

public final class Formatos {
	
	public static String getFMoneda(double valor) {
		return "$" + getFNumero(valor);
	}
	
	public static String getFDecimal(double valor) {
		DecimalFormat fMon = new DecimalFormat("0.######");
		
		return  fMon.format(valor);
	}
	
	public static String getFNumero(double valor) {
		DecimalFormat fMon = new DecimalFormat("#,##0.0000");
		
		return fMon.format(valor);
	}
	
	public static String getFNumeroSingle(double valor) {
		DecimalFormat fMon = new DecimalFormat("#0.0000");
		
		return fMon.format(valor);
	}
	
	public static String getFNumeroSinPunto(double valor) {
		DecimalFormat fMon = new DecimalFormat("#0.00");
		
		String sVal = fMon.format(valor);
		
		return sVal.substring(0, sVal.length() - 3) + sVal.substring(sVal.length() - 2);
	}
	
	public static String getFNumeroCBB(double valor) {
		DecimalFormat fMon = new DecimalFormat("0000000000.000000");
		
		String sVal = fMon.format(valor);
		
		return sVal; //.substring(0, sVal.length() - 3) + sVal.substring(sVal.length() - 2);
	}
	
	public static String getHoyStr() {
		SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss.SSS");
		
		Date hoy = new Date();
		
		return fDate.format(hoy);
	}
	
	public static String getHoyAAMMDD() {
		SimpleDateFormat fDate = new SimpleDateFormat("yyMMdd");
		
		Date hoy = new Date();
		
		return fDate.format(hoy);
	}
	
	public static String getHoyAAAAMMDD() {
		SimpleDateFormat fDate = new SimpleDateFormat("yyyyMMdd");
		
		Date hoy = new Date();
		
		return fDate.format(hoy);
	}
	
	public static String getHoyHoraHHMMSS() {
		SimpleDateFormat fDate = new SimpleDateFormat("kkmmss");
		
		Date hoy = new Date();
		
		return fDate.format(hoy);
	}
	
	public static String getHoyStr(boolean corto) {

		SimpleDateFormat fDate;
		
		if (corto)
			fDate = new SimpleDateFormat("dd/MM/yyyy");
		else
			fDate = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		
		Date hoy = new Date();
		
		return fDate.format(hoy);
	}
	
	public static String getFechaStr(Date fecha) {
		SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss.SSS");
		
		return fDate.format(fecha);
	}
	
	public static String getFechaStr(Date fecha, boolean corto) {
		SimpleDateFormat fDate;
		
		if (corto)
			fDate = new SimpleDateFormat("dd/MM/yyyy");
		else
			fDate = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		
		return fDate.format(fecha);
	}
	
	public static String getFechaLargo(Date fecha) {
		SimpleDateFormat fDate = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy kk:mm:ss");
		
		return fDate.format(fecha);
	}
	
	public static String getFechaCFDI(Date fecha) {
		SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
		
		return fDate.format(fecha);
	}
	
	public static java.sql.Date getSQLDate(Date fecha) {
		return new java.sql.Date(fecha.getTime());
	}
	
	public static java.sql.Timestamp getSQLTimeStamp(Date fecha) {
		return new java.sql.Timestamp(fecha.getTime());
	}
	
	public static Timestamp getDateTime() {
		Calendar cal = Calendar.getInstance();
		//Calendar cal = GregorianCalendar.getInstance();		
		return new Timestamp(cal.getTime().getTime()); 
	}
	
	public static java.sql.Date getHoySQL() {
		Calendar cal = Calendar.getInstance();
		//Calendar cal = GregorianCalendar.getInstance();
		java.sql.Date hoy = new java.sql.Date(cal.getTimeInMillis());
		
		return hoy;
	}
	
	public static String getFPorcentaje(double valor) {
		DecimalFormat fMon = new DecimalFormat("##0.##%");
		
		return fMon.format(valor);
	}
	
	public static String getFFolio(int valor) {
		DecimalFormat fMon = new DecimalFormat("00000");
		
		return fMon.format(valor);
		
	}
	
	public static String getFFolio(int valor, int ceros) {
		String Rellena = "";
		
		for (int i = 0; i < ceros; i++) {
			Rellena += "0";
		}
		
		DecimalFormat fMon = new DecimalFormat(Rellena);
		
		return fMon.format(valor);
		
	}
	
	public static String getRellenaDerecha(String original, char relleno, int longitud) {
		String rellena = "";
		int cuantos = longitud - original.length();
		
		for (int i = 0; i < cuantos; i++) {
			rellena += relleno;
		}
		
		return rellena + original;
	}
	
	public static Date getFechaFromStr(String fecha) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dFecha = null;
		
		try {
			dFecha = df.parse(fecha);
		} catch (ParseException e) {
			dFecha = new Date();
		}
		
		return dFecha;
	}
	
	public static int getAnno() {
		Calendar hoy = Calendar.getInstance();
		
		return hoy.get(Calendar.YEAR);
	}
	
	public static String getAnno(Date fecha) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		
		return df.format(fecha);
	}
	
	public static int getAxo(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		
		return cal.get(Calendar.YEAR);
	}
	
	public static int getDia() {
		Calendar hoy = Calendar.getInstance();
		
		return hoy.get(Calendar.DAY_OF_MONTH);
	}
	
	public static String getDia(Date fecha) {
		SimpleDateFormat df = new SimpleDateFormat("dd");
		
		return df.format(fecha);
	}
	
	public static int getMes() {
		Calendar hoy = Calendar.getInstance();
		
		return hoy.get(Calendar.MONTH) + 1;
	}
	
	public static String getMes(Date fecha) {
		SimpleDateFormat df = new SimpleDateFormat("MM");
		
		return df.format(fecha);
	}
	
	public static Date setFecha(int dia, int mes, int axo) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(axo, mes-1, dia); // Febrero 2006, los meses empiezan en 0.
		return cal.getTime();
	}
	
	public static int getUltimoDiaMes(int mes) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), mes - 1, 1); // los meses empiezan en 0.
		return cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	}
	
	/**
	 * 
	 * Obtiene la diferencia en dias de una fecha dada con hoy
	 * @return dias de diferencia
	 */
	public static long getDiferenciaDiasHoy(Date dia) {
		Calendar hoy = GregorianCalendar.getInstance();
		
		System.out.println("hoy: " + hoy.getTime());
		System.out.println("otro dia: " + dia);
		Calendar otra = GregorianCalendar.getInstance();
		otra.set(Integer.parseInt(getAnno(dia)), Integer.parseInt(getMes(dia))-1, Integer.parseInt(getDia(dia)));
		
		System.out.println("otro: " + otra.getTime());
		
		
		long difMs = otra.getTimeInMillis() - hoy.getTimeInMillis();
		long difD = difMs / (1000 * 60 * 60 * 24);
		
		return difD;
	}
	
	public static String separaCadena(String cadOriginal, int longitud) {
		String cad = "";
		StringTokenizer tokens = new StringTokenizer(cadOriginal);
		
		while (tokens.hasMoreTokens()) {
			String palabra = tokens.nextToken(" ");
			String cadX = cad + palabra;
			
			if (cadX.length() <= longitud)
				cad += palabra + " ";
			else break;
		}
		
		return cad.trim();
	}
	
	public static String convertToUTF8(String s) {
        String out = null;
        try {
        	CharsetEncoder isoEncoder = Charset.forName("ISO-8859-1").newEncoder();
        	boolean isISO = isoEncoder.canEncode(s);
        	
        	if (isISO)
        		out = new String(s.getBytes("iso-8859-1"), "utf-8");
        	else
        		out = s;
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
	
	public static String reemplazarStr(String cadena, String busqueda, String reemplazo) {
		if (cadena != null)
			if (!cadena.equals(""))
				return cadena.replaceAll(busqueda, reemplazo);
			else
				return "";
		else
			return "";
	}
	
	public static String convertToHTML(String s) {
		String cadena = s.replaceAll("Ñ", "&#209;");		
		cadena = cadena.replaceAll("Á", "&#193;"); 
		cadena = cadena.replaceAll("É", "&#201;"); 
		cadena = cadena.replaceAll("Í", "&#205;"); 
		cadena = cadena.replaceAll("Ó", "&#211;"); 
		cadena = cadena.replaceAll("Ú", "&#218;"); 
		cadena = cadena.replaceAll("ñ", "&#241;");
		cadena = cadena.replaceAll("á", "&#225;"); 
		cadena = cadena.replaceAll("é", "&#233;"); 
		cadena = cadena.replaceAll("í", "&#237;");
		cadena = cadena.replaceAll("ó", "&#243;"); 
		cadena = cadena.replaceAll("ú", "&#250;"); 
		return cadena;
	}
	

	public static int getBimestre(int mes) {
		int bim = 0;
		
		if (mes % 2 > 0)
			bim = (int) mes / 2 + 1;
		else
			bim = (int) mes / 2;
		
		return bim;
	}
	
	public static double getParcialidad(int plazo, double monto) {
		return Math.ceil((monto / plazo)*100) / 100;
	}
	
	public static double Redondear2d(double numero) {
		 return Math.rint(numero * 100) / 100;
	}
	
	public static boolean existeRemoto(String urlName) {
					
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(urlName).openConnection();
			
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public static boolean existeArchivo(String path) {
		
		File archivo = new File(path);
		
		return archivo.exists();
	}
}
