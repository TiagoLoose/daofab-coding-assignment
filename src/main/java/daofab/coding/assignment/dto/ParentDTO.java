package daofab.coding.assignment.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParentDTO {

    private Long id;
    private String sender;
    private String receiver;
    private BigDecimal totalAmount;
    private BigDecimal totalPaidAmount;

}
