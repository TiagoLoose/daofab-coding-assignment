package daofab.coding.assignment.repository;

import daofab.coding.assignment.entity.Child;
import daofab.coding.assignment.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    Page<Child> findByParentId(Long parentId, Pageable pageable);

}
