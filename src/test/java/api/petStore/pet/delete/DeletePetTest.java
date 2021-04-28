package api.petStore.pet.delete;

import api.petStore.CommonApiOperations;
import api.petStore.pet.DefaultPetBody;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;


public class DeletePetTest implements DefaultPetBody {
    @Before
    public void addPet(){
        CommonApiOperations.postPet(defaultPetBody)
                .get()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deletePet(){
        CommonApiOperations.deletePet(defaultPetId)
                .get()
                .statusCode(HttpStatus.SC_OK);
        CommonApiOperations.getPetById(defaultPetId)
                .get()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void deleteNotExisting(){
        CommonApiOperations.deletePet(defaultPetId)
                .get()
                .statusCode(HttpStatus.SC_OK);
        CommonApiOperations.deletePet(defaultPetId)
                .get()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
