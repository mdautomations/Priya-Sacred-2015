var obj = {}, 
    matched = [],
    unmatched = [];
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
	var plagiarisedContent = diff(array1,array2);
     console.log("last :: "+plagiarisedContent); 	
	dtable = $('#initial').dataTable({
				"bDestroy" : true,
				"aoColumns" : [{
					"sTitle" : "MatchedData",
					"sWidth" : "100%",
					"sClass" : "center"
				}]
			});
			dtable.fnClearTable();
			var newRow = [];
			for(index in matched)
			{
				newRow[0] = matched[index];
				dtable.fnAddData(newRow);
			}
				dtable.fnDraw();
				
				dtable = $('#datastables').dataTable({
					"bDestroy" : true,
					"aoColumns" : [{
						"sTitle" : "UnMatchedData",
						"sWidth" : "100%",
						"sClass" : "center"
					}]
				});
				dtable.fnClearTable();
				var newRow = [];
				for(index in unmatched)
				{
					newRow[0] = unmatched[index];
					dtable.fnAddData(newRow);
				}
				dtable.fnDraw();
					$('#main').show();
					$('#loading').hide();
});
function diff(arr1, arr2) {
    
    for (var i = 0, l = arr1.length; i < l; i++) {
        obj[arr1[i]] = (obj[arr1[i]] || 0) + 1;
    }
    for (i = 0; i < arr2.length; i++) {
        var val = arr2[i];
        if (val in obj) {
            matched.push(val);
        } else {
            unmatched.push(val);
        }
    }
    // Here you can find how many times an element is repeating.
    console.log("obj ::"+obj);
    // Here you can find what are matching.
    console.log("matched"+matched);
    // Here you can check whether they are equal or not.
//    console.log('Both are equal ? :' + matched.length === a.length);
    // Here you can find what are different  
    console.log("unmatched :: "+unmatched);
}


 