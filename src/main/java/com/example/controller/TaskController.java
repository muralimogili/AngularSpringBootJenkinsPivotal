package com.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Task;
import com.example.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Task> getAllTasks() {
		return this.taskService.findAll();
	}

	@RequestMapping(value = "/tasks/archive/{taskIds}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> archiveAllTasks(@PathVariable int[] taskIds) {

		List<Integer> ids = Arrays.stream(taskIds).boxed().collect(Collectors.toList());

		ids.forEach(i -> this.taskService.archiveTask(i));

		return this.taskService.findAll();
	}

	@RequestMapping(value = "/tasks/{taskId}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> changeTaskStatus(@PathVariable int taskId, @PathVariable String taskStatus) {
		this.taskService.changeStatusTask(taskId, taskStatus);
		return this.taskService.findAll();
	}

	@RequestMapping(value = "/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> addTask(@PathVariable("taskName") String taskName, @PathVariable("taskDesc") String taskDesc,
			@PathVariable("taskPriority") String taskPriority, @PathVariable("taskStatus") String taskStatus) {
		Task task = new Task();
		task.setTaskName(taskName);
		task.setTaskDescription(taskDesc);
		task.setTaskPriority(taskPriority);
		task.setTaskStatus(taskStatus);

		this.taskService.add(task);

		return this.taskService.findAll();
	}

}
