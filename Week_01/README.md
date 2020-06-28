# 算法训练营第一周笔记

## 训练准备和时间复杂度分析

- 前序 **preOrder**

  > root -> left -> right
  >
  > ```java
  >  void preOder(TreeNode<String> treeNode) {
  > 		if (treeNode == null) return;
  > 		System.out.print(treeNode.data);
  > 		preOder(treeNode.left);
  > 		preOder(treeNode.right);
  > 	}
  > ```
  >
  > 时间复杂度为O(n)

- 中序 **inOrder**

  > ​	left -> root -> right
  >
  > ```java
  >  void inOrder(TreeNode<String> root) {
  > 		if (root == null) return;
  > 		inOrder(root.left);
  > 		System.out.print(root.data);
  > 		inOrder(root.right);
  > 	}
  > ```
  >
  > 时间复杂度为O(n)

- 后序 **postOrder**

  > ​	left -> right -> root
  >
  > ```java
  > void postOrder(TreeNode<String> root) {
  > 		if (root == null) return;
  > 		postOrder(root.left);
  > 		postOrder(root.right);
  > 		System.out.print(root.data);
  > 	}
  > ```
  >
  > 时间复杂度为O(n)

- 图的遍历

  > **BFS(Breadth First Search)**，广度优先， 按层次依次遍历。时间复杂度为O(n)；
  >
  > **DFS(Deepth First Search)**，深度优先， 从单一节点深度依次遍历。时间复杂度为O(n)；

- 二分查找 **BinarySearch**

  > ```java
  > int bs(int[] a, int low, int high, int key) {
  >    if (low > high) return -1;
  >    int mid = (low + high) >>> 1;
  >    if (a[mid] == key) return mid;
  >    if (a[mid] > key) {
  >       return bs(a, low, mid - 1, key);
  >    } else {
  >       return bs(a, mid + 1, high, key);
  >    }
  > }
  > ```
  >
  > 每次只需要折半，所以时间复杂度为O(n)

## 数组，链表，跳表

### 数组

 	数组是在内存中连续的一段空间

**特点**:

1. **可以根据下标直接定位到数组元素**
2. CPU在读取数组的时候，可以缓存当前内存位置左右的数据，所以在预热后读取效率很高
3. 申请空间时，需要指定空间大小，内存如果不足**整个数组**会创建失败

**所以**

1. （查找）根据下标的定位O(1)
2. 如果需要**保证原来的顺序**，而进行**增加**和**删除**，平均时间复杂度为：O(n/2)

### 链表

链表，没有限制其在内存中的分布，通常在内存中的不是连续的

**特点**：

1. 定位元素只能通过节点的关系依次查找
2. 申请空间时，不需要指定空间大小，内存如果不足**只有最近创建的节点**会创建失败

**所以**：

1. 查找的平均时间复杂度为O(n/2)
2. 删除和新增的时间复杂度为O(1)

> 注意：删除和新增，如果是建立在需要先查询，再操作的话，时间复杂度就是 O(n) + O(1)，也就是O(n)

### 跳表

**概念**：

> - 跳表是一种**随机化**的数据结构。这种结构，基于**有序链表**。
>
> - 跳表通过概率，创建子链表。
>
> - 子链表是基于原始链表，它拥有更少的元素，并且不会包含原始链表之外的元素。
>
> - 将其假设为地铁的话，它就是一列**快速列车**，它不会在每个站停靠。假设你知道你的目的地，快速列车是更好的选择。
>
> - 跳表中**有多个链表**，每个链表都不会存储真实的数据，链表每个元素维护指向真实数据的指针，而每个链表之间的关系是**层级关系**，如下图：
>
> ![image-20200628151115930](image/README/image-20200628151115930.png)

**特点**：

跳表更能适应并发的访问，它不像其它的**平衡二叉树**，并发访问时需要锁住很多节点(为了保持平衡)。

这种情况，跳表只会影响它的节点附近的节点，大部分节点是不受影响的。

**随机性**：

1. 假设一个随机数p，1 > p > 0
2. 最底层链表（第n层）：所有元素 + head + tail(nil/null)
3. n - 1 层链表： 所有元素个数 * p + tail(nil/null) 

**增删改步骤**

步骤如下图，如图可见，在增加元素的时候，每一层链表，都会通过随机数`p`计算概率，如果通过，则在上层链表增加对元素的索引。

![增删改](image/README/Skip_list_add_element-en.gif)

## 栈、队列、双端队列、优先队列

栈，队列这样的数据结构，主要提供写操作

### 栈

**特点**：后入先出 **Last In First Out**

> 通常，入栈的方法是 **push()**，出栈的方法是**pop()和peek()**

- JDK8中`Stack#peek()`源码

  ```java
  public synchronized E peek() {
          int     len = size();
  
          if (len == 0)
              throw new EmptyStackException();
          return elementAt(len - 1);
      } 
  ```

  如代码所示，会把当前栈中，栈顶元素取出来返回

- JDK8中`Stack#pop()`源码

  ```java
   public synchronized E pop() {
          E       obj;
          int     len = size();
  
          obj = peek();
          removeElementAt(len - 1);
  
          return obj;
      }
  ```

  如代码所示，会取出栈顶元素返回，并将其从栈中移除

- JDK8中`Stack#push()`源码

  ```java
   public E push(E item) {
          addElement(item);
          return item;
      }
      
      public synchronized void addElement(E obj) {
          modCount++;
          ensureCapacityHelper(elementCount + 1);
          elementData[elementCount++] = obj;
      }
  ```

  如代码所示，只是往栈中添加元素

在java中，`Stack`类作为栈的标准实现，提供的接口如下图展示：

![image-20200628203916495](image/README/image-20200628203916495.png)

它的实现方式也很简单，创建一个数组，数组的**读写只能从尾端操作**

### 队列

**特点**：先入先出 **First In First Out**，按照入队顺序出队。

在java中，`Queue`作为队列的顶级接口，定义了队列的操作方式，接口如下：

![image-20200628204107235](image/README/image-20200628204107235.png)



