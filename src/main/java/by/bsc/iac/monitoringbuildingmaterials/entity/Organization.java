package by.bsc.iac.monitoringbuildingmaterials.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Organization definition. Class describes organizations, which are produce a building materials.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {

    /**
     * Organization ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    /** Organization name */
    @Column(name = "name_org")
    private String name;

    /** Is the organization included in the system of the Ministry of Construction and Architecture  */
    @Column(name = "part_of_mais")
    private boolean isMAiS;

    /**
     * Set of forms which submit current organization
     */
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "forms_organizations",
            joinColumns = @JoinColumn(name = "fk_organization"),
            inverseJoinColumns = @JoinColumn(name = "fk_form")
    )
    @ToString.Exclude
    private Set<Form> formSet;

    /**
     * Set of materials and organization's capacity for their produce
     */
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}
            , mappedBy = "organization")
    @ToString.Exclude
    private Set<Capacity> capacitySet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
