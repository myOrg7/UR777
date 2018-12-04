package ur.team.Report;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class finalReport extends TestListenerAdapter implements ITestNGListener, IInvokedMethodListener {
		
		
		public WebDriver driver =null;
		public static String testCase_id =null;
		public static String expectedOutput = null;
		String tempStatus =null;
		static int counter=1;
		static String NeedScreenshot = null;
		long initialTym;
		long endTym;
		long tymDiff;
		public String[] value = null;
		String getMethodName;
		/*ArrayList<String> tc_name  =  new ArrayList<String>();
		ArrayList<String> storingStatus = new ArrayList<>();
		ArrayList<String> statusTime = new ArrayList<>();*/
		List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
		List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
		List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();
		
		@BeforeMethod
		public void preTest(){
			initialTym = System.currentTimeMillis();
			//System.out.println(initialTym);
		}
		
		@AfterMethod
		public void postTest(ITestResult result){
		
			int status = result.getStatus();
			
			endTym = System.currentTimeMillis();
			//System.out.println(endTym);
    	    switch (status) {
    	        case ITestResult.SUCCESS:
    	        	tempStatus="PASS";
    	            break;
    	            
    	        case ITestResult.FAILURE:
    	        	tempStatus = "FAIL";
    	            break;
    	            
    	        case ITestResult.SKIP:
    	        	tempStatus = "SKIP";
    	            break;
    	            
    	        default:
    	            throw new RuntimeException("Invalid status");
    	    }
    	   
    	   
    	    tymDiff=endTym-initialTym;
    	    String time  = DurationFormatUtils.formatDuration(tymDiff, "HH:mm:ss.SSS").toString();
   	 
    	    ResultUtils r =  new ResultUtils();
    		r.ValueToCell(counter, testCase_id, result.getMethod().getMethodName().toString(), expectedOutput, expectedOutput, ResultUtils.RU_setMessage(result.getMethod().getMethodName()).toString(), "debug", NeedScreenshot, tempStatus.toString(), time);
    	   
    	    
//    	    tc_name.add(result.getMethod().getMethodName());
//    	    System.out.println(result.getMethod().getMethodName());
//    	    storingStatus.add(tempStatus);
//      	    statusTime.add(DurationFormatUtils.formatDuration(tymDiff, "HH:mm:ss.SSS"));
    	    counter+=1;
    	    expectedOutput = null;
		}
		
		@AfterClass
		/*public void uploadingData(){
			ResultUtils.RU_updatingCellValue("","","","","","","","","");
		}
		*/
		
		@AfterSuite
		public void createReport(){
			   
		}
		
		public static void expectedCheckpoint(String tc_id, String expOut, boolean screenshot){
			expectedCheckpoint(expOut);
			
			if(tc_id.equals("") || tc_id.equalsIgnoreCase(null)){
				testCase_id = "TC_"+counter;
			}
			else 
			{
				testCase_id = tc_id;
			}
			
			if(screenshot){
				NeedScreenshot = "YES";
			}
			else {
				NeedScreenshot = "NO";
			}
		}
		
		public static void expectedCheckpoint(String expOut){
			expectedOutput = expOut;
			testCase_id = "TC_"+counter;
			NeedScreenshot = "NO";
		}

		public void afterInvocation(IInvokedMethod invokeMethod, ITestResult result) {
			/*
			StackTraceElement[] shayad_debug = result.getThrowable().getStackTrace();
			System.err.println(shayad_debug);
			System.out.println("####################**********************############################");
			System.out.println(result.getThrowable().getStackTrace().toString());
			System.out.println("####################**********************############################");*/
			if(invokeMethod.getTestMethod().isTest()){
				
				List<Throwable> verificationFailures = new ArrayList<Throwable>();

				if(result.getStatus() == ITestResult.FAILURE){
					if(result.getThrowable() !=null){
						verificationFailures.add(result.getThrowable());
						System.out.println("####################**********************############################");
						System.out.println(result.getThrowable().getStackTrace().toString());
						System.out.println("####################**********************############################");
					}
				}
			}
		}

		
		
		@Override
		public void onTestFailure(ITestResult result) {
			System.err.println(result.getName()+" was a failure.\n Throwable : "+ result.getThrowable());
			failedtests.add(result.getMethod());
	        System.out.println(result.getMethod().getMethodName().toString());
			System.out.println("@@@@ Size() : "+failedtests.size());
		}
		
		@Override
		public void onTestSuccess(ITestResult result) {
		    passedtests.add(result.getMethod());
		    System.out.println("@@@@ Size() : "+passedtests.size());
		}
		
		@Override
	    public void onTestSkipped(ITestResult result) {
	        skippedtests.add(result.getMethod());
	        System.out.println(result.getMethod().getMethodName().toString());
	        System.out.println("@@@@ Size() : "+skippedtests.size());
	    }

		public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
			// TODO Auto-generated method stub
			
		}    
		
}
