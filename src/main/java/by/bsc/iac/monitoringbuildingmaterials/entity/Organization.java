package by.bsc.iac.monitoringbuildingmaterials.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The OrganizationEntity class describes organizations, which are production the building materials
 */
@Data
@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name_org")
    private String name;

    @Column(name = "part_of_mais")
    private boolean isMAiS;
}
