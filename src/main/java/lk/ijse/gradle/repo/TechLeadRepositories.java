package lk.ijse.gradle.repo;

import lk.ijse.gradle.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


public interface TechLeadRepositories extends JpaRepository<TechLead,String> {

}
