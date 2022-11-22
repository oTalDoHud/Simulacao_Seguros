package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.*;
import com.HudLuca.TestTKM.domain.enums.TempoHabilitacao;
import com.HudLuca.TestTKM.domain.enums.TipoCliente;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.domain.propriedades.Propriedade;
import com.HudLuca.TestTKM.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

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

        //SEGUROS E PROPRIEDADES
//        Propriedade automovel1 = new Automovel()

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

        Seguro seguro1 = new Seguro("Seguro 01", clienteHudson, automovel1);
        Seguro seguro2 = new Seguro("Seguro 02", clienteGabriel, automovel2);
        Seguro seguro3 = new Seguro("Seguro 03", clienteLarissa, automovel3);
        Seguro seguro4 = new Seguro("Seguro 04", clienteArgus, automovel4);

        seguro1.getCoberturas().addAll(Arrays.asList(1, 2, 3));
        seguro2.getCoberturas().addAll(Arrays.asList(1, 4, 5));
        seguro3.getCoberturas().addAll(Arrays.asList(1, 8, 3));
        seguro4.getCoberturas().addAll(Arrays.asList(6));

        propriedadeRepository.saveAll(Arrays.asList(automovel1, automovel2, automovel3, automovel4));
        seguroRepository.saveAll(Arrays.asList(seguro1, seguro2, seguro3, seguro4));
    }
}
