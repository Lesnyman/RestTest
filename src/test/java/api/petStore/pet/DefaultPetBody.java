package api.petStore.pet;

import java.util.Arrays;
import java.util.List;

public interface DefaultPetBody {
    Long defaultPetId = 2L;
    String defaultName = "doggie";
    PetBody.Category defaultCateory = new PetBody.Category(0L, "doggie");
    List defaultUrls = Arrays.asList("first", "second");
    List defaultTags = Arrays.asList(
            new PetBody.Tags(0L, "sometag"),
            new PetBody.Tags(1L, "sometag2")
    );
    PetStatus defaultStatus = PetStatus.AVAILABLE;

    PetBody defaultPetBody = new PetBody(
            defaultPetId,
            defaultCateory,
            defaultName,
            defaultUrls,
            defaultTags,
            defaultStatus.status
    );
}
