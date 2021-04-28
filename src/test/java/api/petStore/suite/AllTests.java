package api.petStore.suite;

import api.petStore.pet.delete.DeletePetTest;
import api.petStore.pet.get.FindByIdTest;
import api.petStore.pet.get.FindByStatusTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FindByIdTest.class,
        FindByStatusTest.class,
        DeletePetTest.class,
        })

public class AllTests {
}
