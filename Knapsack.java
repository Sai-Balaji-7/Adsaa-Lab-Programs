import java.util.*;
public class Knapsack{
    //Knapscak program involves selecting the items to maximize profit
    public static void main(String[] args){
        int n=3;//no of items
        int[] profit={60,100,120};//profits of items -p[i]
        int[] weight={10,20,30};//weights of item-w[i]
        int capacity=50;//capacity of knapsack - m
        double maxProfit=knapsackGreedy(n,profit,weight,capacity);
        System.out.println("Maximum profit: "+maxProfit);

    }
    static double knapsackGreedy(int n,int[] p,int[] w,int m){
        double[] ratio=new double[m];
        for(int i=0;i<n;i++){
            ratio[i]=(double)p[i]/w[i];//ratio = profit / weight;
        }
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,(i,j)->Double.compare(ratio[j],ratio[i]));
        //now we select the maximum profit
        double totalProfit=0.0;
        int remainingCapacity=m;
        for(int i:index){
            if(w[i]<=remainingCapacity){
                remainingCapacity-=w[i];
                totalProfit+=p[i];
            }else{
                totalProfit+=ratio[i]*remainingCapacity;
                break;
            }
        }
        return totalProfit;
    }
}
