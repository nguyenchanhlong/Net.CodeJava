package net.codejava.Job;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
    private Integer jid;
    private String name;
    private float salary;
    private Time start;
    private Time end;
    private float late_coefficient;
    private float overtime_coefficient;

    public Job() {

    }

    public Job(Integer jid, String name, float salary, Time start, Time end, float late_coefficient,
            float overtime_coefficient) {
        this.jid = jid;
        this.name = name;
        this.salary = salary;
        this.start = start;
        this.end = end;
        this.late_coefficient = late_coefficient;
        this.overtime_coefficient = overtime_coefficient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public float getLate_coefficient() {
        return late_coefficient;
    }

    public void setLate_coefficient(float late_coefficient) {
        this.late_coefficient = late_coefficient;
    }

    public float getOvertime_coefficient() {
        return overtime_coefficient;
    }

    public void setOvertime_coefficient(float overtime_coefficient) {
        this.overtime_coefficient = overtime_coefficient;
    }
}
