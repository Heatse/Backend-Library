package com.example.thuvien.Dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrderDto implements Serializable {
	private Long id;
	private String book_img;
    private String booktitle;
    private LocalDate date;
    private LocalTime time;
    private String total;
    private Long bookId;
    private Long userId;
    
    public OrderDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderDto(Long id,String book_img, String booktitle, LocalDate date, LocalTime time, String total, Long bookId,
			Long userId) {
		super();
		this.id = id;
		this.book_img = book_img;
		this.booktitle = booktitle;
		this.date = date;
		this.time = time;
		this.total = total;
		this.bookId = bookId;
		this.userId = userId;
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

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}