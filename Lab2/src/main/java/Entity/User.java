package Entity;

import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Users")
public class User {
	@Id
	private String id;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Admin")
	private Boolean admin = false;
	
	
}
