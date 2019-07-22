package com.jancloud.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jancloud.cursomc.model.Categoria;
import com.jancloud.cursomc.model.Cidade;
import com.jancloud.cursomc.model.Cliente;
import com.jancloud.cursomc.model.Endereco;
import com.jancloud.cursomc.model.Estado;
import com.jancloud.cursomc.model.Produto;
import com.jancloud.cursomc.model.enums.TipoCliente;
import com.jancloud.cursomc.repository.CategoriaRepository;
import com.jancloud.cursomc.repository.CidadeRepository;
import com.jancloud.cursomc.repository.ClienteRepository;
import com.jancloud.cursomc.repository.EnderecoRepository;
import com.jancloud.cursomc.repository.EstadoRepository;
import com.jancloud.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepo;	
	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//instanciando e gravando no banco as categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		//instanciando e gravando no banco os produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora",800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		//associando produtos as categorias
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		System.out.println("log01: produtos foram associados a categorias!");
		//associando categorias aos produtos
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		System.out.println("log02: categorias foram associados a produtos!");
		
		categoriaRepo.save(Arrays.asList(cat1, cat2));
		System.out.println("log03: categorias foram salvas");
		produtoRepo.save(Arrays.asList(p1,p2,p3));
		System.out.println("log04: produtos foram salvos");
		
		//instanciando estados
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		System.out.println("log05:Instanciando Estados");
		
		//instanciando cidades
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		System.out.println("log06:Instanciando e associando as cidades");
		//relacionando cidades aos estados
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		System.out.println("log07: cidades foram relacionadas aos estados");
		//salvando estados
		estadoRepo.save(Arrays.asList(est1,est2));
		System.out.println("log08: os estados foram salvos");
		//salvando cidades
		cidadeRepo.save(Arrays.asList(c1,c2,c3));
		System.out.println("log09: as cidades foram salvas");
		//instanciando clientes e atribuindo telefones
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "88759937580", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("7133474097","71987453712"));
		System.out.println("log10: cliente foi criado com telefone");
		//instanciando endereços
		Endereco e1 = new Endereco(null, "rua flores", "300", "apto 303", "jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "avenida matos", "105", "Sala 800", "Centro", "38775834", cli1, c2);
		System.out.println("log11: endereços foram criados");
		//atribuindo endereços
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		System.out.println("log12: cliente recebeu endereços");
		//salvando cliente
		clienteRepo.save(Arrays.asList(cli1));
		System.out.println("log13: cliente foi salvo");
		enderecoRepo.save(Arrays.asList(e1,e2));
		System.out.println("log14: endereços foram salvos");
	}
	
	

}
