package com.leo.one.to.one.repositories;

import com.leo.one.to.one.entities.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LIULE9
 */

@Repository
public interface KlassRepository extends JpaRepository<Klass,Integer> {
}
