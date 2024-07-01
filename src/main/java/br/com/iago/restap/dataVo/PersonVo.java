package br.com.iago.restap.dataVo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


@JsonPropertyOrder({"id", "name", "lastname", "address", "gender"})
public class PersonVo extends RepresentationModel<PersonVo> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	

	private String name;

	private String lastname;
	private String address;
	private String gender;
	
	public PersonVo() {

	}
	
	
	public Long getId() {
		return key;
	}


	public void setId(Long id) {
		this.key = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, gender, key, lastname, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVo other = (PersonVo) obj;
		return Objects.equals(address, other.address) && Objects.equals(gender, other.gender)
				&& Objects.equals(key, other.key) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(name, other.name);
	}

	
	
	

}
