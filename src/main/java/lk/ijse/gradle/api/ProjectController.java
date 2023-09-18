package lk.ijse.gradle.api;

import lk.ijse.gradle.dto.ProjectDTO;
import lk.ijse.gradle.dto.TechLeadDTO;
import lk.ijse.gradle.service.ProjectService;
import lk.ijse.gradle.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveProjectJson(@RequestBody ProjectDTO projectDTO){
        System.out.println("Json");
        return new ResponseUtil("202","Successfully",projectService.saveProject(projectDTO));
    }
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,params = "techLeadID")
    public ResponseUtil saveProject(@ModelAttribute ProjectDTO projectDTO,@RequestParam String techLeadID){
        System.out.println(techLeadID);
        projectDTO.setTechLead(new TechLeadDTO(techLeadID));
        return new ResponseUtil("202","Successfully",projectService.saveProject(projectDTO));
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateProject(@RequestBody ProjectDTO projectDTO){
        return new ResponseUtil("202","Successfully",projectService.updateProject(projectDTO));
    }
    @GetMapping(path = "search",params = "projectID")
    public ResponseUtil searchProject(@RequestParam String projectID){
        return new ResponseUtil("202","Successfully",projectService.searchProject(projectID));
    }
    @GetMapping
    public ResponseUtil getAllProject(){
        return new ResponseUtil("202","Successfully",projectService.getAllProject());
    }
    @DeleteMapping(path = "delete",params = "projectID")
    public ResponseUtil deleteProject(@RequestParam String projectID){
        projectService.deleteProject(projectID);
        return new ResponseUtil("202","Successfully",null);
    }

}
