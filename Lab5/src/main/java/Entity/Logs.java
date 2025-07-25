package Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Url")
    private String url;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Time")
    private Date time;

    @Column(name = "UserId") // Tên đúng với cột trong DB
    private String userId;

    // Getter/Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Date getTime() { return time; }
    public void setTime(Date time) { this.time = time; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
