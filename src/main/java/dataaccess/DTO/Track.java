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

    @ManyToMany
    @JoinTable( name = "T_pitch_track_Association",
            joinColumns = @JoinColumn( name = "idTrack" ),
            inverseJoinColumns = @JoinColumn( name = "idPitch" ) )
    private List<Pitch> roles = new ArrayList<>();

    public Track() {
    }

    public Track(String name, List<Pitch> roles) {
        this.name = name;
        this.roles = roles;
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

    public List<Pitch> getRoles() {
        return roles;
    }

    public void setRoles(List<Pitch> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Track{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
