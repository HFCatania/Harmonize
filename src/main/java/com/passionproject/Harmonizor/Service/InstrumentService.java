package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.Instrument;
import com.passionproject.Harmonizor.Repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class InstrumentService {
    @Autowired
    private InstrumentRepository instrumentRepository;

    public Instrument create(Instrument instrument){ return instrumentRepository.save(instrument);}

    public Iterable<Instrument> findAll(){ return instrumentRepository.findAll();}

}
