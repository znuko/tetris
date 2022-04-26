public class Mino {
  public static final int size = 4;
  public static final int angles = 4;
  private int[][][] values = new int[angles][size][size];
  private int angle;
  private int positionY, positionX;

  Mino(){
    this.reset();
  }

  public void reset(){
    for(int y = 0; y < size; y++){
      for(int x = 0; x < size; x++){
        for(int angle = 0; angle < angles; angle++){
          this.values[angle][y][x] = 0;
        }
      }
    }

    this.angle = 0;
    this.positionY = 0;
    this.positionX = 4;

    this.setValues(Minos.getType("L"));
  }

  // セッター

  public void setValues(int[][][] values){
    this.values = values;
  }
  public void setValue(int angle, int y, int x, int value){
    this.values[angle][y][x] = value;
  }

  public void setPositionY(int positionY){
    this.positionY = positionY;
  }
  public void setPositionX(int positionX){
    this.positionX = positionX;
  }

  public void setAngle(int angle){
    this.angle = angle;
  }

  // ゲッター

  public int[][][] getAllValues(){
    return this.values;
  }
  public int[][] getValues(){
    return this.values[this.angle];
  }

  public int getPositionY(){
    return this.positionY;
  }
  public int getPositionX(){
    return this.positionX;
  }

  public int getAngle(){
    return this.angle;
  }

  // 操作

  public void moveRight(){
    this.move(0, 0, 1);
  }
  public void moveLeft(){
    this.move(0, 0, -1);
  }
  public void moveDown(){
    this.move(0, 1, 0);
  }
  public void moveUP(){
    this.move(0, -1, 0);
  }
  public void rotateRight(){
    this.move(1, 0, 0);
  }
  public void rotateLeft(){
    this.move(3, 0, 0);
  }

  private void move(int da, int dy, int dx){
    this.positionY += dy;
    this.positionX += dx;
    this.angle = (this.angle + da) % angles;
  }

} // end of class
