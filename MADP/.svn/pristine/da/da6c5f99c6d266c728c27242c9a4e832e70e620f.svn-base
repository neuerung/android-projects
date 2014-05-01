package mobi.neuerung.ScreenParser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ScreenWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class HomeScreenParser extends DefaultHandler
{
	private String localName = "";
	String buffer="";

	ScreenWrapper _objScreenWrapper;
	ElementWrapper _objElementWrapper;
	ScreenPartWrapper _objScreenPartWrapper;
	String ScreenName="";
	String Section="";
	
	String ParsingFor="";

	public HomeScreenParser(String LocalOrLiveOrLocalLive)
	{
		this.ParsingFor = LocalOrLiveOrLocalLive;
	}

	
	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("Screens"))
		{
			MyUIApplication.ScreenNumbers = new ArrayList<String>();
			
			// ** DB List FOr Speed 
			if(ParsingFor.equals("Local"))
			{
				MyUIApplication._objScreenWrappersList=null;
				MyUIApplication._objScreenWrappersList= new ArrayList<ScreenWrapper>();

				MyUIApplication._objScreenPartWrappersList=null;
				MyUIApplication._objScreenPartWrappersList= new ArrayList<ScreenPartWrapper>();

				MyUIApplication._objElementWrapperList=null;
				MyUIApplication._objElementWrapperList= new ArrayList<ElementWrapper>();
			}
			else if(ParsingFor.equals("Live"))
			{
				MyUIApplication._objScreenWrappersList=null;
				MyUIApplication._objScreenWrappersList= new ArrayList<ScreenWrapper>();
				
				MyUIApplication._objScreenPartWrappersList=null;
				MyUIApplication._objScreenPartWrappersList= new ArrayList<ScreenPartWrapper>();
				
				MyUIApplication._objElementWrapperList=null;
				MyUIApplication._objElementWrapperList= new ArrayList<ElementWrapper>();
			}
			else
			{

				MyUIApplication._objTempScreenWrappersList=null;
				MyUIApplication._objTempScreenWrappersList= new ArrayList<ScreenWrapper>();

				MyUIApplication._objTempScreenPartWrappersList=null;
				MyUIApplication._objTempScreenPartWrappersList= new ArrayList<ScreenPartWrapper>();

				MyUIApplication._objTempElementWrapperList=null;
				MyUIApplication._objTempElementWrapperList= new ArrayList<ElementWrapper>();
			}

			// ************************************//
		}
		if(localName.equals("Screen"))
		{

			System.out.println("HomePuneetParserPoint1");
			_objScreenWrapper=null;
			_objScreenWrapper=new ScreenWrapper();


			_objScreenPartWrapper=null;
			_objScreenPartWrapper = new ScreenPartWrapper();


			_objScreenWrapper.Number=(atts.getValue("Number"));
			MyUIApplication.ScreenNumbers.add(atts.getValue("Number"));
			ScreenName=_objScreenWrapper.Number;

			_objScreenWrapper.Type=(atts.getValue("Type"));
			_objScreenWrapper.Title=(atts.getValue("Title"));
			_objScreenWrapper.OnClick=(atts.getValue("OnClick"));
			_objScreenWrapper.bgImage=(atts.getValue("bgImage"));
			_objScreenWrapper.bgcolor=(atts.getValue("bgcolor"));

			//			int i = MyUIApplication._objScreenDB.insertRecords(_objScreenWrapper);

			if(ParsingFor.equals("Local"))
			{
				MyUIApplication._objScreenWrappersList.add(_objScreenWrapper);
			}
			else if(ParsingFor.equals("Live"))
			{
				MyUIApplication._objScreenWrappersList.add(_objScreenWrapper);
			}
			else
			{
				MyUIApplication._objTempScreenWrappersList.add(_objScreenWrapper);
				int l =MyUIApplication._objScreenWrappersList.size();
				System.out.println("" +l);
			}
			int j =MyUIApplication._objScreenWrappersList.size();
			//			System.out.println(""+i +j);
			System.out.println("" +j);
			_objScreenWrapper = null;

		}

		if(localName.equals("Element"))
		{
			_objElementWrapper = new ElementWrapper();

			_objElementWrapper.ScreenName=ScreenName;
			_objElementWrapper.Number=(atts.getValue("Number"));
			_objElementWrapper.Type=(atts.getValue("Type"));
			_objElementWrapper.Code=(atts.getValue("Code"));
			_objElementWrapper.Section=this.Section;
			_objElementWrapper.Title=(atts.getValue("Title"));
			_objElementWrapper.Bitmap=(atts.getValue("Bitmap"));
			_objElementWrapper.OnClick=(atts.getValue("OnClick"));
			_objElementWrapper.width=(atts.getValue("width"));
			_objElementWrapper.height=(atts.getValue("height"));
			_objElementWrapper.left=(atts.getValue("left"));
			_objElementWrapper.middle=(atts.getValue("middle"));
			_objElementWrapper.right=(atts.getValue("right"));
			_objElementWrapper.rightper=(atts.getValue("rightper"));
			_objElementWrapper.leftper=(atts.getValue("leftper"));
			_objElementWrapper.middleper=(atts.getValue("middleper"));
			_objElementWrapper.leftbgColor=(atts.getValue("leftbgColor"));
			_objElementWrapper.midbgColor=(atts.getValue("midbgColor"));
			_objElementWrapper.rightbgColor=(atts.getValue("rightbgColor"));
			_objElementWrapper.leftbgImage=(atts.getValue("leftbgImage"));
			_objElementWrapper.midbgImage=(atts.getValue("midbgImage"));
			_objElementWrapper.rightbgImage=(atts.getValue("rightbgImage"));
			_objElementWrapper.distleft=(atts.getValue("distleft"));
			_objElementWrapper.disttop=(atts.getValue("disttop"));
			_objElementWrapper.leftClick=(atts.getValue("leftClick"));
			_objElementWrapper.rightClick=(atts.getValue("rightClick"));
			_objElementWrapper.bgcolor=(atts.getValue("bgcolor"));
			_objElementWrapper.selectedBgcolor=(atts.getValue("selectedBgcolor"));
			_objElementWrapper.txtColor=(atts.getValue("txtColor"));
			_objElementWrapper.body=(atts.getValue("body"));
			_objElementWrapper.mailto=(atts.getValue("mailto"));
			_objElementWrapper.subject=(atts.getValue("subject"));
			_objElementWrapper.font=(atts.getValue("font"));
			_objElementWrapper.leftscalefactor=(atts.getValue("leftscalefactor"));
			_objElementWrapper.rightscalefactor=(atts.getValue("rightscalefactor"));
			_objElementWrapper.midscalefactor=(atts.getValue("midscalefactor"));
			_objElementWrapper.subTitle=(atts.getValue("Subtitle"));
			_objElementWrapper.maxline=(atts.getValue("maxline"));
			_objElementWrapper.TitleGravity=(atts.getValue("TitleGravity"));
			_objElementWrapper.SubTitleGravity=(atts.getValue("SubTitleGravity"));
			_objElementWrapper.SubTitlefont=(atts.getValue("SubTitlefont"));
			_objElementWrapper.xper=(atts.getValue("xper"));
			_objElementWrapper.yper=(atts.getValue("yper"));
			_objElementWrapper.shareText=(atts.getValue("shareText"));
			_objElementWrapper.ImageWidth=(atts.getValue("ImageWidth"));
			_objElementWrapper.ImageHeight=(atts.getValue("ImageHeight"));
			_objElementWrapper.TextWidth=(atts.getValue("TextWidth"));
			_objElementWrapper.TextHeight=(atts.getValue("TextHeight"));
			_objElementWrapper.Link=(atts.getValue("Link"));
			_objElementWrapper.dividerColor=(atts.getValue("dividerColor"));
			_objElementWrapper.ImageSet=(atts.getValue("ImageSet"));
			_objElementWrapper.switcherTimer=(atts.getValue("switcherTimer"));
			_objElementWrapper.TextMode=(atts.getValue("TextMode"));
			_objElementWrapper.TextTransColor=(atts.getValue("TextTransColor"));
			_objElementWrapper.circleColor=(atts.getValue("circleColor"));
			_objElementWrapper.ImageMode=(atts.getValue("ImageMode"));
			_objElementWrapper.TopMargin=(atts.getValue("TopMargin"));
			_objElementWrapper.ImageUrlSet=(atts.getValue("ImageUrlSet"));
			_objElementWrapper.Datefont=(atts.getValue("Datefont"));
			_objElementWrapper.Timefont=(atts.getValue("Timefont"));
			_objElementWrapper.Linkfont=(atts.getValue("Linkfont"));
			_objElementWrapper.Datebg=(atts.getValue("Datebg"));
			_objElementWrapper.ReadNewsfont=(atts.getValue("ReadNewsfont"));
			_objElementWrapper.shareVisiblity=(atts.getValue("shareVisiblity"));
			_objElementWrapper.textChangeSizeVisiblity=(atts.getValue("textChangeSizeVisiblity"));
			_objElementWrapper.cc=(atts.getValue("cc"));
			_objElementWrapper.bcc=(atts.getValue("bcc"));
			_objElementWrapper.dialogText=(atts.getValue("dialogText"));
			_objElementWrapper.dialogOnOff=(atts.getValue("dialogOnOff"));
			_objElementWrapper.instance	=	(atts.getValue("instance"));
			if(_objElementWrapper.instance == null){
				_objElementWrapper.instance	=	"";
			}
			
			try {
			String aa[] =_objElementWrapper.font.split(",");
			_objElementWrapper.fontStyle = aa[0];
			_objElementWrapper.fontSize = aa[1];
			_objElementWrapper.fontColor = aa[2];
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String aa[] =_objElementWrapper.SubTitlefont.split(",");
				_objElementWrapper.subtitlefontStyle = aa[0];
				_objElementWrapper.subtitlefontSize = aa[1];
				_objElementWrapper.subtitlefontColor = aa[2];
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String aa[] =_objElementWrapper.Datefont.split(",");
				_objElementWrapper.DatefontStyle = aa[0];
				_objElementWrapper.DatefontSize = aa[1];
				_objElementWrapper.DatefontColor = aa[2];
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String aa[] =_objElementWrapper.Timefont.split(",");
				_objElementWrapper.TimefontStyle = aa[0];
				_objElementWrapper.TimefontSize = aa[1];
				_objElementWrapper.TimefontColor = aa[2];
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String aa[] =_objElementWrapper.Linkfont.split(",");
				_objElementWrapper.LinkfontStyle = aa[0];
				_objElementWrapper.LinkfontSize = aa[1];
				_objElementWrapper.LinkfontColor = aa[2];
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String aa[] =_objElementWrapper.ReadNewsfont.split(",");
				_objElementWrapper.ReadNewsfontStyle = aa[0];
				_objElementWrapper.ReadNewsfontSize = aa[1];
				_objElementWrapper.ReadNewsfontColor = aa[2];
			} catch (Exception e) {
				e.printStackTrace();
			}

			//			int i=MyUIApplication._objElementDB.insertRecords(_objElementWrapper);
			if(ParsingFor.equals("Local"))
			{
				MyUIApplication._objElementWrapperList.add(_objElementWrapper);
			}
			else if(ParsingFor.equals("Live"))
			{
				MyUIApplication._objElementWrapperList.add(_objElementWrapper);
			}
			else
			{
				MyUIApplication._objTempElementWrapperList.add(_objElementWrapper);
			}
			int j =MyUIApplication._objElementWrapperList.size();
			//			System.out.println(""+i +j);
			System.out.println("" +j);
			_objElementWrapper = null;
		}

		if(localName.equals("Top"))
		{
			Section="Top";

			_objScreenPartWrapper.ScreenName=ScreenName;
			_objScreenPartWrapper.Toprows=(atts.getValue("rows"));
			_objScreenPartWrapper.Topcolumns=(atts.getValue("columns"));
			_objScreenPartWrapper.TopHeight=(atts.getValue("height"));
			_objScreenPartWrapper.TopWidth=(atts.getValue("width"));
			_objScreenPartWrapper.TopType=(atts.getValue("Type"));
			_objScreenPartWrapper.TopLink=(atts.getValue("Link"));
			_objScreenPartWrapper.Topbgcolor=(atts.getValue("bgcolor"));
			_objScreenPartWrapper.TopbgImage=(atts.getValue("bgImage"));
			_objScreenPartWrapper.TophorizontalSpacing=(atts.getValue("horizontalSpacing"));
			_objScreenPartWrapper.TopverticalSpacing=(atts.getValue("verticalSpacing"));
			

		}
		if(localName.equals("Middle"))
		{
			Section="Middle";
			if(ScreenName.equals("600"))
			{
				String col = atts.getValue("columns");
				
				System.err.println(col);
			}

			_objScreenPartWrapper.ScreenName=ScreenName;
			_objScreenPartWrapper.Midrows=(atts.getValue("rows"));
			_objScreenPartWrapper.Midcolumns=(atts.getValue("columns"));
			_objScreenPartWrapper.MidHeight=(atts.getValue("height"));
			_objScreenPartWrapper.MidWidth=(atts.getValue("width"));
			_objScreenPartWrapper.MidType=(atts.getValue("Type"));
			_objScreenPartWrapper.MidLink=(atts.getValue("Link"));
			_objScreenPartWrapper.Midbgcolor=(atts.getValue("bgcolor"));
			_objScreenPartWrapper.MidbgImage=(atts.getValue("bgImage"));
			_objScreenPartWrapper.MidhorizontalSpacing=(atts.getValue("horizontalSpacing"));
			_objScreenPartWrapper.MidverticalSpacing=(atts.getValue("verticalSpacing"));

		}
		if(localName.equals("Bottom"))
		{
			Section="Bottom";

			_objScreenPartWrapper.ScreenName=ScreenName;
			_objScreenPartWrapper.Bottomrows=(atts.getValue("rows"));
			_objScreenPartWrapper.Bottomcolumns=(atts.getValue("columns"));
			_objScreenPartWrapper.BottomHeight=(atts.getValue("height"));
			_objScreenPartWrapper.BottomWidth=(atts.getValue("width"));
			_objScreenPartWrapper.BottomType=(atts.getValue("Type"));
			_objScreenPartWrapper.BottomLink=(atts.getValue("Link"));
			_objScreenPartWrapper.Bottombgcolor=(atts.getValue("bgcolor"));
			_objScreenPartWrapper.BottombgImage=(atts.getValue("bgImage"));
			_objScreenPartWrapper.BottomhorizontalSpacing=(atts.getValue("horizontalSpacing"));
			_objScreenPartWrapper.BottomverticalSpacing=(atts.getValue("verticalSpacing"));

		}
		this.localName = localName;
		System.out.println("PARSER is of HomeScreen  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(localName.equals("Screen"))
		{
			//			int i=MyUIApplication._objScreenPartDB.insertRecords(_objScreenPartWrapper);
			if(ParsingFor.equals("Local"))
			{
				MyUIApplication._objScreenPartWrappersList.add(_objScreenPartWrapper);
			}
			else if(ParsingFor.equals("Live"))
			{
				MyUIApplication._objScreenPartWrappersList.add(_objScreenPartWrapper);
			}
			else
			{
				MyUIApplication._objTempScreenPartWrappersList.add(_objScreenPartWrapper);
			}
			int j =MyUIApplication._objScreenPartWrappersList.size();
			//			System.out.println(""+i +j);
			System.out.println("" +j);
			_objScreenPartWrapper = null;
		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}
