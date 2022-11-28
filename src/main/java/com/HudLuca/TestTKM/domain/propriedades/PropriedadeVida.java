package com.HudLuca.TestTKM.domain.propriedades;


import com.HudLuca.TestTKM.domain.GerenciadorArquivo;
import com.HudLuca.TestTKM.domain.enums.ConsumoDrogas;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_propriedade_vida")
@JsonTypeName("propriedadeVida")
public class PropriedadeVida extends Propriedade {

    private String praticaEsportesRadicais;
    private Integer idade;
    private Double valorAReceber;
    @OneToMany
    private List<GerenciadorArquivo> atestadoDeSaude = new ArrayList<>();
    private String sexo;
    @ElementCollection
    @CollectionTable(name = "tb_consumo_drogas")
    private List<Integer> consumoDrogas;
    private String trabalho;

    public PropriedadeVida() {
    }

    public PropriedadeVida(int quantidade,
                           String praticaEsportesRadicais, Integer idade,
                           Double valorAReceber, String sexo, String trabalho) {
        super(null, quantidade);
        this.praticaEsportesRadicais = praticaEsportesRadicais;
        this.idade = idade;
        this.valorAReceber = valorAReceber;
        this.sexo = sexo;
        this.trabalho = trabalho;
    }

    public PropriedadeVida(Long id, int quantidade,
                           String praticaEsportesRadicais, Integer idade,
                           Double valorAReceber, String sexo, String trabalho) {
        super(id, null, quantidade);
        this.praticaEsportesRadicais = praticaEsportesRadicais;
        this.idade = idade;
        this.valorAReceber = valorAReceber;
        this.sexo = sexo;
        this.trabalho = trabalho;
    }

    public String getPraticaEsportesRadicais() {
        return praticaEsportesRadicais;
    }

    public void setPraticaEsportesRadicais(String praticaEsportesRadicais) {
        this.praticaEsportesRadicais = praticaEsportesRadicais;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<GerenciadorArquivo> getAtestadoDeSaude() {
        return atestadoDeSaude;
    }

    public void setAtestadoDeSaude(List<GerenciadorArquivo> atestadoDeSaude) {
        this.atestadoDeSaude = atestadoDeSaude;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<String> getConsumoDrogas() {
        List<String> consumoDrogasList = new ArrayList<>();
        for (Integer x : this.consumoDrogas) {
            consumoDrogasList.add(ConsumoDrogas.toEnum(x).getDescricao());
        }
        return consumoDrogasList;
    }

    public void setConsumoDrogas(ConsumoDrogas... consumoDrogas) {
        List<Integer> consumoDrogasList = new ArrayList<>();
        for (ConsumoDrogas x : consumoDrogas) {
            consumoDrogasList.add(x.getCd());
        }
        this.consumoDrogas = consumoDrogasList;
    }

    public String getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    @Override
    public void valorAnual() {

    }
}
