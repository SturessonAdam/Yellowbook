public class Admin implements User {
    @Override
    public boolean adminAdd() {
        return true;
    }

    @Override
    public boolean guestSearch() {
        return true;
    }

    @Override
    public boolean adminUpdate() {
        return true;
    }

    @Override
    public boolean adminDelete() {
        return true;
    }
}
