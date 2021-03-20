package Maths;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Bharat
 *
 */
/** Class for calculating the fast fourier Transform (FFT) of discrete signal using the cooley-Tukey algorithm*/
public class FFT {
	/**
	 * This class represents a complex number and has method for basic operations 
	 */
	static class Complex
	{
		private double real,img;
		
		// default constructor creates the compldex number 0.
		public Complex()
		{
			real = 0;
			img = 0;
		}
		
		/**
		 * Constructor creates a comples number 
		 * 
		 * @param r the eral part of number
		 * 
		 * @parami the imaginary part of the number
		 */
		public Complex(double r, double i)
		{
			real = r;
			img = i;
		}
		
		/**
		 * returns the real part of teh Complex Number
		 * 
		 * @return The real part of complex number
		 */
		public double getReal()
		{
			return real;
		}
		
		/**
		 * Return the imaginary oart of the complex NUmber
		 * 
		 * @return the imaginary part of the compplex number
		 */
		public double getImaginary()
		{
			return img;
		}
		
		/**
		 * Add this Complex number to another
		 * 
		 * @param z the number to be addded
		 * @return The sum
		 */
		public Complex add(Complex z)
		{
			Complex temp = new Complex();
			temp.real = this.real + z.real;
			temp.img = this.img + z.img;
			return temp;
		}
		/**
		 * Substract a number from this complex 
		 * 
		 * @param z the number to be subtracted 
		 * @return The diference
		 */
		
		
		public Complex subtract(Complex z)
		{
			Complex temp = new Complex();
			temp.real = this.real - z.real;
			temp.img = this.img - z.img;
			return temp;
		}
		
		/**
		 * Mutiplies this complexx number by another
		 * 
		 * 
		 * @param z the number to be multiplication
		 * @return The Product
		 */
		public Complex multiply(Complex z)
		{
			Complex temp = new Complex();
			temp.real = this.real * z.real - this.img * z.img;
			temp.img = this.real * z.img - this.img * z.real;
			return temp;
		}
		
		/**
		 * Mutiplies the complex number byu Scalar
		 * 
		 * @param n the real number to be multiplication
		 * @return the product
		 */
		public Complex multiply(double n)
		{
			Complex temp = new Complex();
			temp.real = this.real * n;
			temp.img = this.img * n;
			return temp;
		}
		
		/**
		 * Finds the the conjugate of this copmplex number 
		 * 
		 * @return The conjugate 
		 */
		public Complex conjugate()
		{
			Complex temp = new Complex();
			temp.real = this.real;
			temp.img = -this.img;
			return temp;
		}
		
		/**
		 * Finds the magnitude of the complex number 
		 * 
		 * @return The magnitude 
		 */
		public double abs()
		{
			return Math.hypot(this.real, this.img);
		}
		
		/**
		 * Divides this complex number by anoather
		 * 
		 * @param z the divisor
		 * @return The Quotient
		 */
		public Complex divide(Complex z)
		{
			Complex temp = new Complex();
			temp.real = (this.real * z.real + this.img * z.img) / (z.abs() * z.abs());
			temp.img = (this.img * z.real - this.real * z.img) / (z.abs() * z.abs());
			return temp;
		}
		
		/**
		 * Divides thsi complex number by a scalar
		 * 
		 * @param n the divisor which is real number 
		 * @return The quotient
		 */
		public Complex divide(double n)
		{
			Complex temp = new Complex();
			temp.real = this.real / n;
			temp.img = this.img / n;
			return temp;
		}
		
		/**
		 *  Iterative in-place radix-2 cooley tukey fast fouries tranform Algorithm with with bit-reversal the 
		 *  size of the input signals must be a power of 2 if it is isn't then it is padded with zeroes and the 
		 *  output FFT will be bigger than the umput signal 
		 *  
		 *  @param x the differnce signal which is then converted to the FFT or the IFFT of signal x
		 *  @param inverse True to find the Inverse of FFT
		 */
		public static void fft(ArrayList<Complex> x, boolean inverse) {
			// pad the signal with zeroes if necessary
			paddingPowerOFTwo(x);
			int N = x.size();
			
			// Find the log2(N)
			int log2N = 0;
			while((1 << log2N) < N) log2N++;
			
			// swap the values of the signal with bit-reversal method
			int reverse;
			for(int i = 0; i < N; i++)
			{
				reverse = reverseBits(i, log2N);
				if(i < reverse) Collections.swap(x, i, reverse);
			}
			int direction = inverse ? -1 : 1;
			
			//main loop of the algorithm
			for(int len = 2; len <= N; len*=2)
			{
				double angle = -2 * Math.PI / len * direction;
				Complex wlen = new Complex(Math.cos(angle), Math.sin(angle));
				for(int i = 0; i < N; i += len)
				{
					Complex w = new Complex(1, 0);
					for(int j = 0; j < len / 2; j++)
					{
						Complex u = x.get(i + j);
						Complex v = w.multiply(x.get(i + j + len /2));
						x.set(i + j , u.add(v));
						x.set(i + j + len / 2, u.subtract(v));
						w = w.multiply(wlen);
					}
				}
			}
			
			// divide by N for the inverse FFT
			
			if(inverse)
			{
				for(int i = 0; i < x.size(); i++)
				{
					Complex z = x.get(i);
					x.set(i, z.divide(N));
				}
			}
		}
		
		/**
		 * This function reverse the bits of a number. It is usedf in Cooley-tukey FFT algorithm
		 * 
		 * @param num integer to reverse the bits 
		 * @param log2N the numebr of bits to reverse 
		 * @return the reversed number
		 */
		public static int reverseBits(int num, int log2N)
		{
			int reversed = 0;
			for(int i = 0; i < log2N; i++)
			{
				if((num & (1 << i)) != 0) reversed |= 1 << (log2N - 1 - i);
			}
			return reversed;
		}
	}
	
	/**
	 * This method pads an arraylist with zeros in order to have a size equal to the next power of previos size
	 */
	private static void paddingPowerOFTwo(ArrayList<Complex> x)
	{
		int n = 1;
		int oldSize = x.size();
		while(n < oldSize) n *= 2;
		for(int i = 0; i < n - oldSize; i++) x.add(new Complex());
	}

	

}
