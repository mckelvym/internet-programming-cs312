The Window Object
	opening new windows
		win=window.open("URL","myWin","properties");
		width=200, height, location, toolbar, status,menubar,scrollbar,resizable,directories
<html>
	<body>
	<form name="winform">
	<input TYPE="button" VALUE="open NEw Button"
	 onClick="win=window.open("",'NewWin','toolbar=0,status=0,width=100,height=200');">

	<input ...
	 onClick="win.close()">
	<input...
	onClick="self.close();">
	
	
	Resizing Windows, moving locations
	
	window.moveTo(x,y)
		window.moveBy(x,y) -relative move
	window.reSize(width, height)
		window.resizeBy(width, height)
			
	<html>
	<head>
	<script...
	function doIt(){
		if(document.form1.w.value && document.form1.h.value)
			self.resize(document.form1.w.value,document.form1.h.value);
		if(document.form1.x.value && document.form1.y.value)
			self.moveTo(document.form1.x.value,document.form1.y.value);
	}
	<p>
	</script>
	<body>
	<form name="form1">
	<b>Width:</b><input type="text" name="w"><br>
	<b>Height:</b><input type="text" name="h"><br>
	<b>X-POs:</b><input type="text" name="x"><br>
	<b>Y-Pos:</b><input type="text" name="y"><br>
	<input type="button" value="ChangeWindow"
	  onClick="doIt();">
	</form>
	</body>
	</html>
	