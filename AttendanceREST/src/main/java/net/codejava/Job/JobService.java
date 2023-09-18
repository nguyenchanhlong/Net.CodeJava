package net.codejava.Job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public List<Job> listAll() {
        return repo.findAll();
    }

    public void save(Job job) {
        repo.save(job);
    }

    public Job get(Integer jid) {
        return repo.findById(jid).get();
    }

    public void delete(Integer jid) {
        repo.deleteById(jid);
    }
}
