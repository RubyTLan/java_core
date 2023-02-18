package com.tian.safe_travels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //means this class will exist in the database
@Table(name="expenses")//the MySql table name
public class Expense {
	//attributes
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//automatically create id when new item


	@NotNull
    @Size(min = 5, max = 200, message="Expense name must be at least 5 characters")
    private String expenseName;//camelCase. MySql is snake case
    
    @NotNull
    @Size(min = 5, max = 200)
    private String vendor;
    
    @NotNull
    @Min(0)
    private Double amount;
    
    @NotNull
    @Size(min = 5, max = 1000)
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //constructor
    public Expense() {
    	
    }
    
    public Expense(String expenseName,
    		String vendor, Double amount,
    		String description) {
    
    	this.expenseName = expenseName;
    	this.vendor = vendor;
    	this.amount = amount;
    	this.description = description;

    
    }
    //getter setter
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    

    public String getExpenseName() {
    	return expenseName;
    }
    
    public void setExpenseName(String expenseName) {
    	this.expenseName = expenseName;
    }
    
    public String getVendor() {
    	return vendor;
    }
    
    public void setVendor(String vendor) {
    	this.vendor = vendor;
    }
    
    public Double getAmount() {
    	return amount;
    }
    
    public void setAmount(Double amount) {
    	this.amount = amount;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public Date getCreatedAt() {
    	return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
    	this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
    	return updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
    	this.updatedAt = updatedAt;
    }
    
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
	}

}
