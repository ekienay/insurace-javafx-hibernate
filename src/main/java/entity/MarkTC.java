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
@Table(name = "mark_tc")
public class MarkTC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TC_mark")
    private String TCMark;

    @OneToMany(mappedBy = "markTC")
    Set<ModelTC> modelTC;

    @Override
    public String toString() {
        return TCMark;
    }
}
