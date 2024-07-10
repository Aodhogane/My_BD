package Table;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Посетитель")
public class Visitor {

    private int id_Visitor;
    private String FIO;
    private String Age;
    private Set<Ticket> tickets;

    public Visitor(String FIO, String Age){
        setFIO(FIO);
        setAge(Age);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_Visitor() {
        return id_Visitor;
    }

    public void setId_Visitor(int id_Visitor) {
        this.id_Visitor = id_Visitor;
    }

    @Column(name = "ФИО")
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Column(name = "Возраст")
    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    @OneToMany(mappedBy = "visitor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }









}