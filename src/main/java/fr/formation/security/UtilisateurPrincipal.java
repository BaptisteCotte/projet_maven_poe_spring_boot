package fr.formation.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import fr.formation.model.Utilisateur;

public class UtilisateurPrincipal implements UserDetails {
	private Utilisateur utilisateur;
	
	public UtilisateurPrincipal(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
			if (this.utilisateur.isAdmin()) {
				System.out.println("Je suis admin");
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			
			else {
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
		
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return this.utilisateur.getPassword();
	}

	@Override
	public String getUsername() {

		return this.utilisateur.getUsername();
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
}