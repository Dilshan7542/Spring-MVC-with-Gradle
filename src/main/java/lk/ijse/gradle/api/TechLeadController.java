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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseUtil saveTechLead(@RequestBody TechLeadDTO techLeadDTO){
        System.out.println("JSON");
        return new ResponseUtil("202","Successfully",techLeadService.saveTechLead(techLeadDTO));
    }
    @GetMapping(path = "search",params = "id",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseUtil searchTechLead(@RequestParam String id){
        return new ResponseUtil("202","Successfully",techLeadService.searchTechLead(id));
    }
}
