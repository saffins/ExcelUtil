package ExcelReaderUtility;

import java.io.IOException;
import java.time.LocalDateTime;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob   implements Job {

	
	 public void execute(JobExecutionContext context)   throws JobExecutionException {
	        LocalDateTime localTime = LocalDateTime.now();
	        System.out.println("Run QuartzJob at " + localTime.toString());
	 
	        ExcelReaderTask mytask = new ExcelReaderTask();
	        try {
				mytask.Task();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 
 
	 
}
