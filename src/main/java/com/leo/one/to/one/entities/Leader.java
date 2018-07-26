package com.leo.one.to.one.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author LIULE9
 */
@Entity
public class Leader {

    private Integer id;
    private String name;
    private ZonedDateTime createDate = ZonedDateTime.now();
    private Klass klass;

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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "leader", targetEntity = Klass.class)
    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
