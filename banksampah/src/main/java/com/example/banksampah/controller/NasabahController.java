package com.example.banksampah.controller;

import javax.validation.Valid;

import com.example.banksampah.model.Nasabah;
import com.example.banksampah.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/nasabah")
public class NasabahController {
    private NasabahRepository nasabahRepository;

    @Autowired 
    public NasabahController(NasabahRepository nasabahRepository){
        this.nasabahRepository = nasabahRepository;
    }
    @GetMapping("/all")
    Iterable<Nasabah> all() {
      return nasabahRepository.findAll();
    }

    @GetMapping("/{id}")
    Nasabah userById(@PathVariable Long id) {
      return nasabahRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save") 
    Nasabah save(@RequestBody Nasabah nasabah){
        return nasabahRepository.save(nasabah);
    }
    @PutMapping("/{id}")
    Nasabah updatenasabah(@RequestBody Nasabah newUser, @PathVariable Long id) {
      return nasabahRepository.findById(id)
     .map(nasabah ->{
        nasabah.setNama_nasabah(newUser.getNama_nasabah());
        nasabah.setAlamat(newUser.getAlamat());
        nasabah.setNomor_telpon(newUser.getNomor_telpon());
        nasabah.setEmail(newUser.getEmail());
        nasabah.setNomor_rekening(newUser.getNomor_rekening());
        return nasabahRepository.save(nasabah);

      })
      .orElseGet(() -> {
         newUser.setId_nasabah(id);
        return nasabahRepository.save(newUser);
      });
      }

      @DeleteMapping("/{id}")
      public void deletenasabah(@PathVariable Long id){
        nasabahRepository.deleteById(id);
      }
    }
 