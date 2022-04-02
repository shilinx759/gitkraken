#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 3
// 2.
// 停车场管理。
// 设停车场是一个可停放几辆车的狭长通道，且只有一个大门可供汽车进出。在停车场内，汽车按到达的究
// 后次序由北向南依次排列（假设大门在最南端）。若车场内已停满n辆车，则后来的汽车需在门外的便道上年
// 候，当有车开走时，便道上的第一辆车即可开入。当停车场内某辆车要离开时，在它之后进人的车辆必须先退
// 车场为它让路，待该辆车开出大门后，其他车辆再按原次序返回车场。每辆车离开停车场时，应按其停留时间的
// 长短交费（在便道上停留的时间不收费）。
// 试编写程序，模拟上述管理过程。要求以顺序栈模拟停车场，以链队列模拟便道。从终端读入汽车到达
// 或离去的数据，每组数据包括三项：①是“到达”还是“离去”；②汽车牌照号码；③“到达”或“离去”的时刻
// 与每组输入信息相应的输出信息为：如果是到达的车辆，则输出其在停车场中或便道上的位置；如果是离去的
// 车辆，则输出其在停车场中停留的时间和应交的费用。（提示：需另设一个栈，临时停放为让路而从车场退出

// testCase:(1-进入，0-离去)
// 3 2
// 1 10
// 2 20
// 3 30
// 1 4 40
// 0 2 20
typedef int Status;
typedef struct {
    int data[2][MAXSIZE];
    int top;
}SqStack;

typedef struct Node {
    int data[2];
    struct Node*next;
}QNode,*QuePtr;

typedef struct {
    QuePtr front,rear;
}LinkQue;


Status InitQue(LinkQue *Q){
    Q->front=Q->rear=(QuePtr)malloc(sizeof(QNode));
    Q->front->next=NULL;
    return 1;
}
Status QueisEmpty(LinkQue q){
    if(q.front==q.rear){
        return 1;
    }
    else{
        return 0;
    }
}
void EnterQue(LinkQue *Q,int num,int time){
    QuePtr q;
    q=(QuePtr)malloc(sizeof(QNode));
    q->data[0]=num;
    q->data[1]=time;
    q->next=NULL;
    Q->rear->next=q;
    Q->rear=q;
}
int IntoPark(LinkQue *Q,int *num,int *time){//队头进入车场，返回它的车牌
    QuePtr q;
    q=Q->front->next;
    *num=q->data[0];
    *time=q->data[1];
    Q->front->next=q->next;
    if(Q->rear==q){
         Q->rear=Q->front;
    }
    free(q);
    return 1;
}

Status InitStack(SqStack *S){
    S->top=-1;
    return 1;
}
Status isEmpty(SqStack s){
    if(s.top==-1){
        return 1;
    }
    else{
        return 0;
    }
}
Status isFull(SqStack s){
    if(s.top==MAXSIZE-1){
        return 1;
    }
    else{
        return 0;
    }
}
int main(){
    SqStack park;
    LinkQue waitQue;
    InitStack(&park);
    InitQue(&waitQue);
    //有m辆车到达
    int m,n;
    printf("请输入原始车辆n，以及操作数m\n");
    scanf("%d %d",&n,&m);
    int num,time,status[MAXSIZE]={0},i=0,j=0;
    printf("请输入原始进入的n辆车的车牌号、时间：\n");
    for(int k=0;k<n;k++){
        scanf("%d %d",&num,&time);
        park.top++;
        park.data[0][park.top]=num;
        park.data[1][park.top]=time;
        
    }
    while(m){
        scanf("%d %d %d",&status[park.top],&num,&time);//对车牌为num的车做status【i】操作，时间为time
        if(status[park.top]==1){//进入
            if(isFull(park)){
                EnterQue(&waitQue,num,time);
                printf("车牌为%d的车进入等待队列,进入时刻：%d\n",num,time);
                //等待链式队列
            }
            else{
                park.top++;
                park.data[0][park.top]=num;//第一行存号码
                park.data[1][park.top]=time;//第二行存时间
            }
        }
        else{//离开
            if(isEmpty(park)){
               printf("已经没车了"); 
            }
            SqStack temp;
            InitStack(&temp);
            while(park.data[0][park.top]!=num){
                temp.top++;
                temp.data[0][temp.top]=park.data[0][park.top];
                temp.data[1][temp.top]=park.data[1][park.top];
                park.top--;
            }
            printf("车牌为%d的车离开，进入时刻:%d，离去时刻：%d 停车时长：%d\n",
            park.data[0][park.top],park.data[1][park.top],time,time-park.data[1][park.top]);
            park.top--;//删除这辆车
            while(temp.top!=-1){//装回去
                park.top++;
                park.data[0][park.top]=temp.data[0][temp.top];
                park.data[1][park.top]=temp.data[1][temp.top];
                temp.top--;
            } 
        }
        if(!isFull(park) && !QueisEmpty(waitQue)){//有空位了,且有车在等待
            int newnum,newtime;
            IntoPark(&waitQue,&newnum,&newtime);
            printf("车牌为%d的车离开等待队列,进入停车场\n",newnum);
            park.top++;
            park.data[0][park.top]=newnum;//第一行存号码
            park.data[1][park.top]=newtime;//第二行存时间
        }
        m--;
    }
    printf("操作完成后的停车场：\n");
    i=1;
    while(park.top!=-1){
        printf("第%d辆车 车牌：%d 停车时间：%d\n",i,park.data[0][park.top],park.data[1][park.top]);
        i++;
        park.top--;
    }
    return 0;
}