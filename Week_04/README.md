# 第四周笔记

## 深度优先搜索、广度优先搜索

#### **使用场景**： 

​	深度优先和广度优先，在图和树中使用的很多。

#### **时间复杂度**： 

1. 在深度优先和广度优先的问题中，都可以看成对节点访问的问题。

2. 所以时间复杂度可以看作是，节点访问次数。

#### **空间复杂度**：

 空间复杂度需要看实现方式，有没有使用辅助空间

#### **DFS特点**：

1. 深度优先，它目的是先找到一条链路上的头尾，再回溯回去寻找另外的链路

2. 深度优先的实现方式通常是通过**栈**来协助完成的

3. 代码模板如下：

   ```java
   public List<List<Integer>> levelOrder(TreeNode root) {
           List<List<Integer>> allResults = new ArrayList<>();
           if(root==null){
               return allResults;
           }
           travel(root,0,allResults);
           return allResults;
       }
   
   
       private void travel(TreeNode root,int level,List<List<Integer>> results){
           if(results.size()==level){
               results.add(new ArrayList<>());
           }
           results.get(level).add(root.val);
           if(root.left!=null){
               travel(root.left,level+1,results);
           }
           if(root.right!=null){
               travel(root.right,level+1,results);
           }
       }
   ```


#### BFS特点：

1. 广度优先，它的目的是一层一层的寻找
2. 广度优先通常是通过队列来协助完成的
3. 广度优先在图等数据结构中更广泛的被使用，很多是时间复杂度比较高

模板：

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```









## 二分查找

二分查找的思想很简单，就是对一个有序的集合，遍历的时候，只找中点，用中点和target比较，这样的方式循环或者递归，直到找到或者遍历完集合。

这种思想带来的时间收益很高，时间复杂度是**O(logn)**，一千个长度的集合，最多只需要10此遍历就得到结果。

模板很简单，下面分别是循环和递归的模板：

```java
int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	int search(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) >>> 1;
		if (nums[mid] > target)
			return search(nums, left, mid - 1, target);
		else if (nums[mid] < target)
			return search(nums, mid + 1, right, target);
		else
			return mid;
	}
```

二分查找，直接（left + right）>>> 1不会出现问题。

因为**二分查找的原始集合单调的**，所以它**与坐标轴的交点最多一个**，可以**左右逼近的方式寻找与坐标轴的交点**。



这个二分查找的变种，就不行，因为它不是单调的，按照题目的说明，它最多与坐标轴会有两个交点。

```
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。
```

它的不单调有个**特点**：

- **在某个值的左侧和右侧分别是单调的**

可以**通过渐近寻找**特定值，渐近的长度，取当前**非单调区间长度的一半**，就可以找到特定的点。

在这个例子中，**特定的点就是最小值**。所以它的解题方法就是更改一下计算**mid**的方法。如下：

```java
mid = left + (left + right)/2 + 1；
 或
mid = right - (left + right) / 2 - 1;
```

注意：

- 经典二分查找，**左侧和右侧分别需要加一和减一**，因为mid已经比较过了，不用再次拿来比较
- 这个例子中，左侧和右侧的值都不确定，所以左侧和右侧不应该执行加一或减一操作，但是如果不执行加一或减一操作，会导致重复计算，所以需要在计算mid的时候，把对一的加或减补偿回来
- 这个例子中，如果假如集合是单调的，` if (nums[left] < nums[mid])`判断里面的操作有可能导致**mid**计算出错

代码如下：

```java
int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right -left) / 2 + 1;
                if (nums[left] > nums[mid]) {
                    right = mid - 1;
                } else if (nums[left] < nums[mid]) {
                    left = mid;
                } else break;
            }
            return nums[(right + 1) % nums.length];
    }
```

或者

```java
int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = right - (right - left) / 2 - 1;
			if (nums[left] > nums[mid]) {
				right = mid;
			} else if (nums[left] < nums[mid]) {
				left = mid + 1;
			} else break;
		}
		return nums[(left + 1) % nums.length];
	}
```

下面这个代码，在**nums**数组是单调的情况下，会出错。上面的代码，在**nums**数组是否单调都是正确的。

毕竟只有非单调的情况下出现`nums[left] < nums[mid]`才应该做**left**的补偿加操作

而非单调的情况根本不会进入`nums[left] > nums[mid]`这个判断，`nums[left]`是一定小于`nums[right]`的

单调的时候，执行上面的代码，就是单纯的渐近寻找最小值（就在最左侧）