package api.petStore;

public enum PetApiPath {
    GET_BY_STATUS("findByStatus"),
    GET_BY_ID(""),
    POST_PET(""),
    DELETE_PET("");

    String path;
    private String address = "https://petstore.swagger.io/v2/pet/";

    PetApiPath(String path) {
        this.path = address + path;
    }

    @Override
    public String toString(){
        return address + path;
    }
}
