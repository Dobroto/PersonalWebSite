package edu.tu.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="work_experience")
public class Experience {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="work_position")
	private String workPosition;
	
	@Column(name="company")
	private String company;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;

	public Experience() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkPosition() {
		return workPosition;
	}

	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStartDate() {
		return this.startDate;
		//return DateUtils.formatDate(this.startDate);
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
		//this.startDate = DateUtils.parseDate(startDate);
	}

	public String getEndDate() {
		return this.endDate;
		//return DateUtils.formatDate(this.endDate);
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
		//this.endDate = DateUtils.parseDate(endDate);
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", workPosition=" + workPosition + ", company=" + company + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}














