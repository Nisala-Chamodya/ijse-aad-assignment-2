package lk.blacky.ijse.assignment_2.repo;

import lk.blacky.ijse.assignment_2.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TechLeadRepo extends JpaRepository<TechLead, UUID> {
}
