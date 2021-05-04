package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PTS")
public class Pts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PTS_series")
    private String ptsSeries;

    @Column(name = "PTS_number")
    private String ptsNumber;

    @Column(name = "VIN")
    private String vin;

    @Column(name = "year_manufacture")
    private Date yearOfManufacture;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "color_trailer")
    private String colorTrailer;

    @Column(name = "power_engine_LS_kVT")
    private String powerEngineLSKvT;

    @Column(name = "engine_volume")
    private String engineVolume;

    @Column(name = "max_weight")
    private String maxWeight;

    @Column(name = "unladen_weight")
    private String unladenWeight;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "country_imp_TC")
    private String countryImpTC;

    @Column(name = "series_number_TD_TPO")
    private String seriesNumberTDTPO;

    @Column(name = "customs_restrictions")
    private String customsRestrictions;

    @Column(name = "reg_name_organization")
    private String regNameOrganization;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_TC_id")
    private TypeTC typeTC;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_engine_id")
    private TypeEngine typeEngine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ECO_class_id")
    private EcoClass ecoClass;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_TC_id")
    private ModelTC modelTC;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private Driver drivers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "pts", fetch = FetchType.EAGER)
    Set<Certificate> certificateSet;

    @Override
    public String toString() {
        return ptsSeries +" - "+ptsNumber;
    }
}
