package daofab.coding.assignment.controller;

import daofab.coding.assignment.dto.ChildDTO;
import daofab.coding.assignment.dto.ParentDTO;
import daofab.coding.assignment.entity.Child;
import daofab.coding.assignment.entity.Parent;
import daofab.coding.assignment.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BusinessController {

    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Operation(summary = "Get all the parent transactions")
    @GetMapping("/parent")
    public Page<ParentDTO> getAllParent(@ParameterObject @PageableDefault(sort={"id"}, size = 2) Pageable pageable){
        return businessService.findAllParent(pageable);
    }

    @Operation(summary = "Get child from required parent transaction")
    @GetMapping("/parent/{parentId}/child")
    public Page<ChildDTO> getChildByParent(@PathVariable Long parentId, @ParameterObject @PageableDefault(sort={"id"}) Pageable pageable){
        return businessService.findAllParentChildByParent(parentId, pageable);
    }

}
