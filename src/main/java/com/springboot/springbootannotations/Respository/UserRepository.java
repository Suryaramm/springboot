package com.springboot.springbootannotations.Respository;

import com.springboot.springbootannotations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
