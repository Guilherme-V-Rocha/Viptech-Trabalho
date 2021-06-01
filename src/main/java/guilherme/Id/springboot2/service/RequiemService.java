package guilherme.Id.springboot2.service;

import guilherme.Id.springboot2.domain.Requiem;
import guilherme.Id.springboot2.exception.BadRequestException;
import guilherme.Id.springboot2.repository.RequiemRepository;
import guilherme.Id.springboot2.request.RequiemPostRequestBody;
import guilherme.Id.springboot2.request.RequiemPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequiemService {

    private final RequiemRepository requiemRepository;

    public List<Requiem> listAll(){
        return requiemRepository.findAll();
    }

    public List<Requiem> findByName (String name){ return requiemRepository.findByName(name);}

    public Requiem findByIdOrThrowBadRequestException(long id){
        return requiemRepository.findById(id)
                .orElseThrow( () -> new BadRequestException("Id not Found Requiem"));
    }
    public Requiem save(RequiemPostRequestBody requiemPostRequestBody) {
        return requiemRepository.save(Requiem.builder().name(requiemPostRequestBody.getName()).build());
    }

    public void delete(long id) {
        requiemRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(RequiemPutRequestBody requiemPutRequestBody) {
        Requiem savedRequiem = findByIdOrThrowBadRequestException(requiemPutRequestBody.getId());
        Requiem requiem = Requiem.builder()
                .id(savedRequiem.getId())
                .name(requiemPutRequestBody.getName())
                .build();
        requiemRepository.save(requiem);
    }
}
