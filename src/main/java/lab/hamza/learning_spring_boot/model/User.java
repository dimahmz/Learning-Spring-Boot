package lab.hamza.learning_spring_boot.model;

import jakarta.persistence.*;
import lab.hamza.learning_spring_boot.model.audit.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String label;
    private Boolean isAdmin;
    private Boolean isActive;
    private Integer reference;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
