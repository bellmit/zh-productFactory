package zh.productfactory.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

// jobExecution.getStatus(): STARTING, STARTED, STOPPING, STOPPED, FAILED, COMPLETED, ABANDONED
public class JobCompletionListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        //System.out.println(jobExecution.getStatus()); //STARTED
        System.out.println("=== START BATCH JOB ===");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        //System.out.println(jobExecution.getStatus()); //COMPLETED
        System.out.println("=== BATCH JOB COMPLETED SUCCESSFULLY ===");
    }
}