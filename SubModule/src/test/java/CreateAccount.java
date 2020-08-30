import api.SubModuleBase;
import org.testng.annotations.Test;



/**
 * Author: Israt Uddin
 * Last Modified : 08/28/2020  @9:30 PM EST
 */

/**
 * Note:  I was told not to submit any form, so some actions are commented below. The createafreeaccount method can be enhanced to validate create a free account functionality.
 * Verify user should be able to see required validation massage while try to create an account without entering any input data.
 */

public class CreateAccount extends SubModuleBase {
    @Test
    public void createAFreeAccount() throws Exception {

        createAccount();
        takeTheScreenshot("createAFreeAccount");

    }

    }




