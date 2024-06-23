//leetcode 1642
package ArrayQuestions;

import java.util.PriorityQueue;

class FurthestBuilding {
    public static void main(String[] args) {
        int[] heights= {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;
        System.out.println(furthestBuilding(heights,bricks,ladders));
    }
    static public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i =0;
        int jump =0;
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
    //     while(i<heights.length){
    //         if(i== heights.length-1)break;
    //         if(heights[i+1]>heights[i]){
    //             int jump= heights[i+1]-heights[i];
    //             p.add(jump);
    //             bricks-=jump;
    //             if(bricks<0){
    //                 ladders--;
    //                 if(ladders<0){
    //                     break;
    //                 }
    //                bricks+=p.poll();
    //                 i++;
    //             }else{
    //                 i++;
    //             }
                
    //         }else{
    //                 i++;
    //             }    
    //     }
    //     return i;

    //2nd approch
    for( i=0;i<heights.length-1;i++){
       jump= heights[i+1]-heights[i]; 

       if(jump<=0){
           continue;
       }
       bricks-=jump;
       p.offer(jump);

       if(bricks<0){
           ladders--;
           bricks+=p.poll();
       }
       if(ladders<0){
           break;
       }
    }
     return i;
    }  
}
