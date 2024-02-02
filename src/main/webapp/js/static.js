$( document ).ready(function() {
  
  $("#progress").data("progress", 0);
  
  $( "#click" ).on( "click", function() {
    console.log("Button was clicked!");
    let progress = $("#progress").data("progress");
    if( progress < 100 && progress >= 0 ) {
	    progress += 10
	    $("#progress").css("width", progress.toString() + "%");
	    $("#progress .sr-only").text( progress.toString() + "% Complete" );
	    $("#progress").data("progress", progress);		
	} else if ( progress === 100 ) {
		progress = 0
	    $("#progress").css("width", progress.toString() + "%");
	    $("#progress .sr-only").text( progress.toString() + "% Complete" );
	    $("#progress").data("progress", progress);		
	}	
  } );
  
});