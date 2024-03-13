package com.spring.cloud.controller;

import com.spring.cloud.model.CuponEntity;
import com.spring.cloud.repository.CuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuponapi")
public class CuponRestController {
    @Autowired
    private CuponRepository cuponRepository;

    @PostMapping("/cupons")
    public CuponEntity create(@RequestBody CuponEntity cuponEntity) {
        CuponEntity entity = cuponRepository.save(cuponEntity);
        System.out.println("Entity save in db "+entity);
        return cuponEntity;
    }

    @GetMapping("/Cupons/{code}")
    public List<CuponEntity> getCupon(@PathVariable String code){
       return cuponRepository.findByCode(code);
    }
}
