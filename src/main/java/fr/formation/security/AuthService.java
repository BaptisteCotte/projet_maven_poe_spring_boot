package fr.formation.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import fr.formation.dao.IUtilisateurDao;
import fr.formation.model.Utilisateur;

@Service
public class AuthService implements UserDetailsService {
	@Autowired
	private IUtilisateurDao daoUtilisateur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> optUser = this.daoUtilisateur.findByUsername(username);
		
		if (optUser.isPresent()) {
			return new UtilisateurPrincipal(optUser.get());
		}
		
		else  {
			Utilisateur utilisateur = this
					.daoUtilisateur
					.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas."));
			
			return new UtilisateurPrincipal(utilisateur);
		}
	
	}
}