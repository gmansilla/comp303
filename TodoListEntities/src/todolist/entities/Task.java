package todolist.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name = "tasks")
@NamedQueries({
		@NamedQuery(name = "Task.findTasksByUserId", query = "SELECT t FROM Task t where t.user.id = :userId"),
		@NamedQuery(name = "Task.findTaskById", query = "SELECT t FROM Task t where t.id = :taskId"),
		@NamedQuery(name = "Task.getPendingTasksByUserId", query = "SELECT t FROM Task t where t.status <> 'f' and t.user.id = :userId order by t.dueDate DESC"),
		@NamedQuery(name = "Task.getFinishedTasksByUserId", query = "SELECT t FROM Task t where t.status = 'f' and t.user.id = :userId"), 
		})
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "due_date")
	private Date dueDate;

	private String name;

	private String priority;

	private String status;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Task() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {
		return "Task Name: " + this.name + ", Desc: " + this.description
				+ ", Priority: " + this.priority + ", Status: " + this.status
				+ ", Due date: " + this.dueDate.toString() + ", Created: "
				+ this.created.toString();
	}

}