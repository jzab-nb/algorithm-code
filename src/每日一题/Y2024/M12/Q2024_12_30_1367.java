package 每日一题.Y2024.M12;

public class Q2024_12_30_1367 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Definition for singly-linked list.


    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static public class Solution {
        private ListNode inHead;

        private boolean isSubPath(ListNode head, TreeNode root) {
            inHead = head;
            return dfs(head, root);
        }

        private boolean dfs(ListNode head, TreeNode root) {
            if (head == null) return true;
            if (root == null) return false;
            // 当前节点匹配上了，则匹配后面的节点
            return  head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right))
                    ||
                    // 第一个节点没匹配上，则从下一个重新节点开始匹配
                    head==inHead && (dfs(inHead, root.left) || dfs(inHead, root.right));

        }
    }

    public static void main(String[] args) {
//        new Solution().isSubPath(new ListNode(1), null);
    }
}

