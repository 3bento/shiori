package dev.ebento.shiori.bookmark;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_BOOKMARK")
public class Bookmark {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String url;

}
