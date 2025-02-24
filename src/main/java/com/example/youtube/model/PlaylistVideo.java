package com.example.youtube.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "attach")
public class PlaylistVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private UUID PlaylistId;
    private UUID VideoId;
    private LocalDateTime CreatedDate;
    private Integer OrderNum;

}
