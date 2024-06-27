package com.cryss.springjpamaterializedview.model.recursiveentity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String titulo;

    @Column(nullable = false)
    public String link;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    public CategoriaEnum categoria;
}
