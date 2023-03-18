package com.hugo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugo.bookstore.domain.Categoria;
import com.hugo.bookstore.domain.Livro;
import com.hugo.bookstore.repositories.CategoriaRepository;
import com.hugo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null,"Informatica","Livro de TI");
		Categoria cat2 = new Categoria(null,"Ficçao","Livro de ficção");
		Categoria cat3 = new Categoria(null,"Biografias","Livro de biografia");
		
		Livro l1 = new Livro(null,"Clean code","Robert Martin","Lorem ipsum",cat1);
		Livro l2 = new Livro(null,"Engenharia de software","Louis V","Lorem ipsum",cat2);
		Livro l3 = new Livro(null,"Spring boot na prática","H.G Wells","Lorem ipsum",cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3));
	}
}
