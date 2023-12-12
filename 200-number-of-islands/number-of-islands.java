class Solution {

    //todo: 만들어진 섬의 넒이, 길이 구하는 방법 생각해보기
    public int numIslands(char[][] grid) {
        int answer = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    checkIsland(grid, i, j);
                    System.out.println("checkStart" + i + j);
                    answer ++;
                }
            }
        }

        return answer;
    }

    public void checkIsland(char[][] grid,  int checkY, int checkX) {
        grid[checkY][checkX] = '0';
        if(checkY-1 > -1 && grid[checkY-1][checkX] == '1'){
            System.out.println("up ok" + (checkY-1) + checkX);
            checkIsland(grid, checkY-1, checkX);
        }
        if(checkY+1 < grid.length && grid[checkY+1][checkX] == '1'){
            System.out.println("down ok" + (checkY+1) + checkX);
            checkIsland(grid, checkY+1, checkX);
        }
        if(checkX-1 > -1 && grid[checkY][checkX-1] == '1'){
            System.out.println("left ok" + checkY + (checkX-1));
            checkIsland(grid, checkY, checkX-1);
        }
        if(checkX+1 < grid[checkY].length && grid[checkY][checkX+1] == '1'){
            System.out.println("right ok" + checkY + (checkX+1));
            checkIsland(grid, checkY, checkX+1);
        }
    }
}