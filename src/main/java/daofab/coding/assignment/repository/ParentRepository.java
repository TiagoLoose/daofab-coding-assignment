package daofab.coding.assignment.repository;

import daofab.coding.assignment.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {

}
