public class NewsWebsite implements Observer {
    private String name;

    public NewsWebsite(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}
