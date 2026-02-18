package org.spring.impiegati.service;

import static org.spring.impiegati.mapper.MapperImpiegato.*;
import org.spring.impiegati.dto.ImpiegatoDTO;
import org.spring.impiegati.dto.NomeCognomeDTO;
import org.spring.impiegati.entity.Impiegato;
import org.spring.impiegati.mapper.MapperImpiegato;
import org.spring.impiegati.repository.DAOImpiegato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class ImpiegatoServiceImpl implements ImpiegatoService{

    @Autowired
    DAOImpiegato dao;


    @Override
    public void assumi(ImpiegatoDTO dto) {
        if(dao.findById(dto.getMatricola()).isEmpty()){
            dao.save(ImpiegatoDtoEntity(dto));
        }
    }

    @Override
    public ImpiegatoDTO cercaPerMatricola(int matricola) {
        if(dao.findById(matricola).isPresent()){
            return ImpiegatoEntityDto(dao.findById(matricola).get());
        }
        return null;
    }

    @Override
    public List<ImpiegatoDTO> visualizzaTutti() {
        return dao.findAll().stream()
                .map(MapperImpiegato::ImpiegatoEntityDto)
                .toList();
    }

    @Override
    public ImpiegatoDTO cancellaPerMatricola(int matricola) {
        if(dao.findById(matricola).isPresent()){
            Impiegato impiegato = dao.findById(matricola).get();
            dao.deleteById(matricola);
            return ImpiegatoEntityDto(impiegato);
        }
        return null;
    }

    @Override
    public ImpiegatoDTO modificaSalario(int matricola, double nuovoSalario) {
        if(dao.findById(matricola).isPresent()){
            Impiegato impiegato = dao.findById(matricola).get();
            impiegato.setSalario(nuovoSalario);
            return ImpiegatoEntityDto(impiegato);
        }
        return null;
    }

    @Override
    public NomeCognomeDTO cancellaConNomeCognome(int matricola) {
        if(dao.findById(matricola).isPresent()){
            Impiegato impiegato = dao.findById(matricola).get();
            dao.deleteById(matricola);
            return new NomeCognomeDTO(impiegato.getNome(), impiegato.getCognome());
        }
        return null;
    }

    @Override
    public List<NomeCognomeDTO> visualizzaOrdinatiMatricola() {
        return dao.findAll().stream()
                .sorted(Comparator.comparingInt(Impiegato::getMatricola))
                .map(i -> new NomeCognomeDTO(i.getNome(), i.getCognome()))
                .toList();
    }

    @Override
    public double visualizzaTotSalarioMese() {
        return dao.findAll().stream()
                .mapToDouble(Impiegato::getSalario)
                .reduce(0, Double::sum);
    }

    @Override
    public List<ImpiegatoDTO> visualizzaOrdinatiCognome() {
        return dao.findAll().stream()
                .sorted(Comparator.comparing(Impiegato::getCognome))
                .map(MapperImpiegato::ImpiegatoEntityDto)
                .toList();
    }

    @Override
    public ImpiegatoDTO visualizzaAssunzionePiuVecchia() {
        return dao.findAll().stream()
                .min(Comparator.comparing(Impiegato::getDataAssunzione))
                .map(MapperImpiegato::ImpiegatoEntityDto)
                .orElse(null);
    }

    @Override
    public ImpiegatoDTO visualizzaSalarioMaggioreDatoTempo(LocalDate data) {
        return dao.findAll().stream()
                .filter(i -> i.getDataAssunzione().isAfter(data))
                .max(Comparator.comparingDouble(Impiegato::getSalario))
                .map(MapperImpiegato::ImpiegatoEntityDto)
                .orElse(null);
    }
}
