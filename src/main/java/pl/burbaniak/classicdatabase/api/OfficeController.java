package pl.burbaniak.classicdatabase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Office;
import pl.burbaniak.classicdatabase.dto.OfficeDto;
import pl.burbaniak.classicdatabase.manager.OfficeManager;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/office-srv")
public class OfficeController {

    private OfficeManager officeManager;

    @Autowired
    public OfficeController(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    @GetMapping("/offices/{officeCode}")
    public ResponseEntity<Optional<OfficeDto>> findById(@PathVariable Long officeCode){
        return new ResponseEntity<>(officeManager.findById(officeCode), HttpStatus.OK);
    }

    @PostMapping("/offices")
    public ResponseEntity<Office> addOffice(@RequestBody Office office){
        return new ResponseEntity<>(officeManager.addOffice(office),HttpStatus.OK);
    }

    @RequestMapping("/offices")
    public ResponseEntity<List<OfficeDto>> getAll(){
        return  new ResponseEntity<>(officeManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/offices")
    public ResponseEntity<Long> deleteOfficeByOfficeCode(@PathParam("officeCode") Long officeCode){
        officeManager.deleteOffice(officeCode);
        return new ResponseEntity<>(officeCode,HttpStatus.OK);
    }
}
