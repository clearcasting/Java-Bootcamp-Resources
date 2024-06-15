import java.util.ArrayList;

public class MagazineLibrary {
    private ArrayList<Magazine> magazines;

    public MagazineLibrary() {
        magazines = new ArrayList<>();
    }

    public MagazineLibrary(ArrayList<Magazine> magazine) {
        this.magazines = new ArrayList<>(magazine);
    }

    public Magazine getMagazine(int index) {
        return new Magazine(magazines.get(index));
    }

    public void setMagazine(Magazine magazine, int index) {
        this.magazines.set(index, new Magazine(magazine));
    }

    public void addMagazine(Magazine magazine) {
        this.magazines.add(new Magazine(magazine));
    }
}
