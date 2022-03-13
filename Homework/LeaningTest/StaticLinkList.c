#define MAXSIZE 1000
//静态链表储存结构
#define OK 1
#define ERROR 0
typedef int Status;
typedef int ElemType;
typedef struct
{
    ElemType data;
    int cur;
}Component,StaticLinkList[MAXSIZE];

Status InitList(StaticLinkList space){
    int i;
    for(i-0;i<MAXSIZE-1;i++){
        space[i].cur=i+1;
    }
    space[MAXSIZE-1].cur=0;//数组的最后一个元素的cur用来存第一个有植元素的下标，
    //现在是空表，cur值为0
    return OK;
}

//分配空间
//若备用链表非空，则返回分配的结点下标，否则返回0
int Malloc_SSL(StaticLinkList space){
    //查数组0下标的cur值，来获取备用空间的第一个下标
    int i=space[0].cur;//假如第一个空元素下标为7，i=7
    if(space[0].cur){
        space[0].cur=space[i].cur;//7元素的cur为8，同时也是第一个空元素的下标，存入space【0】的cur
        return i;
    }

}

//插入操作
Status ListInsert(StaticLinkList  L,int i,ElemType e){
    int j,k,l;
    k=MAXSIZE-1;//数组尾是头指针
    if(i>ListLenth(L)+1||i<1){
        return ERROR;
    }
    j=Malloc_SSL(L);//获得第一个空闲空间的下标
    if(j){
        L[j].data=e;
        for(l=1;l<=i-1;l++){
            k=L[k].cur;//找到第i个元素之前的位置
        }
        L[j].cur=L[k].cur;//插入 操作
        L[k].cur=j;
        return OK;
    }
    return ERROR;
}


//手动实现free
//删除L中第i个元素
Status ListDlete(StaticLinkList L,int i){
    int j,k;
    k=MAXSIZE-1;
    if(i<1||i>ListLenth(L)+1){
        return ERROR;
    }
    for(j=1;j<=i-1;j++){//找的是第i个，而不是下标为i的，所以要做循环来找
        k=L[k].cur;
    }
    j=L[k].cur;//把指向i的cur赋给j，其实就是i元素的下标
    L[k].cur=L[j].cur;//跳过i，指向i的cur，即i的下一个元素
    Free_SSl(L,j);
    return OK;
}

void Free_SSL(StaticLinkList space,int k){
    space[k].cur=space[0].cur;//把第一个元素的cur赋给已删除变量的cur
    //把指向空位置的下标交给这个删除的变量
    //然后这个变量自己变成第一个空位置
    
    space[0].cur=k;//表示这个删除的元素，就是第一个空的空间了，下一个新元素直接覆盖它

}

int  ListLenth(StaticLinkList L){
    int j=0;
    int i=L[MAXSIZE-1].cur;//i头指针
    while(i){
        i=L[i].cur;//不断指向下一个
        j++;
    }//i指向空，即i=0推出循环
    return j;
}

