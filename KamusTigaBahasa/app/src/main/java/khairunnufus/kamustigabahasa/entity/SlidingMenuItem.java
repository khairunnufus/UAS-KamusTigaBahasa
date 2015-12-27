package khairunnufus.kamustigabahasa.entity;

/**
 * Created by hairuns on 12/20/2015.
 */public class SlidingMenuItem {
    String title;
    int icon;

    public SlidingMenuItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}