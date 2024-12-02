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
public class RequestStatus extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String description;

    @OneToMany(mappedBy = "requestStatus")
    private List<RepairRequest> repairRequests;

}
