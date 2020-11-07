package miscellaneous;

public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		
		long area1 = (C - A) * (D - B);
		long area2 = (G - E) * (H - F);
		long totalArea = area1 + area2;

		long left = Math.max(A, E);
		long right = Math.max(Math.min(C, G), left);
		long bottom = Math.max(B, F);
		long top = Math.max(Math.min(D, H), bottom);
		long overlappedArea = (right - left) * (top - bottom);
		return (int)(totalArea - overlappedArea);
	}
}