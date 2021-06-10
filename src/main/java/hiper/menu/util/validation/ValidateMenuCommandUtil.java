package hiper.menu.util.validation;

import hiper.menu.Action;
import hiper.menu.ValidEntity;

public class ValidateMenuCommandUtil {
    public static boolean validateAction(String commandAction) {
            for (Action action : Action.values()) {
                if (action.name().equalsIgnoreCase(commandAction)) {
                    return true;
                }
            }

            return false;
    }

    public static boolean validateEntity(String commandEntity) {
        for (ValidEntity entity : ValidEntity.values()) {
            if (entity.name().equalsIgnoreCase(commandEntity)) {
                return true;
            }
        }

        return false;
    }
}
