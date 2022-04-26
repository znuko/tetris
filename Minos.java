public class Minos {

  public static final String[] types = {"I", "J", "L", "O", "S", "T", "Z"};

  public static int[][][] getType(int typeNum){
    return getType(types[typeNum]);
  }

  public static int[][][] getType(String type){
    int[][][] values = new int[Mino.angles][Mino.size][Mino.size];

    switch (type){
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "I":
        values[0][0] = new int[]{0, 1, 0, 0};
        values[0][1] = new int[]{0, 1, 0, 0};
        values[0][2] = new int[]{0, 1, 0, 0};
        values[0][3] = new int[]{0, 1, 0, 0};

        values[1][0] = new int[]{0, 0, 0, 0};
        values[1][1] = new int[]{1, 1, 1, 1};
        values[1][2] = new int[]{0, 0, 0, 0};
        values[1][3] = new int[]{0, 0, 0, 0};

        for (int y = 0; y < Mino.size; y++){
          for (int x = 0; x < Mino.size; x++){
            values[2][y][x] = values[0][y][x];
            values[3][y][x] = values[1][y][x];
          }
        }

        break;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "J":
        values[0][0] = new int[]{0, 0, 1, 0};
        values[0][1] = new int[]{0, 0, 1, 0};
        values[0][2] = new int[]{0, 1, 1, 0};
        values[0][3] = new int[]{0, 0, 0, 0};

        values[1][0] = new int[]{1, 0, 0, 0};
        values[1][1] = new int[]{1, 1, 1, 0};
        values[1][2] = new int[]{0, 0, 0, 0};
        values[1][3] = new int[]{0, 0, 0, 0};

        values[2][0] = new int[]{0, 1, 1, 0};
        values[2][1] = new int[]{0, 1, 0, 0};
        values[2][2] = new int[]{0, 1, 0, 0};
        values[2][3] = new int[]{0, 0, 0, 0};

        values[3][0] = new int[]{1, 1, 1, 0};
        values[3][1] = new int[]{0, 0, 1, 0};
        values[3][2] = new int[]{0, 0, 0, 0};
        values[3][3] = new int[]{0, 0, 0, 0};
        
        break;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "L":
        values[0][0] = new int[]{0, 1, 0, 0};
        values[0][1] = new int[]{0, 1, 0, 0};
        values[0][2] = new int[]{0, 1, 1, 0};
        values[0][3] = new int[]{0, 0, 0, 0};

        values[1][0] = new int[]{1, 1, 1, 0};
        values[1][1] = new int[]{1, 0, 0, 0};
        values[1][2] = new int[]{0, 0, 0, 0};
        values[1][3] = new int[]{0, 0, 0, 0};

        values[2][0] = new int[]{0, 1, 1, 0};
        values[2][1] = new int[]{0, 0, 1, 0};
        values[2][2] = new int[]{0, 0, 1, 0};
        values[2][3] = new int[]{0, 0, 0, 0};

        values[3][0] = new int[]{0, 0, 1, 0};
        values[3][1] = new int[]{1, 1, 1, 0};
        values[3][2] = new int[]{0, 0, 0, 0};
        values[3][3] = new int[]{0, 0, 0, 0};

        break;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "O":
        for (int angle = 0; angle < Mino.angles; angle++){
          values[angle][0] = new int[]{0, 1, 1, 0};
          values[angle][1] = new int[]{0, 1, 1, 0};
          values[angle][2] = new int[]{0, 0, 0, 0};
          values[angle][3] = new int[]{0, 0, 0, 0};
        }

        break;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "S":
        values[0][0] = new int[]{0, 1, 1, 0};
        values[0][1] = new int[]{1, 1, 0, 0};
        values[0][2] = new int[]{0, 0, 0, 0};
        values[0][3] = new int[]{0, 0, 0, 0};

        values[1][0] = new int[]{0, 1, 0, 0};
        values[1][1] = new int[]{0, 1, 1, 0};
        values[1][2] = new int[]{0, 0, 1, 0};
        values[1][3] = new int[]{0, 0, 0, 0};

        for (int y = 0; y < Mino.size; y++){
          for (int x = 0; x < Mino.size; x++){
            values[2][y][x] = values[0][y][x];
            values[3][y][x] = values[1][y][x];
          }
        }

        break;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "T":
        values[0][0] = new int[]{1, 1, 1, 0};
        values[0][1] = new int[]{0, 1, 0, 0};
        values[0][2] = new int[]{0, 0, 0, 0};
        values[0][3] = new int[]{0, 0, 0, 0};

        values[1][0] = new int[]{0, 0, 1, 0};
        values[1][1] = new int[]{0, 1, 1, 0};
        values[1][2] = new int[]{0, 0, 1, 0};
        values[1][3] = new int[]{0, 0, 0, 0};

        values[2][0] = new int[]{0, 1, 0, 0};
        values[2][1] = new int[]{1, 1, 1, 0};
        values[2][2] = new int[]{0, 0, 0, 0};
        values[2][3] = new int[]{0, 0, 0, 0};

        values[3][0] = new int[]{0, 1, 0, 0};
        values[3][1] = new int[]{0, 1, 1, 0};
        values[3][2] = new int[]{0, 1, 0, 0};
        values[3][3] = new int[]{0, 0, 0, 0};

        break;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      case "Z":
        values[0][0] = new int[]{1, 1, 0, 0};
        values[0][1] = new int[]{0, 1, 1, 0};
        values[0][2] = new int[]{0, 0, 0, 0};
        values[0][3] = new int[]{0, 0, 0, 0};

        values[1][0] = new int[]{0, 0, 1, 0};
        values[1][1] = new int[]{0, 1, 1, 0};
        values[1][2] = new int[]{0, 1, 0, 0};
        values[1][3] = new int[]{0, 0, 0, 0};

        for (int y = 0; y < Mino.size; y++){
          for (int x = 0; x < Mino.size; x++){
            values[2][y][x] = values[0][y][x];
            values[3][y][x] = values[1][y][x];
          }
        }
        
        break;

    } // end of switch

    return values;
  }

} // end of class
