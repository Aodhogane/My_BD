package Table;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Зоопарк")
public class Zoo {

    private int animals;
    private int rab;

    public Zoo(int animals, int rab){
        setAnimals(animals);
        setRab(rab);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Zoo;
    public int getId() {
        return id_Zoo;
    }
    public void setId(int id_Zoo) {
        this.id_Zoo = id_Zoo;
    }

    @Column(name = "Количество животных")
    public int getAnimals() {
        return animals;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }

    @Column(name = "Количество работников")
    public int getRab() {
        return rab;
    }

    public void setRab(int rab) {
        this.rab = rab;
    }


    @OneToMany(mappedBy = "zoo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Workers> workers;
    public Set<Workers> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }













}