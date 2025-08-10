package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "Users")
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
}
