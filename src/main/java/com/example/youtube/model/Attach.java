package com.example.youtube.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "attach")
public class Attach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String originName;
    private long size;
    private String type; // file extension
    private String path;
    private long duration; // in seconds or milliseconds
}
