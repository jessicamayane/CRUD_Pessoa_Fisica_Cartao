/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cartao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jessica.santos19
 */
public interface CartaoDao extends BaseDao<Cartao, Long> {
    Cartao pesquisarPorNumero(String numero, Session session) throws HibernateException;
    //porque sempre tem que criar essa lista
}
