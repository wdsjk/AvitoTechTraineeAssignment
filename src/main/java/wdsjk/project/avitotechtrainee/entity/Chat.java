package wdsjk.project.avitotechtrainee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @SequenceGenerator(
            name = "chat_sequence",
            sequenceName = "chat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "chat_sequence"
    )
    private Long chatId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate created_at;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade({CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "UserEntity_Chat",
            joinColumns = {@JoinColumn(name = "chatId", referencedColumnName = "chatId")},
            inverseJoinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")}
    )
    private List<UserEntity> users;

    public Chat(String name, List<UserEntity> users, LocalDate created_at) {
        this.name = name;
        this.users = users;
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + chatId +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", users=" + users +
                '}';
    }
}
