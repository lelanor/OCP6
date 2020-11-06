package dataaccess.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable( name = "T_pitch_track_Association",
            joinColumns = @JoinColumn( name = "idTrack" ),
            inverseJoinColumns = @JoinColumn( name = "idPitch" ) )
    private List<Pitch> pitches = new ArrayList<>();

    public Track() {
    }

    public Track(String name, List<Pitch> pitches) {
        this.name = name;
        this.pitches = pitches;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pitch> getPitches() {
        return pitches;
    }

    public void setPitches(List<Pitch> pitches) {
        this.pitches = pitches;
    }

    @Override
    public String toString() {
        return "Track{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", roles=" + pitches +
                '}';
    }
}
