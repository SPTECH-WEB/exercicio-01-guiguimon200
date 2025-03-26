package com.example.atividade.Service;

import com.example.atividade.Model.Fatura;
import com.example.atividade.Repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    public final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository repository) {
        this.faturaRepository = repository;
    }

    public List<Fatura> getFaturas() {
        return faturaRepository.findAll();
    }

    public Fatura salvarFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }
}
