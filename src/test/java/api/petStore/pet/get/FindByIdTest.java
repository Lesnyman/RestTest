package api.petStore.pet.get;

import api.petStore.CommonApiOperations;
import api.petStore.pet.DefaultPetBody;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindByIdTest implements DefaultPetBody {

    @Before
    public void addPet() {
        CommonApiOperations.postPet(defaultPetBody)
                .get()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTest() {
        ValidatableResponse value = CommonApiOperations.getPetById(defaultPetId).get()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("doggie"));
        long id = value.extract().body().jsonPath().getLong("id");
        assertThat("Wrong ID in response", id, is(defaultPetId));
    }

}
