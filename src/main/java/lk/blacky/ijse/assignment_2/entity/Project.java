package lk.blacky.ijse.assignment_2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Project {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    private UUID projectId;

    private String projectName;

    private String projectDeadline;

    private String projectStatus;

    @ManyToOne
    @JoinColumn(name = "tlId", referencedColumnName = "tlId")
    private TechLead techLead;
}
