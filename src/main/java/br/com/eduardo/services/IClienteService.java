package br.com.eduardo.services;

import br.com.eduardo.domain.Cliente;
import br.com.eduardo.exceptions.DAOException;
import br.com.eduardo.exceptions.TipoChaveNaoEncontradaException;
import br.com.eduardo.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
