package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Users")
public class User {
	@Id
	@Column(name = "Id")
	String id;
	
	@Column(name = "Password")
	String password;
	
	@Column(name = "Fullname")
	String fullname;
	
	@Column(name = "Email")
	String email;
	
	@Column(name = "Admin")
	Boolean admin = false;
	
	
}
