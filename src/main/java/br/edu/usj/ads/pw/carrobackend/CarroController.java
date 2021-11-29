package br.edu.usj.ads.pw.carrobackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@CrossOrigin
public class CarroController {
    @Autowired
    CarroRepository carroRepository;

    @GetMapping(value="/")
    public List<Carro> getListarTodos() {
        List<Carro> lista = carroRepository.findAll();
        
        return lista;
    }

    @GetMapping(value="/detalhes/{id}")
    public Carro getDetalhes(@PathVariable Long id) {
        Carro carro = carroRepository.findById(id).get();
        return carro;
    }
    
    @PostMapping(value="/cadastro")
    public Carro postCadastro(@RequestBody Carro carroNovo) {
       
        Carro carroSalvo = carroRepository.save(carroNovo);
        return carroSalvo;
    }
    
    @GetMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
       carroRepository.deleteById(id);
        
    }
    
    


}
