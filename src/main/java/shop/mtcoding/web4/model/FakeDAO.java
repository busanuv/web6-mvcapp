package shop.mtcoding.web4.model;

public class FakeDAO {
    public User userData() {
        User u1 = new User(1, "ssar", "1234");
        return u1;
    }

    public Board boardData() {
        Board b1 = new Board(1, "제목1", 1);
        return b1;
    }
}
