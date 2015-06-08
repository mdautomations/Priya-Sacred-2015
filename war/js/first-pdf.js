/*==========================================================================================
 												1. STEP 1 
==========================================================================================*/
var pdfTextone ;
var isSent = "false";
var common_words="the, it is, we all, a, an, by, to, you, me, he, she, they, we, how, it, i, are, to, for, of"; 

/*==========================================================================================
												2. STEP 2 
==========================================================================================*/

var filteredPDFone  = new Array();

/*==========================================================================================
												4. STEP 4 
==========================================================================================*/

$(document).ready(function()
{
	$('#comparefiles').click(function()
	{
		window.location.href="/compare.jsp";
	});
	$('#proceeding').click(function()
	{
						$('#h2header').show();
						var pdfTextone = $('#output').html();
						var testArray = new Array();
						debugger;
						console.log("THE PDF CONTENT IS THIS :: ")
						console.log("============================")
						console.log(pdfTextone);
						debugger;
						filteredPDFone= getUncommon(pdfTextone,common_words);
						console.log("THE FILTERED EXTRACTED KEYWORD FROM PDF 1 :: ")
						console.log("=============================================")
						for(var agentview=0;agentview<filteredPDFone.length;agentview++){
							$('#store').append(filteredPDFone[agentview])	;
							$('#store').append('<br/>')	;
						}
						var filenumber = $('#filenum').val();
						if(isSent =="false")
						{
							$.ajax({
								type	: 'POST', 
								url		: '/fileload' ,
								data	: {filteredPDFone :filteredPDFone.join(','),filenumber:filenumber},
								success	: function(data)
										  {
											isSent = "true";
										  }
							});
						}
						
					});
});


/*==========================================================================================
												3. STEP 3 
==========================================================================================*/

function getUncommon(sentence, common) {
    var wordArr = sentence.match(/\w+/g),
        commonObj = {},
        uncommonArr = [],
        word, i;

    common = common.split(',');
    for ( i = 0; i < common.length; i++ ) {
        commonObj[ common[i].trim() ] = true;
    }

    for ( i = 0; i < wordArr.length; i++ ) {
        word = wordArr[i].trim().toLowerCase();
        if ( !commonObj[word] ) {
            uncommonArr.push(word);
        }
    }

    return uncommonArr;
}

