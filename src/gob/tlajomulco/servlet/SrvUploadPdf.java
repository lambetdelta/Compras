package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelUsuario;
import gob.tlajomulco.utiles.Formatos;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.tempuri.EstrucuraRetornoUpdate;

/**
 * Servlet implementation class SrvUploadPdf
 */
@WebServlet("/UploadPdf")
public class SrvUploadPdf extends HttpServlet {

	private static final long serialVersionUID = 280001943170703908L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SrvUploadPdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);			

		System.out.println(Formatos.getHoyStr() + "\tIngresando a upload de archivos... " + isMultipart);
		// Procesamos solo si es Multipart
		if (isMultipart) {
			// Leemos datos de la sesion
			HttpSession s = req.getSession(false);
			ModelUsuario user = new ModelUsuario();
			user = (ModelUsuario) s.getAttribute("user");	
								
			String cotNo = ""; // Número de cotización	
			String idCotizacion = ""; // Numero de cotizacion
			
			System.out.println("Test, creamos DiskFileItemFactory");
			FileItemFactory factory = new DiskFileItemFactory();
			System.out.println("Test, creamos ServletFileUpload");
			ServletFileUpload upload = new ServletFileUpload(factory);
								

			try {
				System.out.println("Test, creamos lista de FileItem cargados");
				ServletRequestContext rc = new ServletRequestContext(req);				
				List<FileItem> multiparts = upload. parseRequest(rc);

				System.out.println("Lista de archivos a subir: " + multiparts.size());
				
				//for (int j = 0; j < multiparts.size(); j++) {
				//	FileItem item = multiparts.get(j);
					
				//}
				for (FileItem item : multiparts) {
					//System.out.println("Entrada: " + i);
					if (!item.isFormField()) {
						String name = new File (item.getName()).getName();
						System.out.println("Archivo: " + name + "\tCotización: " + cotNo);
						//item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

						ComprasDAO db = new ComprasDAO();			
						
						EstrucuraRetornoUpdate uploadR = db.uploadFile(cotNo, user.getUsuario(), item.get(), name, idCotizacion);
						
						if (!uploadR.isEXITO()) {
							System.out.println(uploadR.getMENSAJE());
						}
					} else {
						String campo = (String) item.getFieldName();
						
						if (campo.equals("cotNo")) {
							cotNo = item.getString();
						}
						if (campo.equals("idCotizacion")) {
							idCotizacion = item.getString();
 						}
					}
				}

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				System.out.println("Fallo la carga de archivos..");
			}

		} else
			System.out.println(Formatos.getHoyStr() + "\tCotización no cargada...");
	}

}
