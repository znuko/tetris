public class Field {
  public static final int height = 22;
  public static final int width = 12;
  int minoSize = Mino.size;

  int[][] values = new int[height][width];
  int[][] valuesWithMino = new int[height][width];
  String[][] values4print = new String[height][width];
  // int[][] minoValues = new int[minoSize][minoSize];
  // int minoPositionY;
  // int minoPositionX;

  Field(){
    this.resetValues();
  }

  public void resetValues(){
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        this.values[y][x] = 0;
      }
    }
    for(int y = 0; y < height; y++){
      this.values[y][0] = -1;
      this.values[y][width - 1] = -1;
    }
    for(int x = 0; x < width; x++){
      this.values[height - 1][x] = -1;
    }
  }

  public int[][] getValues(){
    return this.values;
  }

  public int[][] getValuesWithMino(){
    return this.valuesWithMino;
  }


  public void setFixedMino(){
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        this.values[y][x] = valuesWithMino[y][x];
      }
    }
  }

  public void setMino(Mino mino){
    int minoPositionY = mino.getPositionY();
    int minoPositionX = mino.getPositionX();
    int[][] minoValues = mino.getValues();

    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        this.valuesWithMino[y][x] = this.values[y][x];
      }
    }

    for(int y = 0; y < minoSize; y++){
      for(int x = 0; x < minoSize; x++){
        if (minoValues[y][x] == 1){
          this.valuesWithMino[minoPositionY + y][minoPositionX + x] += 1;
        }
      }
    }
  }

  public void clearLines(){
    // 下から上への順で確認
    int checkY = height - 2;
    while(0 <= checkY){
      if (this.checkLineFill(checkY)){
        // 消えた行より上を全部一行下げる
        for (int y = checkY; 0 < y; y--){
          // 上の行を下の行にコピー
          for(int x = 1; x < width - 1; x++){
            this.values[y][x] = this.values[y - 1][x];
          }
        }
        // 一番上の行は0に
        for(int x = 1; x < width - 1; x++){
          this.values[0][x] = 0;
        }
      } else {
        checkY--;
      }
    }
  }

  public boolean checkLineFill(int y){
    for(int x = 1; x < width - 1; x++){
      if(this.values[y][x] == 0){
        return false;
      }
    }
    return true;
  }



} // end of class
