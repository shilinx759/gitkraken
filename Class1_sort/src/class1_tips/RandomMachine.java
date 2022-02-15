package class1_tips;
public class RandomMachine {
    public static int[] randomMachine(int maxSize,int maxValue){
        //Math.random() [0,1)
        //Math.random()*N [0,N) 产生0到N中所有数，包括小数
        //(int)(Math.random()*N)  [0,N-1] 产生0-N上所有整数
        int [] arr =new int[(int)((maxSize+1)*Math.random())];//产生一个长度为0-maxSize的数组
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
            //产生一个大小随机的数
        }
        //总的看来就，产生了一个长度唯一大小也唯一的数
           return arr;
    }
    
}
