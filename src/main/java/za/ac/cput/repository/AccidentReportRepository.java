package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.AccidentReport;
import za.ac.cput.domain.Customer;

import java.util.List;

@Repository
public interface AccidentReportRepository extends JpaRepository<AccidentReport, Integer> {
//    List<AccidentReport> findByCustomerId(@Param("customerId") int customerId);
//    List<AccidentReport> findReportsByCustomerID(Customer customerId);

    List<AccidentReport> findByCustomer_CustomerID(@Param("customerID") Customer customerId);

//    @Query("SELECT a FROM AccidentReport a WHERE a.customer.email = :email")
//    List<AccidentReport> findReportsByCustomerEmail(@Param("email") String email);

}
