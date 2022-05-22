/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cartao;
import static br.com.senac.util.GeradorUtil.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jessica.santos19
 */
public class CartaoDaoImplTest {

    private Cartao cartao;

    private CartaoDao cartaoDao;

    private Session sessao;

    public CartaoDaoImplTest() {
        cartaoDao = new CartaoDaoImpl();
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarCartaoBd();
        sessao = HibernateUtil.abrirConexao();
        Cartao cartaoPesq = cartaoDao.pesquisarPorId(cartao.getId(), sessao);
        sessao.close();
        assertNotNull(cartaoPesq);
        System.out.println(cartaoPesq.getId());

    }

//    @Test
    public void testPesquisarPorNumero() {
        System.out.println("pesquisarPorNumero");
        buscarCartaoBd();
        sessao = HibernateUtil.abrirConexao();
        Cartao cartaoPesq = cartaoDao.pesquisarPorNumero(cartao.getNumero(), sessao);
        sessao.close();
        assertNotNull(cartaoPesq);
     
           System.out.println(cartao.getNumero());  
             
    }

//    @Test
    public void testSalvar() {

        cartao = new Cartao(gerarNumero(16), gerarBandeiraCartao(), gerarValidadeCartao());
        PessoaFisicaDaoImplTest pf = new PessoaFisicaDaoImplTest();

        cartao.setCliente(pf.buscarPessoaFisicaBd());
        sessao = HibernateUtil.abrirConexao();
        cartaoDao.salvarOuAlterar(cartao, sessao);

        sessao.close();
        assertNotNull(cartao.getId());
    }

    public Cartao buscarCartaoBd() {
        String hql = "from Cartao c ";
        sessao = HibernateUtil.abrirConexao();
        Query<Cartao> consulta = sessao.createQuery(hql);
        List<Cartao> cartoes = consulta.getResultList();
        sessao.close();
        if (cartoes.isEmpty()) {
            testSalvar();
        } else {
            cartao = cartoes.get(0);
        }
        return cartao;
    }

}
