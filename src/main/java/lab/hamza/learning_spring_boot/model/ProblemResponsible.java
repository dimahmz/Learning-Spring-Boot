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
public class ProblemResponsible extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "repair_request_problem_responsible",
            joinColumns = {
                @JoinColumn(name = "problem_responsible_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "repair_request_id", referencedColumnName = "id")
            }
    )

    private List<RepairRequest> repairRequests;

}
