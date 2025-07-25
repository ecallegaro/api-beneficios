package com.beneficios.presentation;

import com.beneficios.application.BeneficioService;
import com.beneficios.domain.Beneficio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficios")
public class BeneficioController {

    private final BeneficioService service;

    public BeneficioController(BeneficioService service) {
        this.service = service;
    }

    @PostMapping
    public Beneficio criar(@RequestBody Beneficio beneficio) {
        return service.criar(beneficio);
    }

    @GetMapping
    public List<Beneficio> listar() {
        return service.listar();
    }

    @PutMapping("/{id}/ativar")
    public void ativar(@PathVariable Long id) {
        service.ativar(id);
    }

    @PutMapping("/{id}/desativar")
    public void desativar(@PathVariable Long id) {
        service.desativar(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
