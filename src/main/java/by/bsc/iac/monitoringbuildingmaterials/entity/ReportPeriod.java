package by.bsc.iac.monitoringbuildingmaterials.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Report period definition. Class consist a months and a years of reports periods .
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "report_period")
public class ReportPeriod {

    /**
     * Report period ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    /**
     * Month of report period
     */
    @Column(name = "report_month")
    private String month;

    /**
     * Year of report period
     */
    @Column(name = "report_year")
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReportPeriod that = (ReportPeriod) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
