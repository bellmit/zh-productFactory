package zh.productfactory.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobParameters().getString("jobName");
        System.out.println("=== START BATCH JOB ===");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        long instanceId = jobExecution.getJobInstance().getInstanceId();
        System.out.println("=== BATCH JOB COMPLETED SUCCESSFULLY 2 ===");
    }
}
