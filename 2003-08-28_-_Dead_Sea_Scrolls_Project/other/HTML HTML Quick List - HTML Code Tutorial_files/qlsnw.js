//------------------------------------------------------------------
// this script copyright Idocs, Inc, 1999
// http://www.idocs.com
// Distribute this script freely but keep this notice in place
//------------------------------------------------------------------


//------------------------------------------------------------------
// setCookie
//
function setCookie(name,value,path,expireRelDays)
{
if (expireRelDays)
	{
	var today = new Date();
	var expires = new Date();
	expires.setTime(today.getTime() + ( 86400000 * expireRelDays));
	}

document.cookie = 
	name + "=" + escape(value) + 
	((path == null) ? "" : ("; path=" + escape(path))) +
	((expires == null) ? "" : ("; expires=" + expires.toGMTString()))
}
//
// setCookie
//------------------------------------------------------------------


//------------------------------------------------------------------
// getCookie
// this function kindly supplied by Netscape
//
function getCookie(Name)
{
var search = Name + "=";
if (document.cookie.length > 0)
	{
	offset = document.cookie.indexOf(search); 
	if (offset != -1)
		{
		offset += search.length ;
		end = document.cookie.indexOf(";", offset);
		if (end == -1) 
			end = document.cookie.length;
		return unescape(document.cookie.substring(offset, end));
		} 
	}
}
//
// getCookie
//------------------------------------------------------------------


//------------------------------------------------------------------
// newwin
//
function newwin(mylink)
{
if(document.forms["newwindowform"].elements["newwindow"].checked)
	mylink.target="_blank";
else
	mylink.target="_self";
}
//
// newwin
//------------------------------------------------------------------


//------------------------------------------------------------------
// snwc
// "Set New Window Cookie"
//
function snwc(mycb)
{
setCookie('wmrnewwin',mycb.checked,'/',100);
}
//
//
// snwc
//------------------------------------------------------------------


//------------------------------------------------------------------
// writeCheckBox
//
function writeCheckBox()
{
var checked;
document.write('<FORM NAME="newwindowform">');
document.write('<INPUT TYPE=CHECKBOX NAME="newwindow" ');
document.write('onClick="snwc(this)" ');
checked = getCookie('wmrnewwin');
if (checked && checked=="true")
	document.write('CHECKED');
document.write('>Open these links in a new window');
document.write('</FORM>');
document.snwready=true;
}
//
// writeCheckBox
//------------------------------------------------------------------

// note loaded
document.snwloaded=true;
