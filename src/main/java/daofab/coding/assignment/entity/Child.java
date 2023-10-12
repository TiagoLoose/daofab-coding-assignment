package daofab.coding.assignment.entity;

import daofab.coding.assignment.dto.ChildDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Entity(name = "child")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Child {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    @Column(name = "paid_amount")
    private BigDecimal paidAmount;

    public static ChildDTO convertToDTO(Child child){
        if(ObjectUtils.isEmpty(child)) return null;

        return ChildDTO.builder()
                .id(child.getId())
                .sender(child.getParent().getSender())
                .receiver(child.getParent().getReceiver())
                .totalAmount(child.getParent().getTotalAmount())
                .paidAmount(child.getPaidAmount())
                .build();
    }
}
