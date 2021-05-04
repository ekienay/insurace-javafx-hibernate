package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "eco_class")
public class EcoClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "eco_class")
    private String ecoClass;

    @OneToMany(mappedBy = "ecoClass")
    Set<Pts> pts;

    @Override
    public String toString() {
        return ecoClass;
    }
}
