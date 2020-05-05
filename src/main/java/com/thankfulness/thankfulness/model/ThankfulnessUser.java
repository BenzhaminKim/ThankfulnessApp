package com.thankfulness.thankfulness.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="thankfulnessUser")
public class ThankfulnessUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    @Type(type="pg-uuid")
    private UUID userId;
    @Column(name="user_name")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="user_image")
    private String userImage;
    @Column(name="created_date")
    @CreationTimestamp
    private Date createdDate;
}
