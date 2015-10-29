package average;

public class Average_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] alpha = {0.4, 0.2, 0.4}, mu = {1,2,2};
		int N = 5, K = 3;
		
		Average_lib alib = new Average_lib(alpha, N, K, mu);
		
		alib.calcAverage();
		double[] L = alib.getL();
		double[] R = alib.getR();
		double[] lambda = alib.getLambda();
		
		for(int i = 0;i < K; i++){
			System.out.println("L["+i+"]="+L[i]);
			System.out.println("R["+i+"]="+R[i]);
			System.out.println("Lambda["+i+"]="+lambda[i]);
		}
	}

}
