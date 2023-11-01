package br.com.williamdev.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // create getters and setters for the attributes below it.
@Entity(name="tb_users")
public class UserModel {

    @Id // tells the database that the one below is the primary key.
    @GeneratedValue(generator = "UUID") // makes the system responsible for managing the UUID.
    private UUID id;

    //@Column(name = "usuario") // changes the name of the attribute in the database.
    @Column(unique = true)
    private String name;
    private String username;
    private String password;

    @CreationTimestamp // defines a timestamp for saving this data
    private LocalDateTime createdAt; 
}
