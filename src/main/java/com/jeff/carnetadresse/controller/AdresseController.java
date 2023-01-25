package com.jeff.carnetadresse.controller;

import com.jeff.carnetadresse.domain.dto.AdresseDto;
import com.jeff.carnetadresse.domain.rest.response.DtoOutput;
import com.jeff.carnetadresse.exception.RestClientParameterValidationException;
import com.jeff.carnetadresse.service.AdresseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresse")
@AllArgsConstructor
public class AdresseController {

    private final AdresseService adresseService;

    @GetMapping
    ResponseEntity<DtoOutput> getAllAdresse() {
        List<AdresseDto> adresseDto = adresseService.getAll();
        return ResponseEntity.ok().body(new DtoOutput(adresseDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<DtoOutput> getAdresse(@PathVariable Long id) {
        AdresseDto adresseDto = adresseService.getById(id);
        return ResponseEntity.ok().body(new DtoOutput(adresseDto));
    }

    @PostMapping()
    ResponseEntity<DtoOutput> saveAdresse(@RequestBody @Validated AdresseDto adresseDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new RestClientParameterValidationException(bindingResult);
        }
        adresseDto = adresseService.save(adresseDto);
        return ResponseEntity.ok().body(new DtoOutput(adresseDto));
    }

    @PutMapping("/{id}")
    ResponseEntity<DtoOutput> updateAdresse(@RequestBody @Validated AdresseDto adresseDto, BindingResult bindingResult,
                                            @PathVariable Long id) {

        if (bindingResult.hasErrors()) {
            throw new RestClientParameterValidationException(bindingResult);
        }
        adresseDto = adresseService.update(adresseDto, id);
        return ResponseEntity.ok().body(new DtoOutput(adresseDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DtoOutput> deleteAdresse(@PathVariable Long id) {
        adresseService.deleteById(id);
        return ResponseEntity.ok().body(new DtoOutput());
    }
}
