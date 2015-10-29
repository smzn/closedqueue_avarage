package average;

public class Average_lib {
	
	private double[] alpha, lambda, L, R, mu;
	private int N, K;
	//ネットワーク内の総客数がn人の時のノートk゙でのスループット,平均ノード内客数,平均ノード通過時間(滞在時間)とする

	public Average_lib(double[] alpha, int N, int K, double[] mu) {
		this.alpha = alpha;
		this.N = N;
		this.K = K;
		this.mu = mu;
		lambda = new double[K];
		L = new double[K];
		R = new double[K];
		for(int i = 0; i < L.length; i++) L[i] = 0;
	}

	public void calcAverage(){
		int n = 0;
		while(n < N){
			n++;
			//Step3 Rの更新
			for(int i = 0; i < K;i++){
				R[i] = (L[i] + 1)/mu[i];
			}
			
			for(int i = 0; i < K; i++){
				System.out.println("R["+n+","+i+"]="+R[i]);
			}
			
			//Step4 Lambdaの更新
			for(int i = 0; i < K;i++){
				double sum = 0;
				for(int j = 0; j < K; j++) sum += alpha[j]*R[j]; 
				if(i == 0) lambda[i] = n/sum;
				else lambda[i] = alpha[i]*lambda[0];
			}
			
			for(int i = 0; i < K; i++){
				System.out.println("lambda["+n+","+i+"]="+lambda[i]);
			}
			
			//Step5 Lの更新
			for(int i = 0; i < K; i++){
				L[i] = lambda[i]*R[i];
			}
			
			for(int i = 0; i < K; i++){
				System.out.println("L["+n+","+i+"]="+L[i]);
			}
			
		}
	}

	public double[] getLambda() {
		return lambda;
	}

	public double[] getL() {
		return L;
	}

	public double[] getR() {
		return R;
	}
	
}
