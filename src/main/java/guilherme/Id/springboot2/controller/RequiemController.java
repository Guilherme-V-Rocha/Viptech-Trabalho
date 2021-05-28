package guilherme.Id.springboot2.controller;
import guilherme.Id.springboot2.domain.Requiem;
import guilherme.Id.springboot2.service.RequiemService;
import guilherme.Id.springboot2.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("requiems")
@Log4j2
@RequiredArgsConstructor
public class RequiemController {

    private final DateUtil dateUtil;
    private final RequiemService requiemService;

    //localhost:8080/requiems/list
    @GetMapping
    public ResponseEntity<List<Requiem>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(requiemService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Requiem> findById(@PathVariable long id){
        return ResponseEntity.ok(requiemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Requiem> save(@RequestBody Requiem requiem){
        return new ResponseEntity<>(RequiemService.save(requiem), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        requiemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Requiem requiem){
        requiemService.replace(requiem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
