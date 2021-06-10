package hiper.menu;

public class MenuCommandProps {
    private Action action;
    private String entityName;

    public MenuCommandProps() {
    }

    public MenuCommandProps(Action action, String entityName) {
        this.action = action;
        this.entityName = entityName;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
