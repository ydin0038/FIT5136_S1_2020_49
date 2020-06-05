package Administrator;

/**
 * Class of the jobs of the mission in the Mission to Mars System
 */

public class Job {
    private String jobName;
    private String jobDescription;

    public Job() {
    }

    public Job(String jobName, String jobDescription) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}

