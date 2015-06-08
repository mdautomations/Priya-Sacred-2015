
$(document).ready(function()
{
	var array1 = new Array();
	var array2 = new Array();
	
	array1 = toappend.split(',');
	array2 = toappend2.split(',');
	console.log("array 1 length b4 :: "+array1.length);
	console.log("array 2 length b4 :: "+array2.length);
	array1 = array1.filter(function(item, i, ar){ return ar.indexOf(item) === i; });
	console.log("array 1 length after :: "+array1.length);
	array2 = array2.filter(function(item, i, ar){ return ar.indexOf(item) === i; });
	console.log("array2  length after :: "+array2.length);
  console.log("toappend :: "+toappend);
  
   $('#mini').html(array1.join(','));
   $('#mini2').html(array2.join(','));
  

});



		