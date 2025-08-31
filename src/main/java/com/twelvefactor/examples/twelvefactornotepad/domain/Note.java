package com.twelvefactor.examples.twelvefactornotepad.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "notes")
@Schema(description = "Represents a user note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the Note.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(
            description = "Content of the note.",
            example = "Remember to buy milk.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Column(columnDefinition = "TEXT")
    @Schema(
            description = "Content of the note.",
            example = "Remember to buy milk.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    private String color;

    @Column(name = "position_x")
    private Integer positionX;

    @Column(name = "position_y")
    private Integer positionY;

    @Column(updatable = false)
    @CreationTimestamp
    @Schema(
            description = "Timestamp of when the note was created.",
            example = "2023-05-14T10:00:00Z",
            accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Schema(
            description = "Timestamp of when the note was last updated.",
            example = "2023-05-14T12:30:00Z",
            accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Note(
            Long id,
            String title,
            String content,
            String color,
            Integer positionX,
            Integer positionY,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Note() {
        super();
        // TODO Auto-generated constructor stub
    }
}
