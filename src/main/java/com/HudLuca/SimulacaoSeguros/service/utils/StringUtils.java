package com.HudLuca.SimulacaoSeguros.service.utils;

import org.stringtemplate.v4.ST;

public class StringUtils {

    public static String getSTIdNaoEncontrado(String nomeOBJ, String pronome, Long idOBJ, String classeOBJ) {
        ST template = new ST("<nomeOBJString> não encontrad<pronome>! id: <idOBJ>. Tipo: <nomeClasseOBJ>");
        template.add("nomeOBJString", nomeOBJ);
        template.add("idOBJ", idOBJ);
        template.add("pronome", pronome);
        template.add("nomeClasseOBJ", classeOBJ);

        return template.render();
    }
}
