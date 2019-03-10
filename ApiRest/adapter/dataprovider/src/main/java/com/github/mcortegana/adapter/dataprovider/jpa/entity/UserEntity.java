package com.github.mcortegana.adapter.dataprovider.jpa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String lastName;

    @Column
    private String firstName;

}
