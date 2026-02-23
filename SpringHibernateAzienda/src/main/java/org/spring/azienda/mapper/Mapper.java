package org.spring.azienda.mapper;

import org.spring.azienda.dto.AziendaDTO;
import org.spring.azienda.dto.DipendenteDTO;
import org.spring.azienda.dto.PostoAutoDTO;
import org.spring.azienda.entity.Azienda;
import org.spring.azienda.entity.Dipendente;
import org.spring.azienda.entity.PostoAuto;

public class Mapper {

    public static Azienda AziendaDtoEntity(AziendaDTO dto){
        Azienda azienda = new Azienda(
                dto.getCapitale(),
                dto.getIntestazione()
        );
        azienda.setId(dto.getId());
        return azienda;
    }

    public static AziendaDTO AziendaEntityDto(Azienda azienda){
        AziendaDTO dto = new AziendaDTO(
                azienda.getCapitale(),
                azienda.getIntestazione()
        );
        dto.setId(azienda.getId());
        return dto;
    }

    public static Dipendente DipendenteDtoEntity(DipendenteDTO dto){
        Dipendente dipendente = new Dipendente(
                dto.getSalario(),
                dto.getCognome(),
                dto.getNome()
        );
        dipendente.setMatricola(dto.getMatricola());
        return dipendente;
    }

    public static DipendenteDTO DipendenteEntityDto(Dipendente dipendente){
        DipendenteDTO dto = new DipendenteDTO(
                dipendente.getSalario(),
                dipendente.getCognome(),
                dipendente.getNome()
        );
        dto.setMatricola(dipendente.getMatricola());
        return dto;
    }

    public static PostoAuto PostoAutoDtoEntity(PostoAutoDTO dto){
        PostoAuto postoAuto = new PostoAuto(
                dto.getPosizione()
        );
        postoAuto.setId(dto.getId());
        return postoAuto;
    }

    public static PostoAutoDTO PostoAutoEntityDto(PostoAuto postoAuto){
        PostoAutoDTO dto = new PostoAutoDTO(
                postoAuto.getPosizione()
        );
        dto.setId(postoAuto.getId());
        return dto;
    }

}
