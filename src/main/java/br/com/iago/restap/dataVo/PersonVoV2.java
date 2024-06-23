package br.com.iago.restap.dataVo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



public class PersonVoV2  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long id;
	

	private String name;

	private String lastname;
	private String address;
	private String gender;
	private Date date;
	
	public PersonVoV2() {

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
		return Objects.hash(address, date, gender, id, lastname, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVoV2 other = (PersonVoV2) obj;
		return Objects.equals(address, other.address) && Objects.equals(date, other.date)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(name, other.name);
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
	
	

}
