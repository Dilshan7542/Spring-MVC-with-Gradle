package lk.ijse.gradle.api;

import lk.ijse.gradle.dto.TechLeadDTO;
import lk.ijse.gradle.service.TechLeadService;
import lk.ijse.gradle.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/tech")
public class TechLeadController {
    @Autowired
    TechLeadService techLeadService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseUtil saveTechLead(@RequestBody TechLeadDTO techLeadDTO){
        return new ResponseUtil("202","Successfully",techLeadService.saveTechLead(techLeadDTO));
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,path = "image")
    public ResponseUtil saveTechLeadWithImage(
            @RequestPart String id,
            @RequestPart String name,
            @RequestPart String address,
            @RequestPart byte[] image
            ){
        return new ResponseUtil("202","Successfully",techLeadService.saveTechLead(new TechLeadDTO(id,name,address,image)));
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTechLead(@RequestBody TechLeadDTO techLeadDTO){
        return new ResponseUtil("202","Successfully",techLeadService.updateTechLead(techLeadDTO));
    }
    @GetMapping(path = "search",params = "id",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseUtil searchTechLead(@RequestParam String id){
        return new ResponseUtil("202","Successfully",techLeadService.searchTechLead(id));
    }
    @GetMapping
    public ResponseUtil getAllTechLead(){
        return new ResponseUtil("202","Successfully",techLeadService.getAllTechLead());
    }
    @DeleteMapping(path = "delete",params = "id")
    public ResponseUtil deleteTechLead(@RequestParam String id){
        techLeadService.deleteTechLead(id);
        return new ResponseUtil("202","Successfully",null);
    }
}
