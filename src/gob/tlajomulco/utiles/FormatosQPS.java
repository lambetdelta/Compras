package gob.tlajomulco.utiles;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.DecimalFormat;


public class FormatosQPS {

	public FormatosQPS() {
		// TODO Auto-generated constructor stub
	}

	public static String getFechaCorta(String fechaWS) {
		// yyyyMMddkkmmssSSS
		try {
			String axo = fechaWS.substring(0, 4);
			String mes = fechaWS.substring(4, 6);
			String dia = fechaWS.substring(6, 8);

			return dia + "/" + mes + "/" + axo;
		} catch(Exception e) {
			System.out.println(e.getMessage());

			return fechaWS;
		}
	}
	
	public static String getAxo(String fechaWS) {
		return fechaWS.substring(0, 4);
	}
	
	public static String getFechaLarga(String fechaWS) {
		// yyyyMMddkkmmssSSS
		try {
			String axo = fechaWS.substring(0, 4);
			String mes = fechaWS.substring(4, 6);
			String dia = fechaWS.substring(6, 8);
			String hora = fechaWS.substring(8, 10);
			String min = fechaWS.substring(10, 12);
			String seg = fechaWS.substring(12, 14);
			String mil = fechaWS.substring(14);
			return dia + "/" + mes + "/" + axo + " " + hora + ":" + min + ":" + seg + ":" + mil;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
			return fechaWS;
		}
		
	}
	
	public static String getFechaQPS(String fechaSimple) {
		String dia = fechaSimple.substring(0, 2);
		String mes = fechaSimple.substring(3, 5);
		String axo = fechaSimple.substring(6);
		
		
		return axo + mes + dia + "000000000";
	}
	
	public static String getMoneda(String valorWS) {
		try {
			if (valorWS.equals(""))
				valorWS = "0";
			
			DecimalFormat fMon = new DecimalFormat("#,##0.0000");
			double valor = Double.parseDouble(valorWS);
			
			return "$ " + fMon.format(valor);
			
		} catch (Exception e)  {
			return "$ 0.00";
		}
	}	
	
	public static String getPorcentaje(String valorWS) {
		try {
			if (valorWS.equals(""))
				valorWS = "0 %";
			
			DecimalFormat fMon = new DecimalFormat("##0");
			double valor = Double.parseDouble(valorWS);
			
			return fMon.format(valor) + " %";
			
		} catch (Exception e)  {
			return "0 %";
		}
	}
	
	public static String getBooleano(String valorWS) {
		
		if (valorWS.equals("T"))
			return "Si";
		else
			return "No";
		
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
}
