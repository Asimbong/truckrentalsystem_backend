package za.ac.cput.factory;

import za.ac.cput.domain.AccidentReport;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Truck;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class AccidentReportFactory {
    public static AccidentReport buildAccidentReport(int reportId, LocalDate accidentDate, String description,
                                                     String location, String response, String status, Customer customer) {
        if (Helper.isIntNotValid(reportId) || accidentDate == null
                || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(location)
                || Helper.isNullOrEmpty(response) || Helper.isNullOrEmpty(status) || customer == null) {
            return null;
        }
        return new AccidentReport.Builder().setReportId(reportId)
                .setAccidentDate(accidentDate)
                .setDescription(description)
                .setLocation(location)
                .setResponse(response)
                .setStatus(status)
                .setCustomer(customer)
                .build();
    }
}
