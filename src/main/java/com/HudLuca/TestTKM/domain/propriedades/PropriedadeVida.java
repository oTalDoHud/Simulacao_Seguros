package com.HudLuca.TestTKM.domain.propriedades;


import com.HudLuca.TestTKM.domain.GerenciadorArquivo;
import com.HudLuca.TestTKM.domain.enums.ConsumoDrogasEnum;
import com.HudLuca.TestTKM.domain.enums.PraticaEsportesRadicaisEnum;
import com.HudLuca.TestTKM.domain.enums.TipoTrabalhoEnum;
import com.HudLuca.TestTKM.domain.enums.ValoAReceberSeguroVidaEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_propriedade_vida")
@JsonTypeName("propriedadeVida")
public class PropriedadeVida extends Propriedade {

    @ElementCollection
    @CollectionTable(name = "tb_pratica_esportes_radicais")
    private List<Integer> praticaEsportesRadicais = new ArrayList<>();
    private Integer valorAReceber;
    @OneToMany
    private List<GerenciadorArquivo> atestadoDeSaude = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "tb_consumo_drogas")
    private List<Integer> consumoDrogas = new ArrayList<>();
    private Integer trabalho;

    public PropriedadeVida() {
    }

    public PropriedadeVida(ValoAReceberSeguroVidaEnum valorAReceber, TipoTrabalhoEnum trabalho) {
        super(null, 1);
        this.valorAReceber = (valorAReceber == null) ? null : valorAReceber.getCd();
        this.trabalho = (trabalho == null) ? null : trabalho.getCd();
    }

    public PropriedadeVida(Long id, ValoAReceberSeguroVidaEnum valorAReceber, TipoTrabalhoEnum trabalho) {
        super(id, null, 1);
        this.valorAReceber = (valorAReceber == null) ? null : valorAReceber.getCd();
        this.trabalho = (trabalho == null) ? null : trabalho.getCd();
    }

    public List<String> getPraticaEsportesRadicaisDescricao() {
        List<String> praticaEsportesRadicais = new ArrayList<>();
        for (Integer x : this.praticaEsportesRadicais) {
            praticaEsportesRadicais.add(PraticaEsportesRadicaisEnum.toEnum(x).getDescricao());
        }
        return praticaEsportesRadicais;
    }

    @JsonIgnore
    public List<Integer> getPraticaEsportesRadicais() {
        return praticaEsportesRadicais;
    }

    public void setPraticaEsportesRadicais(List<Integer> praticaEsportesRadicais) {
        this.praticaEsportesRadicais = praticaEsportesRadicais;
    }

    public String getValorAReceberDescricao() {
        return ValoAReceberSeguroVidaEnum.toEnum(valorAReceber).getDescricao();
    }

    @JsonIgnore
    public ValoAReceberSeguroVidaEnum getValorAReceber() {
        return ValoAReceberSeguroVidaEnum.toEnum(valorAReceber);
    }

    public void setValorAReceber(ValoAReceberSeguroVidaEnum valorAReceber) {
        this.valorAReceber = valorAReceber.getCd();
    }

    public List<GerenciadorArquivo> getAtestadoDeSaude() {
        return atestadoDeSaude;
    }

    public void setAtestadoDeSaude(List<GerenciadorArquivo> atestadoDeSaude) {
        this.atestadoDeSaude = atestadoDeSaude;
    }

    public List<String> getConsumoDrogasDescricao() {
        List<String> consumoDrogasList = new ArrayList<>();
        for (Integer x : this.consumoDrogas) {
            consumoDrogasList.add(ConsumoDrogasEnum.toEnum(x).getDescricao());
        }
        return consumoDrogasList;
    }

    @JsonIgnore
    public List<Integer> getConsumoDrogas() {
        return consumoDrogas;
    }

    public void setConsumoDrogas(List<Integer> consumoDrogas) {
        this.consumoDrogas = consumoDrogas;
    }

    public String getTrabalhoDescricao() {
        return TipoTrabalhoEnum.toEnum(trabalho).getDescricao();
    }

    @JsonIgnore
    public TipoTrabalhoEnum getTrabalho() {
        return TipoTrabalhoEnum.toEnum(trabalho);
    }

    public void setTrabalho(TipoTrabalhoEnum trabalho) {
        this.trabalho = trabalho.getCd();
    }

}
