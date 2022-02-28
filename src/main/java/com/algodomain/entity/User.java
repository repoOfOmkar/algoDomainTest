package com.algodomain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private boolean isSeller;

    private boolean isAdmin;

    @OneToMany(mappedBy = "userId")
    private List<Product> products = new LinkedList<>();
}
