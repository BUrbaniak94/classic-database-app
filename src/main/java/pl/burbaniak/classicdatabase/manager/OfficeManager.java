package pl.burbaniak.classicdatabase.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.OfficeRepo;
import pl.burbaniak.classicdatabase.dao.entity.Office;
import pl.burbaniak.classicdatabase.dto.OfficeDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeManager {

    private OfficeRepo officeRepo;

    @Autowired
    public OfficeManager(OfficeRepo officeRepo) {
        this.officeRepo = officeRepo;
    }

    public List<OfficeDto> findAll(){
        return officeRepo.findAll()
                .stream()
                .map(OfficeDto::from)
                .collect(Collectors.toList());
    }

    public Optional<OfficeDto> findById(Long id){
        return officeRepo.findById(id).map(OfficeDto::from);
    }
    public Office addOffice (Office office){
        return officeRepo.save(office);
    }
    public void deleteOffice (Long id){
        officeRepo.deleteById(id);
    }
}
