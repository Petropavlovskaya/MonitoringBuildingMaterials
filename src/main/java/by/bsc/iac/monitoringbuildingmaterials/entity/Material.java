package by.bsc.iac.monitoringbuildingmaterials.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Material definition. Class describes materials which organizations are produce.
 */
@Data
@Entity
@Table(name = "materials")
public class Material {

    /**
     * Material ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    /**
     * Material name
     */
    @Column(name = "name_material")
    private String name;

    /**
     * Material unit
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id")
    private Unit unit;

    /**
     * Set of organizations names and their capacity for produce material
     */
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}
            , mappedBy = "material")
    private Set<Capacity> capacitySet;
}
