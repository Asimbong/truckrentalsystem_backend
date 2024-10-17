package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.AccidentReport;
import za.ac.cput.domain.Complaint;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.RentTruck;
import za.ac.cput.repository.AccidentReportRepository;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class AccidentReportService implements IAccidentReportService {
    private final AccidentReportRepository accidentReportRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    AccidentReportService(AccidentReportRepository accidentReportRepository, CustomerRepository customerRepository){
        this.accidentReportRepository = accidentReportRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public AccidentReport create(AccidentReport accidentReport) {
        return accidentReportRepository.save(accidentReport);
    }

    @Override
    public AccidentReport read(Integer reportId) {
        return this.accidentReportRepository.findById(reportId).orElse(null);
    }

    @Override
    public void delete(Integer reportId) {
        accidentReportRepository.deleteById(reportId);

    }

    @Override
    public AccidentReport update(Integer reportId, AccidentReport reportDetails) {
        AccidentReport existingReport = read(reportId);
        if (existingReport != null) {
            AccidentReport updatedReport = new AccidentReport.Builder()
                    .copy(existingReport)
                    .setDescription(reportDetails.getDescription())
                    .setLocation(reportDetails.getLocation())
                    .setStatus(reportDetails.getStatus())
                    .setResponse(reportDetails.getResponse())
                    .build();
            return accidentReportRepository.save(updatedReport);
        }
        return null;
    }

    @Override
    public List<AccidentReport> getAll() {
        return accidentReportRepository.findAll();
    }

//    public List<AccidentReport> getReportsByCustomerId(int customerID) {
//        return accidentReportRepository.findByCustomer_CustomerID(customerID);
//    }

    public AccidentReport respondToAccident(int reportId, String response) {
        AccidentReport existingReport = read(reportId);

        if (existingReport != null) {

            AccidentReport updatedReport = new AccidentReport.Builder()
                    .copy(existingReport)
                    .setResponse(response)
                    .setStatus("Resolved")
                    .build();


            return accidentReportRepository.save(updatedReport);
        } else {
            throw new IllegalArgumentException("Report not found");
        }
    }


//    public List<AccidentReport> findReportsByCustomerId(int customerId) {
//        Customer customer = customerRepository.findById(customerId)
//                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
//
//        // Fetching reports associated with the customer
//        return accidentReportRepository.findReportsByCustomerID(customer);
//    }


    public List<AccidentReport> getReportByCustomerEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with email: " + email);
        }

        // Fetching rentals associated with the customer
        return accidentReportRepository.findByCustomer_CustomerID(customer);
    }
}
