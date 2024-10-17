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
    private String response;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    protected AccidentReport() {
    }

    private AccidentReport(Builder builder) {
        this.reportId = builder.reportId;
        this.accidentDate = builder.accidentDate;
        this.description = builder.description;
        this.location = builder.location;
        this.customer = builder.customer;
        this.response = builder.response;
        this.status = builder.status;
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

    public String getResponse(){return response;}

    public String getStatus(){return status;}

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentReport that = (AccidentReport) o;
        return reportId == that.reportId && Objects.equals(accidentDate, that.accidentDate) && Objects.equals(description, that.description) && Objects.equals(location, that.location) && Objects.equals(response, that.response) && Objects.equals(status, that.status) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, accidentDate, description, location, response, status, customer);
    }

    @Override
    public String toString() {
        return "AccidentReport{" +
                "reportId=" + reportId +
                ", accidentDate=" + accidentDate +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", response='" + response + '\'' +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{
        private int reportId;
        private LocalDate accidentDate;
        private String description;
        private String location;
        private String response;
        private String status;
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

        public Builder setResponse(String response) {
            this.response = response;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
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
            this.response = accidentReport.response;
            this.status = accidentReport.status;
            this.customer = accidentReport.customer;
            return this;
        }
        public AccidentReport build() {
            return new AccidentReport(this);
        }
    }
}

