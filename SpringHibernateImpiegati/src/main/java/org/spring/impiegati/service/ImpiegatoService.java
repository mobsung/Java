package org.spring.impiegati.service;

import org.spring.impiegati.dto.ImpiegatoDTO;
import org.spring.impiegati.dto.NomeCognomeDTO;
import org.spring.impiegati.entity.Impiegato;

import java.time.LocalDate;
import java.util.List;

public interface ImpiegatoService {

    void assumi(ImpiegatoDTO dto);

    ImpiegatoDTO cercaPerMatricola(int matricola);

    List<ImpiegatoDTO> visualizzaTutti();

    ImpiegatoDTO cancellaPerMatricola(int matricola);

    ImpiegatoDTO modificaSalario(int matricola, double nuovoSalario);

    NomeCognomeDTO cancellaConNomeCognome(int matricola);

    List<NomeCognomeDTO> visualizzaOrdinatiMatricola();

    double visualizzaTotSalarioMese();

    List<ImpiegatoDTO> visualizzaOrdinatiCognome();

    ImpiegatoDTO visualizzaAssunzionePiuVecchia();

    ImpiegatoDTO visualizzaSalarioMaggioreDatoTempo(LocalDate data);

    List<ImpiegatoDTO> getImpiegatiOrdinatiNome();

    List<ImpiegatoDTO> getImpiegatoSalarioMaggiore();
}
