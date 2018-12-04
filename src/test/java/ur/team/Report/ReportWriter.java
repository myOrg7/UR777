package ur.team.Report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ReportWriter {
	static BufferedWriter bf;
	static String startDateTime =  new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
	
	public static void ur_writingHeader() throws IOException{
		String startDateTime =  new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
		startDateTime.getClass();
		// here need to  handle the space nd file existance
		String fileLoc = "C:\\Users\\Utkarsh\\Desktop\\new.html";
		File file = new File(fileLoc);
		bf = new BufferedWriter(new FileWriter(file));
		
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
		
		
		bf.write("<html>"+"\n");
			//---------------------Starting html header-------------------------
			bf.write("\t"+"<head>"+"\n");
			bf.write("\t"+"\t"+"<meta name='viewport' content='width=device-width, initial-scale=1'>\r\n" + 
					"\t"+"\t"+"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>\r\n" + 
					"\t"+"\t"+"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>\r\n" + 
					"\t"+"\t"+"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+"\n");
			bf.write("\t"+"\t"+"<meta http-equiv='Content-Type' content='text/html'; charset='windows-1252'>"+"\n");
				bf.write("\t"+"\t"+"<title>Test Execution Report [TER]</title>"+"\n");
				bf.write("\t"+"\t"+"<style type='text/css'>"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_tableCreator"+"\n"+"\t"+"\t"+"\t"+"{"+"\n");
					bf.write(""+
							"				display: table;\r\n" + 
							"				border: 3px solid #233460;\r\n" + 
							"				background: #D6D3DE;\r\n" + 
							"				margin-left: auto;\r\n" + 
							"				margin-right: auto;"+"\n"+"\t"+"\t"+"\t"+"}"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_resultTitle\r\n" + 
							"			{\r\n" + 
							"				display: table-caption;\r\n" + 
							"				font-weight: bold;\r\n" + 
							"				background: #D6D3DE;\r\n" + 
							"				font-size: larger;\r\n" + 
							"				text-align: center;\r\n" + 
							"				border: 3px solid #233460;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_tableHeading\r\n" + 
							"			{\r\n" + 
							"				display: table-row;\r\n" + 
							"				font-weight: bold;\r\n" + 
							"				text-align: center;\r\n" + 
							"				background:#cccccc;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_tableRow\r\n" + 
							"			{\r\n" + 
							"				display: table-row;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_tableCell\r\n" + 
							"			{\r\n" + 
							"				display: table-cell;\r\n" + 
							"				border: solid;\r\n" + 
							"				border-width: thin;\r\n" + 
							"				padding-left: 5px;\r\n" + 
							"				padding-right: 5px;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_tableRow:nth-child(odd)\r\n" + 
							"			{\r\n" + 
							"				background:#cddfff;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+".onPage\r\n" + 
							"			{\r\n" + 
							"				background:#E4E6EA;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+"#PASS\r\n" + 
							"			{\r\n" + 
							"				background-color: #2ECC71;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+"#FAIL\r\n" + 
							"			{\r\n" + 
							"				background-color: #FE243B;\r\n" + 
							"			}"+"\n");
					bf.write("\t"+"\t"+"\t"+".ur_snapThumbnail{\r\n" + 
							"				position: relative;\r\n" + 
							"				z-index: 0;\r\n" + 
							"			}\r\n" + 
							"\r\n" + 
							"			.ur_snapThumbnail:hover{\r\n" + 
							"				background-color: transparent;\r\n" + 
							"				z-index: 50;\r\n" + 
							"			}\r\n" + 
							"\r\n" + 
							"			.ur_snapThumbnail span{ /*CSS for enlarged image*/\r\n" + 
							"				position: absolute;\r\n" + 
							"				background-color: lightyellow;\r\n" + 
							"				padding: 5px;\r\n" + 
							"				border: 1px dashed gray;\r\n" + 
							"				visibility: hidden;\r\n" + 
							"				color: black;\r\n" + 
							"				text-decoration: none;\r\n" + 
							"			}\r\n" + 
							"\r\n" + 
							"			.ur_snapThumbnail span img{ /*CSS for enlarged image*/\r\n" + 
							"				border-width: 0;\r\n" + 
							"				padding: 2px;\r\n" + 
							"				width:650px;\r\n" + 
							"				height :430px;\r\n" + 
							"			}\r\n" + 
							"\r\n" + 
							"			.ur_snapThumbnail:hover span{ /*CSS for enlarged image on hover*/\r\n" + 
							"				visibility: visible;\r\n" + 
							"				top: 0;\r\n" + 
							"				float: left;\r\n" + 
							"				left: 45px; /*position where enlarged image should offset horizontally */\r\n" + 
							"			}"+"\n");
					
					bf.write("			#myModal div div div img {\r\n" + 
							"				margin-left: auto;\r\n" + 
							"				margin-right: auto;\r\n" + 
							"				display: block;\r\n" + 
							"				height : 580px;\r\n" + 
							"				width : 860px;\r\n" + 
							"			}"+"\n");
					bf.write("			#myModal{\r\n" + 
							"				width : 995px;\r\n" + 
							"			}\r\n" + 
							"\r\n" + 
							"			#abc{\r\n" + 
							"				height : 600px;	\r\n" + 
							"			}"+"\n");
					GraphGenerator.graphCSS();
				bf.write("\t"+"\t"+"</style>"+"\n");
			
			GraphGenerator.graphScripting(75, 65, 9);
			bf.write("\t"+"</head>"+"\n");
			//---------------------Closing html header-------------------------
			
			//---------------------Body starts : Start creating table-----
			bf.write("\t"+"<body class='onPage'>"+"\n");
				bf.write("\t"+"\t"+"<div id='tableId' class='ur_tableCreator'>"+"\n");
					// -------Writing Report Heading---------------
					bf.write("\t"+"\t"+"\t"+"<div class='ur_resultTitle'>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"<h1><u>Your Results | Stats </u></h1>"+"\n");
					bf.write("\t"+"\t"+"\t"+"</div>"+"\n");
					//--------Writing pie-chart and bar-graph-----
					GraphGenerator.graphElement();
					//--------Writing Report header---------------
					bf.write("\t"+"\t"+"\t"+"<div id='row0' class='ur_tableHeading'>"+"\n");
						//------------------TC_id---------------------
						bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4>&nbsp; TC_id &nbsp;</h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
						//---------------------Test Case Name------------
						bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4>&nbsp; Test Case Name &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
						//--------------------Actual Output---------------
						bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4> &nbsp; Actual Output &nbsp;</h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
						//----------------Expected Output----------------
						bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4> &nbsp; Expected Output &nbsp; </h4>"+"\n");
					    bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
						//-------------------Message-------------------
					    bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4>&nbsp;&nbsp; Message &nbsp;&nbsp; </h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");					
						//-------------------Debug-info-------------------
					    bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4>&nbsp;&nbsp; Debug-info &nbsp;&nbsp; </h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
						//-------------------Snap-------------------
					    bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4> Snap &nbsp;</h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
						//-------------------Status-------------------
					    bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4> Status </h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");						
						//-------------------Time-------------------
					    bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");
							bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<h4> &nbsp;&nbsp;Time &nbsp;&nbsp;</h4>"+"\n");
						bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
					bf.write("\t"+"\t"+"\t"+"</div>"+"\n");  
					//------table header: ---class=Heading closing------													
	}
	
	/**
	 * @param rowNumber : row number
	 * @param tc_id : test case id if provided
	 * @param tc_name : TC name from method name
	 * @param actual : Actual result 
	 * @param expt : Expected result from user
	 * @param message : message for the particular TC
	 * @param debug : debug info for failed TC 
	 * @param snap : snap as link if user wants 
	 * @param status : status of TC Pass/Fail
	 * @param time : time taken to execute the TC
	 * @throws IOException : In case of File writing
	 */
	public static void ur_updatingTableRow(int rowNumber, String tc_id, String tc_name, String actual, String expt, String message, String debug, String snap, String status, String time) throws IOException{
			String row_id = "row"+rowNumber;	
				System.out.println(time);
				bf.write("\t"+"\t"+"\t"+"<div id='"+row_id+"' class='ur_tableRow'>"+"\n");
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+tc_id+"</div>"+"\n");
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+tc_name+"</div>"+"\n");
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+actual+"</div>"+"\n");
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+expt+"</div>"+"\n");
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+message+"</div>"+"\n"); 
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+debug+"</div>"+"\n");  // Create Function
					ur_snapOption(snap);
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell' id='"+status+"'>"+status+"</div>"+"\n"); 
					bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+ur_timeFormatWriter(time)+"</div>"+"\n"); 
				bf.write("\t"+"\t"+"\t"+"</div>"+"\n");
	}
	
	public static void ur_updatingFooter() throws IOException{
					bf.write("\t"+"\t"+"</div>"+"\n");
					bf.write("\t"+"</body>"+"\n");
				bf.write("</hmtl>");
				bf.close();
	}
	
	/**
	 * 
	 * @param time : time which have to convert into proper format
	 * @return
	 */
	public static String ur_timeFormatWriter(String time){
		System.out.println(time);
		String finalTym=null;
		String[] timeValue = time.split(":");
		System.out.println(timeValue[0]+" HH "+timeValue[1] +" mm "+ timeValue[2]+" ss");
		if(timeValue[0].equals("00") && timeValue[1].equals("00") )
		{
			 String secTym = timeValue[2].substring(0, 2);
			 String msecTym = timeValue[2].substring(3, 6);
			 
			if(secTym.equals("00"))
			{
				finalTym = "0."+msecTym+" sec";
			}
			else
			{
				finalTym = timeValue[2]+" sec";
			}
		}
		else if(timeValue[0].equals("00") && !timeValue[1].equals("00"))
		{
			 String secTym = timeValue[2].substring(0, 2);
			 String msecTym = timeValue[2].substring(3, 6);
			if(Integer.parseInt(msecTym) >= 600){
				finalTym = timeValue[1]+" min "+(Integer.parseInt(secTym)+1)+" sec";
			}
			else
			{
				finalTym = timeValue[1]+" min "+ secTym+" sec"; 
			}
		}
		else
		{
			finalTym = timeValue[0]+" hr "+timeValue[1]+" min";
		}
		
		return finalTym;
	}
	
	/**
	 * 
	 * @param snap : path of image (if available)
	 * @throws IOException
	 */
	public static void ur_snapOption(String snap) throws IOException{
		bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableCell'>"+"\n");  
		bf.write("             <!-- Trigger the modal with a button -->"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<a href='#' data-toggle='modal' data-target='#myModal' class='ur_snapThumbnail'>\r\n" + 
				"						Snap\r\n" + 
				"							<span>\r\n" + 
				"								<img src ='"+snap+"' alt='na ho pai' align='center' id = 'id1'/>\r\n" + 
				"							</span>\r\n" + 
				"\t"+"\t"+"\t"+"\t"+"\t"+"</a>"+"\n");
		bf.write("                  <!-- Modal -->"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"<div class='modal fade' id='myModal' role='dialog' style='position:absolute; width:100%; height:100%'>"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"<div class='modal-dialog modal-lg'>"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"<div class='modal-body' id = 'abc'>"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"<div class='modal-content'>\r\n" + 
				"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"<img src ='"+snap+"' alt='na ho pai' align='center' /> \r\n" + 
				"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"</div>\r\n" + 
				"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"</div>\r\n" + 
				"\t"+"\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
		bf.write("\t"+"\t"+"\t"+"\t"+"</div>"+"\n");
		
	}
	
}
