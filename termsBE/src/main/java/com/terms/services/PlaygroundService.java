package com.terms.services;

import com.terms.DTO.PlaygroundDTO;
import com.terms.domen.Playground;
import com.terms.domen.Region;
import com.terms.repository.PlaygroundInfoRepository;
import com.terms.repository.PlaygroundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaygroundService {

    private PlaygroundInfoRepository playgroundInfoRepository;
    private PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository, PlaygroundInfoRepository playgroundInfoRepository)
    {
        this.playgroundInfoRepository = playgroundInfoRepository;
        this.playgroundRepository = playgroundRepository;

    }

    public PlaygroundDTO findOne(Long playgroundId){
        PlaygroundDTO playgroundDTO = new PlaygroundDTO();
        playgroundDTO.setPlaceInfos(playgroundInfoRepository.findByPlayground(playgroundId));
        playgroundDTO.setPlayground(playgroundRepository.findOne(playgroundId));

        return playgroundDTO;
    }
    public void delete(Playground playground){
        playgroundRepository.delete(playground);
    }

    public List<Playground> findAllPlaygroundByRegion(Region region){
            return playgroundRepository.findAllByRegion(region);
    }

}
