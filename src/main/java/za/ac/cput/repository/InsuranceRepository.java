package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
}
