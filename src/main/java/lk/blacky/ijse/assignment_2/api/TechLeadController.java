package lk.blacky.ijse.assignment_2.api;

import lk.blacky.ijse.assignment_2.dto.TechLeadDto;
import lk.blacky.ijse.assignment_2.util.ResponseUtil;
import lk.blacky.ijse.assignment_2.service.impl.TechLeadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tl")
public class TechLeadController {

    private final TechLeadServiceImpl tlService;

    @Autowired
    public TechLeadController(TechLeadServiceImpl tlService) {
        this.tlService = tlService;
    }

    @PostMapping
    public ResponseEntity<ResponseUtil> saveTL(@RequestBody TechLeadDto techLeadDto){
        TechLeadDto add = tlService.add(techLeadDto);
        return new ResponseEntity<>((
                new ResponseUtil(201,"TL Saved",add)),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ResponseUtil> searchTL(@RequestParam UUID id){
        TechLeadDto search = tlService.search(id);
        return new ResponseEntity<>((
                new ResponseUtil(200,"TL Searched",search)),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<ResponseUtil> updateTL(@RequestBody TechLeadDto techLeadDto){
        TechLeadDto update = tlService.update(techLeadDto);
        return new ResponseEntity<>((
                new ResponseUtil(200,"TL Updated",update)),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping
    public ResponseEntity<ResponseUtil> deleteTL(@RequestParam UUID id){
        boolean delete = tlService.delete(id);
        return new ResponseEntity<>((
                new ResponseUtil(204,"TL Deleted",delete)),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseUtil> getAllTL(){
        List<TechLeadDto> all = tlService.getAll();
        return new ResponseEntity<>((
                new ResponseUtil(200,"All TLs",all)),
                HttpStatus.OK
        );
    }

}
