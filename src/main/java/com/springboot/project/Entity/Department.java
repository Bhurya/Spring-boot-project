package com.springboot.project.Entity;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_department")
@Builder
@Entity
public class Department {

   /*@Id
    @SequenceGenerator(
            name = "sequence_department",
            sequenceName = "sequence_department",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_department"
    )*/

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
    private String departmentNumber;

}
