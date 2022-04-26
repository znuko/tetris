import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControler implements KeyListener
{
  public int status;

  public Field field = new Field();
  public Mino mino = new Mino();

  int minoNum;
  int[] order = new int[Minos.types.length];
  int orderIndex;

  // コンストラクタ
  GameControler()
  {
    System.out.printf("\n\n\tPress Enter to Start\n\n");
    this.status = 0;

    minoNum = 0;
    orderIndex = 0;
    order = this.getOrder();
    mino.setValues(Minos.getType(this.order[orderIndex]));
    
  }

  //keyPressed() method takes care of moving the zero according to the key pressed
  @Override
  public void keyPressed(KeyEvent e)
  {

    // スタート画面
    if (this.status == 0){
      switch (e.getKeyCode()){
        case KeyEvent.VK_ENTER:
          this.status = 1;
          break;
        default:
          System.out.println("You Typed: " + KeyEvent.getKeyText(e.getKeyCode()));
      }
    }

    // テトリス画面
    if(this.status == 1){
      Mino newMino = new Mino();
      newMino.setPositionY(this.mino.getPositionY());
      newMino.setPositionX(this.mino.getPositionX());
      newMino.setValues(this.mino.getAllValues());
      newMino.setAngle(this.mino.getAngle());

      boolean isTryMoveDown = false;

      switch (e.getKeyCode()){
        case KeyEvent.VK_RIGHT:
          newMino.moveRight();
          break;
        case KeyEvent.VK_LEFT:
          newMino.moveLeft();
          break;
        case KeyEvent.VK_DOWN:
          newMino.moveDown();
          isTryMoveDown = true;
          break;
        case KeyEvent.VK_UP:
          do {
            this.mino.setPositionY(newMino.getPositionY());
            this.mino.setPositionX(newMino.getPositionX());
            newMino.moveDown();
          } while (!checkHit(newMino, this.field));
          isTryMoveDown = true;
          break;
        case KeyEvent.VK_P:
          newMino.rotateRight();
          break;
        case KeyEvent.VK_O:
          newMino.rotateLeft();
          break;
      }

      this.field.setMino(this.mino);
      this.clear();
      this.print("ミノの数：" + Integer.toString(this.minoNum));

      if (!checkHit(newMino, this.field)){
        this.mino.setPositionY(newMino.getPositionY());
        this.mino.setPositionX(newMino.getPositionX());
        this.mino.setAngle(newMino.getAngle());
      } else if (isTryMoveDown){
        this.field.setFixedMino();
        this.field.clearLines();
        this.mino.reset();
        this.minoNum++;
        this.orderIndex = minoNum % Minos.types.length;
        if (this.orderIndex == 0){
          this.order = this.getOrder();
        }
        mino.setValues(Minos.getType(this.order[this.orderIndex]));
        if (checkHit(mino, this.field)){
          this.status = 2;
        }
      }

      this.field.setMino(this.mino);
      this.clear();
      this.print("ミノの数：" + Integer.toString(this.minoNum));
    }

    // リザルト画面
    if(status == 2){
      this.clear();
      System.out.printf("\n\n\tGAME OVER\n\n");
      System.out.printf("\nMino Numbers: %d\n\n", this.minoNum);
      System.out.printf("\nPress Q to Exit\n\n");
    }

    // ゲーム終了
    if (e.getKeyCode() == KeyEvent.VK_Q)
    {
      System.exit(0);
    }

  } // end of keyPressed()

  //We don't need the other two methods
  @Override
  public void keyReleased(KeyEvent e)
  {}
  @Override
  public void keyTyped(KeyEvent e)
  {}

  // メソッド

  public int[] getOrder(){
    int[] order = new int[Minos.types.length];
    for (int i = 0; i < Minos.types.length; i++){
      order[i] = i;
    }
    Shuffle.shuffle(order);
    return order;
  }

  public boolean checkHit(Mino mino, Field field){
    int[][] minoValues = mino.getValues();
    int minoY = mino.getPositionY();
    int minoX = mino.getPositionX();
    int[][] fieldValues = field.getValues();

    for(int y = 0; y < Mino.size; y++){
      for(int x = 0; x < Mino.size; x++){
        if (minoValues[y][x] == 1 && fieldValues[minoY + y][minoX + x] != 0){
          return true;
        }
      }
    }
    return false;
  }

  public void clear(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void print(){
    this.printField();
  }

  public void print(String text){
    this.printField();
    System.out.println(text);
  }

  public void printField(){
    int[][] values = this.field.getValuesWithMino();
    for(int y = 0; y < Field.height; y++){
      for(int x = 0; x < Field.width; x++){
        System.out.printf("%s ", getFieldValues4print(values)[y][x]);
      }
      System.out.println();
    }
  }

  public String[][] getFieldValues4print(int[][] valuesWithMino){
    String strWall = "*";
    String strMino = "+";
    String strBG = " ";

    String[][] values4print = new String[Field.height][Field.width];
    for(int y = 0; y < Field.height; y++){
      for(int x = 0; x < Field.width; x++){
        switch (valuesWithMino[y][x]){
          case -1:
            values4print[y][x] = strWall;
            break;
          case 1:
            values4print[y][x] = strMino;
            break;
          case 0:
            values4print[y][x] = strBG;
            break;
          default:
            values4print[y][x] = Integer.toString(valuesWithMino[y][x]);
        }
      }
    }
    return values4print;
  }

} // end of class
