package com.leo.many.to.many.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LIULE9
 */
@Entity
@Table(name="t_group")
public class Group {


    private Integer groupId;
    private String name;
    private ZonedDateTime createDate = ZonedDateTime.now();
    private List<User> users = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.LAZY, mappedBy = "groups")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
