package lab.hamza.learning_spring_boot.model;


import jakarta.persistence.*;
import lab.hamza.learning_spring_boot.model.audit.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wire extends AuditableEntity{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String adresse;

    private String cable;

    private String carline;

    private String col;

    private String fam;

    private String fil;

    private String groupe;

    private String identification;

    private String kitD;

    private String kitG;

    private String leadcode;

    private String length;

    private String m;

    private String marD;

    private String marG;

    private String mqs;

    private String niveau;

    private String outilD;

    private String outilG;

    private String process;

    private String projet;

    private String protectionD;

    private String protectionG;

    private String pvc;

    private String sealD;

    private String sealG;

    private String sec;

    private String tempsMoyReg;

    private String terD;

    private String terG;

    private String typeAttacheFil;

    private String unico;

}
