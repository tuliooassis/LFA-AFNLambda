/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfa.afnlamb;

/**
 *
 * @author tulio
 */
public class Aresta {

    private Estado m_atual;
    private Estado m_proximo;
    private String m_consome;

    Aresta(Estado p_atual, String p_consome, Estado p_proximo) {
        this.m_atual = p_atual;
        this.m_proximo = p_proximo;
        this.m_consome = p_consome;
    }

    public Estado getAtual() {
        return m_atual;
    }

    public void setAtual(Estado atual) {
        this.m_atual = atual;
    }

    public Estado getProximo() {
        return m_proximo;
    }

    public void setProximo(Estado proximo) {
        this.m_proximo = proximo;
    }

    public String getConsome() {
        return m_consome;
    }

    public void setConsome(String consome) {
        this.m_consome = consome;
    }
}
