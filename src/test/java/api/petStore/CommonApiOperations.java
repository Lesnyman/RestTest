package api.petStore;

import api.petStore.pet.PetBody;
import api.petStore.pet.PetStatus;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.util.*;
import java.util.function.Supplier;

public final class CommonApiOperations {

    public static Supplier<ValidatableResponse> getPetByStatus(PetStatus status) {
        return getPetByStatus(new AbstractMap.SimpleEntry<String, String>("status", status.status));
    }

    public static Supplier<ValidatableResponse> getPetByStatus(AbstractMap.SimpleEntry<String, String> param) {
        return () -> RestAssured.given()
                .param(param.getKey(), param.getValue())
                .get(PetApiPath.GET_BY_STATUS.path)
                .then();
    }

    public static Supplier<ValidatableResponse> getPetById(long id) {
        return () -> RestAssured.given()
                .get(PetApiPath.GET_BY_ID.path + id)
                .then();
    }

    public static Supplier<ValidatableResponse> deletePet(long id) {
        return () -> RestAssured.given()
                .delete(PetApiPath.DELETE_PET.path + id)
                .then();
    }

    public static Supplier<ValidatableResponse> postPet(PetBody petBody) {
        return () -> RestAssured.given()
                .body(petBody.createBody().toString())
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .post(PetApiPath.POST_PET.path)
                .then();
    }
}
