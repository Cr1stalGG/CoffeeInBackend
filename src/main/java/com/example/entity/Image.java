package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity
@Table(name = "images")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    @Column(name = "object_name")
    private String objectName;
    @Column(name = "bucketName")
    private String bucketName;

    public Image(@NotNull String objectName, @NotNull String bucketName) {
        this.bucketName = bucketName;
        this.objectName = objectName;
    }
}
