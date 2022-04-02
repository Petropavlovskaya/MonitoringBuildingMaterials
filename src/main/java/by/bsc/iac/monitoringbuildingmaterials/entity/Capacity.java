package by.bsc.iac.monitoringbuildingmaterials.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Capacity definition. Class describes capacity of organization, which producing a building material.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "materials_organizations")
public class Capacity {

    /**
     * Capacity ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    /**
     * Amount of organization's capacity to produce a material
     */
    @Column
    private int capacity;

    /**
     * Material which produce of organization
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_material")
    private Material material;

    /**
     * Organization which produce a material
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_organization")
    private Organization organization;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Capacity capacity = (Capacity) o;
        return Objects.equals(id, capacity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
