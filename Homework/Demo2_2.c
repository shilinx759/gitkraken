#include<stdio.h>
#include<stdlib.h>
#define N 30		//n<=30;
int a[N];			//定义一个全局的数组用来存储每个人的密码
typedef struct Node{
	int data;		//data用来存储每个人的编号，即下标
	struct Node *next;
}Node,*LNode;
	
LNode InitLNode(int n){
	LNode p,tail;
	LNode head=(LNode)malloc(sizeof(Node));
	if(head==NULL)
		return 0;
	head->next=NULL;
	head->data=n;//保存参与游戏的人数
	tail=head;//记录尾部
	for(int i=1;i<=n;i++){
		p=(LNode)malloc(sizeof(Node));//新建一个结点，即有多少个人就多少个结点
		p->data=i;			//给他们编号
		p->next=tail->next;//tail->next=Null,p指向null
		tail->next=p;//tail指向p
		tail=p;//p变成尾部
	}
	tail->next=head->next;//tial指向第一个结点
	return head->next;//返回第一个结点
}

void Dele_List(LNode List,int n,int m){
	LNode p=List;
	LNode tail=List;
	while(p->next!=p){		//	循环遍历
		for(int i=1;i<m;i++){		//遍历前m-1个节点，使得p正好指向第m个节点
			tail=p;
			p=p->next;//不断向下指
		}
		tail->next=p->next;			
		printf("出列的下标为：%d\n",p->data);
		m=a[p->data];			//把第m个节点的密码赋给m
		free(p);		//删除第m个节点
		p=tail->next;	//并从p的下一个开始新一轮循环	
	}
	printf("出列的下标为：%d\n",p->data);//因为上面那个循环并不能正好把列表中的节点释放完，最后还剩一个，需要单独释放
	free(p);
}

int main(){
	int n,m;
	printf("请输入人数N和其实密码M，以空格间隔:\n");
	scanf("%d %d",&n,&m);
	LNode List=InitLNode(n);
	for(int i=1;i<=n;i++)
		scanf("%d",&a[i]);
	Dele_List(List,n,m);//删除第m个
	return 0;
}

// 要点：
// 1.出队函数中的循环条件
// 2.循环并不能删除所有节点

