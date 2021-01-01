package br.suite.honra.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCACAO")
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_LOCACAO")
    private Long idLocacao;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "LAT")
    private String lat;
    @Column(name = "LNG")
    private String lng;
    @Column(name = "ID_BAIRRO")
    private Long idBairro;
    @Column(name = "ATIVO")
    private short ativo;

    /**
     * @return the idLocacao
     */
    public Long getIdLocacao() {
        return idLocacao;
    }

    /**
     * @param idLocacao the idLocacao to set
     */
    public void setIdLocacao(Long idLocacao) {
        this.idLocacao = idLocacao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return the idBairro
     */
    public Long getIdBairro() {
        return idBairro;
    }

    /**
     * @param idBairro the idBairro to set
     */
    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    /**
     * @return the ativo
     */
    public short getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(short ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Locacao [idLocacao=" + idLocacao + ", nome=" + nome + ", endereco=" + endereco + ", lat=" + lat + ", lng=" + lng
                + ", idBairro=" + idBairro + ", ativo=" + ativo + "]";
    }

}
