package org.colizeum.crmapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "steam")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Steam {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "manifest_id", unique = true, nullable = false)
    private String manifestId;
}
