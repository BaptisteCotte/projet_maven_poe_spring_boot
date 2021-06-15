package fr.formation.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Le personnage n'est pas valide.")
public class PersonnageNotValidException extends RuntimeException{

}
