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
    private String m_atual;
    private String m_proximo;
    private String m_consome;
    private String m_word;

    Aresta (String p_atual, String p_proximo, String p_consome, String p_word){
        this.m_atual = p_atual;
        this.m_proximo = p_proximo;
        this.m_consome = p_consome;
        this.m_word = p_word;
    }

    public String getAtual() {
        return m_atual;
    }

    public void setAtual(String atual) {
        this.m_atual = atual;
    }

    public String getProximo() {
        return m_proximo;
    }

    public void setProximo(String proximo) {
        this.m_proximo = proximo;
    }

    public String getConsome() {
        return m_consome;
    }

    public void setConsome(String consome) {
        this.m_consome = consome;
    }

    public String getM_atual() {
        return m_atual;
    }

    public void setM_atual(String m_atual) {
        this.m_atual = m_atual;
    }

    public String getM_proximo() {
        return m_proximo;
    }

    public void setM_proximo(String m_proximo) {
        this.m_proximo = m_proximo;
    }

    public String getM_consome() {
        return m_consome;
    }

    public void setM_consome(String m_consome) {
        this.m_consome = m_consome;
    }

    public String getM_word() {
        return m_word;
    }

    public void setM_word(String m_word) {
        this.m_word = m_word;
    }
    
}
