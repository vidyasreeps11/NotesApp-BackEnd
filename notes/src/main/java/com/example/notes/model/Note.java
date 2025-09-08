package com.example.notes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String content;

    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
	
}
