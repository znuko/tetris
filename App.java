public class App {
  public static void main(String [] args) {
    System.out.println("hoge");
    System.out.print("Everything on the console will cleared");
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("hoge");
  }
}
