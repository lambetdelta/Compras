<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String cotNo = request.getParameter("cotNo");
	String idCotizacion = request.getParameter("idCotizacion");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subir archivos adjuntos</title>
<link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">

<script src="js/bootstrap-filestyle.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script src="js/jquery-ready-cotiza-adjuntos.js" type="text/javascript"></script>
</head>
<body>
	<div class="modal-dialog" id="dialog-cotizaitem">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3><span class="glyphicon glyphicon-paperclip"></span> Adjuntar documentos Cot: <%=cotNo %></h3>
			</div>
			
			<div class="modal-body">
				<form name="frmUpload" id="frmUpload"  role="form" data-toggle="validator" action="UploadPdf" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
					<input type="hidden" name="cotNo" value="<%=cotNo %>">
					<input type="hidden" name="idCotizacion" value="<%=idCotizacion %>">				
					Cargar documentos (Solo archivos PDF, máximo 3 Mb):
					<br/>
					<br/>
					<input type="file" size="50" name="file1" required accept=".pdf" class="filestyle" data-buttonText="Cargar" data-iconName="glyphicon-open-file" data-buttonName="btn-primary">
					<br/>
					<input type="file" size="50" name="file2" accept=".pdf" class="filestyle" data-buttonText="Cargar" data-iconName="glyphicon-open-file">
					<br/>
					<input type="file" size="50" name="file3" accept=".pdf" class="filestyle" data-buttonText="Cargar" data-iconName="glyphicon-open-file">
					<br/>
					<input type="file" size="50" name="file4" accept=".pdf" class="filestyle" data-buttonText="Cargar" data-iconName="glyphicon-open-file">
					<br/>
					<input type="file" size="50" name="file5" accept=".pdf" class="filestyle" data-buttonText="Cargar" data-iconName="glyphicon-open-file">
					<br>
					<div id="progressbox">
         				<div id="progressbar"></div>
         				<div id="percent">0%</div>
       				</div>
					
					<br />
					<div id="message"></div>								
				</form>
			</div>
			
			<div class="modal-footer">
				<button id="btn-okupload" type="submit" class="btn btn-default" form="frmUpload"><span class="glyphicon glyphicon-ok-sign"></span> Subir</button>
				<button type="button" data-dismiss="modal" class="btn"><span class="glyphicon glyphicon-remove-sign"></span> Cerrar</button>
			</div>
		</div>
	</div>
</body>
</html>