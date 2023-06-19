package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.JobDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobService {

    private List<JobDTO> jobs;

    public JobService() {
        this.jobs = new ArrayList<>();
    }

    public void addJob(JobDTO job) {
        jobs.add(job);
    }

    public List<JobDTO> getJobs() {
        return jobs;
    }

    public void changeJob(PlayerDTO player, int jobNumber) {
       List<JobDTO> jobs = getJobs();
       if(jobNumber >= 1 && jobNumber <= jobs.size()) {
           JobDTO newJob = jobs.get(jobNumber - 1);
           player.setJob(newJob.getJobName());
           System.out.println(player.getJob() + "으로 전직하였습니다");
       }

    }

}
