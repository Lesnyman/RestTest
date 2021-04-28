package api.petStore.pet.get;

import api.petStore.CommonApiOperations;
import api.petStore.pet.PetStatus;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.AbstractMap;

import static org.hamcrest.CoreMatchers.is;

public class FindByStatusTest {
    @Test
    public void getSold() {
        validateStatusCodeAndContentType(PetStatus.SOLD);
    }

    @Test
    public void getPending() {
        validateStatusCodeAndContentType(PetStatus.PENDING);
    }

    @Test
    public void getAvailable() {
        validateStatusCodeAndContentType(PetStatus.AVAILABLE);
    }

    @Test
    public void getNotExistingStatus() {
        CommonApiOperations.getPetByStatus(new AbstractMap.SimpleEntry<String, String>("status", "randomValue"))
                .get()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType("application/json")
                .body("size()", is(0));
    }

    private void validateStatusCodeAndContentType(PetStatus status){
        CommonApiOperations.getPetByStatus(status)
                .get()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json");
    }
}

