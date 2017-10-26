package chapter19.question01;

/**
 * Created by blindcant on 6/10/17.
 */
public class TestGenericStack
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//### create stacks ###
		GenericStack<String> stack1 = new GenericStack<>();
		GenericStack<Integer> stack2 = new GenericStack<>();
		//GenericStack<String>[] stack3 = new GenericStack[2];
		
		//### push to stacks ###
		stack1.pushToStack("Busan");
		stack1.pushToStack("Seoul");
		stack1.pushToStack("Incheon");
		stack1.pushToStack("Seongnam");
		
		//All of these primitive types will be autoboxed to an Integer object
		stack2.pushToStack(1);
		stack2.pushToStack(2);
		stack2.pushToStack(3);
		//I am manually boxing these primitive types to an Integer object
		stack2.pushToStack(new Integer(4));
		stack2.pushToStack(new Integer(5));
		stack2.pushToStack(new Integer(6));
		
		//### maniupulate the stacks ###
		System.out.println("@@@ ArrayList<E> stack1 @@@");
		stack1.printStackSize();
		stack1.peekAtStackPrint();
		stack1.popFromStack();
		stack1.printStackSize();
		stack1.pushToStack("Jeju Island");
		stack1.peekAtStackPrint();
		
		System.out.println("\n@@@ ArrayList<E> stack2 @@@");
		stack2.peekAtStackPrint();
		stack2.emptyStack();
		stack2.peekAtStackPrint();
		
		//System.out.println("\n@@@ E[] stack3 @@@");
	}
	
}
