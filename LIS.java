public class LIS {
    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println(lis(arr,n));
    }
    static int lis(int arr[], int n){
        int lis[] = new int[n];
        int i,j;
        int max = 0;
        for(i = 0; i < n; i++){
            lis[i] = 1;
        }
        for(i = 1; i < n; i++){
            for(j = 0; j < i; j++){
                if(arr[i]>arr[j] && lis[i]< lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for(i = 0; i < n; i++){
            if(max < lis[i]){
                max = lis[i];
            }
        }
        return max;

    }
}
