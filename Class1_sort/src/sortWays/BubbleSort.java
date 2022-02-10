package sortWays;

public class BubbleSort {
    //冒泡拍序
    public static void bubbleSort(int [] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        //所有要比较的数一开始是0到N-1号参与比较；
        //一轮比较完后，N-1号固定，就只有0到N-2号参与比较；
        //同理，0到N-3号参与比较，以此类推
        for(int e=arr.length-1;e>0;e--){
            //0-1谁大谁后
            //1-2谁大谁后
            //2-3谁大谁后
            //3-4
            //最后（e-1）-e谁大谁后
            for(int i=0;i<e;i++){
                if (arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void swap(int [] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j]; 
    }
}
