package lk.ijse.gradle.repo;

import lk.ijse.gradle.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TechLeadRepositories extends JpaRepository<TechLead,String> {

}
