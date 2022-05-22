/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cartao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author jessica.santos19
 */
public class CartaoDaoImpl extends BaseDaoImpl<Cartao, Long> implements CartaoDao, Serializable{

    @Override
    public Cartao pesquisarPorId(Long id, Session sessao) throws HibernateException {
        
        
        return sessao.find(Cartao.class, id);
    }

    @Override
    public Cartao pesquisarPorNumero(String numero, Session session) throws HibernateException {
        
        Query<Cartao> consulta = session.createQuery("from Cartao c where c.numero like :numero");
        consulta.setParameter("numero", "%" + numero + "%");
        return consulta.getSingleResult();
          
    }
    
}
