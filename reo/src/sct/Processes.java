package sct;

import nl.cwi.pr.runtime.api.InputPort;
import nl.cwi.pr.runtime.api.OutputPort;

public class Processes {

	public static void Customer(InputPort in, OutputPort out) {
		while (true) {
			Object o = in.getUninterruptibly();
			System.err.println("Customer: " + o);
			out.putUninterruptibly("accept");
		}
	}

	public static void Product(InputPort in, OutputPort out) {
		while (true) {
			Object o = in.getUninterruptibly();
			System.err.println("Product: " + o);
			if (Math.random() > 0.5)
				out.putUninterruptibly("accept");
			else 
				out.putUninterruptibly("reject");
		}
	}

	public static void Agreement(InputPort in, OutputPort out) {
		while (true) {
			Object o = in.getUninterruptibly();
			System.err.println("Agreement: " + o);
			out.putUninterruptibly(o);
		}
	}
}
