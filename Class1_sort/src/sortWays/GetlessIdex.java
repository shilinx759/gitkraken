package sortWays;

public class GetlessIdex {
    //找一个极小值
    public static int getlessIdex(int [] arr){
        if(arr==null||arr.length<2){
            return -1;//no exist
        }
        if(arr[0]<arr[1]||arr.length==1){
            return 0;//第零号位是极小值
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;//最后一个数是极小值
        }
        int left=1;
        int right=arr.length-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]>arr[mid-1]){//比左边的大，0-mid👇👆，所以有边界变到向上的这个位置
                right=mid-1;
            }
            else if(arr[mid]>arr[mid+1]){//比右边的大，mid-N-1:👇👆同理
                left=mid+1;
            }
            else{
                return mid;//直到有那么一个既小于左边又小于右边的mid出现，就是一个极小值
            }
        }
        return left;
        
    }

    //题目三
    public static void printODDtims2(int [] arr){
        int eor=0;
        for(int i=0;i<arr.length;i++){
            eor^=arr[i];//eor=a^b
        }
        //eor中必有一个1，那么不妨取出它最右侧的1作为标志
        //get rightOne
        int rightOne=eor&((~eor)+1);
        //过滤出整个数组中rightOne位置为1的数，其中肯定包含要找的奇次数中的一个
        //再用eor2去异或这些数，就得到了a，b中的一个
        int onlyOne=0;
        for(int j=0;j<arr.length;j++){
            if((arr[j]&rightOne)!=0){
                onlyOne^=arr[j];//除了ab之外，其他的数还是会出现偶次，所以只会剩下a，b中的一个
            }
        }
        int theOtherOne=onlyOne^eor;//eor=a^b,假设onlyOne=a,theOtherOne=a^b^a=b

    }

    //统计一个数的二进制表示里的1的个数
    public static int bit1count(int N){
        int cnt=0;
        while(N!=0){
            int rightOne=N&((~N)+1);//最右边 1
            cnt++;
            //n:0011010100
            //r:0000000100
            //^:0011010000 最右1就被抹掉了
            N^=rightOne;
        }
        return cnt;
    }
    
}
