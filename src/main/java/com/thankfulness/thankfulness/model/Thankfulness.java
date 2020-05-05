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
@Table(name="thankfulness")
public class Thankfulness {
    @Id
    @Column(name="thankfulness_id")
    @Type(type="pg-uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID thankfulnessId;
    @Column(name="user_id")
    private UUID userId;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="created_date")
    @CreationTimestamp
    private Date createdDate;
}
