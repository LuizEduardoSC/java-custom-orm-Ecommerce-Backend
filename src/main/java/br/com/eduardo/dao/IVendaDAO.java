/**
 * @author eduardo
 *
 */
package br.com.eduardo.dao;

import br.com.eduardo.dao.generic.IGenericDAO;
import br.com.eduardo.domain.Venda;
import br.com.eduardo.exceptions.DAOException;
import br.com.eduardo.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
