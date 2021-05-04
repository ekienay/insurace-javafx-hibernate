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
@Table(name = "type_engine")
public class TypeEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "engine_type")
    private String engineType;

    @OneToMany(mappedBy = "typeEngine")
    Set<Pts> pts;

    @Override
    public String toString() {
        return engineType;
    }
}
