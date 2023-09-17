package lk.ijse.gradle.repo;

import lk.ijse.gradle.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProjectRepositories extends JpaRepository<Project,String> {
}
