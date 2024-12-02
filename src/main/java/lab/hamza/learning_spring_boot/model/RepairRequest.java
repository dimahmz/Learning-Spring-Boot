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
public class RepairRequest extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;
    private String problemDescription;
    private String quantity;
    private String problemCause;

    @OneToOne
    @JoinColumn(name="wire_id")
    private Wire wire;

    @ManyToOne
    @JoinColumn(name="refus_type_id")
    private RefusType refusType;

    @ManyToOne
    @JoinColumn(name="repair_reason_id")
    private RepairReason repairReason;

    @ManyToOne
    @JoinColumn(name="request_status_id")
    private RequestStatus requestStatus;

    @ManyToMany(mappedBy = "repairRequests")
    private List<ProblemResponsible> problemResponsibles;
}
