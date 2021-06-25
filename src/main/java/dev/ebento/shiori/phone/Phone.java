package dev.ebento.shiori.phone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_PHONE")
public class Phone {

	@Id
	@GeneratedValue
	private Integer id;
	private String phone;
	
}
