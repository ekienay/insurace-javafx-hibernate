package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_to_license",
            joinColumns = {
            @JoinColumn(name = "category_id")
    },inverseJoinColumns = {
            @JoinColumn(name = "drv_license_id")
    })
    Set<DrvLicense> drvLicenses = new HashSet<>();

    @OneToOne(mappedBy = "category")
    private Pts pts;

    @Override
    public String toString() {
        return  categoryName;
    }
}
