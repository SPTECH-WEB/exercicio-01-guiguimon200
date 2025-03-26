package com.example.atividade.Controller;

import com.example.atividade.Model.Fatura;
import com.example.atividade.Service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;

    public FaturaController(FaturaService fatura) {
        this.faturaService = fatura;
    }

    @GetMapping
    public List<Fatura> listarFaturas() {
        return faturaService.getFaturas();
    }

    @PostMapping
    public ResponseEntity <Fatura> salvarFatura(@Valid @RequestBody Fatura fatura) {
        Fatura salvo = faturaService.salvarFatura(fatura);
        return ResponseEntity.ok(salvo);
    }
}
