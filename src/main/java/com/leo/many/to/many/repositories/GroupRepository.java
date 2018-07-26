package com.leo.many.to.many.repositories;

import com.leo.many.to.many.entites.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LIULE9
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
