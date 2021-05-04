package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "drv_license")
public class DrvLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    @Column(name = "date_expiration")
    private Date dateOfExpiration;

    @Column(name = "dapart_state_inspection")
    private String departStateInspection;

    @Column(name = "license_series")
    private String licenseSeries;

    @Column(name = "license_number")
    private String licenseNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_to_license",
            joinColumns = {
                    @JoinColumn(name = "drv_license_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "category_id")
    })
    Set<Category> categories = new HashSet<>();
    public void addCategory(Category category){
        categories.add(category);
    }

}
