package com.passionproject.Harmonizor.Repository;

import com.passionproject.Harmonizor.Model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
