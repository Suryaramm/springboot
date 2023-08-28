package com.springboot.springbootannotations.Respository;

import com.springboot.springbootannotations.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
