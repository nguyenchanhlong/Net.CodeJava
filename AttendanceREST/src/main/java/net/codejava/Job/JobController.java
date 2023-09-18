package net.codejava.Job;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    
    @Autowired
    private JobService service;

    @GetMapping("/jobs")
    public List<Job> list(){
        return service.listAll();
    }
    @GetMapping("/jobs/{jid}")
    public ResponseEntity<Job> get(@PathVariable Integer jid){
        try{
            Job job = service.get(jid);
            return new ResponseEntity<Job>(job,HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/jobs")
    public void add(@RequestBody Job job){
        service.save(job);
    }
    @PutMapping("/jobs/{jid}")
    public ResponseEntity<?> update(@RequestBody Job job, @PathVariable Integer jid){
        try{
            service.save(job);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("jobs/{jid}")
    public void delete(@PathVariable Integer jid){
        service.delete(jid);
    }
}
