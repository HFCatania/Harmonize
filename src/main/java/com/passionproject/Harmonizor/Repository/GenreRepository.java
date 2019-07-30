package com.passionproject.Harmonizor.Repository;

import com.passionproject.Harmonizor.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
