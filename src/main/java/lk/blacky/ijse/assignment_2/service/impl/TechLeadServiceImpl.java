package lk.blacky.ijse.assignment_2.service.impl;

import lk.blacky.ijse.assignment_2.dto.TechLeadDto;
import lk.blacky.ijse.assignment_2.entity.TechLead;
import lk.blacky.ijse.assignment_2.repo.TechLeadRepo;
import lk.blacky.ijse.assignment_2.service.TechLeadService;
import lk.blacky.ijse.assignment_2.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TechLeadServiceImpl implements TechLeadService {

    private final TechLeadRepo techLeadRepo;

    private final ModelMapper modelMapper;

    public TechLeadServiceImpl(TechLeadRepo techLeadRepo, ModelMapper modelMapper) {
        this.techLeadRepo = techLeadRepo;
        this.modelMapper = modelMapper;

    }

    @Override
    public TechLeadDto add(TechLeadDto techLeadDto) {
        try {
            TechLead save = techLeadRepo.save(modelMapper.map(techLeadDto, TechLead.class));
            return modelMapper.map(save, TechLeadDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(UUID uuid) {
        try {
            techLeadRepo.deleteById(uuid);
            return true;
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public TechLeadDto update(TechLeadDto techLeadDto) {
        try {
            if (techLeadRepo.existsById(techLeadDto.getTlId())) {
                TechLead save = techLeadRepo.save(modelMapper.map(techLeadDto, TechLead.class));
                return modelMapper.map(save, TechLeadDto.class);
            } else {
                throw new NotFoundException("TL not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public TechLeadDto search(UUID uuid) {
        try {
            Optional<TechLead> byId = techLeadRepo.findById(uuid);
            return modelMapper.map(byId, TechLeadDto.class);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<TechLeadDto> getAll() {
        return null;
    }
}
