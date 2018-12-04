package ur.team.Report;

import java.io.IOException;

public class GraphGenerator extends ReportWriter{
	
	public static void graphCSS() throws IOException{
		bf.write("			.chartDisplay{\r\n" + 
				"				display: table-caption;\r\n" + 
				"				height: 350px;\r\n" + 
				"				clear:both;\r\n" + 
				"				width: 99.5%;\r\n" + 
				"				border: 3px solid #233460;\r\n" + 
				"			}"+"\n");
		
		bf.write("			#pieChart{\r\n" + 
				"				width: 52%;\r\n" + 
				"				height: 350px;\r\n" + 
				"				margin-left:0px;\r\n" + 
				"				float : left;\r\n" + 
				"			}"+"\n");
		
		bf.write("			#barChart{\r\n" + 
				"				float : right;\r\n" + 
				"				height: 350px;\r\n" + 
				"				width: 47.5%;\r\n" + 
				"				margin-right: 0px;\r\n" + 
				"			}"+"\n");
		
		bf.write("			.ur_tableColumn {\r\n" + 
				"				display: inline-block;\r\n" + 
				"			}"+"\n");
	}
	public static float getPercentageValue(float totalAmount, float value){	
		return (value/totalAmount)*100;
	}
	
	public static void graphScripting(int pass_tc, int fail_tc, int skip_tc) throws IOException{
		int total_tc = (pass_tc + fail_tc + skip_tc);
		bf.write("		<script>"+"\n");
		bf.write("			window.onload = function() {\r\n" + 
				"				CanvasJS.addColorSet('greenShades',\r\n" + 
				"					[\r\n" + 
				"						'#07BC30',\r\n" + 
				"						'#D10417',\r\n" + 
				"						'#939594',\r\n" + 
				"					]);"+"\n");
		bf.write("				var pieChartLoading = new CanvasJS.Chart('pieChart', {\r\n" + 
				"					animationEnabled: true,\r\n" + 
				"					colorSet: 'greenShades',\r\n" + 
				"					legend: {\r\n" + 
				"						verticalAlign: 'top',\r\n" + 
				"						itemMaxWidth: 250,\r\n" + 
				"						itemWrap: false \r\n" + 
				"					},\r\n" + 
				"					backgroundColor: '#D6D3DE',\r\n" + 
				"					title: {\r\n" + 
				"						text: 'Pie-Chart anyalsis of execution stats'\r\n" + 
				"					},\r\n" + 
				"					data: [{\r\n" + 
				"						type: 'pie',\r\n" + 
				"						startAngle: 180,\r\n" + 
				"						showInLegend: true,\r\n" + 
				"						legendText: '{label}',\r\n" + 
				"						yValueFormatString: '##0.00\\'%\\'',\r\n" + 
				"						indexLabel: '{label} : {y}',\r\n" + 
				"						dataPoints: [\r\n" + 
				"							{y: "+getPercentageValue(total_tc,pass_tc)+", label: 'Pass("+pass_tc+")'},\r\n" + 
				"							{y: "+getPercentageValue(total_tc, fail_tc)+", label: 'Fail("+fail_tc+")'},\r\n" + 
				"							{y: "+getPercentageValue(total_tc, skip_tc)+", label: 'Skip("+skip_tc+")'},\r\n" + 
				"						]\r\n" + 
				"					}]\r\n" + 
				"			});\r\n" + 
				""+"\n");
		bf.write("				var barChartLoading = new CanvasJS.Chart('barChart', {\r\n" + 
				"					colorSet: 'greenShades',\r\n" + 
				"					backgroundColor: '#D6D3DE',\r\n" + 
				"					title:{\r\n" + 
				"						text: 'Total TC Vs Execution Stats | Simple bar analysis'\r\n" + 
				"					},\r\n" + 
				"					axisX:{\r\n" + 
				"						title: 'Execution status-->',\r\n" + 
				"						titleFontSize: 14,\r\n" + 
				"						titleFontColor: '#0404B4',\r\n" + 
				"						titleFontWeight: 'bold'\r\n" + 
				"					},\r\n" + 
				"					axisY:{\r\n" + 
				"						title: 'Number of TC-->',\r\n" + 
				"						titleFontSize: 14,\r\n" + 
				"						titleFontColor: '#0404B4',\r\n" + 
				"						titleFontWeight: 'bold'\r\n" + 
				"					},\r\n" + 
				"					data: [\r\n" + 
				"						{        \r\n" + 
				"							type: 'column',\r\n" + 
				"							indexLabel: '{label} : {y}',\r\n" + 
				"							indexLabelPlacement: 'outside',  \r\n" + 
				"							indexLabelOrientation: 'horizontal',\r\n" + 
				"							dataPoints: [\r\n" + 
				"							{label : 'Pass',  y: "+pass_tc+" },\r\n" + 
				"							{label : 'Fail' , y: "+fail_tc+"},\r\n" + 
				"							{label : 'Skip',  y: "+skip_tc+" },\r\n" + 
				"							]\r\n" + 
				"						}\r\n" + 
				"					]\r\n" + 
				"				});"+"\n");
		
		bf.write("				pieChartLoading.render();\r\n" + 
				"				barChartLoading.render();\r\n" + 
				"			}\r\n");
		bf.write("		</script>"+"\n");
	}
	
	public static void graphElement() throws IOException{
		//--------Writing pie-chart and bar-graph-----
		bf.write("\t"+"\t"+"\t"+"<div class='chartDisplay'>"+"\n");
			bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableColumn' id='pieChart' ></div>"+"\n");
			bf.write("\t"+"\t"+"\t"+"\t"+"<div class='ur_tableColumn' id='barChart' ></div>"+"\n");
			bf.write("\t"+"\t"+"\t"+"\t"+"<script src='https://canvasjs.com/assets/script/canvasjs.min.js'></script>"+"\n");
		bf.write("\t"+"\t"+"\t"+"</div>");
	}
}
