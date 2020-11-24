package dataaccess.DTO;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SECTOR")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSector;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "SECTOR_TRACK",
            joinColumns = @JoinColumn(name = "idSector"),
            inverseJoinColumns = @JoinColumn(name = "idTrack"))
    private List<Track> tracks = new ArrayList<>();
}
