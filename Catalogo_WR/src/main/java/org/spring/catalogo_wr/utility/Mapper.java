package org.spring.catalogo_wr.utility;

import org.spring.catalogo_wr.dto.ProdottoDTO;
import org.spring.catalogo_wr.entity.Prodotto;

public class Mapper {

    public static Prodotto ProdottoDtoEntity(ProdottoDTO dto){
        if (dto == null) return null;
        Prodotto prodotto = new Prodotto(
                dto.quantita(),
                dto.prezzo(),
                dto.nome(),
                dto.versione()
        );
        prodotto.setId(dto.id());
        return prodotto;
    }

    public static ProdottoDTO ProdottoEntityDto(Prodotto prodotto){
        if (prodotto == null) return null;
        return new ProdottoDTO(
                prodotto.getId(),
                prodotto.getNome(),
                prodotto.getPrezzo(),
                prodotto.getQuantita(),
                prodotto.getVersione()
        );
    }

}
