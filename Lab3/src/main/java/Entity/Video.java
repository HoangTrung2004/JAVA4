package Entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Video")
public class Video {
    @Id
    @Column(name = "Id", length = 50)
    private String id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active")
    private Boolean active;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;
}
