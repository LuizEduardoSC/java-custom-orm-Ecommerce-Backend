package br.com.eduardo.services;

import br.com.eduardo.dao.IProdutoDAO;
import br.com.eduardo.domain.Produto;
import br.com.eduardo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
