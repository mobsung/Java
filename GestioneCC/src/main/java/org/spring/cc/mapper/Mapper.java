package org.spring.cc.mapper;

import org.spring.cc.dto.ContoCorrenteDTO;
import org.spring.cc.dto.IndirizzoDTO;
import org.spring.cc.dto.MovimentoDTO;
import org.spring.cc.dto.UtenteDTO;
import org.spring.cc.entity.ContoCorrente;
import org.spring.cc.entity.Indirizzo;
import org.spring.cc.entity.Movimento;
import org.spring.cc.entity.Utente;

public class Mapper {

    public static Indirizzo DTOtoIndirizzo(IndirizzoDTO dto){
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setIndirizzo(dto.indirizzo());
        indirizzo.setCap(dto.cap());
        indirizzo.setCitta(dto.citta());
        indirizzo.setProvincia(dto.provincia());
        indirizzo.setVia(dto.via());
        return indirizzo;
    }

    public static IndirizzoDTO IndirizzoToDTO(Indirizzo en){
        return new IndirizzoDTO(
                en.getIndirizzo(),
                en.getVia(),
                en.getCap(),
                en.getCitta(),
                en.getProvincia()
        );
    }

    public static Utente DTOtoUtente(UtenteDTO dto){
        Utente utente = new Utente();
        utente.setIdUtente(dto.idUtente());
        utente.setNome(dto.nome());
        utente.setCognome(dto.cognome());
        utente.setMail(dto.mail());
        utente.setTelefono(dto.telefono());
        utente.setIndirizzo(dto.indirizzo());
        return utente;
    }

    public static UtenteDTO UtenteToDTO(Utente en){
        return new UtenteDTO(
                en.getIdUtente(),
                en.getNome(),
                en.getCognome(),
                en.getMail(),
                en.getTelefono(),
                en.getIndirizzo()
        );
    }

    public static ContoCorrente DTOtoCC(ContoCorrenteDTO dto){
        ContoCorrente cc = new ContoCorrente();
        cc.setNumeroConto(dto.numeroConto());
        cc.setSaldo(dto.saldo());
        cc.setDataApertura(dto.dataApertura());
        cc.setIntestatario(dto.intestatario());
        cc.setCoIntestatario(dto.coIntestatario());
        cc.setMovimenti(dto.movimenti());
        return cc;
    }

    public static ContoCorrenteDTO CCtoDTO(ContoCorrente en){
        return new ContoCorrenteDTO(
                en.getNumeroConto(),
                en.getSaldo(),
                en.getDataApertura(),
                en.getIntestatario(),
                en.getCoIntestatario(),
                en.getMovimenti()
        );
    }

    public static Movimento DTOtoMovimento(MovimentoDTO dto){
        return new Movimento(
                DTOtoUtente(dto.operatore()),
                dto.dataOperazione(),
                dto.importo(),
                dto.tipo(),
                dto.idMovimento()
        );
    }

    public static MovimentoDTO MovimentoToDTO(Movimento en){
        return new MovimentoDTO(
                en.getIdMovimento(),
                en.getTipo(),
                en.getImporto(),
                en.getDataOperazione(),
                UtenteToDTO(en.getOperatore())
        );
    }

}
