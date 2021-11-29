package br.edu.usj.ads.pw.carrobackend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long>{
    List<Carro> findAll();
    
}
