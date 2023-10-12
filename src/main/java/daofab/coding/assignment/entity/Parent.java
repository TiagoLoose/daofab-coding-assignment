package daofab.coding.assignment.entity;

import daofab.coding.assignment.dto.ParentDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "parent")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parent {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "parent")
    List<Child> childs;

    public static ParentDTO convertToDTO(Parent parent){
        if(ObjectUtils.isEmpty(parent))
            return null;

        return ParentDTO.builder()
                .id(parent.getId())
                .receiver(parent.getReceiver())
                .sender(parent.getSender())
                .totalAmount(parent.getTotalAmount())
                .totalPaidAmount(parent.childs
                        .stream()
                        .map(Child::getPaidAmount)
                        .reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element)))
                .build();
    }
}
