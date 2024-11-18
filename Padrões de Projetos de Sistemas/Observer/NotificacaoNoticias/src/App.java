public class App {
    public static void main(String[] args) throws Exception {
        NewsAgency newsAgency = new NewsAgency();

        NewsWebsite website = new NewsWebsite("Super News Website");
        NewsApp app = new NewsApp("Super News App");

        newsAgency.addObserver(website);
        newsAgency.addObserver(app);

        newsAgency.setLatestNews("Breaking News: New Java version released!");
    }
}
