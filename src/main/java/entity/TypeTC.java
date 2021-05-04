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
@Table(name = "type_tc")
public class TypeTC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TC_type")
    private String TCType;

    @OneToMany(mappedBy = "typeTC")
    Set<Pts> pts;

    @Override
    public String toString() {
        return TCType;
    }
}
