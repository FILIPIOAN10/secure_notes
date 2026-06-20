package secure_notes.secure_notes.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // content will be higher tha 255 suitable for long text
    private String content;

    private String ownerUsername;
}
