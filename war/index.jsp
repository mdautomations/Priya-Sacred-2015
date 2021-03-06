<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>PDFToText</title>
  <style>.textLayer { display: none; }</style>
  <script src="example/jquery.min.js"></script>
</head>

<body style="font:13px Helvetica,sans-serif">
  <div id="message">Loading...</div>
  <div id="viewer" style="display:none"></div>
  
  <div>Uses <a href="https://github.com/arturadib/pdf.js/tree/text-select/" target="_blank">pdf.js + text-select</a>, by Mozilla and Artur Adib.<br><a href="https://github.com/hubgit/hubgit.github.com/tree/master/2011/11/pdftotext" target="_blank">Code on GitHub</a></div>

  <script id="pdf-js" src="pdf.js"></script>
  <script>PDFJS.workerSrc = document.getElementById("pdf-js").getAttribute("src");</script>

  <script src="app.js"></script>
  <script>var app = new App;</script>
</body>

</html>
