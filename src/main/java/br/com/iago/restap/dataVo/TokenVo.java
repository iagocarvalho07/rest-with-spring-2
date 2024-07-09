package br.com.iago.restap.dataVo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokenVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String username;
	private Boolean authenticated;
	private Date created;
	private Date accessToken;
	private String refreshToken;
	
	public TokenVo() {}
	public TokenVo(String username, Boolean authenticated, Date created, Date accessToken, String refreshToken) {
		this.username = username;
		this.authenticated = authenticated;
		this.created = created;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(Date accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accessToken, authenticated, created, refreshToken, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVo other = (TokenVo) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(authenticated, other.authenticated)
				&& Objects.equals(created, other.created) && Objects.equals(refreshToken, other.refreshToken)
				&& Objects.equals(username, other.username);
	}
	
	
	
	

}
