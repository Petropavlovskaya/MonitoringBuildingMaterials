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
 * Form type definition. Class describes types of forms which organizations are submitted.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "forms")
public class Form {

    /**
     * Form ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    /**
     * Form name
     */
    @Column(name = "name_form")
    private String name;

    /**
     * Form version
     */
    @Column(name = "form_version")
    private String version;

    /**
     * Set of organizations which submit current form
     */
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "forms_organizations",
            joinColumns = @JoinColumn(name = "fk_form"),
            inverseJoinColumns = @JoinColumn(name = "fk_organization")
    )
    @ToString.Exclude
    private Set<Organization> organizationSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Form form = (Form) o;
        return Objects.equals(id, form.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
