package lab.hamza.learning_spring_boot.model;

import jakarta.persistence.*;
import lab.hamza.learning_spring_boot.model.audit.AuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class RepairReason extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String name;

    @OneToMany(mappedBy = "repairReason")
    private List<RepairRequest> repairRequests;


}
