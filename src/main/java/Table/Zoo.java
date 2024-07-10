package Table;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Зоопарк")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Zoo;

    @Column(name = "Количество животных")
    private int animals;

    @Column(name = "Количество работников")
    private int rab;


    @OneToMany(mappedBy = "zoo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Workers> workers;


    public Zoo(int animals, int rab){
        this.animals = animals;
        this.rab = rab;
    }

    public int getId() {
        return id_Zoo;
    }

    public void setId(int id_Zoo) {
        this.id_Zoo = id_Zoo;
    }

    public int getAnimals() {
        return animals;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }

    public int getRab() {
        return rab;
    }

    public void setRab(int rab) {
        this.rab = rab;
    }

    public Set<Workers> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }
}