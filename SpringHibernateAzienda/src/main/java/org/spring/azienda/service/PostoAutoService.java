package org.spring.azienda.service;

import org.spring.azienda.dto.PostoAutoDTO;

import java.util.List;

public interface PostoAutoService {

    void inserisciPostoAuto(PostoAutoDTO dto);

    List<PostoAutoDTO> selectAll();

    PostoAutoDTO selectPostoAutoById(int id);

    PostoAutoDTO deletePostoAuto(int id);

}
