package com.sun.datastructure.array;

public class MaxArea {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //暴力解体法
    //两层for循环
    public static int f(int[] arr){
        int maxarea = 0;
        int tmp;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                tmp=Math.min(arr[i],arr[j])*(j-i);
                maxarea=Math.max(tmp,maxarea);
            }

        }
        return maxarea;
    }

    //双指针
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }


//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        int[] arr={2,4,5};
        System.out.println(f(arr));
    }
}
