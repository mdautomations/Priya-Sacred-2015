/*==========================================================================================
 												1. STEP 1 
==========================================================================================*/

var common_words="the, it is, we all, a, an, by, to, you, me, he, she, they, we, how, it, i, are, to, for, of"; 

/*==========================================================================================
												2. STEP 2 
==========================================================================================*/

var filteredPDFtwo  = new Array();

/*==========================================================================================
												4. STEP 4 
==========================================================================================*/

$(document).ready(function()
{
	var pdfTexttwo = $('#output').html();
	console.log("THE PDF CONTENT IS THIS :: ")
	console.log("============================")
	console.log(pdfTexttwo);
	filteredPDFtwo= getUncommon(pdfTexttwo,common_words);
	console.log("THE FILTERED EXTRACTED KEYWORD FROM PDF 1 :: ")
	console.log("=============================================")
	console.log(filteredPDFtwo);
	
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

