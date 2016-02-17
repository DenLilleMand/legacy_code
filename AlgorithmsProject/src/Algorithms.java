
public class Algorithms {
	/**
	 * Noter:
	 * primitive operations(Som vi tæller:)
	 * Assigning a value to a variable
• Following an object reference
• Performing an arithmetic operation (for example, adding two numbers)
• Comparing two numbers
• Accessing a single element of an array by index
• Calling a method
• Returning from a method


An algorithm may run faster on some inputs than it does on others of the same size.
Thus, we may wish to express the running time of an algorithm as the function of
the input size obtained by taking the average over all possible inputs of the same
size. Unfortunately, such an average-case analysis is typically quite challenging.
It requires us to define a probability distribution on the set of inputs, which is often
a difficult task. Figure 4.2 schematically shows how, depending on the input distribution,
the running time of an algorithm can be anywhere between the worst-case
time and the best-case time. For example, what if inputs are really only of types
“A” or “D”?


An average-case analysis usually requires that we calculate expected running
times based on a given input distribution, which usually involves sophisticated
probability theory. Therefore, for the remainder of this book, unless we specify
otherwise, we will characterize running times in terms of the worst case, as a function
of the input size, n, of the algorithm.
Worst-case analysis is much easier than average-case analysis, as it requires
only the ability to identify the worst-case input, which is often simple. Also, this
approach typically leads to better algorithms. Making the standard of success for an
algorithm to perform well in the worst case necessarily requires that it will do well
on every input. That is, designing for the worst case leads to stronger algorithmic
“muscles,” much like a track star who always practices by running up an incline.
	 */
}
