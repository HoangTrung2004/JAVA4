package Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Share")
public class Share {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")     // Người chia sẻ
    private Users user;

    @ManyToOne
    @JoinColumn(name = "VideoId")    // Video được chia sẻ
    private Video video;

    @Column(name = "Emails")         // Danh sách email chia sẻ (ngăn cách ; )
    private String emails;

    @Temporal(TemporalType.DATE)
    @Column(name = "ShareDate")      // Ngày chia sẻ
    private Date shareDate;
}
