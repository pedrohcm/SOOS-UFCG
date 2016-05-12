package Orgaos;

import java.util.ArrayList;

import Exceptions.OrgaoException;
import Factory.OrgaoFactory;

public class BancoOrgaos {
	private ArrayList<Orgao> orgaos;
	private OrgaoFactory factoryOrgaos;
	
	/**
	 * Construtor de BancoOrgaos, criando o banco a ser usado e instanciando a factory.
	 */
	public BancoOrgaos() {
		orgaos = new ArrayList<Orgao>();
		factoryOrgaos = new OrgaoFactory();
	}
	
	/**
	 * Adiciona um novo orgao no banco.
	 * @param nome nome do orgao a ser criado na factory
	 * @param tipoSanguineo  tipo Sanguineo do orgao a ser criado na factory
	 * @return nome do orgao
	 */
	public String adicionaOrgao(String nome, String tipoSanguineo) {
		Orgao orgao = factoryOrgaos.criaOrgao(nome, tipoSanguineo);
		orgaos.add(orgao);
		return orgao.getNome();
	}
	
	/**
	 * Remove um orgao do banco
	 * @param nome nome do orgao ser removido
	 * @throws OrgaoException caso o orgao nao exista no banco
	 */
	public void removeOrgao(String nome) throws OrgaoException {
		for(Orgao orgao: orgaos) {
			if(orgao.getNome().equals(nome)) {
				orgaos.remove(orgao);
				return;
			}
		}
		throw new OrgaoException("Orgao nao existe.");
	}
	
	/**
	 * Recupera um orgao que tenha o mesmo nome recebido
	 * @param nome nome do orgao a ser recuperado
	 * @return o objeto, caso ele exista
	 * @throws OrgaoException caso o objeto nao exista
	 */
	public Orgao getOrgaoNome(String nome) throws OrgaoException {
		for(Orgao orgao: orgaos) {
			if(orgao.getNome().equals(nome)) {
				return orgao;
			}
		}
		throw new OrgaoException("Orgao nao existe.");
	}
	
	/**
	 * Recupera um orgao que tenha o mesmo tipo Sanguineo recebido
	 * @param tipo tipo Sanguineo do orgao a ser recuperado
	 * @return o objeto, caso ele exista
	 * @throws OrgaoException caso o objeto nao exista
	 */
	public Orgao getOrgaoTipoSanguineo(String tipo) throws OrgaoException {
		for(Orgao orgao: orgaos) {
			if(orgao.getTipoSanguineo().equals(tipo)) {
				return orgao;
			}
		}
		throw new OrgaoException("Orgao nao existe.");
	}
	
	/**
	 * Retorna a quantidade total de orgaos disponiveis no banco
	 * @return a quantidade de orgaos
	 */
	public int getQuantidadeBanco() {
		return orgaos.size();
	}
	
	/**
	 * Retorna a quantidade de orgaos que tem o mesmo nome recebido
	 * @param nome nome do orgao a ser pesquisado
	 * @return a quantidade do orgao;
	 */
	public int getQuantidadeOrgao(String nome) {
		int quantidade = 0;
		for(Orgao orgao: orgaos) {
			if(orgao.getNome().equals(nome)) {
				quantidade += 1;
			}
		}
		return quantidade;
	}
		
}
