package com.test.dao;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey on 21.04.2017.
 */
@Entity
@Table(name = "workhome")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "work")
    private String work;

    @Column(name = "time")
    private String time;

    @Column(name = "flag")
    private Integer flag;

    public Task(Integer id, String work, String time, Integer flag) {
        this.id = id;
        this.work = work;
        this.time = time;
        this.flag = flag;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
