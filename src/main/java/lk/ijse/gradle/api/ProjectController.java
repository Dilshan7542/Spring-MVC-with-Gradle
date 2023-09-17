package lk.ijse.gradle.api;

import lk.ijse.gradle.dto.ProjectDTO;
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
        return new ResponseUtil("202","Successfully",projectService.saveProject(projectDTO));
    }
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveProject(@ModelAttribute ProjectDTO projectDTO){
        return new ResponseUtil("202","Successfully",projectService.saveProject(projectDTO));
    }
}
