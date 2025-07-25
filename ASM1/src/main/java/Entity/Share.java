package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Share")
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne @JoinColumn(name = "videoId")
    private Video video;

    private String emails;

    private Date shareDate;
}
