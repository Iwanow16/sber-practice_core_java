public class Test {
    public static void main(String[] args) {

        Author author = new Author("Стивен Эдвин Кинг", "M", "stk@gmail.com");
        System.out.println(author.getName());
        System.out.println(author.getGender());
        System.out.println(author.getEmail());
        System.out.println(author);

        Book book = new Book("Кладбище домашних животных", author, 1983);
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getYear());
        System.out.println(book);

        author.setName("Стивен Кинг");
        author.setGender("M");
        author.setEmail("rtt@gmail.com");
        System.out.println(author);
    }
}
