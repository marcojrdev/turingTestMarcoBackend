package com.marco.turingTestMarcoBackend.resources;

import java.util.List;

import org.dom4j.IllegalAddException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.turingTestMarcoBackend.repository.ContatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.marco.turingTestMarcoBackend.models.Contato;

@RestController
@RequestMapping(value = "/api")

@Api(value = "API REST Produtos")
public class ContatoResources {
	
	@Autowired
	ContatoRepository contatoRepository;

	@GetMapping("/contato")
	@ApiOperation(value = "Retorna uma lista de contatos")
	public List<Contato> listaContatos() {
		return contatoRepository.findAll();
	}
	
	@GetMapping("/contato/{id}")
	@ApiOperation(value = "Retorna um contato unico")
	public Contato contatosByID(@PathVariable(value = "id") long id) {
		return contatoRepository.findById(id);
	}
	
	@PostMapping("/contato")
	@ApiOperation(value = "Salva contato")
	public Contato salvaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping("/contato/{id}")
	@ApiOperation(value = "Deleta contato")
	public void deleteContato(@PathVariable ("id") long id) {
		contatoRepository.delete(contatoRepository.findById(id));
	}
	
	@PutMapping("/contato/{id}")
	@ApiOperation(value = "Edita contato")
	public Contato editaContato(@RequestBody Contato contato, @PathVariable ("id") long id) {
		
		if(contatoRepository.findById(id) == null) {
			throw new IllegalAddException("Erro contato não existe");
		}
		contato.setId(id);
		return contatoRepository.save(contato);
	}
}

