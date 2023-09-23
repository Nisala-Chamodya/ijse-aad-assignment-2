package lk.blacky.ijse.assignment_2.dto;

import lk.blacky.ijse.assignment_2.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechLeadDto {
    private UUID tlId;

    private String tlName;

    private String tlEmail;

    private List<Project> projects;
}
