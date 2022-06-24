package br.com.araujoit.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author araujo
 *
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {
	
	private static final long serialVersionUID = 5473112617836371920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String subject;
	
	@Column(nullable = false, length = 1000)
	private String content;
	
	@Column(nullable = false)
	private Timestamp updatedAt;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * @param updatedAt
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, subject, updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(subject, other.subject) && Objects.equals(updatedAt, other.updatedAt);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", subject=" + subject + ", content=" + content + ", updatedAt=" + updatedAt + "]";
	}
}
