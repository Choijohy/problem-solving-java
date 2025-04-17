package 구현;

import java.util.*;

class 공원 {
    int[] mats;
    int w,h;
    String[][] park;
    int minMat, maxMat;

    public int getMaxArea(int x, int y){
        int maxSize = -1;
        int k;
        for (k=minMat; k<=maxMat;k++){
            for (int i=0; i<k;i++){
                for (int j=0;j<k;j++){
                    int nx = x+i;
                    int ny = y+j;
                    if (nx >-1 && nx <h && ny>-1 && ny<w){
                        if (!park[nx][ny].equals("-1")) return maxSize;
                    } else return maxSize;
                }
            }
            maxSize = k;
        }
        return maxSize;
    }

    public int solution(int[] mats, String[][] park) {
        this.mats = mats;
        this.park = park;
        this.h = park.length;
        this.w = park[0].length;

        Arrays.sort(mats);

        this.minMat = mats[0];
        this.maxMat = mats[mats.length-1];

        int answer = 0;

        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                if (park[i][j].equals("-1")){
                    int temp =getMaxArea(i,j);
                    answer = Math.max(answer,temp);
                }


            }
        }

        int maxMatSize = -1;
        for(int mat:mats){
            if (answer < mat) break;
            maxMatSize = mat;
        }

        return maxMatSize;
    }
}