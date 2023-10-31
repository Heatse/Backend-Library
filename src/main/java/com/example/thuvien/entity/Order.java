package com.example.thuvien.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="book_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="book_img")
	private String book_img;
	
	@Column(name="booktitle")
	@Lob
	private String book_title;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name ="time")
	private LocalTime time;
	
	@Column(name = "total")
	private String total;
	
	@ManyToOne
	@JoinColumn(name="book_id", nullable = false)
	@JsonIgnore
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	public Order() {
		
	}

	 
	 	public Order(String book_img,String book_title, LocalDate date, LocalTime time, String total) {
		super();
		this.book_img = book_img;
		this.book_title = book_title;
		this.date = date;
		this.time = time;
		this.total = total;
	}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    

		public String getBook_img() {
			return book_img;
		}


		public void setBook_img(String book_img) {
			this.book_img = book_img;
		}


		public String getBook_title() {
			return book_title;
		}


		public void setBook_title(String book_title) {
			this.book_title = book_title;
		}


		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public LocalTime getTime() {
	        return time;
	    }

	    public void setTime(LocalTime time) {
	        this.time = time;
	    }

	    public Book getBook() {
	        return book;
	    }

	    public void setBook(Book book) {
	        this.book = book;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

}