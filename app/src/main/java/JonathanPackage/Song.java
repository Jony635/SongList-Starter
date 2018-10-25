package JonathanPackage;

class Song {
    private String title;
    private String group;
    private int year;
    public Song(String title, String group, int year) {
        this.title = title;
        this.group = group;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup(){return group;}
    public void setGroup(String newGroup){group = newGroup;}

    public int getYear(){return year;}
    public void setYear(int newYear){year = newYear;}


}
