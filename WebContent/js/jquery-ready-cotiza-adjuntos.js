/**
 * 
 */
$(document).ready(function() {	
	var options = {
			beforeSend : function() {
				$("#progressbox").show();
				// clear everything
				$("#progressbar").width('0%');
				$("#message").empty();
				$("#percent").html("0%");
			},
			uploadProgress : function(event, position, total, percentComplete) {
				$("#progressbar").width(percentComplete + '%');
				$("#percent").html(percentComplete + '%');

				// change message text and % to red after 50%
				if (percentComplete > 50) {
					$("#message").html("<font color='red'>Carga de archivos en proceso .. </font>");
				}
			},
			success : function() {
				$("#progressbar").width('100%');
				$("#percent").html('100%');
			},
			complete : function(response) {
				$("#message").html("<font color='blue'>¡Archivos cargados satisfactoriamente!</font>");
				$("#btn-okupload").hide();
			},
			error : function() {
				$("#message").html("<font color='red'> ERROR: No se pudieron subir los archivos</font>");
			}
	};
	
	$("#frmUpload").ajaxForm(options);
});