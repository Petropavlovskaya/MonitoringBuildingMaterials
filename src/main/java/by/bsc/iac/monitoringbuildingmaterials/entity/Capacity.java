package by.bsc.iac.monitoringbuildingmaterials.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Capacity definition. Class describes capacity of organization, which is produce a building material.
 */
@Data
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
}
