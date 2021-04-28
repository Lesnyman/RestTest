package api.petStore.pet;

public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    public String status;

    PetStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return status;
    }
}
