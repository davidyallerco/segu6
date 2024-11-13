package net.pe.yallerco.segu6.persistence.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import net.pe.yallerco.segu6.persistence.util.Role;

@Entity
@Table(name = "\"user\"")//user es una palabra reservada en muchos gestores de DB, por ello
					//..no se llamara: user sino lo pondremos "user" incluida las comillas
					//..por lo tanto la tabla se llama: "user" y no user
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String nombre;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {//devuelve los permisos concedidos sobre el rol que tenga
		if(role == null) return null;
		if(role.getPermissions() == null) return null;
		return role.getPermissions().stream()
			//una forma
//			.map(each -> {
//				String permission = each.name();
//				return new SimpleGrantedAuthority(permission);
//			})
			//otra forma
			.map(each -> each.name())
			.map(each -> new SimpleGrantedAuthority(each))
			
			
			.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
