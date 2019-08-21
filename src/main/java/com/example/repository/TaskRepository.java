package com.example.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.domain.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {
	
	@Modifying
	@Query("update Task t set t.taskArchived = true where t.taskId = ?1")
	void archiveTask(Integer taskId);
	
	@Modifying
	@Query("update Task t set t.taskStatus = ?2 where t.taskId = ?1")
	void changeStatusTask(Integer taskId, String status);
	
}
