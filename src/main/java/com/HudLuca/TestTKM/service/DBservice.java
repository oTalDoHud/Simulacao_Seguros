package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.*;
import com.HudLuca.TestTKM.domain.enums.ConsumoDrogas;
import com.HudLuca.TestTKM.domain.enums.TempoHabilitacao;
import com.HudLuca.TestTKM.domain.enums.TipoCliente;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.HudLuca.TestTKM.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBservice {

    @Autowired
    private PropriedadeRepository propriedadeRepository;
    @Autowired
    private SeguroRepository seguroRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private GerenciadorArquivoRepository gerenciadorArquivoRepository;

    public void instanciandoBancoDeDados() throws ParseException {

        //CIDADES E ESTADOS
        Estado estadoSP = new Estado("São Paulo");
        Estado estadoMG = new Estado("Minas Gerais");

        Cidade cidadeUber = new Cidade("Uberlândia", estadoMG);
        Cidade cidadeSP = new Cidade("São Paulo", estadoSP);
        Cidade cidadeCampinas = new Cidade("Campinas", estadoSP);

        estadoMG.getCidades().add(cidadeUber);
        estadoSP.getCidades().addAll(Arrays.asList(cidadeSP, cidadeCampinas));

        estadoRepository.saveAll(Arrays.asList(estadoSP, estadoMG));
        cidadeRepository.saveAll(Arrays.asList(cidadeUber, cidadeSP, cidadeCampinas));

        Cliente clienteHudson = new Cliente("Hudson Lucas Teles Vieira",
                "Hudson@gmail.com", "52840256010", TipoCliente.PESSOA_FISICA);

        Cliente clienteLarissa = new Cliente("Larissa Bertoldo Santos",
                "Larissa@gmail.com", "40530720000", TipoCliente.PESSOA_FISICA);

        Cliente clienteGabriel = new Cliente("Gabriel Henrique Teles Vieira",
                "Gabriel@gmail.com", "79027285004", TipoCliente.PESSOA_FISICA);

        Cliente clienteArgus = new Cliente("Argus Sec",
                "Argus@gmail.com", "66654230000", TipoCliente.PESSOA_JURIDICA);

        clienteHudson.getTelefones().addAll(Arrays.asList("933350-8032", "192858-2673"));
        clienteLarissa.getTelefones().addAll(Arrays.asList("183612-2406", "113167-1477"));
        clienteGabriel.getTelefones().addAll(Arrays.asList("193138-6888", "173012-3616"));
        clienteArgus.getTelefones().addAll(Arrays.asList("172598-9250", "152726-1812"));

        Endereco enderecoRuaFlores = new Endereco("Rua Flores", "300", "apto 203", "Jardim Helena", "3838092", clienteHudson, cidadeUber);
        Endereco enderecoAvenidaMatos = new Endereco("Avenida Maria Quitéria", "105", "sala 80", "Trem", "68901060", clienteGabriel, cidadeSP);
        Endereco enderecoEspiritoSanto = new Endereco("Espírito Santo", "85", "apto 32 bloco c", "guaianases", "69035580", clienteLarissa, cidadeSP);
        Endereco enderecoOtorrino = new Endereco("Rua Ana Bezerra", "965", "sala 24", "Joaquim Távora", "60130175", clienteArgus, cidadeUber);

        clienteHudson.getEnderecos().addAll(Arrays.asList(enderecoRuaFlores, enderecoAvenidaMatos,
                enderecoEspiritoSanto, enderecoOtorrino));

        clienteLarissa.getEnderecos().addAll(Arrays.asList(enderecoOtorrino));

        clienteGabriel.getEnderecos().addAll(Arrays.asList(enderecoEspiritoSanto, enderecoAvenidaMatos));

        clienteArgus.getEnderecos().addAll(Arrays.asList(enderecoAvenidaMatos,
                enderecoEspiritoSanto, enderecoOtorrino));

        clienteRepository.saveAll(Arrays.asList(clienteHudson, clienteLarissa, clienteGabriel,
                clienteArgus));

        enderecoRepository.saveAll(Arrays.asList(enderecoRuaFlores, enderecoAvenidaMatos,
                enderecoEspiritoSanto, enderecoOtorrino));

        //PROPRIEDADES AUTOMOVEL

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Automovel automovel1 = new Automovel("Automóvel Hudson - contrato completo feito em x lugar", 35000.00, 1,
                "KAG2519", "Civic 2017", "Honda", sdf.parse("12/03/2018"),
                2, "m", 40000.00, TempoHabilitacao.MEDIANO);

        Automovel automovel2 = new Automovel("Seguro Larissa - feito por terceiros", 159000.00, 1,
                "LXA9907", "Civic 2017", "Mitsubishi", sdf.parse("04/12/2018"),
                2, "m", 40000.00, TempoHabilitacao.NOVATO);

        Automovel automovel3 = new Automovel("Seguro Gabriel", 35000.00, 1,
                "NEB4099", "audi r8", "Audi", sdf.parse("13/01/2018"),
                2, "m", 40000.00, TempoHabilitacao.EXPERIENTE);

        Automovel automovel4 = new Automovel("Seguro argus", 35000.00, 1,
                "JAS1485", "Tesla model 3", "Tesla", sdf.parse("17/06/2018"),
                2, "m", 40000.00, TempoHabilitacao.MEDIANO);


        propriedadeRepository.saveAll(Arrays.asList(automovel1, automovel2, automovel3, automovel4));

        //PROPRIEDADE VIDA E ATESTADO DE SAUDE
        GerenciadorArquivo atestadoSaudeHudson = new GerenciadorArquivo(clienteHudson, new Date(),
                "AtestadoSaudeHudson.pdf", "servidor/Documentos/AtestadoSaudeHudson.pdf");
        PropriedadeVida propriedadeVida1 = new PropriedadeVida(1,
                "Não pratica", 35, 50000.000,
                "Masculino", "Trabalho como desenvolvedor");
        propriedadeVida1.getAtestadoDeSaude().addAll(Arrays.asList(atestadoSaudeHudson));
        propriedadeVida1.setConsumoDrogas(ConsumoDrogas.ALCOOL, ConsumoDrogas.MEDICAMENTOS_RECORRENTES);

        GerenciadorArquivo atestadoSaudeGabriel = new GerenciadorArquivo(clienteGabriel, new Date(),
                "AtestadoSaudeGabriel.pdf", "servidor/Documentos/AtestadoSaudeGabriel.pdf");
        PropriedadeVida propriedadeVida2 = new PropriedadeVida(1,
                "Pratica", 19, 25000.00,
                "Masculino", "Trabalho como paraquedista");
        propriedadeVida2.getAtestadoDeSaude().addAll(Arrays.asList(atestadoSaudeGabriel));
        propriedadeVida2.setConsumoDrogas(ConsumoDrogas.MACONHA);

        gerenciadorArquivoRepository.saveAll(Arrays.asList(atestadoSaudeHudson, atestadoSaudeGabriel));
        propriedadeRepository.saveAll(Arrays.asList(propriedadeVida1, propriedadeVida2));


        //SEGUROS
        Seguro seguroAutomovel1 = new Seguro("Seguro automovel 01", clienteHudson, automovel1);
        Seguro seguroAutomovel2 = new Seguro("Seguro automovel 02", clienteGabriel, automovel2);
        Seguro seguroAutomovel3 = new Seguro("Seguro automovel 03", clienteLarissa, automovel3);
        Seguro seguroAutomovel4 = new Seguro("Seguro automovel 04", clienteArgus, automovel4);

        Seguro seguroDeVida5 = new Seguro("Seguro de vida 01", clienteHudson, propriedadeVida1);
        Seguro seguroDeVida6 = new Seguro("Seguro de vida 02", clienteGabriel, propriedadeVida2);

        seguroAutomovel1.addCoberturas(1, 2, 3);
        seguroAutomovel2.addCoberturas(1, 4, 5);
        seguroAutomovel3.addCoberturas(1, 1, 1, 4, 3);
        seguroAutomovel4.addCoberturas(6);

        seguroDeVida5.addCoberturas(1, 3, 4);
        seguroDeVida6.addCoberturas(1, 2, 4);
        seguroRepository.saveAll(Arrays.asList(
                seguroAutomovel1, seguroAutomovel2, seguroAutomovel3,
                seguroAutomovel4, seguroDeVida5, seguroDeVida6
        ));
    }
}
