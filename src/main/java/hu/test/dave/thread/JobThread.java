package hu.test.dave.thread;

import hu.test.dave.model.Job;
import hu.test.dave.repository.JobRepository;

public class JobThread implements Runnable {

    private JobRepository jobRepository;

    private Long jobId;

    public JobThread(JobRepository jobRepository, Long jobId) {
        this.jobRepository = jobRepository;
        this.jobId = jobId;
    }

    @Override
    public void run() {

        try {

            System.out.println(jobRepository);

            Thread.sleep(10000);

            Job job = jobRepository.findOne(jobId);

            job.setDone(true);

            jobRepository.save(job);

            System.out.println("Job #" + jobId + " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
