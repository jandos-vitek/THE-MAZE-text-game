package Commands;

public class Exit implements Command{
    @Override
    public String execute() {
        return "Ukoncili jste hru";
    }

    @Override
    public Boolean end() {
        return true;
    }
}
