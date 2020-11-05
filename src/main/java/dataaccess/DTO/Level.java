package dataaccess.DTO;

import javax.persistence.*;

@Entity
@Table(name = "T_level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLevel;
    private String degree;

    public Level() {
    }

    public Level(String degree) {
        this.degree = degree;
    }

    public Level(int idLevel, String degree) {
        this.idLevel = idLevel;
        this.degree = degree;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Level{" +
                "idLevel=" + idLevel +
                ", degree='" + degree + '\'' +
                '}';
    }
}
