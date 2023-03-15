package ai.lentra.config.dbconfig;

import ai.lentra.modal.lookups.CustomLookupTable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CustomTableService {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<CustomLookupTable> findAll(){
//        return entityManager.createQuery("from CustomLookupTable", CustomLookupTable.class).getResultList();
//
//    }
}
