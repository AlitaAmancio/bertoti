public class NewsApp implements Observer{
    private String name;

    public NewsApp(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}
