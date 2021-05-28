package guilherme.Id.springboot2.service;

import guilherme.Id.springboot2.domain.Requiem;
import guilherme.Id.springboot2.repository.RequiemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RequiemService {
    private  static List<Requiem>  requiems;
    static{
        requiems = new ArrayList<>(List.of(new Requiem( 1L, "Berserk"), new Requiem(2L,"SAO")));
    }
    public static Requiem save(Requiem requiem) {
        requiem.setId(ThreadLocalRandom.current().nextLong(3,100000));
        requiems.add(requiem);
        return requiem;
    }

    public List<Requiem> listAll(){
        return requiems;
    }

    public Requiem findById(long id){
        return requiems.stream()
                .filter(requiem -> requiem.getId().equals(id))
                .findFirst()
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not Found Requiem"));
    }

    public void delete(long id) {
        requiems.remove(findById(id));
    }

    public void replace(Requiem requiem) {
        delete(requiem.getId());
        requiems.add(requiem);
    }
}
