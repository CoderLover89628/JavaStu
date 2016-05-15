package com.zs.forInterView.string;

import java.util.Stack;

public class BinaryTree {
	protected Nodess root;

	public BinaryTree(Nodess root) {
		this.root = root;
	}

	public Nodess getRoot() {
		return root;
	}

	/** 构造树 */
	public static Nodess init() {
		Nodess a = new Nodess('A');
		Nodess b = new Nodess('B', null, a);
		Nodess c = new Nodess('C');
		Nodess d = new Nodess('D', b, c);
		Nodess e = new Nodess('E');
		Nodess f = new Nodess('F', e, null);
		Nodess g = new Nodess('G', null, f);
		Nodess h = new Nodess('H', d, g);
		return h;// root
	}

	/** 访问节点 */
	public static void visit(Nodess p) {
		System.out.print(p.getKey() + " ");
	}

	/** 递归实现前序遍历 */
	protected static void preorder(Nodess p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	/** 递归实现中序遍历 */
	protected static void inorder(Nodess p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	/** 递归实现后序遍历 */
	protected static void postorder(Nodess p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	/** 非递归实现前序遍历 */
	protected static void iterativePreorder(Nodess p) {
		Stack<Nodess> stack = new Stack<Nodess>();
		if (p != null) {
			stack.push(p);
			while (!stack.empty()) {
				p = stack.pop();
				visit(p);
				if (p.getRight() != null)
					stack.push(p.getRight());
				if (p.getLeft() != null)
					stack.push(p.getLeft());
			}
		}
	}

	/** 非递归实现前序遍历2 */
	protected static void iterativePreorder2(Nodess p) {
		Stack<Nodess> stack = new Stack<Nodess>();
		Nodess node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {// 压入所有的左节点，压入前访问它
				visit(node);
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {//
				node = stack.pop();
				node = node.getRight();
			}
		}
	}

	/** 非递归实现后序遍历 */
	protected static void iterativePostorder(Nodess p) {
		Nodess q = p;
		Stack<Nodess> stack = new Stack<Nodess>();
		while (p != null) {
			// 左子树入栈
			for (; p.getLeft() != null; p = p.getLeft())
				stack.push(p);
			// 当前节点无右子或右子已经输出
			while (p != null && (p.getRight() == null || p.getRight() == q)) {
				visit(p);
				q = p;// 记录上一个已输出节点
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子
			stack.push(p);
			p = p.getRight();
		}
	}

	/** 非递归实现后序遍历 双栈法 */
	protected static void iterativePostorder2(Nodess p) {
		Stack<Nodess> lstack = new Stack<Nodess>();
		Stack<Nodess> rstack = new Stack<Nodess>();
		Nodess node = p, right;
		do {
			while (node != null) {
				right = node.getRight();
				lstack.push(node);
				rstack.push(right);
				node = node.getLeft();
			}
			node = lstack.pop();
			right = rstack.pop();
			if (right == null) {
				visit(node);
			} else {
				lstack.push(node);
				rstack.push(null);
			}
			node = right;
		} while (lstack.size() > 0 || rstack.size() > 0);
	}

	/** 非递归实现后序遍历 单栈法 */
	protected static void iterativePostorder3(Nodess p) {
		Stack<Nodess> stack = new Stack<Nodess>();
		Nodess node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				Nodess temp = stack.peek().getRight();
				if (temp == null || temp == prev) {
					node = stack.pop();
					visit(node);
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}

		}
	}

	/** 非递归实现后序遍历4 双栈法 */
	protected static void iterativePostorder4(Nodess p) {
		Stack<Nodess> stack = new Stack<Nodess>();
		Stack<Nodess> temp = new Stack<Nodess>();
		Nodess node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				temp.push(node);
				stack.push(node);
				node = node.getRight();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.getLeft();
			}
		}
		while (temp.size() > 0) {
			node = temp.pop();
			visit(node);
		}
	}

	/** 非递归实现中序遍历 */
	protected static void iterativeInorder(Nodess p) {
		Stack<Nodess> stack = new Stack<Nodess>();
		while (p != null) {
			while (p != null) {
				if (p.getRight() != null)
					stack.push(p.getRight());// 当前节点右子入栈
				stack.push(p);// 当前节点入栈
				p = p.getLeft();
			}
			p = stack.pop();
			while (!stack.empty() && p.getRight() == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	/** 非递归实现中序遍历2 */
	protected static void iterativeInorder2(Nodess p) {
		Stack<Nodess> stack = new Stack<Nodess>();
		Nodess node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node);
				node = node.getRight();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(init());
		System.out.print(" Pre-Order:");
		preorder(tree.getRoot());
		System.out.println();
		System.out.print(" In-Order:");
		inorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order:");
		postorder(tree.getRoot());
		System.out.println();
		System.out.print(" Pre-Order:");
		iterativePreorder(tree.getRoot());
		System.out.println();
		System.out.print("Pre-Order2:");
		iterativePreorder2(tree.getRoot());
		System.out.println();
		System.out.print(" In-Order:");
		iterativeInorder(tree.getRoot());
		System.out.println();
		System.out.print(" In-Order2:");
		iterativeInorder2(tree.getRoot());
		System.out.println();
		System.out.print(" Post-Order:");
		iterativePostorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order2:");
		iterativePostorder2(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order3:");
		iterativePostorder3(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order4:");
		iterativePostorder4(tree.getRoot());
		System.out.println();
	}
}

class Nodess {
	private char key;
	private Nodess left, right;

	public Nodess(char key) {
		this(key, null, null);
	}

	public Nodess(char key, Nodess left, Nodess right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public Nodess getLeft() {
		return left;
	}

	public void setLeft(Nodess left) {
		this.left = left;
	}

	public Nodess getRight() {
		return right;
	}

	public void setRight(Nodess right) {
		this.right = right;
	}
}
