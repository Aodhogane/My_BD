package Table;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Класс")
public class Clas {
    private int id_clas;
    private String view_ani;
    private Set<Animals> animals;
    public Clas(String view_ani) {
        setView_ani(view_ani);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_clas() {
        return id_clas;
    }

    public void setId_clas(int id_clas) {
        this.id_clas = id_clas;
    }

    @Column(name = "Вид животного")
    public String getView_ani() {
        return view_ani;
    }

    public void setView_ani(String view_ani) {
        this.view_ani = view_ani;
    }

    @OneToMany(mappedBy = "clas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Animals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }

}