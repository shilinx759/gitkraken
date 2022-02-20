package Class5;

public class RadixSort {
    public static void radixSort(int[] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    public static int maxbits(int[] arr){
        int max=Integer.MIN_VALUE;//?
        for(int i=0;i<arr.length;i++){
            max=Math.max(max, arr[i]);
        }
        int res=0;
        while(max!=0){
            res++;
            max/=10;
        }
        return res;
    }
    //digit==最大值的位数
    public static void radixSort(int[] arr,int L,int R,int digit){
        final int radix=10;//十进制
        int i=0,j=0;
        int[] help=new int [R-L+1];
        for(int d=1;d<=digit;d++){
            int[] count1=new int[radix];
            //得到count·1数组
            for(i=L;i<=R;i++){
                j=getDigit(arr[i],d);//得到某个数的 第d位 个、十、百、千。。。
                count1[j]++;
            }
            //得到count2
            int[] count2=new int [radix];
            for(i=1;i<radix;i++){
                count2[i]=count1[i]+count1[i-1];
            }

            for(i=R;i>=L;i--){//left->right 每个数都是最后出来，
                //放在在词频-1的位置上
                j=getDigit(arr[i],d);//得到arr【i】的d位数
                help[count2[j]-1]=arr[i];//
                count2[j]--;
            }
            //copy help[]->arr[]
            for(i=L,j=0;i<=R;j++,i++){
                arr[i]=help[j];
            }
        }

    }

    public static int getDigit(int num,int d){
        
        for(int i=1;i<=d;i++){
            num%=10;
        }
        return num;
    }
    
}
