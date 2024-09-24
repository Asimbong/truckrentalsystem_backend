package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AccidentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;
    private LocalDate accidentDate;
    private String description;
    private String location;
    private double damageCost;

    @ManyToOne
    @JoinColumn(name = "Vin")
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    protected AccidentReport() {
    }

    private AccidentReport(Builder builder) {
        this.reportId = builder.reportId;
        this.accidentDate = builder.accidentDate;
        this.description = builder.description;
        this.location = builder.location;
        this.damageCost = builder.damageCost;
        this.truck = builder.truck;
        this.customer = builder.customer;
    }

    public int getReportId() {
        return reportId;
    }

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getDamageCost() {
        return damageCost;
    }

    public Truck getTruck() {
        return truck;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentReport that = (AccidentReport) o;
        return reportId == that.reportId && Double.compare(damageCost, that.damageCost) == 0 && Objects.equals(accidentDate, that.accidentDate) && Objects.equals(description, that.description) && Objects.equals(location, that.location) && Objects.equals(truck, that.truck) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, accidentDate, description, location, damageCost, truck, customer);
    }

    @Override
    public String toString() {
        return "AccidentReport{" +
                "reportId=" + reportId +
                ", accidentDate=" + accidentDate +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", damageCost=" + damageCost +
                ", truck=" + truck +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{
        private int reportId;
        private LocalDate accidentDate;
        private String description;
        private String location;
        private double damageCost;
        private Truck truck;
        private Customer customer;

        public Builder setReportId(int reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setAccidentDate(LocalDate accidentDate) {
            this.accidentDate = accidentDate;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setDamageCost(double damageCost) {
            this.damageCost = damageCost;
            return this;
        }

        public Builder setTruck(Truck truck) {
            this.truck = truck;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(AccidentReport accidentReport) {
            this.reportId = accidentReport.reportId;
            this.accidentDate = accidentReport.accidentDate;
            this.description = accidentReport.description;
            this.location = accidentReport.location;
            this.damageCost = accidentReport.damageCost;
            this.truck = accidentReport.truck;
            this.customer = accidentReport.customer;
            return this;
        }
        public AccidentReport build() {
            return new AccidentReport(this);
        }
    }
}

