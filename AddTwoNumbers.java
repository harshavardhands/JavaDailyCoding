package com.java.ds;

import java.math.BigInteger;

public class AddTwoNumbers {

	public static void main(String[] args) {
		int[] i1 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int[] i2 = new int[] { 9 };

		System.out.println(getValue(addTwoNumbers(createList(i1), createList(i2))));

	}

	private static ListNode createList(int[] input) {
		ListNode root = null;
		ListNode node = null;

		for (int i = 0; i < input.length; i++) {
			ListNode tmp = new ListNode(input[i]);

			if (node != null)
				node.next = tmp;

			node = tmp;

			if (root == null)
				root = tmp;
		}

		return root;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String val1 = getValue(l1);
		String val2 = getValue(l2);
		BigInteger b1 = new BigInteger(val1);
		BigInteger b2 = new BigInteger(val2);
		String result = (b1.add(b2)).toString();

//		String result = String.valueOf(Long.valueOf(val1) + Long.valueOf(val2));

		ListNode resNode = new ListNode();
		ListNode next = null;
		for (int i = 0; i < result.length(); i++) {
			if (next == null) {
				next = resNode;
				resNode.val = Integer.valueOf(String.valueOf(result.charAt(i)));
			} else {
				next = new ListNode();
				next.val = Integer.valueOf(String.valueOf(result.charAt(i)));
				next.next = resNode;
				resNode = next;
			}

		}
		return resNode;
	}

	public static String getValue(ListNode l1) {
		String val = "";
		while (l1 != null) {
			val = l1.val + "" + val;
			l1 = l1.next;
		}
		return val;
	}

	public static class ListNode {
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
}
