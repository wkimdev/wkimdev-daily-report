package com.wkimdev.demo.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Journal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private Date created;
	private String summary;
	
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public Journal(String title, String summary, String date) throws ParseException{
		this.title = title;
		this.summary = summary;
		this.created = format.parse(date);
	}
	
	Journal() {}
	
	public String getCreatedAsShort() {
		return format.format(created);
	}
	
	public String toString() {
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",제목: ");
        value.append(title);
        value.append(",요약: ");
        value.append(summary);
        value.append(",작성일자: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
	
}
