public class Guest implements User {
    @Override
    public boolean adminAdd() {
        return false;
    }

    @Override
    public boolean adminDelete() {
        return false;
    }

    @Override
    public boolean adminUpdate() {
        return false;
    }

    @Override
    public boolean guestSearch() {
        return true;
    }
}
