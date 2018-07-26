package com.leo.one.to.one.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.ZonedDateTime;

/**
 * @author LIULE9
 */
@Entity
public class Klass {

    private Integer id;
    private String name;
    private ZonedDateTime createDate = ZonedDateTime.now();
    private Leader leader;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @CreatedDate
    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klass_id")
    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
