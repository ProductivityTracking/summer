package com.nkxgen.spring.orm.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskInput {
	private int taskId;
	private String taskName;
	private String taskCreationDateTime;
	private String taskType;
	private Integer referencedTaskId;
	private String taskCategory;
	private String taskDescription;
	private Integer taskCreatorId;
	private BigDecimal numberOfHoursRequired;
	private String taskExpectedDateTime;
	private String taskCompletedDateTime;
	private Integer taskSupervisorId;
	private String taskRemarks;
	private String taskStatus;
	private int projectId;
	private short moduleId;
	private int assignedUserId;

	@Override
	public String toString() {
		return "TaskInput [taskName=" + taskName + ", taskCreationDateTime=" + taskCreationDateTime + ", taskType="
				+ taskType + ", referencedTaskId=" + referencedTaskId + ", taskCategory=" + taskCategory
				+ ", taskDescription=" + taskDescription + ", taskCreatorId=" + taskCreatorId
				+ ", numberOfHoursRequired=" + numberOfHoursRequired + ", taskExpectedDateTime=" + taskExpectedDateTime
				+ ", taskCompletedDateTime=" + taskCompletedDateTime + ", taskSupervisorId=" + taskSupervisorId
				+ ", taskRemarks=" + taskRemarks + ", taskStatus=" + taskStatus + ", projectId=" + projectId
				+ ", moduleId=" + moduleId + ", assignedUserId=" + assignedUserId + ", taskId=" + taskId + "]";
	}

	// Constructors, getters, and setters

	public TaskInput() {
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCreationDateTime() {
		return taskCreationDateTime;
	}

	public void setTaskCreationDateTime(String taskCreationDateTime) {
		this.taskCreationDateTime = taskCreationDateTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Integer getReferencedTaskId() {
		return referencedTaskId;
	}

	public void setReferencedTaskId(Integer referencedTaskId) {
		this.referencedTaskId = referencedTaskId;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Integer getTaskCreatorId() {
		return taskCreatorId;
	}

	public void setTaskCreatorId(Integer taskCreatorId) {
		this.taskCreatorId = taskCreatorId;
	}

	public BigDecimal getNumberOfHoursRequired() {
		return numberOfHoursRequired;
	}

	public void setNumberOfHoursRequired(BigDecimal numberOfHoursRequired) {
		this.numberOfHoursRequired = numberOfHoursRequired;
	}

	public String getTaskExpectedDateTime() {
		return taskExpectedDateTime;
	}

	public void setTaskExpectedDateTime(String taskExpectedDateTime) {
		this.taskExpectedDateTime = taskExpectedDateTime;
	}

	public String getTaskCompletedDateTime() {
		return taskCompletedDateTime;
	}

	public void setTaskCompletedDateTime(String taskCompletedDateTime) {
		this.taskCompletedDateTime = taskCompletedDateTime;
	}

	public Integer getTaskSupervisorId() {
		return taskSupervisorId;
	}

	public void setTaskSupervisorId(Integer taskSupervisorId) {
		this.taskSupervisorId = taskSupervisorId;
	}

	public String getTaskRemarks() {
		return taskRemarks;
	}

	public void setTaskRemarks(String taskRemarks) {
		this.taskRemarks = taskRemarks;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public short getModuleId() {
		return moduleId;
	}

	public void setModuleId(short moduleId) {
		this.moduleId = moduleId;
	}

	public Task toEntity() {
		Task task = new Task();
		task.setTaskId(this.taskId);

		User assignedUser = new User();
		assignedUser.setUserId(this.assignedUserId);
		task.setTaskSupervisor(assignedUser);

		task.setTaskName(this.taskName);
		task.setTaskCreationDateTime(parseDate(this.taskCreationDateTime));
		task.setTaskType(this.taskType);

		Task referencedTask = new Task();
		referencedTask.setTaskId(this.referencedTaskId);
		task.setReferencedTask(referencedTask);

		task.setTaskCategory(this.taskCategory);
		task.setTaskDescription(this.taskDescription);

		User taskCreator = new User();
		taskCreator.setUserId(this.taskCreatorId);
		task.setTaskCreator(taskCreator);

		task.setNumberOfHoursRequired(this.numberOfHoursRequired);
		task.setTaskExpectedDateTime(parseDate(this.taskExpectedDateTime));
		task.setTaskCompletedDateTime(parseDate(this.taskCompletedDateTime));

		User taskSupervisor = new User();
		taskSupervisor.setUserId(this.taskSupervisorId);
		task.setTaskSupervisor(taskSupervisor);

		task.setTaskRemarks(this.taskRemarks);
		task.setTaskStatus(this.taskStatus);

		Project project = new Project();
		project.setProjectId(this.projectId);
		task.setProject(project);

		ProjectModule module = new ProjectModule();
		module.setModuleId(this.moduleId);
		task.setModule(module);

		return task;
	}

	private Date parseDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parsedDate = dateFormat.parse(dateString);
			return new Date(parsedDate.getTime());
		} catch (ParseException e) {
			// Handle the exception or log an error
			e.printStackTrace();
			return null;
		}
	}
	// Rest of the code...

}
