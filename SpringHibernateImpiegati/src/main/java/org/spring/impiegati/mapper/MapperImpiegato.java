package org.spring.impiegati.mapper;

import org.spring.impiegati.dto.ImpiegatoDTO;
import org.spring.impiegati.entity.Impiegato;

public class MapperImpiegato {

    public static Impiegato ImpiegatoDtoEntity(ImpiegatoDTO dto){
        Impiegato impiegato = new Impiegato(
                dto.getNome(),
                dto.getCognome(),
                dto.getSalario(),
                dto.getDataAssunzione()
        );
        impiegato.setMatricola(dto.getMatricola());
        return impiegato;
    }

    public static ImpiegatoDTO ImpiegatoEntityDto(Impiegato impiegato){
        ImpiegatoDTO dto =  new ImpiegatoDTO(
                impiegato.getNome(),
                impiegato.getCognome(),
                impiegato.getSalario(),
                impiegato.getDataAssunzione()
        );
        dto.setMatricola(impiegato.getMatricola());
        return dto;
    }

}
