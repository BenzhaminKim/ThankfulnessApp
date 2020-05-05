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
@Table(name="thankfulnessImage")
public class ThankfulnessImage {
    @Id
    @Column(name="imageId")
    @Type(type="pg-uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID imageId;
    @Column(name="thankfulnessId")
    @Type(type="pg-uuid")
    private UUID thankfulnessId;
    @Column(name="imagePath")
    private String imagePath;
    @Column(name="createdDate")
    @CreationTimestamp
    private Date createdDate;
}
