package Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Users")
public class Users {
	@Id
	private String id;
	
	@Column(name = "Password", nullable = false)
	private String password;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "Email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "Admin")
	private Boolean admin = false;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Favorite> favorites;


	
	
	@OneToMany(mappedBy = "user")      // Quan hệ 1-N với bảng Share
    private List<Share> shares;
	
}
