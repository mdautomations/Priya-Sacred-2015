/*==========================================================================================
 							FINAL OPERATION - 1
==========================================================================================*/
 function intersection_destructive(a, b)
{
  var result = new Array();
  while( a.length > 0 && b.length > 0 )
  {  
     if      (a[0] < b[0] ){ a.shift(); }
     else if (a[0] > b[0] ){ b.shift(); }
     else /* they're equal */
     {
       result.push(a.shift());
       b.shift();
     }
  }

  return result;
}
 
/*==========================================================================================
							FINAL OPERATION - 2
==========================================================================================*/
 
 var plagiarisedContent = intersection_destructive(filteredPDFone,filteredPDFtwo);
 
/*==========================================================================================
							FINAL OPERATION - 3
==========================================================================================*/
 console.log("THE FINAL PLAGIARSED CONTENT AMONG THE TWO ARRAYS ARE");
 console.log("======================================================")
 console.log(plagiarisedContent);
 