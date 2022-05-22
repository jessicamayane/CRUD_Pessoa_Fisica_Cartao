/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import static br.com.senac.util.GeradorUtil.*;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jessica.santos19
 */
public class ProfissaoDaoImplTest {

    private Profissao profissao;
    private ProfissaoDao profissaoDao;
    private Session sessao;

    public ProfissaoDaoImplTest() {
        profissaoDao = new ProfissaoDaoImpl();
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();
        Profissao pesProfissao = profissaoDao.pesquisarPorId(profissao.getId(), sessao);
        sessao.close();
        assertNotNull(pesProfissao);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Profissao> profissoes = profissaoDao.pesquisarPorNome(profissao.getNome(), sessao);
        for (Profissao profissao : profissoes) {
            System.out.println(profissao.getNome());

        }
        sessao.close();
        assertTrue(!profissoes.isEmpty());
    }

//    @Test
    public void testSalvar() {
        Faker faker = new Faker();
        profissao = new Profissao(gerarProfissao(), faker.lorem().sentence());
        sessao = HibernateUtil.abrirConexao();
        profissaoDao.salvarOuAlterar(profissao, sessao);
        sessao.close();
        assertNotNull(profissao.getId());
    }

    public Profissao buscarProfissaoBd() {
        sessao = HibernateUtil.abrirConexao();

        Query<Profissao> consulta = sessao.createQuery("from Profissao p ");
        List<Profissao> profissaos = consulta.list();
        sessao.close();
        if (profissaos.isEmpty()) {
            testSalvar();
        } else {
            profissao = profissaos.get(3);
        }
        return profissao;
    }
    
    
}
//crud cartao
//gerar cartao escolhendo um cliente pf ou pj
