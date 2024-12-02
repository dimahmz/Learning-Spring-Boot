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
public class RefusType extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "refusType")
    private List<RepairRequest> repairRequests;

}
