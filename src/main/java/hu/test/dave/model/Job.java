package hu.test.dave.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean done;

    private String jobName;

    public Job() {
    }

    public Job(Long id, boolean done, String jobName) {
        this.id = id;
        this.done = done;
        this.jobName = jobName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (done != job.done) return false;
        if (!id.equals(job.id)) return false;
        return jobName.equals(job.jobName);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (done ? 1 : 0);
        result = 31 * result + jobName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", done=" + done +
                ", jobName='" + jobName + '\'' +
                '}';
    }

}
