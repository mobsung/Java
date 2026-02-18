package org.spring.impiegati.mapper;

import org.spring.impiegati.dto.ImpiegatoDTO;
import org.spring.impiegati.entity.Impiegato;

public class MapperImpiegato {

    public static Impiegato ImpiegatoDtoEntity(ImpiegatoDTO dto){
        return new Impiegato(
                dto.getMatricola(),
                dto.getNome(),
                dto.getCognome(),
                dto.getSalario(),
                dto.getDataAssunzione()
        );
    }

    public static ImpiegatoDTO ImpiegatoEntityDto(Impiegato impiegato){
        return new ImpiegatoDTO(
                impiegato.getMatricola(),
                impiegato.getNome(),
                impiegato.getCognome(),
                impiegato.getSalario(),
                impiegato.getDataAssunzione()
        );
    }

}
