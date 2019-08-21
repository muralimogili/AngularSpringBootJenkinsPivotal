package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_LIST", schema="TASKMANAGER")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer taskId;
	private String taskName;
	private String taskDescription;
	private String taskPriority;
	private String taskStatus;
	private boolean taskArchived;
	
	public Task() {}

	public Task(String taskName, String taskDescription, String taskPriority, String taskStatus,
			boolean taskArchived) {
		super();
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
		this.taskArchived = taskArchived;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TASK_ID")
	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "TASK_NAME")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "TASK_DESCRIPTION")
	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Column(name = "TASK_PRIORITY") 
	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	@Column(name = "TASK_STATUS")
	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public boolean isTaskArchived() {
		return taskArchived;
	}

	public void setTaskArchived(boolean taskArchived) {
		this.taskArchived = taskArchived;
	}
}
