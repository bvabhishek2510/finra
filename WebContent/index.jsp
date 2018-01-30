<!doctype html>
<html>
<head>

<link rel="stylesheet" href="css/gstApplication.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet" href="css/ui.jqgrid.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="js/jquery.jqGrid.src.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>

<script>
    $(document).ready(function () {
    	$('#btnSubmit').click(function() {
    		if($('#phoneNumber').val().length == 7 || $('#phoneNumber').val().length == 10){
        	$.ajax({
    			url : 'generateAlphaNumericNumber',
    			type: "GET",
    			data : {
    				phoneNumber : $('#phoneNumber').val()
    			},
    			success : function(responseText) {
    				var list=[];
    				var mydata = [];
    				list = responseText.slice(1, -1).split(",");
    				var names = ["id"];
    				for (var i = 0; i < list.length; i++) {
    				    mydata[i] = {};
    				    for (var j = 0; j < list[i].length; j++) {
    				        mydata[i][names[j]] = list[i];
    				    }
    				}
    				$('#totalCount').text(list.length);
    				jQuery('#alphaNumericGrid').jqGrid('clearGridData');
					jQuery('#alphaNumericGrid').jqGrid('setGridParam', {data: mydata});
					jQuery('#alphaNumericGrid').trigger('reloadGrid');
    				jQuery("#alphaNumericGrid").jqGrid({
    		    		datatype: "local",
    		    		data:mydata,
    		    	   	colNames:['Alpha Numeric Numbers'],
    		    	   	colModel:[
    		    	   		{name:'id',index:'id', width:300}	
    		    	   	],
    		    	   	multiselect: false,
    		    	    rowNum: 20,
    	                altRows:true,
    	                autowidth:true, 
    	                shrinkToFit:true,
    	                forceFit:true,
    	                pager: "#pager",
    	                height: 'auto',
    	                
    	                viewrecords: true,   	
    		    	}).navGrid('#pager', {edit: false, add: false, del: false, search: false, refresh:false});
    				$("#pager_left").css("width", "5px"); 		    	
    			}
    		});
        	
    		}else{
    			alert("Phone number should be 7 or 10 digits.")
    		}
        	
        	
        	
        });        
    });
    
    </script>
</head>
<body>


	<div class="dashboard">
		<div class="container-fluid">
			<div class="row" style="background-color: white;">
				<div class="col-md-6">
					<div class="modal-dialog" style="margin: 30px 56px;">
						<div class="modal-content" style="margin-bottom: 80px;">
							<div class="modal-header login_modal_header">
								<h2 class="modal-title" id="myModalLabel">Phone Number
									Generator</h2>
							</div>
							<div class="registration" style="padding: 0 13% 0 13%;">
								<br />
								<div class="clearfix"></div>
								<form class="form-horizontal">
									<div class="form-group">

										<label class="control-label col-md-4"> Phone Number</label>
										<div class="controls col-md-8 ">
											<input type="text" id="phoneNumber" name="phoneNumber"
												placeholder="Phone Number(XXXXXXXXXX)"
												onkeypress='return event.charCode >= 48 && event.charCode <= 57'
												class="form-control" autofocus />
										</div>
									</div>
									<div class="form-group">
										<div>
											<a class="btn btn-success" id="btnSubmit" href="#">Submit</a>
										</div>
									</div>
								</form>
								<!-- /form -->
							</div>
							<div class="clearfix"></div>
							<div class="modal-footer login_modal_footer"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="modal-dialog" style="margin: 30px 56px;">
						<div class="modal-content" style="margin-bottom: 80px;">
							<div class="modal-header login_modal_header">
								<h2 class="modal-title" id="myModalLabel"></h2>
							</div>
							<div style="padding: 0 13% 0 13%;">
								<br /> Total Number of Alpha Numeric Numbers
								<p id="totalCount"></p>
								<div class="widget stacked widget-table action-table"
									style="margin-top: 20px;">


									<div class="widget-content"
										style="width: 100%; overflow: auto;">

										<table class="table table-striped table-bordered" border=1
											id="alphaNumericGrid"></table>
										<div id="pager"></div>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="modal-footer login_modal_footer"></div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
