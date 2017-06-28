package ts.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import ts.adapter.TimeAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.sql.Time;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "flight", schema = "ticketorder", catalog = "")
@XmlRootElement(name = "flight")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flight implements Serializable {
    private String id;
    private Time startTime;
    private Time arriveTime;
    private Double businessPrice;
    private Double economyPrice;
    private Integer businessNum;
    private Integer economyNum;
    private Integer status;
    private Company company;
    private Airport startAirport;//始发机场
    private Airport arriveAirport;//目的机场

    private static final long serialVersionUID = -3267943602377867497L;

    @XmlElement()
    @Id
    @Column(name = "id", nullable = false, length = 25)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlJavaTypeAdapter(TimeAdapter.class)
    @XmlElement
    @Basic
    @Column(name = "startTime", nullable = false)
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @XmlJavaTypeAdapter(TimeAdapter.class)
    @XmlElement
    @Basic
    @Column(name = "arriveTime", nullable = false)
    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    @XmlElement
    @Basic
    @Column(name = "businessPrice", nullable = false, precision = 0)
    public Double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(Double businessPrice) {
        this.businessPrice = businessPrice;
    }

    @XmlElement
    @Basic
    @Column(name = "economyPrice", nullable = false, precision = 0)
    public Double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(Double economyPrice) {
        this.economyPrice = economyPrice;
    }

    @XmlElement
    @Basic
    @Column(name = "businessNum", nullable = false)
    public Integer getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(Integer businessNum) {
        this.businessNum = businessNum;
    }

    @XmlElement
    @Basic
    @Column(name = "economyNum", nullable = false)
    public Integer getEconomyNum() {
        return economyNum;
    }

    public void setEconomyNum(Integer economyNum) {
        this.economyNum = economyNum;
    }

    @XmlElement
    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlElement
    @ManyToOne
    @JoinColumn(name = "companyUName", referencedColumnName = "username")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @XmlElement
    @OneToOne
    @JoinColumn(name = "startAirport", referencedColumnName = "id")
    public Airport getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    @XmlElement
    @OneToOne
    @JoinColumn(name = "arriveAirport", referencedColumnName = "id")
    public Airport getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(Airport arriveAirport) {
        this.arriveAirport = arriveAirport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight that = (Flight) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (arriveTime != null ? !arriveTime.equals(that.arriveTime) : that.arriveTime != null) return false;
        if (businessPrice != null ? !businessPrice.equals(that.businessPrice) : that.businessPrice != null)
            return false;
        if (economyPrice != null ? !economyPrice.equals(that.economyPrice) : that.economyPrice != null) return false;
        if (businessNum != null ? !businessNum.equals(that.businessNum) : that.businessNum != null) return false;
        if (economyNum != null ? !economyNum.equals(that.economyNum) : that.economyNum != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (arriveTime != null ? arriveTime.hashCode() : 0);
        result = 31 * result + (businessPrice != null ? businessPrice.hashCode() : 0);
        result = 31 * result + (economyPrice != null ? economyPrice.hashCode() : 0);
        result = 31 * result + (businessNum != null ? businessNum.hashCode() : 0);
        result = 31 * result + (economyNum != null ? economyNum.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", arriveTime=" + arriveTime +
                ", businessPrice=" + businessPrice +
                ", economyPrice=" + economyPrice +
                ", businessNum=" + businessNum +
                ", economyNum=" + economyNum +
                ", status=" + status +
                ", startAirport=" + startAirport +
                ", arriveAirport=" + arriveAirport +
                ", company=" + company +
                '}';
    }

    public static final class STATUS {
        public static final int FLIGHT_NORMAL = 0; //正常状态
        public static final int FLIGHT_CANCEL = -1; //航班取消
    }
}
