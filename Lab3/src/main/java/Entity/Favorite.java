package Entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Favorite", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"UserId", "VideoId"})  // Cặp UserId + VideoId là duy nhất
})
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // ID tự tăng
    @Column(name = "Id")
    private Long id;

    @ManyToOne                                           // Nhiều Favorite thuộc về 1 Users
    @JoinColumn(name = "UserId")                         // Khóa ngoại đến bảng Users
    private Users user;

    @ManyToOne                                           // Nhiều Favorite thuộc về 1 Video
    @JoinColumn(name = "VideoId")                        // Khóa ngoại đến bảng Video
    private Video video;

    @Temporal(TemporalType.DATE)                         // Kiểu ngày (java.util.Date)
    @Column(name = "LikeDate")
    private Date likeDate;
}
