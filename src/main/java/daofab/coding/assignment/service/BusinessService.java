package daofab.coding.assignment.service;

import daofab.coding.assignment.dto.ChildDTO;
import daofab.coding.assignment.dto.ParentDTO;
import daofab.coding.assignment.entity.Child;
import daofab.coding.assignment.entity.Parent;
import daofab.coding.assignment.repository.ChildRepository;
import daofab.coding.assignment.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    private ParentRepository parentRepository;
    private ChildRepository childRepository;

    @Autowired
    public BusinessService(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    public Page<ParentDTO> findAllParent(Pageable pageable){
        Page<Parent> page = parentRepository.findAll(pageable);
        List<ParentDTO> listDTO = page.stream().map(parent -> {
          return Parent.convertToDTO(parent);
        }).collect(Collectors.toList());

        return new PageImpl<ParentDTO>(listDTO, pageable, page.getTotalElements());
    }

    public Page<ChildDTO> findAllParentChildByParent(Long parentId, Pageable pageable){
        Page<Child> page = childRepository.findByParentId(parentId, pageable);
        List<ChildDTO> listDTO = page.stream().map(child -> {
            return Child.convertToDTO(child);
        }).collect(Collectors.toList());

        return new PageImpl<ChildDTO>(listDTO, pageable, page.getTotalElements());
    }
}
