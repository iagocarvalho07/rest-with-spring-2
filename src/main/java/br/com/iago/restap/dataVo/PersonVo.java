package br.com.iago.restap.dataVo;

import java.io.Serializable;
import java.util.Objects;



public class PersonVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long id;
	

	private String name;

	private String lastname;
	private String address;
	private String gender;
	
	public PersonVo() {

	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
		return Objects.hash(address, gender, id, lastname, name);
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
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(name, other.name);
	}

	
	
	

}
