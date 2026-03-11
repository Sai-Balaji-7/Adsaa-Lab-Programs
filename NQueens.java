
import java.util.Scanner;

class NQueens{
    int x[]=new int[150];//array inorder to store the postions of column of queens
    boolean place(int k,int i){//place the queen in current place by checking column and diagonal comdition
        for (int j=1;j<=k-1;j++){
            if((x[j]==i)||(Math.abs(k-j)==Math.abs(i-x[j]))){
                return false;
            }
        }
        return true;
    }
    void nqueens(int k,int n){
        for(int i=1;i<=n;i++){
            if(place(k, i)){
                x[k]=i;         //if queen can be placed the place method return true and this method places
            if(k==n){
                for(int j=1;j<=n;j++){
                    System.out.print(x[j]+"");
                }
                System.out.println();
            }
            else
                nqueens(k+1,n);//this is a recursive ,it is run until every queen is placed
        }
    }
}
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter no of queens:");
        n=sc.nextInt();
        NQueens obj=new NQueens();
        obj.nqueens(1,n);
    }
}