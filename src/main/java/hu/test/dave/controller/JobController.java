package hu.test.dave.controller;

import hu.test.dave.model.Job;
import hu.test.dave.repository.JobRepository;
import hu.test.dave.thread.JobThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String startJob(@RequestParam("name") String name){

        Job job = new Job();
        job.setJobName(name);
        job.setDone(false);

        Job storedJob = jobRepository.save(job);

        new Thread(new JobThread(jobRepository, storedJob.getId())).start();

        return "Job #" + storedJob.getId() + " started!";

    }

    @RequestMapping(path = "/{jobId}", method = RequestMethod.GET)
    public String getJob(@PathVariable("jobId") Long jobId){

        Job job = jobRepository.findOne(jobId);

        if(job.isDone()){

            return job.toString();

        }else{

            return "In progress...";

        }

    }

}
