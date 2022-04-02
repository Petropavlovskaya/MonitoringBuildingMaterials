package by.bsc.iac.monitoringbuildingmaterials.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Report definition by dry mixes (form 1a).
 * Class describes amount of produced, shipment to the domestic market and exported of dry mixes include a mixes on a gypsum base
 * (for a report month & for a period since begin of year) and amount of product's stock for an end of report period.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "dm_1a_report")
public class DryMixes1aReport {
    /**
     * DryMixes1aReport ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    /**
     * Amount of the dry mixes produced since the beginning of the year
     */
    @Column(name = "produce_all")
    private float produceAll;

    /**
     * Amount of the gypsum based dry mixes produced since the beginning of the year
     */
    @Column(name = "produce_all_gypsum")
    private float produceAllGypsum;

    /**
     * Amount of the dry mixes produced by the report month
     */
    @Column(name = "produce_month")
    private float produceMonth;

    /**
     * Amount of the gypsum based dry mixes produced by the report month
     */
    @Column(name = "produce_month_gypsum")
    private float produceMonthGypsum;

    /**
     * Amount of the dry mixes shipment to the domestic market since the beginning of the year
     */
    @Column(name = "onvr_all")
    private float onvrAll;

    /**
     * Amount of the gypsum based dry mixes shipment to the domestic market since the beginning of the year
     */
    @Column(name = "onvr_all_gypsum")
    private float onvrAllGypsum;

    /**
     * Amount of the dry mixes shipment to the domestic market by the report month
     */
    @Column(name = "onvr_month")
    private float onvrMonth;

    /**
     * Amount of the gypsum based dry mixes shipment to the domestic market by the report month
     */
    @Column(name = "onvr_month_gypsum")
    private float onvrMonthGypsum;

    /**
     * Amount of the dry mixes exported since the beginning of the year
     */
    @Column(name = "export_all")
    private float exportAll;

    /**
     * Amount of the gypsum based dry mixes exported since the beginning of the year
     */
    @Column(name = "export_all_gypsum")
    private float exportAllGypsum;

    /**
     * Amount of the dry mixes exported by the report month
     */
    @Column(name = "export_month")
    private float exportMonth;

    /**
     * Amount of the gypsum based dry mixes exported by the report month
     */
    @Column(name = "export_month_gypsum")
    private float exportMonthGypsum;

    /**
     * Amount of the dry mixes stock
     */
    @Column
    private float stock;

    /**
     * Additional information to describe a report form
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private Report report;

    /**
     * Type of report form
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private Form form;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DryMixes1aReport that = (DryMixes1aReport) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
