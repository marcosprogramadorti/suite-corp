package br.suite.honra.negocio.to;

import java.io.Serializable;

public class LocacaoTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long idLocacao;
    private String nome;
    private String endereco;
    private String lat;
    private String lng;
    private Long idBairro;
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

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
