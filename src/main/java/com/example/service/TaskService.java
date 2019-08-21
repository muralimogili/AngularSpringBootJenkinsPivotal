package com.example.service;

import java.util.List;

import com.example.domain.Task;

public interface TaskService {
	void add(Task task);
	void update(Task task);
	List<Task> findAll();
	Task findById(Integer taskId);
	void archiveTask(Integer taskId);
	void changeStatusTask(Integer taskId, String status);
}
