# 算法训练营第三周笔记

**递归 java模板**

```java
void recurision (int level, int maxLevel) {
	// terminator 终结递归
    if (level > maxLevel ) {
         // process result 
        return;
    }
    // process current logic 处理应当处理的逻辑
    process();
    // drill down  递归深度增加
    recursion(level + 1, maxLevel);
    // reverse   善后 
    reverse();    
}
```

**递归的特点**：

1. 节点的定义
2. 重复性（自相似性）

**递归要考虑的点**

1. 参数中的变量

   > 递归每一次的调用都会被单独分配栈空间
   >
   > 变量也会被传递，如果process的过程依赖与参数
   >
   > 最好的方式是，使用一份拷贝的变量传递，或者通过全局变量来传递

2. 返回值

   > 递归的返回值也会被传递
   >
   > 如果process的过程依赖于一个不变的全局变量
   >
   > 最好的方式是通过一个拷贝来传递，或者通过全局变量来传递

**回溯与分治特点**

1. 重复性，有最近重复性和最优重复性

2. 最优重复性 -> 动态规划

3. 最近重复性 ->  怎么构造，怎么分解  ->  分治

   ​															  ->  回溯	

   回溯，通常都会由一个**backtrack**的操作
   
   排列组合相关的问题，都可以考虑回溯法